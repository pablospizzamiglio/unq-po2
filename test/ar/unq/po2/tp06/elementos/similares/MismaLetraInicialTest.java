package ar.unq.po2.tp06.elementos.similares;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MismaLetraInicialTest {
	
	Filtro filtro;
	WikipediaPage lobo;
	WikipediaPage laPlata;
	WikipediaPage queso;

	@BeforeEach
	void setUp() throws Exception {
		this.filtro = new MismaLetraInicial();
		
		this.lobo = new WikiPage("Lobo");		
		this.laPlata = new WikiPage("La Plata");
		this.queso = new WikiPage("Queso");
	}

	@Test
	void testGetSimilarPages() {
		List<WikipediaPage> pages = List.of(this.laPlata, this.queso);
		
		List<WikipediaPage> expected = List.of(this.laPlata);
		
		List<WikipediaPage> actual = this.filtro.getSimilarPages(this.lobo, pages);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetSimilarPagesWithEmptyResult() {
		List<WikipediaPage> pages = List.of(this.lobo, this.laPlata);
			
		List<WikipediaPage> actual = this.filtro.getSimilarPages(this.queso, pages);
		
		assertTrue(actual.isEmpty());
	}

}
