package ar.unq.po2.tp08.shapeshifter;

import java.util.ArrayList;
import java.util.List;

public class Shapeshifter implements IShapeshifter {
	
	private Integer value;

	public Shapeshifter(Integer value) {
		this.setValue(value);
	}

	private Integer getValue() {
		return this.value;
	}

	private void setValue(Integer value) {
		this.value = value;
	}

	@Override
	public IShapeshifter compose(IShapeshifter that) {
		List<IShapeshifter> shapeshifters = new ArrayList<IShapeshifter>(List.of(this, that));
		ShapeshifterGroup composite = new ShapeshifterGroup(shapeshifters);
		return composite;
	}

	@Override
	public int deepest() {
		return 0;
	}

	@Override
	public IShapeshifter flat() {
		return this;
	}

	@Override
	public List<Integer> values() {
		return new ArrayList<Integer>(List.of(this.getValue()));
	}

}
