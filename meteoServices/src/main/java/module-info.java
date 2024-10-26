open module otus.moryakovdv.meteoservices {
	exports otus.moryakovdv.meteoservices.service;
	exports otus.moryakovdv.meteoservices.web;
	exports  otus.moryakovdv.meteoservices;

	requires otus.moryakovdv.meteohelpers; 

	
	requires transitive jakarta.servlet;
	
	requires lombok;
	requires org.slf4j;
	requires spring.beans;
	requires spring.boot;
	requires spring.boot.autoconfigure;
	requires spring.context;
	requires spring.core;

	requires spring.web;
	
	requires transitive spring.messaging;
	requires spring.amqp;
	requires spring.rabbit;
	requires com.rabbitmq.client;
	requires com.fasterxml.jackson.databind;


	
	requires transitive  io.github.resilience4j.circuitbreaker;
	requires transitive io.github.resilience4j.annotations;
	
	requires transitive  io.github.resilience4j.ratelimiter;
	requires transitive  io.github.resilience4j.core;
	requires micrometer.observation;

}