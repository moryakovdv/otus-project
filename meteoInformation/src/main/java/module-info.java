open module otus.moryakovdv.meteoinformation {
	exports otus.moryakovdv.meteoinformation.service;
	exports otus.moryakovdv.meteoinformation.model;
	exports otus.moryakovdv.meteoinformation.repository;
	exports otus.moryakovdv.meteoinformation.web;
	exports  otus.moryakovdv.meteoinformation;

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
	
	
	
	requires reactor.core;
	requires org.reactivestreams;
	requires micrometer.observation;

}