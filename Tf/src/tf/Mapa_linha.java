package tf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

/**
 * @author Eduardo Chave: Id_linha VALOR : classe referente ao Id_linha
 */
public class Mapa_linha {

	Map<Integer, Linha> linhas = new HashMap<Integer, Linha>();

	public void add(Linha li) {
		linhas.put(li.getId_linha(), li);

	}
	

	public ArrayList<Integer> idlinha(String linha) { // retorna os ids das linhas com este nome 1/2
		ArrayList<Integer> lin = new ArrayList<Integer>();
		Set<Map.Entry<Integer, Linha>> set = linhas.entrySet();
		
		for (Entry<Integer, Linha> me : set) {
			Linha nova = linhas.get(me.getKey());
			if (nova.getNome().equalsIgnoreCase(linha)) {
				lin.add(nova.getId_linha());
				
			}
		}

		return lin;
		
	}
	
	public String tem_linha(int idlinha){ //busca o nome da linha recebendo o id como parametro
		if (linhas.containsKey(idlinha)){
			Linha li = linhas.get(idlinha);
			return li.getNome();
			
		}
		return null;
	}

	/**
	 * retorna um arraylist de string contendo o nome das linhas passadas por
	 * parametro(id linha)
	 *
	 */

	public ArrayList<String> nome_linhas(ArrayList<Integer> id_linha) {

		ArrayList<String> lista = new ArrayList<String>();

		if (id_linha.size() == 0 || id_linha.isEmpty()) {
			lista.add("Sem paradas");
			return lista;

		}
		for (int e : id_linha) {

			Linha linha = linhas.get(e);
			if (lista.contains(linha.getNome())) {
				continue;
			}
			lista.add(linha.getNome());
		}

		return lista;

	}

	public ArrayList<String> listar_linhas() { // retornar uma lista com os
												// nomes de TODAS as linhas
		ArrayList<String> lista = new ArrayList<>();

		Set<Map.Entry<Integer, Linha>> set = linhas.entrySet();
		for (Entry<Integer, Linha> me : set) {
			Linha nova = linhas.get(me.getKey());
			if (lista.contains(nova.getNome())) {
				continue;
			}

			else {
				lista.add(nova.getNome());
			}
		}

		return lista;
	}

}
