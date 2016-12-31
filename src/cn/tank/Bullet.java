package cn.tank;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;

public class Bullet {


	public int bulletX;
	public int bulletY;
	public int bulletSpeed=5;
	public int tankWhere;
	
	public boolean live=true;
	private boolean good;
	
	
	Important it; 
	MainTank.TankWhere tw;
	List<MainTank> enemyTanks;
	List<Explode> explodes;
	public void ifDrawBullet(Graphics g){	
		//this.hitTank(enemyTanks);	
		if(!live){ 
				it.bullets.remove(this);
				return;
				}
		
		Color c=g.getColor();
		if(good){
			g.setColor(Color.black);
		}else{
			g.setColor(Color.red);
		}
		g.fillOval(bulletX, bulletY, Count.BULLETWIDTH,Count.BULLETHEIGNT);
		g.setColor(c);
		bulletMove();

	}
			
		
	
	private void bulletMove() {
		switch (tw){
		case U:
			//			bulletX+=bulletSpeed;
			bulletY-=bulletSpeed;

			break;
		case UR:
			bulletX+=bulletSpeed;
			bulletY-=bulletSpeed;
			break;
		case R:
			bulletX+=bulletSpeed;
			//			bulletY+=bulletSpeed;

			break;
		case RD:
			bulletX+=bulletSpeed;
			bulletY+=bulletSpeed;

			break;
		case D:
			//			bulletX+=bulletSpeed;
			bulletY+=bulletSpeed;

			break;
		case DL:
			bulletX-=bulletSpeed;
			bulletY+=bulletSpeed;

			break;
		case L:
			bulletX-=bulletSpeed;
			//			bulletY+=bulletSpeed;

			break;
		case LU:
			bulletX-=bulletSpeed;
			bulletY-=bulletSpeed;

			break;
		}
		if(bulletX<0||bulletY<0||bulletX>Count.FRAMEWIDTH||bulletY>Count.FRAMEHEIGHT){
			live=false;
			it.bullets.remove(this);
		}
		
	}


	public Rectangle getRect(){
		return new Rectangle(bulletX,bulletY,Count.BULLETWIDTH,Count.BULLETHEIGNT);
	}
	public boolean hitTank(MainTank mt){
		if(this.getRect().intersects(mt.getRect())&&true==mt.isLive()&&good!=mt.isGood()){
			Explode ex=new Explode(mt.x,mt.y,it,true);
			explodes.add(ex);
			this.live=false;
			mt.setLive(false);
			return true;
		}
			return false;
	}
	public boolean hitTank(List<MainTank> enemyTanks){
		for(int i=0;i<enemyTanks.size();i++){
			MainTank et=enemyTanks.get(i);
			if(this.getRect().intersects(et.getRect())&&et.isLive()&&good!=et.isGood()){
				Explode ex=new Explode(et.x,et.y,it,true);
				explodes.add(ex);
				this.live=false;
				et.setLive(false);
				enemyTanks.remove(et);
				return true;
			}
		}
		return false;
	}
	public boolean isGood() {
		return good;
	}



	public void setGood(boolean good) {
		this.good = good;
	}
	public Bullet() {
	
	}
	public Bullet(int x, int y, MainTank.TankWhere tw,Important it) {
		this.bulletX = x;
		this.bulletY = y;
		this.tw = tw;
		this.enemyTanks=it.enemyTanks;
		this.explodes=it.explodes;
		this.it=it;
	}
	public Bullet(int x, int y, MainTank.TankWhere tw,Important it,boolean good){
		this(x,y,tw,it);
		this.good=good;
	}
}
