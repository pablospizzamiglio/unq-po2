package ar.unq.po2.tp08.shapeshifter;

import java.util.List;

public interface IShapeshifter {
	
	public IShapeshifter compose(IShapeshifter shapeshifter);
	
	public int deepest();
	
	public IShapeshifter flat();
	
	public List<Integer> values();
	
}
