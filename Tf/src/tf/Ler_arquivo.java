package tf;
/** 
 * @author Eduardo Dornelles
 * Classe para realizar a leitura dos 3 arquivos solicitados no trabalho
 * 
 *
 */
public class Ler_arquivo extends ArquivoTexto {

	private String arquivo;

	private static Mapa_linha linhas = new Mapa_linha();
	private static Mapa_parada paradas = new Mapa_parada();
	private static Mapa_paradalinha paradalinhas = new Mapa_paradalinha();
	private static Mapa_linhaparada linhaparadas = new Mapa_linhaparada();

	public Ler_arquivo(String arquivo) { // recebe o arquivo por parametro
		this.arquivo = arquivo;
		LeArquivo();

	}

	public static Mapa_linhaparada getLinhaparadas() {
		return linhaparadas;
	}

	public static Mapa_paradalinha getParadalinhas() {
		return paradalinhas;
	}

	public static Mapa_parada getParadas() {
		return paradas;
	}

	public String getArquivo() {
		return arquivo;
	}

	public static Mapa_linha getLinhas() {
		return linhas;
	}

	/**
	 * metodo para fazer as leituras dos arquivos.
	 */
	public void LeArquivo() {

		abrirParaLeitura(arquivo);
		boolean res = true;

		String primeira = lerLinhaArquivo(); // pular a primeira linha

		while (res == true) {

			String linha = lerLinhaArquivo();

			if (linha == null) {
				res = false;
			} else {

				linha = linha.replaceAll("[\"\']", "");
				linha = linha.trim(); // eliminar espaço em branco

				String[] str = linha.split(";");
				armazena(str); // armazenar na lista

			}

		}
		fechar();
	}

	/**
	 * recebe o array de string do arquivo e armazena no mapa correto de acordo
	 * com o arquivo.
	 */
	public void armazena(String[] str) {
		if (arquivo.equals("linhas.csv")) {
			int idlinha = Integer.parseInt(str[0]);
			String nome = str[1];
			String codigo = str[2];
			char tipo = str[3].charAt(0);

			Linha nova = new Linha(idlinha, nome, codigo, tipo);
			linhas.add(nova); // adicionar ao mapa de linhas

		} else if (arquivo.equals("paradalinha.csv")) {
			int idlinha = Integer.parseInt(str[0]);
			int idparada = Integer.parseInt(str[1]);

			Parada_linha nova = new Parada_linha(idlinha, idparada);

			paradalinhas.add(nova); // armazenar as linhas de cada parada
			linhaparadas.add(nova); // armazenar as paradas de cada linha

		} else if (arquivo.equals("paradas.csv")) {
			int idparada = Integer.parseInt(str[0]);
			int codigo = Integer.parseInt(str[1]);
			String auxlong = str[2].replace(",", ".");
			double longitude = Double.parseDouble(auxlong);
			String auxlat = str[3].replace(",", ".");
			double latitude = Double.parseDouble(auxlat);
			char terminal = str[4].charAt(0);

			Parada nova = new Parada(idparada, codigo, longitude, latitude,
					terminal);
			paradas.add(nova);

		}

	}

}



