package com.example.demo.service;

import com.example.demo.dto.PropostaDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AnaliseCreditoService {

    private static final Logger log = LoggerFactory.getLogger(AnaliseCreditoService.class);
    private static final BigDecimal LIMITE_HUMANO = new BigDecimal("100000");
    private static final BigDecimal LIMITE_MINIMO = new BigDecimal("500");

    public void processar(PropostaDTO proposta) {
        log.info("Iniciando motor de regras para Protocolo: {}", proposta.getProtocolo());

        try {
            Thread.sleep(2000); // Simulando consulta externa
            BigDecimal valor = proposta.getValor();

            if (valor.compareTo(LIMITE_HUMANO) > 0) {
                log.warn(">>> STATUS: [EM ANÁLISE] - Valor R$ {} exige Comitê Regional.", valor);
            } else if (valor.compareTo(LIMITE_MINIMO) < 0) {
                log.error(">>> STATUS: [REPROVADO] - R$ {} abaixo do mínimo operacional.", valor);
            } else {
                log.info(">>> STATUS: [APROVADO] - Cliente: {}", proposta.getClienteNome());
            }

        } catch (InterruptedException e) {
            log.error("Erro no processamento da proposta {}", proposta.getProtocolo(), e);
            Thread.currentThread().interrupt();
        }
    }

}
