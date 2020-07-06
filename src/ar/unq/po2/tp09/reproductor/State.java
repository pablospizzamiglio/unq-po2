package ar.unq.po2.tp09.reproductor;

public abstract class State {
	
	private Player player;
	
	public State(Player player) {
		this.setPlayer(player);
	}
	
	public Player getPlayer() {
		return player;
	}

	private void setPlayer(Player player) {
		this.player = player;
	}

	public abstract void play() throws Exception;
	
	public abstract void pause() throws Exception;
	
	public abstract void stop() throws Exception;

}
