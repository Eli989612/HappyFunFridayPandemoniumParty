package data.eng;

import java.util.ArrayList;

import data.sys.Game;

public class Forces{
	
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Vector> force = new ArrayList<Vector>();
	private ArrayList<Vector> pos = new ArrayList<Vector>();
	
	private Shape s;
	
	public Forces(Shape s) {
		this.s=s;
	}
	
	public void add(Vector force, Vector pos) {
		this.force.add(force);
		this.pos.add(pos.subtract(s.getCenterMass()));
	}
	
	public void reset() {
		for(int i=force.size()-1;i>=0;i--) {
			force.remove(i);
			pos.remove(i);
		}
	}
	
	public Vector getNetForce() {
		Vector f = new Vector(0,0);
		for(Vector x:force) {
			f = f.add(x);
		}
		return f;
	}
	
	public Vector getNetAccel() {
		return this.getNetForce().scale(1/s.getMass());
	}
	
	public double getNetTorque() {
		double t = 0;
		for(int i=0;i<force.size();i++) {
			t += (pos.get(i).crossProduct(force.get(i))).getMagnitude();
		}
		return t;
	}
	
	public double getNetAlpha() {
		return this.getNetTorque()/s.I;
		
	}
	
}
