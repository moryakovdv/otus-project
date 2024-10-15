open module otus.moryakovdv.meteousers {
	exports otus.moryakovdv.meteousers.service;
	exports otus.moryakovdv.meteousers.model;
	exports otus.moryakovdv.meteousers.repository;
	exports otus.moryakovdv.meteousers.web;
	exports  otus.moryakovdv.meteousers;

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
	
	requires transitive  io.github.resilience4j.circuitbreaker;
	requires transitive io.github.resilience4j.annotations;
	
	requires transitive  io.github.resilience4j.ratelimiter;
	requires transitive  io.github.resilience4j.core;
	
}