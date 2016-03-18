package data.sys;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

import data.eng.Forces;
import data.eng.Rectangle;
import data.eng.Vector;
import data.gfx.Texture;

public abstract class GameCharacter extends GameObject{
	
	public GameCharacter(int ID,Vector pos,double mass) {
		super(ID,pos,mass);
		setRotationalInertia();
		setCenterMass();
	}
	
	public GameCharacter(int ID,Vector pos,Vector vel,Vector acc,double theta,double omega,double alpha,double mass) {
		super(ID,pos,vel,acc,theta,omega,alpha,mass);
		setRotationalInertia();
		setCenterMass();
	}
	
	public void updatePhysics(double T) {	
		
		f.reset();
		
		//Velocity Verlet numerical integration
		translate(v.scale(T).add(a.scale(0.5 *T*T)));
		rotate(omega*T + alpha*0.5*T*T,null);

		updateForces();
		
		//Verlet part 2
		a = f.getNetAccel();
		v = v.add(a.scale(T));
		
		alpha = f.getNetAlpha();
		omega += alpha*T;
		
	}
	
	public abstract void updateForces();
	
	protected void setRotationalInertia() {
		I=t.getRotationalInertia();
	}
	
	protected void setCenterMass() {
		c_m=t.getCenterMass();
	}

	public Vector getCenterMass() {
		return t.getCenterMass();
	}

	public void translate(Vector v) {
		t.translate(v);
		p = p.add(v);
	}

	public void rotate(double angle,Vector c) {
		t.rotate(angle,c);
		theta+=angle;
	}

	public Vector getPos() {
		return p;
	}

	public Polygon getGfxPolygon() {
		return null;
	}

}
