package ca.sheridancollege.bask.as1.beans;

import java.io.Serializable;
import java.time.LocalDate;



import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class is a bean class models an evaluation object that keeps
 * title, grade, maximum mark, weight and a due date.
 * Lombok dependencies are used to automate the coding such as defaukt constructor,
 * getters and setters.
 * @author Kubra Bas
 */




@NoArgsConstructor
@Data
public class Evaluation implements Serializable {

	// serial version UID
	private static final long serialVersionUID = 1L;
	
	
	private String title = "TDB";
	private double grade = 0;
	private double max = 0;
	private double weight = 10;
	private LocalDate dueDate;
	
	

	/**
	 * Construct an Evaluation object with the given title, grade,
	 * max, weight, dueDate values.	 
	 * @param title the initial title of the evaluation
	 * @param grade the initial grade of the evaluation
	 * @param max the initial max value of the evaluation
	 * @param weight the initial weight of the evaluation
	 * @param dueDate the initial due date of the evaluation
	 */
	public Evaluation(String title, double grade, double max, 
			double weight, LocalDate dueDate) {
		
		setTitle(title);
		setGrade(grade);
		setMax(max);
		setWeight(weight);
		setDueDate(dueDate);
	}
	
	
	/** 
	 * Mutator method for the title attribute.
	 * Accepts a String type argument for the title
	 * Evaluates if its valid or not	 
	 * @throws IllegalArgumentException if the title is empty or a null string
	 */
	public void setTitle(String title) {		
		if(!title.isEmpty() && title != null) { //if the title is not empty or not a null string
			this.title= title; //assign the title value into the title attribute
		} else { //if the title is an empty string or a null string throw an exception
			throw new IllegalArgumentException("Title cannot be null"
					+ " or an empty string");
		}
	}
		
	
	/**
	 * Mutator method for the grade attribute.
	 * Accepts a double type argument for the grade
	 * Evaluates if its valid or not	 
	 * @throws IllegalArgumentException if the grade is lower than 0
	 */
	public void setGrade(double grade) {
		if(grade >= 0) { //if the grade argument is equal or greater than 0
			this.grade = grade; // assign grade value into the grade attribute
		} else {//if the grade is lower than 0
			//throw an IllegalArgumentException
			throw new IllegalArgumentException("Grade must be greater than 0");
		}
	}
	
	/**
	 * Mutator method for the weight attribute.
	 * Accepts a double type argument for the weight
	 * Evaluates if its valid or not	  
	 * @throws IllegalArgumentException if the weight is lower than 0
	 */
	public void setWeight(double weight) {
		if(weight > 0) { //if the weight argument is greater than 0
			this.weight = weight;// assign the weight value into the weight attribute
		} else {////if the grade is equal or lower than 0
			throw new IllegalArgumentException("Weight value must be greater than 0");
		}
	}
	
	
	/**
	 * Mutator method for the max attribute.
	 * Accepts a double type argument the max
	 * Evaluates if its valid or not	  
	 * @throws IllegalArgumentException if the max value is lower than 0
	 */
	public void setMax(double max) {
		if (max >= 0) {//if the max argument is equal or greater than 0
			this.max = max; //assign the max value into the weight attribute
		} else {//if the max value lower than 0
			throw new IllegalArgumentException("max value must be greater than 0");
		}
	}
	
	/**
	 *  Method to calculate the earned weight.
	 *  @return the earned weight
	 */
	public double calcGrade() {			
		 return (grade / max) * weight; //formula for earned weight
	}

	
	/**
	 *  @return the Evaluation object as a String
	 *  print the grade in the form : g.g where the grade formatted to 1 decimal place
	 *  print the max in the form: m.m where the max formatted to 1 decimal place
	 *  print the earned weight(calcGrade()) in the form : w.w the value is 
	 *  formatted to 1 decimal place
	 */
	@Override
	public String toString() {
		return String.format("%s: %.1f/%.1f %n Earned: %.1f%%",
				title, grade, max, calcGrade());
	}

}

	
	
	
	

