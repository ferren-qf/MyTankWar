package cn.tank;

import java.awt.Color;
import java.awt.Graphics;

import cn.tank.MainTank.TankWhere;

public class Where {
	
	public int x;
	public int y;
	TankWhere tw;
	private boolean good;
	

	public void draw(Graphics g){
		Color c=g.getColor();
		if(good){
		g.setColor(Color.BLUE);
		}else{
			g.setColor(Color.red);
		}
		switch(tw){
		case U:
			g.drawLine(x+10, y+10,x+10 , y-5);
			break;
		case UR:
			g.drawLine(x+10, y+10,(int) (Count.MAINTANKWIDTH+x+0.6) , (int)(y-0.6));
			break;
		case R:
			g.drawLine(x+10, y+10,(int)(x+Count.MAINTANKWIDTH+5), (int)(y+Count.MAINTANKWIDTH/2));
			break;
		case RD:
			g.drawLine(x+10, y+10,(int) (Count.MAINTANKWIDTH+x+0.6)  , (int) (Count.MAINTANKHEINGHT+y+0.6));
			break;
		case D:
			g.drawLine(x+10, y+10,x+10 ,y+5+Count.MAINTANKHEINGHT);
			break;
		case DL:
			g.drawLine(x+10, y+10,(int) (x-0.6), (int)(y+0.6+Count.MAINTANKHEINGHT));
			break;
		case L:
			g.drawLine(x+10, y+10,(int)(x-5), (int)(y+Count.MAINTANKHEINGHT/2));
			break;
		case LU:
			g.drawLine(x+10, y+10,(int) (x-0.6), (int)(y-0.6));
			break;
		}
		g.setColor(c);
	}
	public boolean isGood() {
		return good;
	}

	public void setGood(boolean good) {
		this.good = good;
	}
	public Where(int x,int y,TankWhere tw){
		this.x=x;
		this.y=y;
		this.tw=tw;
	}
	public Where(int x,int y,TankWhere tw,boolean good){
		this(x,y,tw);
		this.good=good;
	}
}
