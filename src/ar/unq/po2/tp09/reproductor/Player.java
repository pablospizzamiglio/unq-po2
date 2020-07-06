package ar.unq.po2.tp09.reproductor;

public class Player {
	
	private State state;
	private Song currentSong;
	
	public Player() {
		this.changeState(new SelectionState(this));
	}
	
	private State getState() {
		return state;
	}

	public void changeState(State state) {
		this.state = state;
	}

	public Song getCurrentSong() {
		return currentSong;
	}

	public void select(Song song) {
		this.currentSong = song;
	}

	public void play() throws Exception {
		this.getState().play();
	}
	
	public void pause() throws Exception {
		this.getState().pause();
	}
	
	public void stop() throws Exception {
		this.getState().stop();
	}

	public void startPlayback() {
		this.getCurrentSong().play();		
	}
	
	public void stopPlayback() {
		this.getCurrentSong().stop();		
	}
	
	public void pausePlayback() {
		this.getCurrentSong().pause();		
	}

}
