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
		  int amountOfPoints =  30 ;// (int) random(20, 50); //number of points
				 
		  int centroX = 700;
		  int centroY = 400;
		 
		  int radius_inside = 150;
		  int radiusMin = 200;
		  int radiusMax = 400;
		 	      
		  //size of shape
		  int dotD = 15;
		  //distance between shapes
	      int distance = 30;
		 
	      drawSun(centroX,centroY,  amountOfPoints, radiusMin ,radiusMax, radius_inside,
	  			dotD, distance)  ;
		 
		  super.draw();
		}
	
	
	/**
	 * if the current value is 0
	 */
	public void styleforZero() {
		
		super.styleforZero();
		
	}
	
	/**
	 * if the current value is 1
	 */
	public void styleforOne() {
		

		super.styleforOne();
		
	}
	

	public void drawSun(int centroX, int centroY, int amountOfPoints,  int radiusMin, int radiusMax,
			int radius_inside, int dotD,int distance) {
		
		float pointAngle = 360 / amountOfPoints; // angle between points
		for (float angle = 270; angle < 630; angle = angle + pointAngle) {

			float xcentr = cos(radians(angle)) * radius_inside;
			float ycentr = sin(radians(angle)) * radius_inside;

			int radius = (int) random(radiusMin, radiusMax);
				
			
			drawRey( centroX,  centroY,  
					xcentr, ycentr,
					radius_inside, radius - radius_inside,
					dotD, distance, angle);

		}

	}
	
	public void drawRey(int centroX, int centroY,float xi, float yi, 
			float radiusi, int radius, 
			int dotD,int distance,float angle)
	{
		int i = 0;
		int N = (radius) / (dotD + distance);

		while (i <= N) {
			
			//to stop drawing if we came to the border of the screen
			if((xi + centroX -10)< 0 || ( yi + centroY - 10)<0 
			   ||
		      (xi + centroX +10)> width || ( yi + centroY + 10)>height )
				break;
			
			
			if (text.isCurrentCharOne())
			{
		       styleforOne();
			}
			else
			{
			  styleforZero();
			}
				
		
			ellipse(xi + centroX, yi + centroY, dotD, dotD);

			radiusi = radiusi + dotD + distance;
			xi = cos(radians(angle)) * radiusi;
			yi = sin(radians(angle)) * radiusi;
			i++;

		}
	}
	

}
