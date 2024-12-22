# Sistema de Gerenciamento do Restaurante

Este é um sistema simples para gerenciar as vendas de um restaurante. Ele permite registrar vendas, exibir resumos diários e calcular o fechamento do caixa.

## Funcionalidades
- Registro de vendas: Marmitas, Pratos Feitos, Bebidas (Refrigerantes, Sucos) e Lanches (Salgados, Mistos, Pães de Queijo e Doces).
- Resumo do dia: Quantidade de itens vendidos.
- Fechamento do caixa: Total de vendas no dia.

## Como executar
1. Certifique-se de ter o Java instalado:
   - Para verificar, execute: `java -version`
   - Para compilar, execute: `javac -version`

2. Compile o código:
   Navegue até a pasta `src` e execute:
   ```bash
   javac Restaurante/RestauranteSistema.java
   
3. Execute o sistema:
   java Restaurante/RestauranteSistema

## Estrutura do Projeto

restaurante-sistema/
├── src/
│   └── Restaurante/
│       └── RestauranteSistema.java    # Código-fonte principal
├── .gitignore                         # Arquivos ignorados pelo Git
├── README.md                          # Documentação do projeto

## Próximas Melhorias

Este projeto está em evolução e, ao longo do tempo, pretende incorporar novas funcionalidades:

- [ ] Adicionar persistência de dados (salvar vendas em arquivo ou banco de dados).
- [ ] Criar relatórios detalhados de vendas (lucro, itens mais vendidos, etc.).
- [ ] Desenvolver uma interface gráfica para facilitar o uso.
- [ ] Implementar autenticação de usuários para acesso ao sistema.
- [ ] Adicionar exportação de relatórios em formato PDF.

Contribuições ou sugestões são bem-vindas para aprimorar o sistema!

## Exemplo de Funcionamento

Aqui está um exemplo do programa em execução:

![Execução do Programa](assets/Sistema-2.png)

Na imagem acima, é possível ver como o sistema registra vendas e exibe o resumo do dia.

