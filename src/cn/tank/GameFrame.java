package cn.tank;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameFrame extends Frame {
	
	
	
	public void lunachFrame(){
		setSize(Count.FRAMEWIDTH,Count.FRAMEHEIGHT);
		setLocation(200,200);
		setVisible(true);
		setTitle("MyTankWar");
		new PaintThread().start();
		
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		
	}
	
//	private Image offScreenImage = null;
//	public void update(Graphics g){
//		if(offScreenImage==null){
//			offScreenImage =this.createImage(500, 600);
//		Graphics gOff=offScreenImage.getGraphics();
//		paint(gOff);
//		g.drawImage(offScreenImage,0,0,null);
//		}
//	}
	private Image offScreenImage = null;
	public void update(Graphics g){
		if(offScreenImage==null){
		}offScreenImage =this.createImage(800, 600);
		Graphics gOff=offScreenImage.getGraphics();
		paint(gOff);
		g.drawImage(offScreenImage,0,0,null);
	}
	
//	public void pressedKey(KeyEvent e) {	
//
//	}
//	public void releasedKey(KeyEvent e) {
//	}
	
	
	
	
	class PaintThread extends Thread{
		public void run(){
			while(true){
				repaint();
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
