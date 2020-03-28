package com.geek.jdbcTmplate;

import com.geek.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * JdbcTemplate CRUD 操作。
 */
public class JdbcTemplateCRUD {

    public static void main(String[] args) {

        // 获取容器。
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:bean.xml");

        // 获取对象。
        JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");

        // 增。
//        jdbcTemplate.execute("insert into account (name, money) values ('eee', '1000')");
//        jdbcTemplate.update("insert into account (name, money) values (?, ?)", "eee", 333f);

        // 删。
//        jdbcTemplate.update("delete from account where name = ?", "geek");

        // 改。
//        jdbcTemplate.update("update account set name = ?, money = ? where id = ?",
//                "geek", 7000f, 9);

        // 查。
//        List<Account> accountList = jdbcTemplate.query("select * from account where money < ?", new AccountRowMapper(), 10000F);
        // Spring 提供的封装实现。
        List<Account> accountList = jdbcTemplate.query("select * from account where money < ?", new BeanPropertyRowMapper<Account>(Account.class), 10000F);
        for (Account account : accountList) {
            System.out.println(account);
        }
        // Spring 的 JdbcTemplate 靠不同的 query(); 方法实现返回。
        // dbutils 靠 ResultSetHandler 中的返回值商定返回的内容。

        // 查询一个。
        List<Account> accountList1 = jdbcTemplate.query("select * from account where id = ?", new BeanPropertyRowMapper<>(Account.class), 1);
        System.out.println(accountList1.isEmpty() ? "没有内容" : accountList1.get(0));

        // 查询返回一行一列（使用聚合函数，但不加 group by 子句）。
        Integer integer = jdbcTemplate.queryForObject("select count(*) from account where money < ?", Integer.class, 10000F);
        System.out.println("integer = " + integer);
    }
}


/**
 * 定义 Account 的封装策略。
 */
class AccountRowMapper implements RowMapper<Account> {
    /**
     * 把结果集中的数据封装到 Account 中，然后由 Spring 把每个 Account 加入到集合中。
     *
     * @param resultSet
     * @param i
     * @return
     * @throws SQLException
     */
    @Override
    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        Account account = new Account();
        account.setId(resultSet.getInt("id"));
        account.setName(resultSet.getString("name"));
        account.setMoney(resultSet.getFloat("money"));
        return account;
//        return null;
    }
}
