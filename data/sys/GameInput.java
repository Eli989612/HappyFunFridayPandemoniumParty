package data.sys;

import java.awt.event.*;

public class GameInput implements KeyListener{
	
	Player p;
	
	public GameInput(Player p){
		this.p=p;
	}
	
	public void keyPressed(KeyEvent e) {
		int x = e.getKeyCode();
		if (x==KeyEvent.VK_RIGHT) {
			((Player)Game.objects.get(1)).moveRight();
		}
		if (x==KeyEvent.VK_LEFT) {
			p.moveLeft();
		}
		if (x==KeyEvent.VK_UP) {
			p.jump();
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int x = e.getKeyCode();
		if (x==KeyEvent.VK_RIGHT) {
			p.stopMoveR();
		}
		if (x==KeyEvent.VK_LEFT) {
			p.stopMoveL();
		}
	
		
	}

	public void keyTyped(KeyEvent e) {
		
	}
	
}
