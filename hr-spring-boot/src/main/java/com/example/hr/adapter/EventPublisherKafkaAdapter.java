package com.example.hr.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.hr.event.EmployeeEvent;
import com.example.hr.infrastructure.EventPublisher;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
@Service
public class EventPublisherKafkaAdapter implements EventPublisher<EmployeeEvent> {
	@Autowired
	private KafkaTemplate<String, EmployeeEvent> kafkaTemplate;

	@Override
	public void publishEvent(EmployeeEvent event) {
		kafkaTemplate.send("employees", event);
	}

}
