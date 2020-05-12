package ar.unq.po2.tp03;

import java.util.ArrayList;

/**
* Implements the operations {@code getEvenOccurrences}, {@code getOddOccurrences} 
* and {@code getMultiples} for a items stored in the collection 
* {@code numbers}
*
* @author  Pablo Spizzamiglio
* @version 1.0
* @since   2020-04-16
*/
public class Counter {
		
	private ArrayList<Integer> numbers;
	
	/**
	 * Constructs an instance of {@code Counter}
	 */
	public Counter() {
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
	 * Returns the occurrences of even numbers within the collection {@code numbers} 
	 * 
	 * @return the occurrences of even numbers within the collection {@code numbers} 
	 */
	public long getEvenOccurrences() {
		return this.getNumbers().stream().filter(x -> x % 2 == 0).count();
	}
	
	/**
	 * Returns the occurrences of odd numbers within the collection {@code numbers} 
	 * 
	 * @return the occurrences of odd numbers within the collection {@code numbers} 
	 */
	public long getOddOccurrences() {
		return this.getNumbers().stream().filter(x -> x % 2 != 0).count();
	}
	
	/**
	 * Returns the occurrences of multiples of {@code n} numbers within the collection {@code numbers} 
	 * 
	 * @return the occurrences of multiples of {@code n} numbers within the collection {@code numbers} 
	 */
	public long getMultiples(Integer n) {
		long numberOfMultiples = 0L;
		if (n != 0) { 
			numberOfMultiples = this.getNumbers().stream().filter(x -> x % n == 0).count();
		}
		return numberOfMultiples;
	}
	
}
