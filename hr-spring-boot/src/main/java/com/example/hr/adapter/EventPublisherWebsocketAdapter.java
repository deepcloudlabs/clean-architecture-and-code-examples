package com.example.hr.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import com.example.hr.event.EmployeeEvent;
import com.example.hr.infrastructure.EventPublisher;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
//@Service
public class EventPublisherWebsocketAdapter implements EventPublisher<EmployeeEvent> {
	@Autowired
	private SimpMessagingTemplate messagingTemplate;

	@Override
	public void publishEvent(EmployeeEvent event) {
		messagingTemplate.convertAndSend("changes", event);
	}

}
