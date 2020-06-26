package ar.unq.po2.tp06.elementos.similares;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LinkEnComunTest {

	Filtro filtro;
	WikiPage lobo;
	WikiPage queso;
	WikiPage roquefort;
	WikiPage danbo;

	@BeforeEach
	void setUp() throws Exception {
		this.filtro = new LinkEnComun();
		
		this.lobo = new WikiPage("Lobo");		
		this.queso = new WikiPage("Queso");
		this.danbo = new WikiPage("Danbo");
		this.roquefort = new WikiPage("Roquefort");
		
		this.queso.addLink(this.danbo);
		this.queso.addLink(this.roquefort);
		this.danbo.addLink(this.queso);
		this.roquefort.addLink(this.queso);
	}

	@Test
	void testGetSimilarPages() {
		List<WikipediaPage> pages = List.of(this.lobo, this.danbo, this.queso);
		
		List<WikipediaPage> expected = List.of(this.danbo);
		
		List<WikipediaPage> actual = this.filtro.getSimilarPages(this.roquefort, pages);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetSimilarPagesWithEmptyResult() {
		List<WikipediaPage> pages = List.of(this.queso, this.roquefort, this.danbo);
			
		List<WikipediaPage> actual = this.filtro.getSimilarPages(this.lobo, pages);
		
		assertTrue(actual.isEmpty());
	}

}
