package ar.unq.po2.tp08.shapeshifter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ShapeshifterGroup implements IShapeshifter {
	
	private List<IShapeshifter> shapeshifters;

	public ShapeshifterGroup(List<IShapeshifter> shapeshifters) {
		this.setShapeshifters(new ArrayList<IShapeshifter>());
		this.getShapeshifters().addAll(shapeshifters);
	}

	private List<IShapeshifter> getShapeshifters() {
		return shapeshifters;
	}

	private void setShapeshifters(List<IShapeshifter> shapeshifters) {
		this.shapeshifters = shapeshifters;
	}

	@Override
	public IShapeshifter compose(IShapeshifter that) {
		List<IShapeshifter> shapeshifters = new ArrayList<IShapeshifter>(List.of(this, that));
		ShapeshifterGroup shapeshifterGroup = new ShapeshifterGroup(shapeshifters);
		return shapeshifterGroup;
	}

	@Override
	public int deepest() {
		return this.getShapeshifters().stream()
				.mapToInt(s -> s.deepest())
				.max()
				.getAsInt() + 1;
	}

	@Override
	public IShapeshifter flat() {
		ShapeshifterGroup flatShapeshifterGroup = this; 
		
		if (this.deepest() >= 1) {
			List<IShapeshifter> shapeshifters = this.getShapeshifters().stream()
					.map(s -> s.flat())
					.collect(Collectors.toList());
			flatShapeshifterGroup = new ShapeshifterGroup(shapeshifters);
		}
		
		return flatShapeshifterGroup;
	}

	@Override
	public List<Integer> values() {
		return this.getShapeshifters().stream()
				.flatMap(s -> s.values().stream())
				.collect(Collectors.toList());
	}

}
