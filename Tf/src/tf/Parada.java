package tf;
/**  
 * @author Eduardo
 * Classe com os dados das paradas.
 */
 

public class Parada {

	private int id_parada;
	private int codigo;
	private double longitude;
	private double latitude;
	private char terminal;

	public Parada(int id_parada, int codigo, double longitude, double latitude,
			char terminal) {
		super();
		this.id_parada = id_parada;
		this.codigo = codigo;
		this.longitude = longitude;
		this.latitude = latitude;
		this.terminal = terminal;
	}

	public int getId_parada() {
		return id_parada;
	}

	public void setId_parada(int id_parada) {
		this.id_parada = id_parada;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(long longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(long latitude) {
		this.latitude = latitude;
	}

	public char getTerminal() {
		return terminal;
	}

	public void setTerminal(char terminal) {
		this.terminal = terminal;
	}

	@Override
	public String toString() {
		return "Parada [id_parada=" + id_parada + ", codigo=" + codigo
				+ ", longitude=" + longitude + ", latitude=" + latitude
				+ ", terminal=" + terminal + "]";
	}

}
