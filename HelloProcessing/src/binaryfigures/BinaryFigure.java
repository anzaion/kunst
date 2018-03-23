package binaryfigures;

import binaryconvertor.StringAndBinary;
import processing.core.PApplet;

public class BinaryFigure extends PApplet{

	StringAndBinary text;
	

	public void setup() {
		
		smooth();
		background(255);
		noLoop();
		beginRecord(PDF, "result.pdf"); 
		text = new StringAndBinary("textforscatch.txt");
	}
	
	

	public void settings() {
		width = 1000;
		height = 1000;
		size(width, height);
	}
	
	public void draw() {

		endRecord();
	}
	
	/**
	 * if the current value is 0
	 */
	public void styleforZero() {
		
		fill(0, 0, 0);
		stroke(255, 0, 0);
		strokeWeight(2);
		
	}
	
	/**
	 * if the current value is 1
	 */
	public void styleforOne() {
		
		fill(0, 0, 0);
		stroke(0, 255, 0);
		strokeWeight(2);
		
	}
	

}
