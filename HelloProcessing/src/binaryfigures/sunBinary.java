package binaryfigures;


import processing.core.PApplet;

public class sunBinary extends BinaryFigure {

	public static void main(String[] args) {
		PApplet.main("binaryfigures.sunBinary");

	} 
			
	public void setup() {
		super.setup();
	}
	
	public void draw(){
		  int amountOfPoints =  15 ;// (int) random(20, 50); //number of points
				 
		  int centroX = 500;
		  int centroY = 500;
		 
		  int radius_inside = 150;
		  int radiusMin = 600;
		  int radiusMax = 600;
		 	      
		  //size of shape
		  int dotDOne = 120;
		  int dotDZero = 8;
		  //distance between shapes
	      int distance = 30;
		 
	      drawSun(centroX,centroY,  amountOfPoints, radiusMin ,radiusMax, radius_inside,
	  			dotDOne, dotDZero, distance)  ;
		 
		  super.draw();
		}
	
	
	/**
	 * if the current value is 0
	 */
	public void styleforZero() {
		
		super.styleforZero();
		noFill();
		stroke(255, 0, 0);
		strokeWeight(20);
		
	}
	
	/**
	 * if the current value is 1
	 */
	public void styleforOne() {
		
		super.styleforOne();
		noFill();
		stroke(255, 0, 0);
		strokeWeight(20);
		
		
	}
	

	public void drawSun(int centroX, int centroY, int amountOfPoints,  int radiusMin, int radiusMax,
			int radius_inside, int dotDOne, int dotDZero,int distance) {
		
		float pointAngle = 360 / amountOfPoints; // angle between points
		for (float angle = 270; angle < 630; angle = angle + pointAngle) {

			float xcentr = cos(radians(angle)) * radius_inside;
			float ycentr = sin(radians(angle)) * radius_inside;

			int radius = (int) random(radiusMin, radiusMax);
				
			
			drawRey( centroX,  centroY,  
					xcentr, ycentr,
					radius_inside, radius - radius_inside,
					dotDOne,  dotDZero, distance, angle);

		}

	}
	
	public void drawRey(int centroX, int centroY,float xi, float yi, 
			float radiusi, int radius, 
			int dotDOne, int dotDZero,int distance,float angle)
	{
		int i = 0;
		int dotD = dotDOne;
		if(dotDZero>dotDOne)
		 dotD = dotDZero;
		
		int N = (radius) / (dotD + distance);

		while (i <= N) {
			
			//to stop drawing if we came to the border of the screen
			if((xi + centroX -10)< 0 || ( yi + centroY - 10)<0 
			   ||
		      (xi + centroX +10)> width || ( yi + centroY + 10)>height )
				break;
			
			
			int dotDTemp = 0;
			if (text.isCurrentCharOne())
			{
		       styleforOne();
		       dotDTemp = dotDOne;
		    }
			else
			{
			  styleforZero();
			  dotDTemp = dotDZero;
			}
				
		
			ellipse(xi + centroX, yi + centroY, dotDTemp, dotDTemp);

			radiusi = radiusi + dotD + distance;
			xi = cos(radians(angle)) * radiusi;
			yi = sin(radians(angle)) * radiusi;
			i++;

		}
	}
	

}
