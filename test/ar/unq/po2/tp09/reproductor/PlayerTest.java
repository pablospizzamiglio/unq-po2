package ar.unq.po2.tp09.reproductor;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

class PlayerTest {
	
	private @Spy Song song;
	private Player player;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.player = new Player();
		this.player.select(this.song);
	}

	@Test
	void testConstructor() {
		// verify
		assertNotNull(this.player);
	}
	
	@Test
	void testSelectSong() {
		// exercise
		this.player.select(this.song);
		// verify
		assertNotNull(this.player.getCurrentSong());
	}
	
	@Test
	void testSelectionStatePlay() throws Exception {
		// exercise
		this.player.play();
		// verify
		verify(this.song, times(1)).play();
	}
	
	@Test
	void testSelectionStatePause() throws Exception {
		// verify
		assertThrows(Exception.class, () -> {
			// exercise
			this.player.pause();
	    });
	}
	
	@Test
	void testSelectionStateStop() throws Exception {
		// verify
		assertThrows(Exception.class, () -> {
			// exercise
			this.player.stop();
	    });
	}
	
	@Test
	void testPlayingStatePlay() throws Exception {
		// set up
		this.player.play();
		// verify
		assertThrows(Exception.class, () -> {
			// exercise
			this.player.play();
	    });
	}
	
	@Test
	void testPlayingStatePause() throws Exception {
		// set up
		this.player.play();
		// exercise
		this.player.pause();
		// verify
		verify(this.song, times(1)).pause();
	}
	
	@Test
	void testPlayingStateStop() throws Exception {
		// set up
		this.player.play();
		// exercise
		this.player.stop();
		// verify
		verify(this.song, times(1)).stop();
	}
	
	@Test
	void testPausedStatePlay() throws Exception {
		// set up
		this.player.play();
		this.player.pause();
		// exercise
		this.player.play();
		// verify
		verify(this.song, times(2)).play();
	}
	
	@Test
	void testPausedStatePause() throws Exception {
		// set up
		this.player.play();
		this.player.pause();
		// verify
		assertThrows(Exception.class, () -> {
			// exercise
			this.player.pause();
	    });
	}
	
	@Test
	void testPausedStateStop() throws Exception {
		// set up
		this.player.play();
		this.player.pause();
		// verify
		assertThrows(Exception.class, () -> {
			// exercise
			this.player.stop();
	    });
	}
	
	

}
