package data.sys;

import java.awt.Color;
import java.awt.Polygon;

import data.eng.Shape;
import data.eng.Vector;
import data.gfx.Texture;

public abstract class GameObject extends Shape{

	private int ID;
	protected Vector g = new Vector(0,9.8); //gravity
	protected Texture t;
	
	public GameObject(int ID,Vector pos,double mass) {
		super(pos,mass,null);
		this.ID=ID;
		t = new Texture(this);
	}
	
	public GameObject(int ID,Vector pos,Vector vel,Vector acc,double theta,double omega,double alpha,double mass) {
		super(pos,vel,acc,theta,omega,alpha,mass,null);
		this.ID=ID;
		t = new Texture(this);
	}
	
	public int getID() {
		return ID;
	}
	
	protected void setTexture(Texture t) {
		this.t = t;
	}

	public Texture getTexture() {
		return t;
	}
	
	public abstract void updatePhysics(double T);
	
}
