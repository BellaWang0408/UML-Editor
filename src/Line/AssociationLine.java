package Line;

import java.awt.Graphics;
import java.awt.Point;

import Scenarios.*;

import javax.swing.JComponent;
import javax.swing.SwingUtilities;

import CanvasArea.Canvas;

public class AssociationLine extends line 
{
	Port startC,endC;
	
	public AssociationLine()//ªì©l¤Æ
	{
		setBounds(0, 0, 1000, 1000);
		
	}
	public void setLine(Port a,Port b)
	{
		startC = a;
		endC = b;
	}
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.fillRect(startC.getX(),startC.getY(), 10 , 10);
		g.fillRect(endC.getX(),endC.getY(), 10 , 10);
		g.drawLine(startC.getX(), startC.getY(), endC.getX(),endC.getY());
	}
	@Override
	public void showport() {
		// TODO Auto-generated method stub
		
	}
}

