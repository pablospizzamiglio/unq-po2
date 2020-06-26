package ar.unq.po2.tp06.elementos.similares;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WikiPage implements WikipediaPage {

	private String title;
	private Map<String, WikipediaPage> infoBox;
	private List<WikipediaPage> links;
	
	public WikiPage(String title) {
		this.setTitle(title);
		this.setInfoBox(new HashMap<String, WikipediaPage>());
		this.setLinks(new ArrayList<WikipediaPage>());
	}

	protected void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String getTitle() {
		return this.title;
	}

	private void setInfoBox(Map<String, WikipediaPage> infoBox) {
		this.infoBox = infoBox;
	}
	
	@Override
	public Map<String, WikipediaPage> getInfobox() {
		return this.infoBox;
	}
	
	private void setLinks(List<WikipediaPage> links) {
		this.links = links;
	}

	@Override
	public List<WikipediaPage> getLinks() {
		return this.links;
	}
	
	public void addInfoBox(String description, WikipediaPage wikiPage) {
		this.getInfobox().put(description, wikiPage);
	}
	
	public void addLink(WikipediaPage wikiPage) {
		this.getLinks().add(wikiPage);
	}

}
