package tf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
/**
 * @author Eduardo
 * CHAVE: id da parada, VALOR: variavel a qual pertence o idparada
 */
 
public class Mapa_parada {

	Map<Integer, Parada> paradas = new HashMap<Integer, Parada>();
	
	public void add(Parada li){
		paradas.put(li.getId_parada(), li);
		
	}	
	
	public boolean verParada(int codigo){ //verificar se existe uma parada
		
		Set<Map.Entry<Integer, Parada>> set = paradas.entrySet();	
		for (Entry<Integer, Parada> me : set) { 
	
			Parada pa = me.getValue();
			if (pa.getCodigo()==codigo){
				return true;
							}		
			
		}
		
		return false;
	}
	
	public ArrayList<Integer> lista_parada (){ //listar todas os  id_paradas
		ArrayList<Integer> lista = new ArrayList<>();		
		Set<Map.Entry<Integer, Parada>> set = paradas.entrySet();	
		for (Entry<Integer, Parada> me : set) { 
			
			lista.add(me.getKey());
		}
		return lista;
	}
	
	public int cod_parada(int idcodigo){ //localizar o codigo da parada passando o id linha como parametro
		if(paradas.containsKey(idcodigo)){
			Parada pa =  paradas.get(idcodigo);
			return pa.getCodigo();
		}
		else return -1;
	}
	
	public int id_da_parada (int codigo){ //retornar o id de uma parada recebendo o codigo como parametro
		Set<Map.Entry<Integer, Parada>> set = paradas.entrySet();	
		for (Entry<Integer, Parada> me : set) { 
			if (me.getValue().getCodigo()==codigo)	{	
				return me.getKey();
			}	
			
		}
		return -1;
	}
}


