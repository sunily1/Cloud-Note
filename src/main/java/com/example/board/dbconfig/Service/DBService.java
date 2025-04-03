package com.example.board.dbconfig.Service;

import com.example.board.dbconfig.DBConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBService {

    private final DBConfig dbConfig;

    @Autowired
    public DBService(DBConfig dbConfig) {
        this.dbConfig = dbConfig;
    }

    public String getDatabaseUrl() {
        return dbConfig.getDatabaseUrl();
    }
}

