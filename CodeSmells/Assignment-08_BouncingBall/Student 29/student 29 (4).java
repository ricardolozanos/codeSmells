package BouncingBall;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Ball implements Bounceable {
	
	 private int x;
	 private int y;
	 private int dx; 
	 private int dy;
	 private int radius;
	 private Color color;
	 
	 
	 protected Ball (int x, int y, int dx, int dy, int radius, Color color) {
		 this.x = x;
		 this.y = y;
		 this.dx = dx;
		 this.dy = dy;
		 this.radius = radius;
		 this.color = color;
	 }

	 public int getX() {
		 return this.x;
	 }
	 
	 public void setX(int x) {
		 this.x = x;
	 }
	 
	 public int getY() {
		 return this.y;
	 }

	 public void setY(int y) {
		 this.y = y;
	 }
	 
	 public int getDx() {
		 return this.dx;
	 }
	 
	 public void setDx(int dx) {
		 this.dx = dx;
	 }
	 
	 public int getDy() {
		 return this.dy;
	 }
	 
	 public void setDy(int dy) {
		 this.dy = dy;
	 }
	 
	 public int getRadius() {
		 return this.radius;
	 }
	 
	 public Color getColor() {
		 return this.color;
	 }
	 
	 public abstract void drawBall(Graphics g, Ball[] b); 
	 

}
