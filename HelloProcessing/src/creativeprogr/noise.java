package creativeprogr;

import processing.core.PApplet;

public class noise extends PApplet {

	public static void main(String[] args) {
		PApplet.main("creativeprogr.noise");

	}

	public void setup() {
		smooth();
		background(255);
	}

	public void settings() {
		size(640, 480);
	}

	/*
	 * float xoff = (float) 0.0;
	 * 
	 * public void draw() { background(204); xoff = (float) (xoff + 0.01); float n =
	 * noise(xoff) * width; line(n, 0, n, height); }
	 */

	float noiseScale = (float) 0.02;

	public void draw() {
		background(0);
		for (int x = 0; x < width; x++) {
			float noiseVal = noise((/*mouseX*/ + x) * noiseScale,/* mouseY **/ noiseScale);
			stroke(noiseVal * 255);
			line(x, /*mouseY*/ + noiseVal * 80, x, height);
		}
	}
}