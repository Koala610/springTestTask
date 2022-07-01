package com.example.eschool;

import com.example.eschool.models.Student;
import com.example.eschool.models.User;
import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MappedTypes({User.class, Student.class})
@MapperScan("com.example.eschool.mappers")
@SpringBootApplication
public class EschoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(EschoolApplication.class, args);
	}

}
