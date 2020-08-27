package com.geekbrains.book.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookStoreApplication {
	// Домашнее задание:
	// 1. (На Thymeleaf) При создании заказа, информация об этом должна попасть в очередь
	// RabbitMQ, заказ в БД помечается как "В обработке"
	// 2. Консольное приложение должно получать список заказов "В обработке" и
	// с помощью команды "/готово {id_заказа}" отправлять через RabbitMQ
	// сообщение о готовности
	// 3. Веб-приложения получая от RabbitMQ такое сообщение, должно перевести в БД
	// состояние заказа в "Готово"

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}
}
