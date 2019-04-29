package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties("server")
@Configuration
public class ServerConfig {
    private int port;

    public int getPort() {
        return port;
    }
    public void setPort(int port) {
        this.port = port;
    }
}
