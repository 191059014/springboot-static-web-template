package com.hb.st.sswt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(App.class, args);
        ConfigurableEnvironment env = applicationContext.getEnvironment();
        String host = env.getProperty("server.address");
        String port = env.getProperty("server.port");
        System.out.println("===========================================");
        System.out.println(String.format(" http://%s:%s/index.html", host == null ? "localhost" : host, port));
        System.out.println("===========================================");
    }

}
