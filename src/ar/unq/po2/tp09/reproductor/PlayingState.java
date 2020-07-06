package ar.unq.po2.tp09.reproductor;

public class PlayingState extends State {

	public PlayingState(Player player) {
		super(player);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void play() throws Exception {
		throw new Exception("La reproducción ya se encuentra en curso");
	}

	@Override
	public void pause() {
		this.getPlayer().pausePlayback();
		this.getPlayer().changeState(new PausedState(this.getPlayer()));
	}

	@Override
	public void stop() {
		this.getPlayer().stopPlayback();
		this.getPlayer().changeState(new SelectionState(this.getPlayer()));
	}

}
