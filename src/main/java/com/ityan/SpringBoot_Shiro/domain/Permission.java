package com.ityan.SpringBoot_Shiro.domain;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter@Getter@ToString
public class Permission {
    private Long pid;

    private String pname;

    private String presource;
}