package data.sys;

import java.awt.Color;
import java.awt.Polygon;

import data.eng.Rectangle;
import data.eng.Vector;
import data.gfx.Texture;

public class Slime extends GameMob{
	
	public static final int ID = 2;

	public Slime(Vector pos, double mass) {
		super(ID, pos, mass);
	}
	
	public Slime(Vector pos, Vector vel, Vector acc, double theta,
			double omega, double alpha, double mass) {
		super(ID, pos, vel, acc, theta, omega, alpha, mass);
	}

	public void updateForces() {
		//gravity
		//f.add(g.scale(m),getCenterMass());
		//spring
		Vector spring = new Vector(10,5);
		double k=1;
		f.add(((Rectangle)t.get(0)).topLeft.subtract(spring).scale(-1*k), getCenterMass());
	}
}
