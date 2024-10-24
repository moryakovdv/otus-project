open module otus.moryakovdv.meteousers {
	exports otus.moryakovdv.meteousers.service;
	exports otus.moryakovdv.meteousers.model;
	exports otus.moryakovdv.meteousers.repository;
	exports otus.moryakovdv.meteousers.web;
	

	requires transitive jakarta.servlet;
	requires jakarta.persistence;
		
	requires otus.moryakovdv.meteohelpers; 

	
	requires lombok;
	requires org.slf4j;
	requires spring.beans;
	requires spring.boot;
	requires spring.boot.autoconfigure;
	requires spring.context;
	requires spring.core;
	requires spring.data.commons;
	requires spring.data.jpa;
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
	
	requires reactor.core;
	requires org.reactivestreams;
	requires micrometer.observation;

}