package com.example.board.dbconfig;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
public class ProdDBConfig implements DBConfig {

    @Override
    public String getDatabaseUrl() {
        return "jdbc:mysql://prod-server/db";  // 운영용 MySQL DB URL
    }
}

