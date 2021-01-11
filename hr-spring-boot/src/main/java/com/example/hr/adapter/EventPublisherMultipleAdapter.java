package com.example.hr.adapter;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hr.event.EmployeeEvent;
import com.example.hr.infrastructure.EventPublisher;

@Service
public class EventPublisherMultipleAdapter implements EventPublisher<EmployeeEvent> {

	@Autowired
	private List<EventPublisher<EmployeeEvent>> publishers;

	@PostConstruct
	public void init() {
		publishers.stream().map(Object::getClass).map(Class::getSimpleName)
		.forEach(System.out::println);
	}

	@Override
	public void publishEvent(EmployeeEvent event) {
		publishers.forEach(publisher -> publisher.publishEvent(event));
	}

}
