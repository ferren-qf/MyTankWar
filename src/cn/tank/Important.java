package cn.tank;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

//不知为什么在其中移除容器中内容，在画方法中添加remove方法，效果没有这么好
public class Important extends GameFrame {
	int howMuch;
	MainTank myTank=new MainTank(this,true);
//	Explode explode=new Explode();
//	MainTank enemyTank=new MainTank(tbis,false);
//	Tank diTank=new Tank();
//	Bullet b;
	List<Bullet> bullets=new ArrayList<Bullet>();
	List<MainTank> enemyTanks=new ArrayList<MainTank>();
	List<Explode> explodes=new ArrayList<Explode>();
	public void lunacbFrame(){
		super.lunachFrame();
		addKeyListener(new KeyMonitor());
	}
	
	
	public void paint(Graphics g){
		for(int i=0;i<bullets.size();i++){
			Bullet bu=bullets.get(i);
				bu.hitTank(enemyTanks);
				bu.hitTank(myTank);
				bu.ifDrawBullet(g);	
		}
		if(myTank.isLive()){
			myTank.draw(g);
		}
		//		if(bullet.size()!=0){
//		for(int i=0;i<enemyTank.size();i++){ 
//			MainTank n=enemyTank.get(i); 
//			
//		}
		
/*		for(int i=0;i<enemyTank.size();i++){
			Bullet b=bullet.get(i);
			if(b.live){
				b.ifDrawBullet(g);
			}
			for(int j=0;j<bullet.size();j++){
				Bullet n=bullet.get(j);
				n.hitTank();
				if(n.isLive()){
					n.draw(g);
				}else{
//					bullet.remove(i);		
					enemyTank.remove(j);
				}
				//			}
			}
			
		}*/
		//		if(m!=null){
//			m.ifDrawBullet(g);}

		//		bullet.draw(g);
//		diTank.draw(g);
	
		for(int j=0;j<enemyTanks.size();j++){
			MainTank en=enemyTanks.get(j);
			en.draw(g);
		}

	
			
			//			for(int j=0;j<enemyTank.size();j++){
			//				MainTank en=enemyTank.get(j);
			//				if(!bu.hitTank(enemyTank)){
			//					enemyTank.draw(g);
			//				}
			//				else{
			//					bullet.remove(i);
			//					enemyTank.remove(j);
			//					howMuch++;
			//					explode.get(j).draw(g);
			//					
			//					explode.remove(j);
		//}
		/*else{
				enemyTank.remove(j);
			}*/
//			}
//		}
		for(int i=0;i<explodes.size();i++){
			Explode ex=explodes.get(i);
			ex.draw(g);
		}
		
//		explode.draw(g);
//		System.out.println(bullet.size());
		g.drawString("bullet count:" + bullets.size(), 10, 50);
		g.drawString("enemyTank count:" + enemyTanks.size(), 10, 80);
		g.drawString("the number of kill dir :"+howMuch, 10,110);
	}
	class KeyMonitor extends KeyAdapter{
		public void keyPressed(KeyEvent e){
			//			System.out.println("按下"+e.getKeyCode());
			myTank.pressedKey(e);
		}
		public void keyReleased(KeyEvent e){
			//			System.out.println("释放"+e.getKeyCode());
			myTank.releasedKey(e);
		}
	
	}
	public static void main(String[] args){
		Important a=new Important();
		a.lunacbFrame();
	}
}

