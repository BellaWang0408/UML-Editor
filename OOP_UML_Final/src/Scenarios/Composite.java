package Scenarios;

import java.awt.BasicStroke;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JComponent;

import CanvasArea.Canvas;

public class Composite extends GroupObject {
	private Point Upleft, Rightdown;
	Shape groupline = null;
	
	
	public Composite() {
		Upleft = new Point(100000, 100000);
		Rightdown = new Point(0, 0);
	}

	public void changesize() {
		for (Component p : getComponents()) {
			if (p.getX() < Upleft.x) {
				Upleft.x = p.getX();
			}
			if (p.getY() < Upleft.y) {
				Upleft.y = p.getY();
			}
			if (p.getY() + p.getHeight() > Rightdown.y) {
				Rightdown.y = p.getY() + p.getHeight();
			}
			if (p.getX() + p.getWidth() > Rightdown.x) {
				Rightdown.x = p.getX() + p.getWidth();
			}
		}
		Upleft.x -= 10;
		Upleft.y -= 10;
		Rightdown.x += 10;
		Rightdown.y += 10;
		setLocation(Upleft);
		setSize(Rightdown.x - Upleft.x, Rightdown.y - Upleft.y);
		adjustLocation();
		// setSize(200,200);
	}

	public void adjustLocation() {
		for (Component p : getComponents()) {
			p.setLocation(p.getX() - Upleft.x, p.getY() - Upleft.y);
			((GroupObject) p).showport();
			((GroupObject) p).hideport();
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(10.0f));
		System.out.println(groupline);
		if (groupline != null) {
			System.out.println(groupline);
			g2d.draw(groupline);
		}
	}

	public void showport() {
		Catch = true;
		groupline = new Rectangle2D.Double(0, 0, getWidth(), getHeight());
		for(Component p : getComponents())
		{
			((GroupObject) p).showport();
		}
		repaint();
	}

	public void hideport() {
		Catch = false;
		groupline = null;
	}

	@Override
	public ArrayList<GroupObject> unGroup()
	{
		ArrayList<GroupObject> New = (ArrayList<GroupObject>) objects.clone();
		objects.clear();
		return New;
	}

	@Override
	public void addGroup(GroupObject g)
	{
		// TODO Auto-generated method stub
		objects.add(g);
	}


	
}
