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

class Striangle {
		private float ax,ay,bx,by,cx,cy;
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
		public Striangle(float x, float y) {
		ax=x;
		ay= (float) (y+len*1.732/3);
		bx= (x-len/2);
		by= (float) (y-len*1.732/6);
		cx= (x+len/2);
		cy= (float) (y-len*1.732/6);
		}
		public void scalene() {
			ax+=800.0*Math.random() -400;
			bx+=100.0*Math.random()-70;
			bx+=100.0*Math.random()-30;
			ay+=100.0*Math.random()-50;
			by+=100.0*Math.random();
			cy+=400.0*Math.random()-200;
		}
}

public class triangle extends JComponent implements Runnable{
	
	static int makeScalene;
	static int itr;
	static JFrame frame = new JFrame("Serpentski Triangle");
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);  
        System.out.print("Type 0 for Equilateral and 1 for Scalene: ");  
        makeScalene = sc.nextInt(); 
        System.out.print("Enter iterations: ");
        itr = sc.nextInt();
        
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(0,0,900,900);
		frame.getContentPane().add(new triangle());
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setVisible(true);
		if(makeScalene==1)
			tri.scalene();
	}
	static Striangle tri = new Striangle(450,450);
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
	float x =  frame.getWidth()/2; 
	float y =  frame.getHeight()/2 ;
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

	        g2D.setRenderingHints(rh);
	        g2D.setColor(Color.RED);
	        g2D.setFont(new Font("TimesRoman", Font.PLAIN, 20));
	        g2D.drawString("Iterator: "+n, 700, 50);
			n++;
			g2D.setColor(Color.WHITE);
			g2D.drawLine((int)tri.getAx(), (int)tri.getAy(), (int)tri.getBx(), (int)tri.getBy());
			g2D.drawLine((int)tri.getBx(), (int)tri.getBy(), (int)tri.getCx(), (int)tri.getCy());
			g2D.drawLine((int)tri.getCx(), (int)tri.getCy(), (int)tri.getAx(), (int)tri.getAy());
			g2D.setStroke(new BasicStroke(1f));
			//g2D.drawOval(frame.getWidth()/2, frame.getHeight()/2, 1, 1);
			for(ArrayList a : points) {
			//g2D.drawOval((int)a.get(0), (int)a.get(1), 1, 1);
			g2D.fill(new Ellipse2D.Float((float)a.get(0), (float)a.get(1), (float)1.00, (float)1.00));
			}
			int random = (int)(100.0 * Math.random());
			if(random%3==0)//write logic to move towards a by half the distance from a
			{
				//g2D.setColor(Color.BLUE);
				x=(x+tri.getAx())/2;
				y=(y+tri.getAy())/2;
			}
			else if(random%3==1)//towards b
			{
				//g2D.setColor(Color.RED);
				x=(x+tri.getBx())/2;
				y=(y+tri.getBy())/2;
			}
			else//towards c
			{
				//g2D.setColor(Color.GREEN);
				x=(x+tri.getCx())/2;
				y=(y+tri.getCy())/2;
			}
			Toolkit t=Toolkit.getDefaultToolkit();  
	        Image im=t.getImage("C:\\Users\\geekSA67\\Downloads\\tri.png");
	        g2D.drawImage(im, 0,0,this);
			if(n==itr+1) return;
			repaint();
	}
	
}
	

