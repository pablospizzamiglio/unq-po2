package ar.unq.po2.tp06.elementos.similares;

import java.util.Collections;

public class LinkEnComun extends Filtro {

	public LinkEnComun() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean meetsCondition(WikipediaPage wikiPage, WikipediaPage anotherWikiPage) {
		return !Collections.disjoint(wikiPage.getLinks(), anotherWikiPage.getLinks());
	}

}
