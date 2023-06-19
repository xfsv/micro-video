package edu.hhu.liweijia.entity;

import lombok.Data;

@Data
public class User {

    private Integer id;
    private String nickName;
    private String account;
    private String password;

}