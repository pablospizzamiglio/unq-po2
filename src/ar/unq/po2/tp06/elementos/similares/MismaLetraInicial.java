package ar.unq.po2.tp06.elementos.similares;

public class MismaLetraInicial extends Filtro {

	public MismaLetraInicial() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean meetsCondition(WikipediaPage wikiPage, WikipediaPage anotherWikiPage) {
		return wikiPage.getTitle().charAt(0) == anotherWikiPage.getTitle().charAt(0);
	}

}
