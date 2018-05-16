package Line;

import java.awt.Graphics;

import javax.swing.JComponent;

import Scenarios.GroupObject;
import Scenarios.Port;

public class CompositionLine extends line
{
	//Port startC,endC;
	int trianglex[] = new int[4];
	int triangley[] = new int[4];
	public CompositionLine()//ªì©l¤Æ
	{
		setBounds(0, 0, 1000, 1000);
	}
	/*public void setLine(Port a,Port b)
	{
		startC = a;
		endC = b;
	}*/
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.fillRect(startC.getX(),startC.getY(), 10 , 10);
		g.fillRect(endC.getX(),endC.getY(), 10 , 10);
		g.drawLine(startC.getX(), startC.getY(), endC.getX(), endC.getY());
		trianglex[0] = endC.getX();
		trianglex[1] = endC.getX()-10;
		trianglex[2] = endC.getX()-20;
		trianglex[3] = endC.getX()-10;
		triangley[0] = endC.getY();
		triangley[1] = endC.getY()-10;
		triangley[3] = endC.getY()+10;
		triangley[2] = endC.getY();
		g.fillPolygon(trianglex,triangley,4);
	}
	@Override
	public void showport() {
		// TODO Auto-generated method stub
		
	}
	

}
