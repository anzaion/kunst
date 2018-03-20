package creativeprogr;

import processing.core.PApplet;

public class curve_calc extends PApplet {

	public static void main(String[] args) {
		PApplet.main("creativeprogr.curve_calc");

	}

	public void settings() {
		size(640, 480);
	}

	float noiseOffset;

	public void setup() {

		smooth();
		noiseOffset = (float) 0.0;
		rectMode(CENTER);
	}

	public void draw() {
		noiseOffset += 0.01;
		background(255);
		// Bézier curve
		stroke(0);
		noFill();
		bezier(40, 200, 120, 40, 300, 240, 600, 40);
		stroke(255, 0, 0);
		line(40, 200, 120, 40);
		line(600, 40, 300, 240);
		fill(255);
		rect(120, 40, 4, 4);
		rect(300, 240, 4, 4);
		float n = (float) 0.5;//noise(noiseOffset);
		float x = bezierPoint(40, 120, 300, 600, n);
		float y = bezierPoint(200, 40, 240, 40, n);
		stroke(0);
		rect(x, y, 6, 6);
		float t = map((float) mouseX, (float) 0, (float) width, (float) -5.0, (float) 5.0);
		curveTightness(t);
	
			// spline
		stroke(0);
		noFill();
		curve(120, 240, 40, 400, 600, 240, 300, 440);
		stroke(255, 0, 0);
		line(120, 240, 40, 400);
		line(600, 240, 300, 440);
		fill(255);
		rect(120, 240, 4, 4);
		rect(300, 440, 4, 4);
		x = curvePoint(120, 40, 600, 300, n);
		y = curvePoint(240, 400, 240, 440, n);
		stroke(0);
		rect(x, y, 6, 6);//*/
	}
}
