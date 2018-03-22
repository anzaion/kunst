package binaryconvertor;


import processing.core.PApplet;

public class sunBinary extends PApplet {

	
	public static void main(String[] args) {
		PApplet.main("binaryconvertor.sunBinary");

	}
	StringAndBinary text;
	int width = 1000;
	int height = 1000; //ss1
	

	public void setup() {
		smooth();
		background(255);
		noLoop();
		beginRecord(PDF, "textinround.pdf"); 
		text = new StringAndBinary("textforscatch.txt");
	}
	
	

	public void settings() {
		size(width, height);
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
		 
		  endRecord();
		}
	
	
	/**
	 * if the current value is 0
	 */
	public void styleforZero() {
		
		fill(255, 0, 0);
		strokeWeight(2);
		
	}
	
	/**
	 * if the current value is 1
	 */
	public void styleforOne() {
		
		fill(0, 255, 0);
		strokeWeight(4);
		
	}
	

	public void drawSun(int centroX, int centroY, int amountOfPoints,  int radiusMin, int radiusMax,
			int radius_inside, int dotD,
			int distance) {
		float pointAngle = 360 / amountOfPoints; // angle between points
		for (float angle = 270; angle < 630; angle = angle + pointAngle) {

			float xcentr = cos(radians(angle)) * radius_inside;
			float ycentr = sin(radians(angle)) * radius_inside;

			int radius = (int) random(radiusMin, radiusMax);
			float x = cos(radians(angle)) * radius;
			float y = sin(radians(angle)) * radius;

			// line(x+centro, y+centro, xcentr+centro, ycentr+centro);

			float xi = xcentr;
			float yi = ycentr;
			float radiusi = radius_inside;
			int i = 0;

			int N = (radius - radius_inside) / (dotD + distance);

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

}
