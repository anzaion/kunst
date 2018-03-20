package creativeprogr;

import processing.core.PApplet;

public class mouse extends PApplet {

	public static void main(String[] args) {
		PApplet.main("creativeprogr.mouse");

	}

	public void setup() {
		smooth();
		background(255);
	}

	public void settings() {
		size(640, 480);
	}

	public void draw() {
		// empty, but we need it to create an app that runs in the continuous mode.
	}

	public void mousePressed() {
		if (mouseButton == RIGHT) {
			background(255);
		}
	}

	public void mouseMoved() {
		stroke(0, 64);
		strokeWeight(1);
		fill(255, 32);
		float d = dist(mouseX, mouseY, pmouseX, pmouseY);
		constrain(d, 8, 100);
		ellipse(mouseX, mouseY, d, d);
	}

	public void mouseDragged() {
		stroke(0);
		float d = dist(mouseX, mouseY, pmouseX, pmouseY);
		constrain(d, 0, 100);
		float w = map(d, 0, 100, 1, 10);
		strokeWeight(w);
		line(mouseX, mouseY, pmouseX, pmouseY);
	}

	public void mouseReleased() {
		noStroke();
		fill(255, 16);
		rect(0, 0, width, height);
	}

	public void mouseClicked() {
		fill(255, 0, 0, 128);
		float d = random(20, 200);
		ellipse(mouseX, mouseY, d, d);
	}
}
