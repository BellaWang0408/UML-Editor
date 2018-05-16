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

import Scenarios.*;
import CanvasArea.Canvas;


public class UseCaseMode extends Mode
{
	private int mouseX;
	private int mouseY;
	
	/*public UseCaseMode()
	{
		setBackground(Color.WHITE);
		setIcon(new ImageIcon("image/useCase.png"));
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
						mouseX = e.getX();
						mouseY = e.getY();
						JComponent Usecase = new usecaseComponent();
						Usecase.setLocation(new Point(mouseX-Usecase.getWidth()/2,mouseY-Usecase.getHeight()/2));
						Canvas.canvaspanel.add(Usecase,0);
						Canvas.canvaspanel.repaint();
					}
				});
			}
		});
		setBounds(10, 445, 108, 77);
	}*/

	@Override
	public void mousePressed(MouseEvent e)
	{
		mouseX = e.getX();
		mouseY = e.getY();
		BasicObject Usecase = new usecaseComponent();
		Usecase.setLocation(new Point(mouseX-Usecase.getWidth()/2,mouseY-Usecase.getHeight()/2));
		Canvas.canvaspanel.add(Usecase,0);
		Canvas.canvaspanel.basic.add(Usecase);
		Canvas.canvaspanel.repaint();
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
