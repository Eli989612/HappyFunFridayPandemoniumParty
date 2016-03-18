package data.gfx;

import java.awt.Color;
import java.awt.Polygon;
import java.util.ArrayList;

import data.eng.Rectangle;
import data.eng.Shape;
import data.eng.Vector;
import data.sys.GameCharacter;
import data.sys.GameObject;
import data.sys.Player;
import data.sys.Slime;

public class Texture extends ArrayList<Shape>{
	
//	public <U extends GameObject> Texture(U u) { --- a cool thing for a constructor
	
	private static final long serialVersionUID = 1L;

	private int ID;
	
	private Vector c_m;
	private double I;
	
	public <U extends GameObject> Texture(U u) {
		ID = u.getID();
		System.out.println(ID);
		if(ID==Player.ID) {
			add(new Rectangle(u.getPos(),.5,.5,u.getVel(),u.getAcc(), u.getTheta(), u.getOmega(), u.getAlpha(), u.getMass()/2,Color.GREEN));
			add(new Rectangle(((Rectangle)this.get(0)).getBottomLeft().subtract(new Vector(.125,0)),.75,1,u.getVel(),u.getAcc(), u.getTheta(), u.getOmega(), u.getAlpha(), u.getMass()/2,Color.RED));
		} else if(ID==Slime.ID) {
			add(new Rectangle(u.getPos(),.5,.5,u.getVel(),u.getAcc(), u.getTheta(), u.getOmega(), u.getAlpha(), u.getMass(),Color.BLUE));
		} else {
			
		}
		setCenterMass();
		setRotationalInertia();
	}

	protected void setRotationalInertia() {
		double i = 0;
		for(Shape x:this) {
			i+=x.getRotationalInertia()+x.getMass()*Math.pow((c_m.subtract(x.getCenterMass())).getMagnitude(),2);
		}
		I=i;
	}
	
	protected void setCenterMass() {
		Vector totalMassC_m = new Vector(0,0);
		double totalMass = 0;
		for(Shape x: this) {
			totalMassC_m = totalMassC_m.add(x.getCenterMass().scale(x.getMass()));
			totalMass+=x.getMass();
		}
		c_m = totalMassC_m.scale(1/totalMass);
	}
	
	public Vector getCenterMass() {
		return c_m;
	}
	
	public double getRotationalInertia() {
		return I;
	}

	public void translate(Vector v) {
		c_m=c_m.add(v);
		for(Shape x: this) {
			x.translate(v);
		}
		
	}

	public void rotate(double angle,Vector c_m) {
		for(Shape x: this) {
			x.rotate(angle,this.c_m);
		}
	}

	public Vector getPos() {
		if(ID==Player.ID) {
			return get(0).getPos();
		} else if(ID==Slime.ID){
			return get(0).getPos();
		} else {
			return null;
		}
	}
	
}
