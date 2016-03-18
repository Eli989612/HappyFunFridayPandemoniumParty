package data.eng;

import java.awt.Color;
import java.awt.Polygon;

import data.sys.Game;

public abstract class Shape {

	protected double m,I; //mass, rotational inertia
	protected Color c; //color
	//linear kinematics
	protected  Vector p; // position
	protected  Vector v = new Vector(0,0); // velocity
	protected Vector a = new Vector(0,0); // acceleration
	//angular kinematics
	protected double theta,omega,alpha = 0; //angular displacement, velocity, acceleration respectively
	//mechanics
	protected Vector c_m; //center of mass
	public Forces f = new Forces(this);//force object
	
	public Shape(Vector position, double mass, Color c) {
		this.p=position;
		this.m=mass;
		this.c=c;
	}
	
	public Shape(Vector position,Vector velocity,Vector acceleration,double theta,double omega,double alpha,double mass,Color c) {
		this.p=position;
		this.v=velocity;
		this.a=acceleration;
		this.theta=theta;
		this.omega=omega;
		this.alpha=alpha;
		this.m=mass;
		this.c=c;
	}
	
	protected abstract void setRotationalInertia();
	
	protected abstract void setCenterMass();
	
	public abstract Vector getCenterMass();
	
	public abstract void translate(Vector v);
	
	public abstract void rotate(double angle,Vector c);
	
	public abstract Vector getPos();
	
	public Vector getVel() {
		return v;
	}
	
	public Vector getAcc() {
		return a;
	}
	
	public double getTheta() {
		return theta;
	}
	
	public double getOmega() {
		return omega;
	}
	
	public double getAlpha() {
		return alpha;
	}
	
	public double getMass() {
		return m;
	}
	
	public double getRotationalInertia() {
		return I;
	}
	
	public Color getColor() {
		return c;
	}
	
	public void setColor(Color c) {
		this.c=c;
	}
	
	public abstract Polygon getGfxPolygon();
	
}
