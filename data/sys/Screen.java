package data.sys;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JComponent;

import data.eng.Rectangle;
import data.eng.Vector;
import data.gfx.Texture;

public class Screen extends JComponent{

	private static final long serialVersionUID = 1L;
	
	double T;
	private static double width = Game.width*Game.mPerPx;
	private static double height = Game.height*Game.mPerPx;
	
	int q = 0;
	Random rand = new Random();
	
	
	public Screen(double T) {
		Game.objects.add(new Slime(new Vector(5,5),.1));
		Game.objects.add(new Player(new Vector(5,9),.01));
		for(int i=0;i<100;i++) {
			Game.objects.add(new Slime(new Vector(5,5+(i*.01)),.1));
		}
		this.T=T;
	}
	
	public void paint(Graphics g) {
		for(int i=0;i<Game.objects.size();i++) {
			Texture t = Game.objects.get(i).getTexture();
			for(int j=0;j<t.size();j++) {
				g.setColor(t.get(j).getColor());
				g.fillPolygon(t.get(j).getGfxPolygon());
			}
		}
		g.setColor(Color.BLACK);
		for(int i=1;i<6;i++) {
			g.fillRect((int)(5*i*Game.pxPerM),(int)(5*Game.pxPerM), 5, 50);
		}
		g.drawLine((int)(Game.objects.get(0).getCenterMass().getX()*Game.pxPerM), (int)(Game.objects.get(0).getCenterMass().getY()*Game.pxPerM), (int)(10*Game.pxPerM),(int)(5*Game.pxPerM));
		
	}
	
	public void addObject(GameObject a) {
		Game.objects.add(a);
	}
	
	public void update() {
		for(int i=0;i<Game.objects.size();i++) {
			Game.objects.get(i).updatePhysics(T);
		}
	}

}
