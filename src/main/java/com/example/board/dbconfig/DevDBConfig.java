package com.example.board.dbconfig;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class DevDBConfig implements DBConfig {

    @Override
    public String getDatabaseUrl() {
        return "jdbc:h2:mem:testdb";  // 예를 들어 H2 메모리 DB URL
    }
}
