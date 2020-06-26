package ar.unq.po2.tp06.elementos.similares;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropiedadEnComunTest {

	Filtro filtro;
	WikiPage animal;
	WikiPage lobo;
	WikiPage pantera;
	WikiPage queso;
	WikiPage roquefort;
	WikiPage danbo;

	@BeforeEach
	void setUp() throws Exception {
		this.filtro = new PropiedadEnComun();
		
		this.animal = new WikiPage("Animal");
		this.lobo = new WikiPage("Lobo");
		this.pantera = new WikiPage("Pantera");
		this.queso = new WikiPage("Queso");
		this.danbo = new WikiPage("Danbo");
		this.roquefort = new WikiPage("Roquefort");
		
		this.lobo.addInfoBox("animal", this.animal);
		this.danbo.addInfoBox("queso", this.queso);
		this.roquefort.addInfoBox("queso", this.queso);
	}

	@Test
	void testGetSimilarPages() {
		List<WikipediaPage> pages = List.of(this.lobo, this.pantera, this.roquefort);
		
		List<WikipediaPage> expected = List.of(this.roquefort);
		
		List<WikipediaPage> actual = this.filtro.getSimilarPages(this.danbo, pages);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetSimilarPagesWithEmptyResult() {
		List<WikipediaPage> pages = List.of(this.lobo, this.pantera);
			
		List<WikipediaPage> actual = this.filtro.getSimilarPages(this.danbo, pages);
		
		assertTrue(actual.isEmpty());
	}

}
