open module otus.moryakovdv.meteoapi {
	exports otus.moryakovdv.meteoapi.service;
	//exports otus.moryakovdv.meteoapi.web;
	exports  otus.moryakovdv.meteoapi;

	requires transitive jakarta.servlet;
	
	
	requires jakarta.annotation;
	
	requires otus.moryakovdv.meteohelpers; 

	
	requires lombok;
	requires org.slf4j;
	requires spring.beans;
	requires spring.boot;
	requires spring.boot.autoconfigure;
	requires spring.context;
	requires spring.core;

	requires spring.web;
	
	requires transitive  io.github.resilience4j.circuitbreaker;
	requires transitive io.github.resilience4j.annotations;
	
	requires transitive  io.github.resilience4j.ratelimiter;
	requires transitive  io.github.resilience4j.core;
	
	requires io.swagger.v3.oas.models;
	requires io.swagger.v3.oas.annotations;
	requires micrometer.observation;
	
}