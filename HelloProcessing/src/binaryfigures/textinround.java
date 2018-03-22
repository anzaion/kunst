package binaryfigures;


import binaryconvertor.StringAndBinary;
import processing.core.PApplet;
import processing.core.PShape;
import processing.pdf.*;

public class textinround extends BinaryFigure {

	public static void main(String[] args) {
		PApplet.main("binaryfigures.textinround");

	}
	PShape snowFlake;
	PShape small1;
	PShape small2;
	StringAndBinary text;

	public void setup() {
		super.setup();

		snowFlake = loadShape("1_T_Outline_with_fill.svg");
		small1 = snowFlake.getChild("sign1");
		small2 = snowFlake.getChild("sign2");
		shapeMode( CENTER );
	}


	
	
	public void round(int centro, int radius, int dotD, int distance,
			PShape figureZero,PShape figureOne,StringAndBinary text) {

		float circumference = 2 * PI * radius;
		int points = (int) (circumference / dotD);
		float pointAngle = 360 / points; // angle between points

		for (float angle = 0; angle < 360; angle = angle + pointAngle) {
			PShape figure = figureZero;
			
			if(text.isCurrentCharOne())
			{
				figure = figureOne;
			}
			
			float x = cos(radians(angle)) * radius;
			float y = sin(radians(angle)) * radius;
			figure.disableStyle();
	    	//figure.rotate(radians(angle));
			shape( figure, x + centro, y + centro, dotD- distance, dotD*2 - distance);
			figure.rotate(radians(0));
			figure.enableStyle();
			

		}
		
		}

	public void draw(){
		   //drawswg();
		
		
		  int points =  25 ;// (int) random(20, 50); //number of points
		  float pointAngle = 360/points; //angle between points
		  int radiusMax = 400;
		  int centro = 400;
	      int radius_inside = 100;
	      int dotD = 15;
	      int distance = 7;
		 
	      snowFlake.disableStyle();
			fill( 255, 128, 0 );
			stroke(204, 102, 0);
			strokeWeight( 1);
		  round( centro, 200,  dotD, distance,small1,small2,text) ;
	//      snowFlake.enableStyle();
		  round( centro, 250, dotD, distance,small1,small2,text) ;
	      round( centro, 300, dotD, distance,small1,small2,text) ;
	  	
	  	      
	      endRecord();
		}
	
	
	
	
	public void drawswg()
	{
		// regular snowflake
		
		
		shape( snowFlake, 160, 120 );
		// distorted snowflake
		shape( snowFlake, 480, 120, 160, 160 );
		
		//snowFlake.disableStyle();
		shape( snowFlake, 600, 120 ,100, 100 );
		
		// orange snowflake
		snowFlake.disableStyle();
		fill( 255, 128, 0 );
		stroke(204, 102, 0);
		strokeWeight( 1);
		shape( snowFlake, 160, 360 , 160, 160 );
		snowFlake.enableStyle();
		
		//draw separate parts (colorful star)
		strokeWeight( 1 );
		stroke( 0 );
		small1.disableStyle();
		//fill( 151, 183, 189 );
		shape( small1, 480, 360,100, 100 );
		small1.enableStyle();
		
		small2.disableStyle();
		fill( 216, 234, 237 );
		shape( small2, 600, 360 ,100, 100 );
		small2.enableStyle();
		
	
	}
}
