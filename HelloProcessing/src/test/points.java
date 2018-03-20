package test;

import processing.core.PApplet;

public class points extends PApplet {

	public static void main(String[] args) {
		PApplet.main("points");

	}

	public void settings() {
		size(640, 480);
	}

	float noiseOffset;
	int amountCurves = 100;
	float[] rendomeVal = new float[amountCurves];

	public void setup() {
		for (int j = 0; j < amountCurves; j++) {
			float n = (float) random(-50, 50);
			rendomeVal[j] = n;
		}
		smooth();
		noiseOffset = (float) 0.0;
		rectMode(CENTER);
	}

	/* (non-Javadoc)
	 * @see processing.core.PApplet#draw()
	 */
	public void draw() {

		noFill();
		
		float centerX = 50;
		float centerY = 75;
		
		bezier(centerX, centerY, 25, 25, 125, 25, 50, 75);
		fill(255);
		int steps = 10;
		for (int j = 0; j < amountCurves; j++) {
			float n = rendomeVal[j];
			float tB = j / (float) (amountCurves);
			float startBX = 	bezierPoint(centerX, 25, 125, 50,tB);
			float startBY = 	bezierPoint(centerY, 25, 25, 75,tB);
			n= n*10;
			for (int i = 0; i <= steps; i++) {
				
				float t = i / (float) (steps);
				noFill();
				//bezier(85+n, 20+n, 10+n, 10+n, 90+n, 90+n, 15+n, 80+n);
				
				
				
				fill(255);
				float x = bezierPoint(startBX, 10 + n, 90 + n, 15 + n, t);
				float y = bezierPoint(startBY, 10 + n, 90 + n, 80 + n, t);
				ellipse(x, y, 5, 5);
				noiseOffset = n;
			}
		}
	}
}
