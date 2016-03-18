package data.sys;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTextField;

//http://buildnewgames.com/gamephysics/

public class Game {

	private static final long serialVersionUID = 1L;

	public static final int width = 1600;
	public static final int height = 900;
	public static final double fps = 1000;
	public static double pxPerM = 30;
			
	private static boolean running = true;
	private static final double T = 1/fps;
	public static double mPerPx = 1/pxPerM;
	
	public static ArrayList<GameObject> objects = new ArrayList<GameObject>();
	
	public static JFrame frame = new JFrame();
	public static Screen screen = new Screen(T);
	public static JTextField txtF = new JTextField();
	
	public static GameInput in = new GameInput((Player)objects.get(1));
	
	public static void main(String[] args) throws InterruptedException {
		initialize();
		while(running) {
			update();
			render();
			Thread.sleep((long) (T*1000));
		}
	}
	
	public static void initialize() {
		frame.add(txtF);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		frame.setResizable(true);
//		frame.add(txtF);
		frame.add(screen);
		txtF.addKeyListener(in);

	}
	
	public static void update() {
		screen.update();
	}
	
	public static void render() {
		frame.repaint();
	}

}
