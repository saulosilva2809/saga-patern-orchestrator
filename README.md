# Java — Saga Pattern (Orchestration)

Projeto básico desenvolvido em Java com o objetivo de estudar o **Saga Pattern utilizando a abordagem de Orchestration**, explorando transações distribuídas, coordenação de serviços e operações compensatórias.

## Objetivo

Simular um cenário de compras em um sistema de e-commerce, onde diferentes serviços são responsáveis por etapas independentes do processo de compra, como criação do pedido, reserva de estoque, processamento do pagamento e solicitação de envio.

O principal objetivo é implementar um **Saga Orchestrator**, responsável por controlar a sequência das operações, acompanhar as etapas concluídas e executar transações compensatórias caso alguma etapa apresente falha.

**Projeto desenvolvido para fins de estudo**, explorando o padrão Saga, consistência eventual e estratégias de compensação em sistemas distribuídos.