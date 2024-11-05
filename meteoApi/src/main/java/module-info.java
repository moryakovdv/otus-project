open module otus.moryakovdv.meteoapi {
	

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
	requires com.fasterxml.jackson.core;
	requires com.fasterxml.jackson.databind;


	requires transitive io.github.resilience4j.circuitbreaker;
	requires transitive io.github.resilience4j.annotations;

	requires transitive io.github.resilience4j.ratelimiter;
	requires transitive io.github.resilience4j.core;

	requires io.swagger.v3.oas.models;
	requires io.swagger.v3.oas.annotations;
	requires micrometer.observation;
	
	requires transitive otus.moryakovdv.meteoservices;
	
	exports otus.moryakovdv.meteoapi;


}