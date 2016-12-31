package cn.tank;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.Random;





public class MainTank {
//	ArrayList bulletList=new ArrayList();
	Important it;
	
	
	private static Random ra=new Random();
	TankWhere[] twn=TankWhere.values();
	
	public int x=500;
	public int y=500;
	private int speed =5;
	private int time;
	private int raI;
	public boolean up,down,right,left,she;
	private boolean good;
	private boolean live=true;
	
	
	
	
	
	
	
	public Color n=Color.RED;
	public Color m=Color.BLUE;
	enum TankWhere{U,UR,R,RD,D,DL,L,LU};
	public TankWhere tw=TankWhere.L;
	
	
//	public int m;
//	Object a[]=new Object[100];
	public int bulletSpeed=10;
//	public int bulletX=x;
//	public int bulletY=y;
	
	
	public void draw(Graphics g){
		if(!live){ 
//			it.enemyTanks.remove(this);
			return;
			}
		
		Color c=g.getColor();

		if(good){
			g.setColor(n);
		}else{
			g.setColor(m);
		}
			g.fillOval(x, y,Count.MAINTANKWIDTH,Count.MAINTANKHEINGHT);
//			g.drawOval(100, 100, 20, 20);
			g.setColor(c);
			move();
			Where we=new Where(x,y,tw,good);
			we.draw(g);
			return;
			
			
//		x+=speed;
//		System.out.println(left);
//		if(!good){
//			int randomNumber=rn.nextInt(twn.length);
//			tw=twn[randomNumber];
//			}
		
		
		
			
	
	
//		System.out.println(888888);
	
		
	}


	public void locateTankWhere(){
		if(up&!right&&!down&&!left)
			tw=TankWhere.U;
		else if(up&&right&&!down&&!left)
			tw=TankWhere.UR;
		else if(!up&&right&&!down&&!left)
			tw=TankWhere.R;
		else if(!up&&right&&down&&!left)
			tw=TankWhere.RD;
		else if(!up&&!right&&down&&!left)
			tw=TankWhere.D;
		else if(!up&&!right&&down&&left)
			tw=TankWhere.DL;
		else if(!up&&!right&&!down&&left)
			tw=TankWhere.L;
		else if(up&&!right&&!down&&left)
			tw=TankWhere.LU;
	}
	
	
	public void move(){
		if(good){
			if(up){	
				y-=speed;
			}
			if(down){
				y+=speed;
			}
			if(right){
				x+=speed;
			}
			if(left){
				x-=speed;
			}
			locateTankWhere();
		}else{	
			if(0==time){
				time=ra.nextInt(12)+3;
				raI=ra.nextInt(8);
				tw=twn[raI];
			}
				switch(tw){
				case L:
					x-=speed;
					break;
				case LU:
					x-=speed;
					y-=speed;
					break;
				case U:
					y-=speed;
					break;
				case UR:
					x+=speed;
					y-=speed;
					break;
				case R:
					x+=speed;
					break;
				case RD:
					x+=speed;
					y-=speed;
					break;
				case D:
					y+=speed;
					break;
				case DL:
					x-=speed;
					y+=speed;
					break;
				default:
					break;
				
			}
			time--;
			if(ra.nextInt(30)<1){
				fire();
			}
		}
		if(x<10){
			x=10;
		}
		if(y<30){
			y=30;
		}
		if(x>Count.FRAMEWIDTH-Count.TANKWIDTH-10){
			x=Count.FRAMEWIDTH-Count.TANKWIDTH-10;
		}
		if(y>Count.FRAMEHEIGHT-Count.TANKHEIGHT-10){
			y=Count.FRAMEHEIGHT-Count.TANKHEIGHT-10;
		}


	}
	
	public  void releasedKey(KeyEvent e){
		switch(e.getKeyCode()){
		case KeyEvent.VK_UP:
			//			System.out.println(111111);
			up=false;
			break;
		case KeyEvent.VK_DOWN:
			down=false;			
			//			System.out.println(333333);
			break;
		case KeyEvent.VK_RIGHT:
			right=false;			
			//			System.out.println(222222);
			break;
		case KeyEvent.VK_LEFT:
			left=false;
			//			System.out.println(444444);
			break;
		case KeyEvent.VK_A:
//			she=true;		
			fire();
			break;
		case KeyEvent.VK_P:
			addEnemyTank();
			break;
		default:
			break;
		}
	}

	public  void pressedKey(KeyEvent e){
		switch(e.getKeyCode()){
		case KeyEvent.VK_UP:
			//		System.out.println("ÉÏ");
			up=true;
			break;
		case KeyEvent.VK_DOWN:
			down=true;
			//			System.out.println("ÏÂ");
			break;
		case KeyEvent.VK_RIGHT:
			right=true;
			//			System.out.println("ÓÒ");
			break;
		case KeyEvent.VK_LEFT:
			left=true;
			//			System.out.println("×ó");
			break;
		case KeyEvent.VK_A:
//			she=false;
//			it.m=fire();
			break;
		default:
			break;
		}
	}
	
	public Rectangle getRect(){
		return new Rectangle(x,y,Count.TANKWIDTH,Count.TANKHEIGHT);
	}
	public Bullet fire() {
		if(live){
		int bulletX = this.x+(int)(Count.MAINTANKWIDTH/2 - Count.BULLETWIDTH/2);
		int bulletY = this.y+(int)(Count.MAINTANKHEINGHT/2 -Count.BULLETHEIGNT/2);
		Bullet b = new Bullet(bulletX,bulletY, tw,it,good);
//		System.out.println("hahahhahahhah");
		it.bullets.add(b);
		return b;
		}
		return null;
	}
	//Ìí¼Ótank explode
	public MainTank addEnemyTank(){
		int addX=(int)(ra.nextDouble()*Count.FRAMEWIDTH);
		int addY=(int)(ra.nextDouble()*Count.FRAMEHEIGHT);
		MainTank m=new MainTank(addX,addY,false,it);
//		Explode e=new Explode(x,y,it);
		it.enemyTanks.add(m);
//		it.explodes.add(e);
		return m;
	}
	
	/*
	 * Ë«»º³å
	 */
//	private Image offScreenImage=null;
//	public void update(Graphics g){
//		if(offScreenImage==null){
//			offScreenImage=createImage(n,m);
//		Graphics gOff=offScreenImage.getGraphics();
//		paint(gOff);
//		gOff.drawImage(offScreenImage, 0, 0, null);
//	}
//	}
	public boolean isGood() {
		return good;
	}


	public void setGood(boolean good) {
		this.good = good;
	}

	
	
	public boolean isLive() {
		return live;
	}


	public void setLive(boolean live) {
		this.live = live;
	}
	public MainTank(){
		
	}
	public MainTank(Important it,boolean good){
		this.it=it;
		this.good=good;
	}
	public MainTank(int x,int y,boolean good){
		this.x=x;
		this.y=y;
		this.good=good;
	}
	public MainTank(int x,int y,boolean good,Important it){
		this(x,y,good);
		this.it=it;
		this.good=good;
	}
	public MainTank(int x,int y,boolean good,Important it,TankWhere tw){
		this(x,y,good,it);
		this.tw=tw;
	}
}
