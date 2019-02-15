package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.*.dao")
public class DoubleBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoubleBootApplication.class, args);
		System.out.println(
						"  _____              _     _      ____              _   \n" +
						" |  __ \\            | |   | |    |  _ \\            | |  \n" +
						" | |  | | ___  _   _| |__ | | ___| |_) | ___   ___ | |_ \n" +
						" | |  | |/ _ \\| | | | '_ \\| |/ _ \\  _ < / _ \\ / _ \\| __|\n" +
						" | |__| | (_) | |_| | |_) | |  __/ |_) | (_) | (_) | |_ \n" +
						" |_____/ \\___/ \\__,_|_.__/|_|\\___|____/ \\___/ \\___/ \\__|");
	}
}
