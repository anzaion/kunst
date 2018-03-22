package binaryfigures;


import processing.core.PApplet;

public class RectangleFill extends BinaryFigure {

	public static void main(String[] args) {
		PApplet.main("binaryfigures.RectangleFill");

	} 
	
	
	public void setup() {
		super.setup();
		
		
	}
	
	public void draw(){
		
		 //size and start point of Rectangle
		  int startRX = 100;
		  int startRY = 100;
		  int widthR = 300;
		  int hightR = 300;
		 
		  
		  // start points on Rectangle, from the startRX and startRY
		  int x1 = 0;
		  int y1 = 100;
		  int x2 = 200;
		  int y2 = hightR;
		  
          //direction L - false or R - true
		  
		  boolean direction = true;
		  	
		
		  //size of shape
		  int dotD = 15;
		  //distance between shapes
	      int distance = 30;
		 
	      rect(startRX, startRY, widthR, hightR);
	      
	      drawStripesInRectangle ( startRX,  startRY, widthR, hightR,
	    		  x1, y1, x2, y2, dotD, distance, direction)  ;
		 
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
	

	private void drawStripesInRectangle(int startRX, int startRY, int widthR, int hightR,
			int x1, int y1, int x2, int y2,
			int dotD, int distance, boolean direction) {
				
		    float length = sqrt (pow ((x1-x2),2) + pow ((y1-y2),2)); 
		
		    int N = (int) ((length) / (dotD + distance));
		    
			float cos = sqrt (pow ((x1-x2),2))/length;
			float sin = sqrt (pow ((y1-y2),2))/length;
			
		
			
			drawRey( startRX + x1,  startRY + y1,  
					length, dotD, distance, cos, sin);

		


	}
	
	

	public void drawRey( float x, float y, float radius, 
			int dotD,int distance, float cos,  float sin)
	{
		int i = 0;
		int N = (int) ((radius) / (dotD + distance));
		float radiusi = 0;
		while (i <= N) {
			
			//to stop drawing if we came to the border of the screen
			if((x - 10)< 0 || ( y - 10)<0 
			   ||
		      (y +10)> width || ( y + 10)>height )
				break;
			
			
			if (text.isCurrentCharOne())
			{
		       styleforOne();
			}
			else
			{
			  styleforZero();
			}
				
		
			ellipse(x, y, dotD, dotD);

			radiusi = radiusi + dotD + distance;
			x = cos * radiusi;
			y = sin * radiusi;
			i++;

		}
	}

}
