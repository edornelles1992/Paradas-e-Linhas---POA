package tf;
/**
 * @author Eduardo
 * Classe para armazenar os dados
 * de parada dos onibus
 */
public class Parada_linha {

	private int id_linha;
	private int id_parada;

	public Parada_linha(int idlinha, int idparada) {
		super();
		this.id_linha = idlinha;
		this.id_parada = idparada;
	}

	public int getId_linha() {
		return id_linha;
	}

	public void setId_linha(int id_linha) {
		this.id_linha = id_linha;
	}

	public int getId_parada() {
		return id_parada;
	}

	public void setId_parada(int id_parada) {
		this.id_parada = id_parada;
	}



	@Override
	public String toString() {
		return "Parada_linha [idlinha=" + id_linha + ", idparada=" + id_parada
				+ "]";
	}

}
