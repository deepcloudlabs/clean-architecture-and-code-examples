package com.example.hr.infrastructure;

public interface EventPublisher<Event> {

	void publishEvent(Event event);

}
