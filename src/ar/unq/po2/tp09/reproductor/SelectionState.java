package ar.unq.po2.tp09.reproductor;

public class SelectionState extends State {

	public SelectionState(Player player) {
		super(player);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void play() {
		this.getPlayer().startPlayback();
		this.getPlayer().changeState(new PlayingState(this.getPlayer()));
	}

	@Override
	public void pause() throws Exception {
		throw new Exception("Nada que pausar");
	}

	@Override
	public void stop() throws Exception {
		throw new Exception("Nada que detener");
	}

}
