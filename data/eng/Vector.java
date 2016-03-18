package data.eng;

public class Vector{

	protected double x,y,z;
	
	public Vector(double x,double y) {
		this.x=x;
		this.y=y;
		z=0;
	}
	
	public Vector(double x,double y,double z) {
		this.x=x;
		this.y=y;
		this.z=z;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public double getZ() {
		return z;
	}
	
	public double getMagnitude() {
		return Math.sqrt(x*x+y*y+z*z);
	}
	
	public void Print() {
		System.out.println("[ " + x + " , " + y + " , " + z + " ]");
	}
	
	//Vector operations
	public Vector add(Vector v) {
		return new Vector(x+v.getX(),y+v.getY(),z+v.getZ());
	}
	
	public Vector subtract(Vector v) {
		return new Vector(x-v.getX(),y-v.getY(),z-v.getZ());
	}
	
	public Vector scale(double n) {
		return new Vector(n*x,n*y,n*z);
	}
	
	public double dotProduct(Vector v) {
		return x*v.getX()+y*v.getY()+z*v.getZ();
	}
	
	public Vector crossProduct(Vector v) {
		double sx = y*v.getZ()-z*v.getY();
		double sy = z*v.getX()-x*v.getZ();
		double sz = x*v.getY()-y*v.getX();
		return new Vector(sx,sy,sz);
	}
	
	public Vector rotateInXY(double angle, Vector point) {
		Vector v = this.subtract(point);
		x = point.getX()+(v.getX()*Math.cos(angle)-v.getY()*Math.sin(angle));
		y = point.getY()+(v.getX()*Math.sin(angle)+v.getY()*Math.cos(angle));
//		x = this.getX()*Math.cos(angle)-this.getY()*Math.sin(angle);
//		y = this.getX()*Math.sin(angle)+this.getY()*Math.cos(angle);
		return new Vector(x,y,z);
	}
	
}

