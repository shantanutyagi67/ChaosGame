package Striangle;

import java.*;
import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Scanner;

import javax.*;
import javax.swing.JComponent;
import javax.swing.JFrame;

class Ssquare {
		private float ax,ay,bx,by,cx,cy,dx,dy;
		public float len = 500;
		public float getAx() {
			return ax;
		}
		public float getAy() {
			return ay;
		}
		public float getBx() {
			return bx;
		}
		public float getBy() {
			return by;
		}
		public float getCx() {
			return cx;
		}
		public float getCy() {
			return cy;
		}
		public float getDx() {
			return dx;
		}
		public float getDy() {
			return dy;
		}
		public Ssquare(float x, float y) {
		ax=x-250;
		ay= y-250;
		bx= x+250;
		by= y-250;
		cx= x-250;
		cy= y+250;
		dx= x+250;
		dy= y+250;
		
		}
//		public void scalene() {
//			ax+=800.0*Math.random() -400;
//			bx+=100.0*Math.random()-70;
//			bx+=100.0*Math.random()-30;
//			ay+=100.0*Math.random()-50;
//			by+=100.0*Math.random();
//			cy+=400.0*Math.random()-200;
//		}
}

public class square extends JComponent implements Runnable{
	
//	static int makeScalene;
	static int itr;
	static JFrame frame = new JFrame("Serpentski Triangle");
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);  
//        System.out.print("Type 0 for Equilateral and 1 for Scalene: ");  
//        makeScalene = sc.nextInt(); 
        System.out.print("Enter iterations: ");
        itr = sc.nextInt();
        
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(0,0,900,900);
		frame.getContentPane().add(new square());
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setVisible(true);
//		if(makeScalene==1)
//			sqr.scalene();
	}
	static Ssquare sqr = new Ssquare(450,450);
	@Override
	public void run() {
		//try {
			//Thread.sleep(50);
			repaint();
		//} //catch (InterruptedException e) {
			//e.printStackTrace();
		//}
		
	}
	//static int startX=frame.getWidth()/2;
	//static int startY=frame.getHeight()/2;
	int n=0;//points counter
	//initial points
	float x =  frame.getWidth()/2-250; 
	float y =  frame.getHeight()/2-250;
	static ArrayList<ArrayList<Float> > points = new ArrayList<ArrayList<Float> >();
	public void paint(Graphics g)
	{
			points.add(new ArrayList<Float>());
			points.get(n).add(0,x);
			points.get(n).add(1,y);
			Graphics2D g2D = (Graphics2D) g;
			RenderingHints rh = new RenderingHints(
	                RenderingHints.KEY_ANTIALIASING,
	                RenderingHints.VALUE_ANTIALIAS_ON);

	        rh.put(RenderingHints.KEY_RENDERING,
	               RenderingHints.VALUE_RENDER_QUALITY);
	        g2D.translate(100, 100);
	        g2D.setRenderingHints(rh);
	        g2D.setColor(Color.RED);
	        g2D.setFont(new Font("TimesRoman", Font.PLAIN, 20));
	        g2D.drawString("Iterator: "+n, 600, -50);
			n++;
			g2D.setColor(Color.WHITE);
			g2D.drawLine((int)sqr.getAx(), (int)sqr.getAy(), (int)sqr.getBx(), (int)sqr.getBy());
			g2D.drawLine((int)sqr.getBx(), (int)sqr.getBy(), (int)sqr.getDx(), (int)sqr.getDy());
			g2D.drawLine((int)sqr.getCx(), (int)sqr.getCy(), (int)sqr.getAx(), (int)sqr.getAy());
			g2D.drawLine((int)sqr.getDx(), (int)sqr.getDy(), (int)sqr.getCx(), (int)sqr.getCy());
			g2D.setStroke(new BasicStroke(1f));
			//g2D.drawOval(frame.getWidth()/2, frame.getHeight()/2, 1, 1);
			for(ArrayList<Float> a : points) {
			//g2D.drawOval((int)a.get(0), (int)a.get(1), 1, 1);
			g2D.fill(new Ellipse2D.Float((float)a.get(0)-(float)1.00, (float)a.get(1)-(float)1.00, (float)2.00, (float)2.00));
			}
			int random = (int)(1000.0 * Math.random());
			if(random%8==0)//write logic to move towards a by half the distance from a
			{
				//g2D.setColor(Color.BLUE);
				x=(x+2*sqr.getAx())/3;
				y=(y+2*sqr.getAy())/3;
			}
			else if(random%8==1)//towards b
			{
				//g2D.setColor(Color.RED);
				x=(x+2*sqr.getBx())/3;
				y=(y+2*sqr.getBy())/3;
			}
			else if(random%8==2)//towards c
			{
				//g2D.setColor(Color.GREEN);
				x=(x+2*sqr.getCx())/3;
				y=(y+2*sqr.getCy())/3;
			}
			else if(random%8==3){
				x=(x+2*sqr.getDx())/3;
				y=(y+2*sqr.getDy())/3;
			}
			else if(random%8==4){
				x=(x+2*(sqr.getAx()+sqr.getBx())/2)/3;
				y=(y+2*(sqr.getAy()+sqr.getBy())/2)/3;
			}
			else if(random%8==5){
				x=(x+2*(sqr.getBx()+sqr.getDx())/2)/3;
				y=(y+2*(sqr.getBy()+sqr.getDy())/2)/3;
			}
			else if(random%8==6){
				x=(x+2*(sqr.getDx()+sqr.getCx())/2)/3;
				y=(y+2*(sqr.getDy()+sqr.getCy())/2)/3;
			}
			else if(random%8==7){
				x=(x+2*(sqr.getCx()+sqr.getAx())/2)/3;
				y=(y+2*(sqr.getCy()+sqr.getAy())/2)/3;
			}
//			else{
//				x=frame.getWidth()/2;
//				y=frame.getHeight()/2;
//			}
			Toolkit t=Toolkit.getDefaultToolkit();  
	        Image im=t.getImage("sqr.png");
	        g2D.drawImage(im, -90,-90,this);
			if(n==itr+1) return;
			repaint();
	}
	
}
	

