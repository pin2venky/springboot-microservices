package com.va.domain;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
    private long userId;

    @NotNull
    private String name;

    @NotNull
    private String email;

    @NotNull
    private String mobileNo;

}