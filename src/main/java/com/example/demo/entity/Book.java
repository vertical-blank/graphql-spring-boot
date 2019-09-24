package com.example.demo.entity;

import lombok.Data;
import org.seasar.doma.Entity;

@Entity
@Data
public class Book {

    private int id;

    private String name;

    private int pageCount;

    private int authorId;

}
