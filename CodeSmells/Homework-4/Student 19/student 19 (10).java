package omok;

import java.awt.Color;

public class Player {
	private String name;
	private Color color;

	public Player(String name, Color color) {
		this.name = name;
		this.color = color;
	}
	
	public String name() {
		return name;
	}
	
	public Color color() {
		return color;
	}
}
