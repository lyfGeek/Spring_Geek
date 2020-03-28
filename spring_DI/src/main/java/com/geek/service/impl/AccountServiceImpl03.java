package com.geek.service.impl;

import com.geek.service.IAccountService;

import java.util.*;

/**
 * 账户的业务层实现类。
 */
public class AccountServiceImpl03 implements IAccountService {

    // 如果是经常变化的数据，并不适用于注入的方式。
    private String[] myStrings;
    private List<String> myList;
    private Set<String> mySet;
    private Map<String, String> myMap;
    private Properties myProps;

    public void setMyStrings(String[] myStrings) {
        this.myStrings = myStrings;
    }

    public void setMyList(List<String> myList) {
        this.myList = myList;
    }

    public void setMySet(Set<String> mySet) {
        this.mySet = mySet;
    }

    public void setMyMap(Map<String, String> myMap) {
        this.myMap = myMap;
    }

    public void setMyProps(Properties myProps) {
        this.myProps = myProps;
    }

    @Override
    public void saveAccount() {
        System.out.println(Arrays.toString(myStrings));
        System.out.println("myList = " + myList);
        System.out.println("mySet = " + mySet);
        System.out.println("myMap = " + myMap);
        System.out.println("myProps = " + myProps);
    }
}
