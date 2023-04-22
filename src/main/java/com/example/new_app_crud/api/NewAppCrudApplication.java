package com.example.new_app_crud.api;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Demo API", version = "1.0", description = "Demo APP Info Management"))
public class NewAppCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewAppCrudApplication.class, args);
    }

}
