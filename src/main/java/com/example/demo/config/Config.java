package com.example.demo.config;


import javax.sql.DataSource;

import org.seasar.doma.SingletonConfig;
import org.seasar.doma.jdbc.Naming;
import org.seasar.doma.jdbc.dialect.Dialect;
import org.seasar.doma.jdbc.dialect.H2Dialect;
import org.seasar.doma.jdbc.tx.LocalTransactionDataSource;
import org.seasar.doma.jdbc.tx.LocalTransactionManager;
import org.seasar.doma.jdbc.tx.TransactionManager;
import org.springframework.stereotype.Component;

@Component("Config")
//@SingletonConfig
public class Config implements org.seasar.doma.jdbc.Config {

    private final LocalTransactionDataSource dataSource = new LocalTransactionDataSource(
            "jdbc:h2:file:./db", null, null);

    private final TransactionManager transactionManager = new LocalTransactionManager(
            dataSource.getLocalTransaction(getJdbcLogger()));

    private Dialect dialect = new H2Dialect();

    @Override
    public DataSource getDataSource() {
        return this.dataSource;
    }

    @Override
    public TransactionManager getTransactionManager() {
        return transactionManager;
    }

    @Override
    public Dialect getDialect() {
        return this.dialect;
    }

    @Override
    public Naming getNaming() {
        return Naming.SNAKE_LOWER_CASE;
    }
}
