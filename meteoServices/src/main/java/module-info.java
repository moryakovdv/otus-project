open module otus.moryakovdv.meteoservices {
	requires transitive jakarta.servlet;
	requires jakarta.annotation;
	requires lombok;
	requires org.slf4j;
	requires spring.beans;
	requires spring.boot;
	requires spring.boot.autoconfigure;
	requires spring.context;
	requires spring.core;
	requires spring.web;
	requires transitive spring.messaging;
	requires transitive spring.amqp;
	requires transitive spring.rabbit;
	requires transitive com.rabbitmq.client;
	requires com.fasterxml.jackson.databind;
	requires transitive  io.github.resilience4j.circuitbreaker;
	requires transitive io.github.resilience4j.annotations;
	requires transitive  io.github.resilience4j.ratelimiter;
	requires transitive  io.github.resilience4j.core;
	requires micrometer.observation;
	
	exports otus.moryakovdv.meteoservices.service;
	exports otus.moryakovdv.meteoservices.rabbit;
	exports otus.moryakovdv.meteoservices;
	

}