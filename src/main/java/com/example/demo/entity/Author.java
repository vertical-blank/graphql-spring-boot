package com.example.demo.entity;

import lombok.Data;
import org.seasar.doma.Entity;

@Entity
@Data
public class Author {

    private int id;

    private String firstName;

    private String lastName;

}
