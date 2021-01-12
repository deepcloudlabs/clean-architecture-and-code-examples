package com.example.hr.adapter;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.example.hr.event.EmployeeEvent;
import com.example.hr.infrastructure.EventPublisher;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class EventPublisherRabbitAdapter implements EventPublisher<EmployeeEvent> {
	// @Autowired // field injection
	private RabbitTemplate rabbitTemplate;
	// @Autowired
	private ObjectMapper mapper;

	// Constructor Injection
	public EventPublisherRabbitAdapter(RabbitTemplate rabbitTemplate, ObjectMapper mapper) {
		this.rabbitTemplate = rabbitTemplate;
		this.mapper = mapper;
	}

	// @Autowired // setter injection
	public void setRabbitTemplate(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	// @Autowired
	public void setMapper(ObjectMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public void publishEvent(EmployeeEvent event) {
		try {
			rabbitTemplate.convertAndSend(mapper.writeValueAsString(event));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
