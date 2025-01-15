package Restaurante;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

/*
 * Sistema de Gerenciamento do Restaurante
 * Este sistema permite:
 * - Registrar vendas diárias.
 * - Consultar vendas de dias específicos.
 * - Gerar resumos mensais de vendas.
 * Ele salva os dados em arquivos organizados por data e os armazena em um diretório específico.
 */

public class RestauranteSistema {

		public static void main(String[] args) {
			
			Scanner scan = new Scanner(System.in);
			boolean continuar = true;
			
			
			// Variáveis para armazenar as vendas do dia
			int marmita = 0;
			int pratoFeito = 0;
			int refrigerante = 0;
			int suco = 0;
			int salgado = 0;
			int misto = 0;
			int paoDeQueijo = 0;
			int doce = 0;
			
			
			while (continuar) {
				
				// Exibe o menu principal do sistema
				System.out.println("\n=== Sistema do Restaurante ===");
				System.out.println("1. Registrar vendas");
				System.out.println("2. Mostrar resumo do dia");
				System.out.println("3. Fechar caixa");
				System.out.println("4. Consultar vendas por data");
				System.out.println("5. Gerar resumo do mês");
				System.out.println("0. Sair");
				System.out.println("Escolha uma opção");
				
				int opcao = scan.nextInt();
				
				// Processa a escolha do usuário
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
						
						// Incrementa a quantidade vendida com base no item selecionado
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
						// Mostra o resumo das vendas do dia 
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
						// Salva os dados do dia e zera as variáveis
						salvarVendasDiarias(marmita, pratoFeito, refrigerante, suco, salgado, misto, paoDeQueijo, doce);
						System.out.println("\n=== Fechamento do caixa ===");
						int totalVendas = marmita + pratoFeito + refrigerante + suco + salgado + misto + paoDeQueijo + doce;
						System.out.println("Total de itens vendidos: " + totalVendas);
						break;
						
					case 4:
						// Consulta vendas de um dia específico
						consultarVendasPorData();
						break;
						
					case 5:
						// Gera um resumo consolidado do mês
						System.out.println("DIgite o mês no formato AAAA-MM");
						String mes = scan.next();
						gerarResumoMensal(mes);
						break;
						
					case 0: 
						// Finaliza o programa
						System.out.println("Encerrando o sistema...");
						continuar = false;
						break;
						
						default:
							System.out.println("Opção inválida! Tente novamente.");
				}
			}
		}
		
		/**
		 * Salva os dados das vendas diárias em um arquivo nomeado com a data atual.
		 * O arquivo é salvo no diretório "registros".
		 * 
		 * @param marmita        Número de marmitas vendidas.
		 * @param pratoFeito     Número de pratos feitos vendidos.
		 * @param refrigerante   Número de refrigerantes vendidos.
		 * @param suco           Número de sucos vendidos.
		 * @param salgado        Número de salgados vendidos.
		 * @param misto          Número de mistos vendidos.
		 * @param paoDeQueijo    Número de pães de queijo vendidos.
		 * @param doce           Número de doces vendidos.
		 */
		
		public static void salvarVendasDiarias(int marmita, int pratoFeito, int refrigerante, int suco, int salgado, int misto, int paoDeQueijo, int doce) {
			
			String diretorio = "registros";
			File pasta = new File(diretorio);
			
			if (!pasta.exists()) {
				if (pasta.mkdir()) {
					System.out.println("Diretório 'registros' criado com sucesso");
				} else {
					System.out.println("Falha ao criar o diretório 'registros'.");
					return;
				}
			}
			
			String dataAtual = LocalDate.now().toString();
			String nomeArquivo = diretorio + "/" + dataAtual + ".txt";
			
			try (FileWriter writer = new FileWriter(nomeArquivo)) {
				writer.write("Marmitas: " + marmita + "\n");
				writer.write("Pratos Feitos: " + pratoFeito + "\n");
		        writer.write("Refrigerantes: " + refrigerante + "\n");
		        writer.write("Sucos: " + suco + "\n");
		        writer.write("Salgados: " + salgado + "\n");
		        writer.write("Mistos: " + misto + "\n");
		        writer.write("Pães de Queijo: " + paoDeQueijo + "\n");
		        writer.write("Doces: " + doce + "\n");
		        System.out.println("Vendas do dia salvas com sucesso em: " + new File(nomeArquivo).getAbsolutePath());
			} catch (IOException e) {
				System.out.println("Erro ao salvar vendas: " + e.getMessage());
			}
		}
		
		/*
		 * Consulta vendas registradas para uma data específica
		 */
		public static void consultarVendasPorData() {
			Scanner scan = new Scanner(System.in);
			System.out.println("Digite a data no formato AAAA-MM-DD para consultar vendas: ");
			String data = scan.nextLine();
			String nomeArquivo = "registros/" + data + ".txt";
			
			File arquivo = new File(nomeArquivo);
			if (!arquivo.exists()) {
				System.out.println("Nenhum registro encontrado para a data" + data);
				return;
			}
			
			try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
				String linha;
				System.out.println("\nVendas do dia " + data + ": ");
				while ((linha = reader.readLine()) != null) {
					System.out.println(linha);
				}
			} catch (IOException e) {
				System.out.println("Não foi possível carregar as vendas para data " + data + ": " + e.getMessage());
			}
		}
		
		 /*
	     * Gera um resumo consolidado das vendas para um mês específico.
	     */
		public static void gerarResumoMensal(String mes) {
			int marmita = 0, pratoFeito = 0, refrigerante = 0, suco = 0, salgado = 0, misto = 0, paoDeQueijo = 0, doce = 0;
			
			File pasta = new File("registros");
			File[] arquivos = pasta.listFiles((dir, nome) ->nome.startsWith(mes) && nome.endsWith(".txt"));
			
			if (arquivos != null) {
				for (File arquivo : arquivos) {
					try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
						  marmita += Integer.parseInt(reader.readLine().split(": ")[1]);
			                pratoFeito += Integer.parseInt(reader.readLine().split(": ")[1]);
			                refrigerante += Integer.parseInt(reader.readLine().split(": ")[1]);
			                suco += Integer.parseInt(reader.readLine().split(": ")[1]);
			                salgado += Integer.parseInt(reader.readLine().split(": ")[1]);
			                misto += Integer.parseInt(reader.readLine().split(": ")[1]);
			                paoDeQueijo += Integer.parseInt(reader.readLine().split(": ")[1]);
			                doce += Integer.parseInt(reader.readLine().split(": ")[1]);
					} catch (IOException e) {
						System.out.println("Erro ao processar arquivo: " + arquivo.getName());
					}
				}
				
				System.out.println("\nResumo do mês " + mes + ":");
		        System.out.println("Marmitas: " + marmita);
		        System.out.println("Pratos Feitos: " + pratoFeito);
		        System.out.println("Refrigerantes: " + refrigerante);
		        System.out.println("Sucos: " + suco);
		        System.out.println("Salgados: " + salgado);
		        System.out.println("Mistos: " + misto);
		        System.out.println("Pães de Queijo: " + paoDeQueijo);
		        System.out.println("Doces: " + doce);
				
			} else {
				System.out.println("Nenhum arquivo encontrado para o mês " + mes);
			}
		}
}
