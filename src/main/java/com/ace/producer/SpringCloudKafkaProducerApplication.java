package com.ace.producer;

import java.util.Random;
import java.util.function.Supplier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;

import com.ace.producer.vo.Book;

@SpringBootApplication
//this annotation tells spring that this will be my publisher

public class SpringCloudKafkaProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudKafkaProducerApplication.class, args);
	}


}
