package data.sys;

import java.awt.Color;
import java.awt.Polygon;

import data.eng.Rectangle;
import data.eng.Vector;
import data.gfx.Texture;

public class Player extends GameCharacter {

	public static final int ID = 1;
	private boolean moveR = false;
	private boolean moveL = false;
	private int jumps = 0;
	private int jumps_max = 2;
	private double floor = 15;
	
	public Player(Vector pos,double mass) {
		super(ID,pos,mass);
	}
	
	public Player(Vector pos,Vector vel,Vector acc,double theta,double omega,double alpha,double mass) {
		super(ID,pos,vel,acc,theta,omega,alpha,mass);
	}
	
	public void updateForces() {
//		gravity
		if(this.p.getY()<floor) {
			f.add(g.scale(m),getCenterMass());
		}
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
		if(moveR==true) {
			translate(new Vector(10*T,0));
			rotate(3*T,null);
		}
		if(moveL==true) {
			translate(new Vector(-10*T,0));
			rotate(-3*T,null);
		}
		if(this.p.getY()>=floor) {
			v = new Vector(v.getX(),0);
			p = new Vector(p.getX(),floor);
			jumps = 0;
		}
		
		alpha = f.getNetAlpha();
		omega += alpha*T;
		
	}
	
	public void moveRight() {
		moveR = true;
		
	}

	public void moveLeft() {
		moveL = true;
		
	}

	public void jump() {
		if(jumps<jumps_max) {
			v = new Vector(v.getX(),-10);
			jumps++;
		}
	}

	public void stopMoveR() {
		moveR = false;
		
	}

	public void stopMoveL() {
		moveL = false;
		
	}
	
}
