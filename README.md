# 🏦 Sistema de Análise de Crédito (Consumer)

Este microserviço é responsável pelo processamento assíncrono de propostas de crédito enviadas via **RabbitMQ**. O sistema atua como o "Motor de Regras", decidindo o destino de cada proposta com base em critérios financeiros.

## 🚀 Tecnologias
* **Java 21** (Amazon Corretto)
* **Spring Boot 3.3.4**
* **Spring AMQP** (RabbitMQ)
* **CloudAMQP** (LavinMQ Managed Service)
* **Jackson** (Serialização JSON)

## 🛠️ Arquitetura da Solução
A solução utiliza o padrão **Publisher-Subscriber**.
1. O **Producer** envia a proposta para a `bdmg.analise.exchange`.
2. A Exchange roteia para a fila `proposta.analise.queue` via a chave `proposta.solicitada.key`.
3. Este **Consumer** processa a mensagem e aplica as regras de negócio.

## ⚖️ Regras de Negócio Simuladas
| Valor (R$) | Status | Ação |
| :--- | :--- | :--- |
| > 100.000,00 | **EM ANÁLISE** | Encaminhado para Comitê Regional |
| < 500,00 | **REPROVADO** | Abaixo do limite operacional |
| Outros valores | **APROVADO** | Crédito pré-aprovado via motor |

## ⚙️ Como Executar
1. Configure as credenciais do CloudAMQP no `application.properties`.
2. Execute o comando:
   ```bash
   mvn spring-boot:run