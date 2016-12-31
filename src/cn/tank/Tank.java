package cn.tank;

import java.awt.Color;
import java.awt.Graphics;

import cn.tank.MainTank.TankWhere;

public class Tank {
	public int x=200;
	public int y=200;
	public int speed=5;
	private Color n=Color.GREEN;
	 TankWhere tw=TankWhere.L;
	 public TankWhere twrandom(){
		int a= (int)(8*Math.random());
		switch (a){
		case 0:
			return TankWhere.L;
		}
		return tw;
		 
	 }
//	public void draw(Graphics g){
//		Color c=g.getColor();
//		g.setColor(n);
//		g.fillOval(x, y,20,20);
	//	g.drawOval(100, 100, 20, 20);
//		g.setColor(c);
//		x+=speed;
//		System.out.println(left);
//		move();
//		System.out.println(888888);
//	}
	public void draw(Graphics g){
		
		Color c=g.getColor();
		g.setColor(n);
		g.fillOval(x, y,Count.MAINTANKWIDTH,Count.MAINTANKHEINGHT);
//		g.drawOval(100, 100, 20, 20);
		g.setColor(c);
//		x+=speed;
//		System.out.println(left);
		Where we=new Where(x,y,tw);
		we.draw(g);
	//	move();
			
	
	
//		System.out.println(888888);
	
	//	locateTankWhere();
	}

}
