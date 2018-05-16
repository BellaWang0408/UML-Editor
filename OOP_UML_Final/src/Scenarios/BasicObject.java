package Scenarios;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import CanvasArea.*;

public abstract class BasicObject extends GroupObject
{
	
	
	
	public BasicObject()
	{
		Catch = false;
		right = new Port();
		left = new Port();
		up = new Port();
		down = new Port();
		Canvas.canvaspanel.add(right);
		Canvas.canvaspanel.add(left);
		Canvas.canvaspanel.add(up);
		Canvas.canvaspanel.add(down);
		hideport();
		
	}
	@Override
	public void showport()
	{
		Catch = true;
		right.setOpaque(true);
		left.setOpaque(true);
		up.setOpaque(true);
		down.setOpaque(true);
		Point loc = SwingUtilities.convertPoint(getParent(), getLocation(), Canvas.canvaspanel);
		System.out.println("*********"+loc);
		right.setLocation(new Point(loc.x+getWidth(),loc.y+getHeight()/2));
		left.setLocation(new Point(loc.x-10,loc.y+getHeight()/2));
		up.setLocation(new Point(loc.x+getWidth()/2,loc.y-10));
		down.setLocation(new Point(loc.x+getWidth()/2,loc.y+getHeight()));
	}
	public void hideport()
	{
		Catch = false;
		right.setOpaque(false);
		left.setOpaque(false);
		up.setOpaque(false);
		down.setOpaque(false);
	}
	@Override
	public abstract ArrayList<GroupObject> unGroup();
	@Override
	public void addGroup(GroupObject g)
	{
		// TODO Auto-generated method stub
		
	}

}
