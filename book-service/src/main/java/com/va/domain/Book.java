package com.va.domain;



import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class Book {

    @Id @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
    private long bookId;

    @NotNull
    private String authorName;

    @NotNull
    private String title;

    @NotNull
    private short publishedYear;

}