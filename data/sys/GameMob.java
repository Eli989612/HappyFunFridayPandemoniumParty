package data.sys;

import java.awt.Polygon;

import data.eng.Vector;
import data.gfx.Texture;

public abstract class GameMob extends GameCharacter{

	public GameMob(int ID,Vector pos,double mass) {
		super(ID,pos,mass);
		
	}
	
	public GameMob(int ID,Vector pos,Vector vel,Vector acc,double theta,double omega,double alpha,double mass) {
		super(ID,pos,vel,acc,theta,omega,alpha,mass);
		
	}
	
}
