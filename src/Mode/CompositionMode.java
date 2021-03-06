package Mode;
import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;

import Line.*;
import Scenarios.BasicObject;
import Scenarios.GroupObject;
import Scenarios.Port;
import CanvasArea.Canvas;

public class CompositionMode extends Mode
{
	private GroupObject startC,endC;
	Port minport;
	Port endport;
	
	/*public CompositionMode(){
		setBackground(Color.WHITE);
		setIcon(new ImageIcon("image/composition.png"));
		setFocusPainted(false);
		addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				for(Component _p : Canvas.modespanel.getComponents())
				{
					JButton p = (JButton) _p;
					p.setBackground(Color.WHITE);
				}
				setBackground(Color.BLACK);
				while (Canvas.canvaspanel.getMouseListeners().length > 0) {
					Canvas.canvaspanel.removeMouseListener(Canvas.canvaspanel
							.getMouseListeners()[0]);// 把全部listeners
				}
				while (Canvas.canvaspanel.getMouseMotionListeners().length > 0) {
					Canvas.canvaspanel.removeMouseMotionListener(Canvas.canvaspanel
							.getMouseMotionListeners()[0]);// 把全部listeners
				}
				Canvas.canvaspanel.addMouseListener(new MouseAdapter()
				{
					@Override
					public void mousePressed(MouseEvent e)
					{
						for(Component p : Canvas.canvaspanel.getComponents())
						{
							if(p instanceof BasicObject)
							{
								if(e.getX()<p.getX()+p.getWidth()&&e.getX()>=p.getX()
								   &&e.getY()<p.getY()+p.getHeight()&&e.getY()>=p.getY())
								{
									startC = (JComponent)p;
									((BasicObject)startC).showport();
									int min = 1000000;
									if(distance(e,((BasicObject)startC).left) < min)
									{
										minport = ((BasicObject)startC).left;
										min = distance(e,((BasicObject)startC).left);
									}
									if(distance(e,((BasicObject)startC).right) < min)
									{
										minport = ((BasicObject)startC).right;
										min = distance(e,((BasicObject)startC).right);
									}
									if(distance(e,((BasicObject)startC).up) < min)
									{
										minport = ((BasicObject)startC).up;
										min = distance(e,((BasicObject)startC).up);
									}
									if(distance(e,((BasicObject)startC).down) < min)
									{
										minport = ((BasicObject)startC).down;
										min = distance(e,((BasicObject)startC).down);
									}
								}
							}
						}
					}
					private int distance(MouseEvent e, Port p)
					{
						int x = (e.getX()-p.getX())*(e.getX()-p.getX());
						int y = (e.getY()-p.getY())*(e.getY()-p.getY());
						// TODO Auto-generated method stub
						return x+y;
					}
					public void mouseReleased(MouseEvent e)
					{
						for(Component p : Canvas.canvaspanel.getComponents())
						{
							if(p instanceof BasicObject)
							{
								if(e.getX()<p.getX()+p.getWidth()&&e.getX()>=p.getX()
								   &&e.getY()<p.getY()+p.getHeight()&&e.getY()>=p.getY())
								{
									endC = (JComponent)p;
									int min = 1000000;
									((BasicObject)endC).showport();
									if(distance(e,((BasicObject)endC).left) < min)
									{
										endport = ((BasicObject)endC).left;
										min = distance(e,((BasicObject)endC).left);
									}
									if(distance(e,((BasicObject)endC).right) < min)
									{
										endport = ((BasicObject)endC).right;
										min = distance(e,((BasicObject)endC).right);
									}
									if(distance(e,((BasicObject)endC).up) < min)
									{
										endport = ((BasicObject)endC).up;
										min = distance(e,((BasicObject)endC).up);
									}
									if(distance(e,((BasicObject)endC).down) < min)
									{
										endport = ((BasicObject)endC).down;
										min = distance(e,((BasicObject)endC).down);
									}
									CompositionLine compositionline = new CompositionLine();
									((BasicObject)startC).showport();
									((BasicObject)endC).showport();
									compositionline.setLine(minport,endport);
									Canvas.canvaspanel.add(compositionline,0);
									Canvas.canvaspanel.repaint();
								}
							}
						}
					}
				});
			}
		});
		setBounds(10, 358, 108, 77);
	}*/

	@Override
	public void mousePressed(MouseEvent e)
	{
		for(GroupObject p : Canvas.canvaspanel.basic)
		{
			//if(p instanceof BasicObject)
			//{
				if(e.getX()<p.getX()+p.getWidth()&&e.getX()>=p.getX()
				   &&e.getY()<p.getY()+p.getHeight()&&e.getY()>=p.getY())
				{
					startC = p;
					startC.showport();
					int min = 1000000;
					if(distance(e,startC.left) < min)
					{
						minport = startC.left;
						min = distance(e,startC.left);
					}
					if(distance(e,startC.right) < min)
					{
						minport = startC.right;
						min = distance(e,startC.right);
					}
					if(distance(e,startC.up) < min)
					{
						minport = startC.up;
						min = distance(e,startC.up);
					}
					if(distance(e,startC.down) < min)
					{
						minport = startC.down;
						min = distance(e,startC.down);
					}
				}
			}
		}
	private int distance(MouseEvent e, Port p)
	{
		int x = (e.getX()-p.getX())*(e.getX()-p.getX());
		int y = (e.getY()-p.getY())*(e.getY()-p.getY());
		// TODO Auto-generated method stub
		return x+y;
	}
	@Override
	public void mouseReleased(MouseEvent e)
	{
		for(GroupObject p : Canvas.canvaspanel.basic)
		{
			//if(p instanceof BasicObject)
			//{
				if(e.getX()<p.getX()+p.getWidth()&&e.getX()>=p.getX()
				   &&e.getY()<p.getY()+p.getHeight()&&e.getY()>=p.getY())
				{
					endC = p;
					int min = 1000000;
					endC.showport();
					if(distance(e,endC.left) < min)
					{
						endport = endC.left;
						min = distance(e,endC.left);
					}
					if(distance(e,endC.right) < min)
					{
						endport = endC.right;
						min = distance(e,endC.right);
					}
					if(distance(e,endC.up) < min)
					{
						endport = endC.up;
						min = distance(e,endC.up);
					}
					if(distance(e,endC.down) < min)
					{
						endport = endC.down;
						min = distance(e,endC.down);
					}
					CompositionLine compositionline = new CompositionLine();
					startC.showport();
					endC.showport();
					compositionline.setLine(minport,endport);
					Canvas.canvaspanel.add(compositionline,0);
					Canvas.canvaspanel.lines.add(compositionline);
					Canvas.canvaspanel.repaint();
				}
			}
		}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
