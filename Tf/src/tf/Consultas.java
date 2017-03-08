package tf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Eduardo Dornelles CLASSE DAS CONSULTAS SOLICITADAS NO TRABALHO 1 -
 *         Exibir as linhas de ônibus que passam em uma determinada parada. OK 2
 *         - Exibir todas as paradas de uma linha de ônibus. OK 3 - Exibir as
 *         linhas de ônibus que passam em um conjunto de paradas selecionadas. -
 *         OK
 */

public class Consultas {

	private Ler_arquivo linhas;
	private Ler_arquivo paradalinha;
	private Ler_arquivo paradas;

	public Consultas() { // construtor -> leitura dos 3 arquivos para realizar
							// as consultas
		linhas = new Ler_arquivo("linhas.csv");
		paradalinha = new Ler_arquivo("paradalinha.csv");
		paradas = new Ler_arquivo("paradas.csv");
	}

	public boolean temParada(int codigo) { // verificar se a parada existe
		Mapa_parada ma = Ler_arquivo.getParadas();
		if (ma.verParada(codigo)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * CONSULTA 1 linhas de ônibus que passam em uma determinada parada. retorna
	 * uma arraylist com os nomes dos onibus que passam na parada passada por
	 * parametro (codigo da parada).
	 */

	public ArrayList<String> linhas_parada(int codigo) {
		if (temParada(codigo)) { // verifica se existe a parada passada por
									// parametro
			Mapa_parada map = Ler_arquivo.getParadas();
			ArrayList<String> saida = new ArrayList<String>();
			
			int lin = map.id_da_parada(codigo); 
			ArrayList<Integer> entrada = Ler_arquivo.getParadalinhas().buscaLinhas(lin); //ids das linhas que passam na parada

			Mapa_linha li = Ler_arquivo.getLinhas(); // pegar o mapa de linhas
			
						
			for (int x:entrada){			
				
				String linha = li.tem_linha(x);
				if (saida.contains(linha)){continue;}
				saida.add(linha);
			}


			return saida;
		}

		return null;
	}

	/**
	 * CONSULTA 2 retorna um ArrayList com os codigos das paradas que uma
	 * determinada linha (passada por parametro) passa.
	 ** 
	 */
	public ArrayList<Integer> paradas_linha1(String linha) { // paradas da linha de onibus no sentido 1
		ArrayList<Integer> par = new ArrayList<Integer>(); // lista dos codigos
															// das paradas
		ArrayList<Integer> idparadas = new ArrayList<Integer>();
		Mapa_linha li = Ler_arquivo.getLinhas(); // pegar lista de linhas
		Mapa_linhaparada pa = Ler_arquivo.getLinhaparadas(); // pegar a lista
																// linhaparada
		Mapa_parada mpa = Ler_arquivo.getParadas(); //lista de paradas

		ArrayList<Integer> idlinha = li.idlinha(linha);

		idparadas = pa.paradas(idlinha.get(0));  //pega os ids paradas do primeiro sentido
		for (int x : idparadas) {
			if (mpa.cod_parada(x) == -1) {
				continue;
			} else {
				int parada = mpa.cod_parada(x); // pega o nome do codigo
												// buscando pelo id parada
				if (par.contains(parada)) {
					continue;
				} else {
					par.add(parada);
				}

			}

		}

		return par;
	}

	public ArrayList<Integer> paradas_linha2(String linha) { // paradas da linha de onibus no sentido 2
		ArrayList<Integer> par = new ArrayList<Integer>(); 
		ArrayList<Integer> idparadas = new ArrayList<Integer>();
		Mapa_linha li = Ler_arquivo.getLinhas();
		Mapa_linhaparada pa = Ler_arquivo.getLinhaparadas(); 		
		Mapa_parada mpa = Ler_arquivo.getParadas();

		ArrayList<Integer> idlinha = li.idlinha(linha);

		idparadas = pa.paradas(idlinha.get(1)); //pega os ids paradas do segundo sentido
		for (int x : idparadas) {
			if (mpa.cod_parada(x) == -1) {
				continue;
			} else {
				int parada = mpa.cod_parada(x);
				if (par.contains(parada)) { //
					continue;
				} else {
					par.add(parada);
				}

			}

		}

		return par;
	}

	/**
	 * CONSULTA 3 retorna um mapa de linhas de ônibus que passam em um conjunto
	 * de paradas passadas por parametro (arraylist - cod parada).
	 */
	public Map<Integer, ArrayList<String>> onibus_paradas(ArrayList<Integer> lista_paradas) {
		Mapa_parada map = Ler_arquivo.getParadas();
		Map<Integer, ArrayList<String>> conjunto = new HashMap<Integer, ArrayList<String>>();
		Mapa_paradalinha ma = Ler_arquivo.getParadalinhas();
		Mapa_linha li = Ler_arquivo.getLinhas();
		
		

		for (int x : lista_paradas) {
			int lin = map.id_da_parada(x); 
			if (ma.buscaLinhas(lin).contains(0)) {
				conjunto.put(x, null);

			} else {
				conjunto.put(x, li.nome_linhas(ma.buscaLinhas(lin)));
			}
		}

		return conjunto;
	}

	/**
	 * Os dois metodos abaixo são adicionais para uso de pesquisa das listas
	 * (linhas/paradas) dentro do programa
	 */
	public ArrayList<String> mostrar_codigos() { // listar o codigo de todas as
													// paradas em string
		Mapa_parada pa = Ler_arquivo.getParadas();
		ArrayList<Integer> cod_parada = pa.lista_parada(); // pegar a lista de
															// id_paradas
		ArrayList<String> lista = new ArrayList<>();
		for (int x : cod_parada) {
			int aux = pa.cod_parada(x);
			lista.add(Integer.toString(aux));
		}
		return lista;
	}

	public ArrayList<String> mostrar_nomes() { // listar o nome de todas as
												// linhas
		Mapa_linha li = Ler_arquivo.getLinhas();
		ArrayList<String> lista = li.listar_linhas();
		return lista;
	}

}
