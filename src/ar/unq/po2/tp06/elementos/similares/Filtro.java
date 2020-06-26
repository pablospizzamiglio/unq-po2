package ar.unq.po2.tp06.elementos.similares;

import java.util.List;
import java.util.stream.Collectors;

public abstract class Filtro {

	public List<WikipediaPage> getSimilarPages(WikipediaPage wikiPage, List<WikipediaPage> wikiPages) {
		return wikiPages.stream()
				.filter(w -> meetsCondition(wikiPage, w))
				.collect(Collectors.toList());
	}
	
	public abstract Boolean meetsCondition(WikipediaPage wikiPage, WikipediaPage anotherWikiPage);

}
