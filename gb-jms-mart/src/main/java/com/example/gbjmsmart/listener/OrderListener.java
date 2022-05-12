package com.example.gbjmsmart.listener;

import com.example.gbjmsmart.config.JmsConfig;
import com.example.gbjmsmart.sender.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import ru.gb.gbapi.events.OrderEvent;

@Component
@RequiredArgsConstructor
public class OrderListener {

	private final MailService mailService;

	@JmsListener(destination = "${order.changed.queue}")
	public void listen(@Payload OrderEvent orderEvent) {
		mailService.sendSimpleMessage(orderEvent.getOrderDto().getMail(), "Change order", orderEvent.getOrderDto().toString());
	}
}
