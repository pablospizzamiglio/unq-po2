package ar.unq.po2.tp3;

import java.util.ArrayList;

/**
* Implements the operations {@code summation}, {@code subtraction} 
* and {@code multiplication} for a items stored in the collection 
* {@code numbers}
*
* @author  Pablo Spizzamiglio
* @version 1.0
* @since   2020-04-16
*/
public class Multioperator {
	
	private ArrayList<Integer> numbers;

	/**
	 * Constructs an instance of {@code Multioperator}
	 */
	public Multioperator() {
		this.setNumbers(new ArrayList<Integer>());
	}

	/*
	 * Returns the collection {@code numbers}
	 * 
	 * @return the collection {@code numbers}  
	 */
	public ArrayList<Integer> getNumbers() {
		return numbers;
	}

	/**
	 * Sets the value for the collection {@code numbers}
	 * 
	 * @param numbers an {@code ArrayList<Integer>} to assigned to {@code numbers}
	 */
	public void setNumbers(ArrayList<Integer> numbers) {
		this.numbers = numbers;
	}
	

	/**
	 * Adds an element {@code n} to the collection {@code numbers}
	 * 
	 * @param n an integer to be added to {@code numbers}
	 */
	public void addNumber(Integer n) {
		this.getNumbers().add(n);
	}
	
	/**
	 * Returns the summation of all elements in the collection {@code numbers} 
	 * 
	 * @return the summation of all elements in the collection {@code numbers} 
	 */
	public int summation() {
		return this.getNumbers().stream().reduce(0, (x, y) -> x + y);
	}
	
	/**     
	 * Returns the subtraction of all elements in the collection {@code numbers} 
	 * 
	 * @return the subtraction of all elements in the collection {@code numbers} 
	 */
	public Integer subtraction() {
		return -this.summation();
	}
	
	/**     
	 * Returns the multiplication of all elements in the collection {@code numbers} 
	 * 
	 * @return the multiplication of all elements in the collection {@code numbers} 
	 */
	public Integer multiplication() {
		return this.getNumbers().stream().reduce(1, (x, y) -> x * y);
	}

}
