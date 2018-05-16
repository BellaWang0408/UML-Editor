package Mode;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

import javax.swing.*;

import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;

import Line.AssociationLine;
import Scenarios.*;
import Scenarios.Composite;
import CanvasArea.Canvas;

public class SelectMode extends Mode {
	private int mouseX;
	private Point Upleft, temp;

	private Point Rightdown;
	private GroupObject current = null;
	private int mouseY;
	Shape rect = null;

	/*public SelectMode() {
		setBackground(Color.WHITE);
		setIcon(new ImageIcon("image/select.png"));
		setFocusPainted(false);
		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (Component _p : Canvas.modespanel.getComponents()) {
					JButton p = (JButton) _p;
					p.setBackground(Color.WHITE);
					//rect=null;
				}
				setBackground(Color.BLACK);
				while (Canvas.canvaspanel.getMouseListeners().length > 0) {
					Canvas.canvaspanel.removeMouseListener(Canvas.canvaspanel
							.getMouseListeners()[0]);// 把全部listeners
				}
				while (Canvas.canvaspanel.getMouseMotionListeners().length > 0) {
					Canvas.canvaspanel
							.removeMouseMotionListener(Canvas.canvaspanel
									.getMouseMotionListeners()[0]);// 把全部listeners
				}
				Canvas.canvaspanel.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						
						for (Component p : Canvas.canvaspanel.getComponents()) {
							if (p instanceof GroupObject) {
								((GroupObject) p).hideport();
							}
						}
						boolean flag = true;
						for (Component p : Canvas.canvaspanel.getComponents()) {
							if (p instanceof GroupObject) {
								if (e.getX() < p.getX() + p.getWidth()
										&& e.getX() >= p.getX()
										&& e.getY() < p.getY() + p.getHeight()
										&& e.getY() >= p.getY()) {
									current = (JComponent) p;
									((GroupObject) current).showport();
									flag = false;
								}
							}
						}
						if(flag)
						{
							Upleft = temp = e.getPoint();
						}
					}

					public void mouseReleased(MouseEvent e) {
						rect = null;
						Upleft = null;
						temp = null;
						Rightdown = null;
						Canvas.canvaspanel.changeshape(rect);
						current = null;
					}
				});
				Canvas.canvaspanel.addMouseMotionListener(new MouseAdapter() {
					@Override
					public void mouseDragged(MouseEvent e) {
					if (Upleft != null) {
						Rightdown = e.getPoint();
						double a = temp.x;
						double b = temp.y;
						double c = Rightdown.x;
						double d = Rightdown.y;
						Upleft = new Point((int) Math.min(a, c), (int) Math
								.min(b, d));
						Rightdown = new Point((int) Math.max(a, c), (int) Math
								.max(b, d));
							rect = new Rectangle2D.Double(Upleft.x, Upleft.y,
									Rightdown.x - Upleft.x, Rightdown.y
											- Upleft.y);
							Canvas.canvaspanel.changeshape(rect);
							for (Component p : Canvas.canvaspanel
									.getComponents()) {
								if (p instanceof GroupObject) {
									if (Upleft.x <= p.getX()
											&& Upleft.y <= p.getY()
											&& p.getX() + p.getWidth() <= Rightdown.x
											&& p.getY() + p.getHeight() <= Rightdown.y) {
										// current = (JComponent)p;
										if (p instanceof GroupObject) {
											((GroupObject) p).showport();
										}
									}
								}
							}
						}
						if (current != null) {
							current.setLocation(new Point(e.getX(), e.getY()));
							System.out.println("SDFSDF");
							((GroupObject) current).showport();
							if(current instanceof Composite)
							{
								for(Component p : current.getComponents())
								{
									((GroupObject) p).showport();
								}
							}
							Canvas.canvaspanel.repaint();
						}
					}
				});
			}
		});
		setBounds(10, 10, 108, 77);
	}*/

	@Override
	public void mousePressed(MouseEvent e) {
		
		for (GroupObject p : Canvas.canvaspanel.basic) {
			//if (p instanceof GroupObject) {
				 p.hideport();
			//}
		}
		boolean flag = true;
		for (GroupObject p : Canvas.canvaspanel.basic) {
			//if (p instanceof GroupObject) {
				if (e.getX() < p.getX() + p.getWidth()
						&& e.getX() >= p.getX()
						&& e.getY() < p.getY() + p.getHeight()
						&& e.getY() >= p.getY()) {
					current = p;
					current.showport();
					flag = false;
				}
			//}
		}
		if(flag)
		{
			Upleft = temp = e.getPoint();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		rect = null;
		Upleft = null;
		temp = null;
		Rightdown = null;
		Canvas.canvaspanel.changeshape(rect);
		current = null;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (Upleft != null) {
			Rightdown = e.getPoint();
			double a = temp.x;
			double b = temp.y;
			double c = Rightdown.x;
			double d = Rightdown.y;
			Upleft = new Point((int) Math.min(a, c), (int) Math
					.min(b, d));
			Rightdown = new Point((int) Math.max(a, c), (int) Math
					.max(b, d));
				rect = new Rectangle2D.Double(Upleft.x, Upleft.y,
						Rightdown.x - Upleft.x, Rightdown.y
								- Upleft.y);
				Canvas.canvaspanel.changeshape(rect);
				for (GroupObject p : Canvas.canvaspanel.basic) {
					//if (p instanceof GroupObject) {
						if (Upleft.x <= p.getX()
								&& Upleft.y <= p.getY()
								&& p.getX() + p.getWidth() <= Rightdown.x
								&& p.getY() + p.getHeight() <= Rightdown.y) {
							// current = (JComponent)p;
							//if (p instanceof GroupObject) {
								p.showport();
							//}
						}
					//}
				}
			}
			if (current != null) {
				current.setLocation(new Point(e.getX(), e.getY()));
				current.showport();
				if(current.objects.size() > 0)
				{
					for(GroupObject p : current.objects)
					//for(Component p : current.getComponents())
					{
						p.showport();
					}
				}
				Canvas.canvaspanel.repaint();
			}
		}
}
