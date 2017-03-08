package tf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
/**
 * @author Eduardo Dornelles
 * CHAVE: idparada VALOR: lista de idlinhas vinculada a essa idparada 
 *  
 */


public class Mapa_paradalinha {

	Map<Integer, ArrayList<Integer>> paradalinhas = new HashMap<Integer, ArrayList<Integer>>();
	
	public void add(Parada_linha li){
		if (paradalinhas.containsKey(li.getId_parada())){ //adiciona uma linha a parada já existente no mapa
			ArrayList<Integer> aux = paradalinhas.get(li.getId_parada());
			aux.add(li.getId_linha());
		paradalinhas.put(li.getId_parada(),aux);
		
		} else { // cria chave e ja insere o primeiro valor
			ArrayList<Integer> novo = new ArrayList<>();
			novo.add(li.getId_linha());
			paradalinhas.put(li.getId_parada(), novo);
			
		}
	}	
	
	/**
	 * Buscar linhas que passam numa parada
	 * passada por parametro (idparada).
	 * retorna um ArrayList de inteiros contendo os IDs
	 * das linhas
	 */
	public ArrayList<Integer> buscaLinhas(int idparada){ //retornar ids linhas vinculado a um id_parada 
		ArrayList<Integer> lista_linha;		
		
		
		lista_linha = paradalinhas.get(idparada); // devolve os valores que é uma lista de inteiros
		if (lista_linha==null||lista_linha.size()==0||lista_linha.isEmpty()){// caso seja uma parada sem linhas ativas
			lista_linha = new ArrayList<>();
			lista_linha.add(new Integer(0));
		}
		return lista_linha;
	}
	
}
