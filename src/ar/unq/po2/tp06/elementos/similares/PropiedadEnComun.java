package ar.unq.po2.tp06.elementos.similares;

import java.util.Collections;

public class PropiedadEnComun extends Filtro {

	public PropiedadEnComun() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean meetsCondition(WikipediaPage wikiPage, WikipediaPage anotherWikiPage) {
		return !Collections.disjoint(wikiPage.getInfobox().keySet(), anotherWikiPage.getInfobox().keySet());
	}

}
