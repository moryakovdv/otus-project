open module otus.moryakovdv.meteohelpers {
	exports otus.moryakovdv.meteohelpers.service;
	exports otus.moryakovdv.meteohelpers.model;
	exports otus.moryakovdv.meteohelpers.repository;
	exports otus.moryakovdv.meteohelpers.web;
	exports  otus.moryakovdv.meteohelpers;

	requires transitive jakarta.servlet;
	requires jakarta.persistence;
		
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
	
	
}