package com.example.demo.component;

import com.example.demo.dto.PropostaDTO;
import com.example.demo.service.AnaliseCreditoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AnaliseConsumer {

    private static final Logger log = LoggerFactory.getLogger(AnaliseConsumer.class);

    @Autowired
    private AnaliseCreditoService analiseService;

    @RabbitListener(queues = "${bdmg.queue.name}", containerFactory = "rabbitListenerContainerFactory")
    public void ouvirProposta(PropostaDTO proposta) {
        log.info("Mensagem recebida da fila RabbitMQ: Protocolo {}", proposta.getProtocolo());
        analiseService.processar(proposta);
    }

}
