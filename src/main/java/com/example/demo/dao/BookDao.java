package com.example.demo.dao;

import com.example.demo.config.Config;
import com.example.demo.config.ConfigAutowireable;
import com.example.demo.entity.Book;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.springframework.stereotype.Repository;

@Dao(config = Config.class)
@ConfigAutowireable
@Repository
public interface BookDao {

    @Select
    Book findById(int id);

}
