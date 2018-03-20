package binaryconvertor;


import processing.core.PApplet;

public class sun extends PApplet {

	public static void main(String[] args) {
		PApplet.main("binaryconvertor.sun");

	}

	public void setup() {
		smooth();
		background(255);
		noLoop();
		beginRecord(PDF, "textinround.pdf"); 
	}

	public void settings() {
		size(1000, 1000);
	}

	public void draw(){
		  int points =  25 ;// (int) random(20, 50); //number of points
		  float pointAngle = 360/points; //angle between points
		  int radiusMax = 400;
		  int centro = 400;
	      int radius_inside = 100;
	      int dotD = 15;
	      int distance = 7;
		 
	      String message = "The following example produces the same result as the previous one but uses a more efficient technique. Instead of shifting the array elements in each frame, the program writes the new data to the next available array position. The elements in the array remain in the same position once they are written, but they are read in a different order each frame. Reading begins at the location of the oldest data element and continues to the end of the array. At the end of the array, the % operator (p. 57) is used to wrap back to the beginning. This technique, commonly known as a ring buffer, is especially useful with larger arrays, to avoid unnecessary copying of data that can slow down a program.";
	      textSize(12);
	      
	      int letterNumber = 0;
	      int textLength = message.length();
	      
	      
		  for(float angle = 270; angle < 630; angle = angle+pointAngle) { 
			  		  
			  float xcentr = cos(radians(angle)) * radius_inside; 
			  float ycentr = sin(radians(angle)) * radius_inside;
			  	  
			  
			  int radius = (int) random(200, radiusMax);
			  float x = cos(radians(angle)) * radius; 
			  float y = sin(radians(angle)) * radius;
			  
			 // line(x+centro, y+centro, xcentr+centro, ycentr+centro); 
			  
			  float xi = xcentr;
			  float yi = ycentr;
			  float radiusi = radius_inside;
			  int i = 0;
			  
			  
			  int N = (radius - radius_inside)/dotD;
			  
			  while(i <= N)
			  {
				  //fill(random(0, 255), random(0, 255), random(0, 255));
				  fill(255, 0, 0);
				  if(letterNumber<textLength)
				  {
					  char c = message.charAt(letterNumber);
					  
					  text(c, xi + centro , yi +centro);
					  letterNumber++;
				   
				  } 
				  else
				  {
					  ellipse(xi + centro , yi +centro, dotD-distance, dotD-distance);  
				  }
				  
				  radiusi = radiusi+dotD;
				  xi = cos(radians(angle)) * radiusi; 
				  yi = sin(radians(angle)) * radiusi;
				  i++;
				  
			  }
			  
			 
			}
		  
		  endRecord();
		}
}
