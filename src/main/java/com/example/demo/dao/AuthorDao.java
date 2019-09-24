package com.example.demo.dao;

import com.example.demo.config.Config;
import com.example.demo.config.ConfigAutowireable;
import com.example.demo.entity.Author;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.springframework.stereotype.Repository;

@Dao(config = Config.class)
@ConfigAutowireable
@Repository
public interface AuthorDao {

    @Select
    Author findById(int id);

}
