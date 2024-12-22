package Restaurante;

import java.util.Scanner;

public class RestauranteSistema {

		public static void main(String[] args) {
			
			Scanner scan = new Scanner(System.in);
			boolean continuar = true;
			
			
			// Variáveis para armazenar as vendas
			int marmita = 0;
			int pratoFeito = 0;
			int refrigerante = 0;
			int suco = 0;
			int salgado = 0;
			int misto = 0;
			int paoDeQueijo = 0;
			int doce = 0;
			
			
			while (continuar) {
				
				// Exibe o menu
				System.out.println("\n=== Sistema do Restaurante ===");
				System.out.println("1. Registrar vendas");
				System.out.println("2. Mostrar resumo do dia");
				System.out.println("3. Fechar caixa");
				System.out.println("0. Sair");
				System.out.println("Escolha uma opção");
				
				int opcao = scan.nextInt();
				
				// Lida com a escolha do usuário
				switch (opcao) {
					case 1:
						System.out.println("\n=== Registrar vendas ===");
						System.out.println("1. Marmita");
						System.out.println("2. Prato Feito");
						System.out.println("3. Refrigerante");
						System.out.println("4. Suco");
						System.out.println("5. Salgado");
						System.out.println("6. Misto");
						System.out.println("7. Pão de Queijo");
						System.out.println("8. Doce");
						System.out.println("Escolha o item para registrar a venda");
						
						int item = scan.nextInt();
						System.out.println("Quantos foram vendidos? ");
						int quantidade = scan.nextInt();
						
						switch(item) {
							case 1:
								marmita += quantidade;
								System.out.println(quantidade + " marmita(s) registrada(s)");
								break;
							case 2:
								pratoFeito += quantidade;
								System.out.println(quantidade + " prato(s) feito(s) registrado(s)");
								break;
							case 3:
								refrigerante += quantidade;
								System.out.println(quantidade + " refrigerante(s) registrado(s)");
								break;
							case 4:
								suco += quantidade;
								System.out.println(quantidade + " suco(s) registrado(s)");
								break;
							case 5:
								salgado += quantidade;
								System.out.println(quantidade + " salgado(s) registrado(s)");
								break;
							case 6:
								misto += quantidade;
								System.out.println(quantidade + " misto(s) registrado(s)");
								break;
							case 7:
								paoDeQueijo += quantidade;
								System.out.println(quantidade + " Pão de Queijo registrado(s)");
								break;
							case 8:
								doce += quantidade;
								System.out.println(quantidade + " Doce(s) registrado(s)");
								break;
							default:
								System.out.println("Item inválido! Tente novamente.");
								
						}
						
						break;
						
					case 2:
						System.out.println("\n=== Resumo do dia ===");
						System.out.println("Marmitas vendidas: " + marmita);
						System.out.println("Pratos feitos vendidas: " + pratoFeito);
						System.out.println("Refrigerantes vendidos: " + refrigerante);
						System.out.println("Sucos vendidos: " + suco);
						System.out.println("Salgados vendidos: " + salgado);
						System.out.println("Mistos vendidos: " + misto);
						System.out.println("Pães de Queijo vendidos: " + paoDeQueijo);
						System.out.println("Doces vendidos: " + doce);
						break;
						
					case 3:
						System.out.println("\n=== Fechamento do caixa ===");
						int totalVendas = marmita + pratoFeito + refrigerante + suco + salgado + misto + paoDeQueijo + doce;
						System.out.println("Total de itens vendidos: " + totalVendas);
						break;
						
					case 0: 
						System.out.println("Encerrando o sistema...");
						continuar = false;
						break;
						
						default:
							System.out.println("Opção inválida! Tente novamente.");
				}
			}
		}
}
