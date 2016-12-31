package cn.tank;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

public class Explode {
	public int x,y;
	Important it;
	List<Explode> explodes;
	public int[] explodeImage={40,4,6,8,10,12,14,20,26,30,40,20,10,8,4};
	private int step=0;
	public boolean live=false;
	public void draw(Graphics g){
		
		if(live&&explodeImage.length==step) {
			explodes.remove(this);
			return ;
			}
		Color c=g.getColor();
		g.setColor(Color.YELLOW);
		g.fillOval(x-explodeImage[step]/2+Count.TANKWIDTH/2, y-explodeImage[step]/2+Count.TANKHEIGHT/2, explodeImage[step],explodeImage[step] );
		g.setColor(c);
		step++;
	}
	public Explode(int x,int y,Important it,boolean live){
		this.x=x;
		this.y=y;
		this.it=it;
		this.explodes=it.explodes;
		this.live=live;
	}
}
