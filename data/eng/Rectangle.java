package data.eng;

import java.awt.Color;
import java.awt.Polygon;

import data.sys.Game;

public class Rectangle extends Shape{

	double w,h;
	//linear spacial dimensions
	public Vector topLeft,topRight,bottomLeft,bottomRight;
	
	public Rectangle(Vector p,double w,double h,double m,Color c) {
		super(p,m,c);
		this.w=w;
		this.h=h;
		topLeft = p;
		topRight = p.add(new Vector(w,0));
		bottomRight = p.add(new Vector(w,h));
		bottomLeft = p.add(new Vector(0,h));
		setRotationalInertia();
		setCenterMass();
	}
	
	public Rectangle(Vector p,double w,double h,Vector v,Vector a,double theta,double omega,double alpha,double m,Color c) {
		super(p,v,a,theta,omega,alpha,m,c);
		this.w=w;
		this.h=h;
		topLeft = p;
		topRight = p.add(new Vector(w,0));
		bottomRight = p.add(new Vector(w,h));
		bottomLeft = p.add(new Vector(0,h));
		setRotationalInertia();
		setCenterMass();
	}
	
	protected void setRotationalInertia() {
		I = (m*(w*w+h*h))/12;
	}
	
	protected void setCenterMass() {
		c_m = topLeft.add(bottomRight.subtract(topLeft).scale(.5));
	}
	
	public Vector getTopLeft() {
		return topLeft;
	}
	
	public Vector getTopRight() {
		return topRight;
	}
	
	public Vector getBottomRight() {
		return bottomRight;
	}
	
	public Vector getBottomLeft() {
		return bottomLeft;
	}
	
	public double getWidth() {
		return w;
	}
	
	public double getHeight() {
		return h;
	}
	
	public Vector getCenterMass() {
		return c_m;
	}
	
	public void translate(Vector v) {
		c_m = c_m.add(v);
		topLeft = topLeft.add(v);
		topRight = topRight.add(v);
		bottomRight = bottomRight.add(v);
		bottomLeft = bottomLeft.add(v);
	}
	
	public void rotate(double angle,Vector c_m) {
		theta+=angle;
		if(c_m.equals(null))
			c_m = this.c_m;
		topLeft = topLeft.rotateInXY(angle, c_m);
		topRight = topRight.rotateInXY(angle, c_m);
		bottomRight = bottomRight.rotateInXY(angle, c_m);
		bottomLeft = bottomLeft.rotateInXY(angle, c_m);
	}
	
	public Vector getPos() {
		return topLeft;
	}

	public Polygon getGfxPolygon() {
		int[] x = {(int)(getTopLeft().getX()*Game.pxPerM),(int)(getTopRight().getX()*Game.pxPerM),(int)(getBottomRight().getX()*Game.pxPerM),(int)(getBottomLeft().getX()*Game.pxPerM)};
		int[] y = {(int)(getTopLeft().getY()*Game.pxPerM),(int)(getTopRight().getY()*Game.pxPerM),(int)(getBottomRight().getY()*Game.pxPerM),(int)(getBottomLeft().getY()*Game.pxPerM)};
		return new Polygon(x,y,4);
	}
	
	
	
}
