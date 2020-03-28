package com.geek.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * 账户实体类。
 */
@Data
public class Account implements Serializable {

    private int id;
    private String name;
    private Float money;
}
