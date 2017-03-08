package tf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

/**
 * @author Eduardo Dornelles
 * CHAVE: idlinha VALOR: lista idparada vinculada a esse idlinha
 */
public class Mapa_linhaparada {

	Map<Integer, ArrayList<Integer>> linhaparada = new HashMap<Integer, ArrayList<Integer>>();

	public void add(Parada_linha li) {
		if (linhaparada.containsKey(li.getId_linha())) { // adiciona uma linha a
															// parada já
															// existente no mapa
			ArrayList<Integer> aux = linhaparada.get(li.getId_linha());
			aux.add(li.getId_parada());
			linhaparada.put(li.getId_linha(), aux);

		} else { // cria chave e ja insere o primeiro valor
			ArrayList<Integer> novo = new ArrayList<>();
			novo.add(li.getId_parada());
			linhaparada.put(li.getId_linha(), novo);

		}
	}

	

	/**
	 * metodo para retornar um lista de IDparadas do mapa recebendo como
	 * parametro um ID_linha *
	 */
	public ArrayList<Integer> paradas(int idlinha) {

		ArrayList<Integer> lista = linhaparada.get(idlinha);

		return lista;
	}

}
