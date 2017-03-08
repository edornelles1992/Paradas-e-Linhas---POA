package tf;
import java.util.ArrayList;
/** 
 * @author Eduardo
 *Classe com os dados das linhas de onibus
 */
public class Linha {

	private int id_linha;
	private String nome;
	private String codigo;
	private char tipo;

	public Linha(int idlinha, String nome, String codigo, char tipo) {
		super();
		this.id_linha = idlinha;
		this.nome = nome;
		this.codigo = codigo;
		this.tipo = tipo;

	}

	public int getId_linha() {
		return id_linha;
	}

	public void setId_linha(int id_linha) {
		this.id_linha = id_linha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Linha [idlinha=" + id_linha + ", nome=" + nome + ", codigo="
				+ codigo + ", tipo=" + tipo + "]";
	}

}
