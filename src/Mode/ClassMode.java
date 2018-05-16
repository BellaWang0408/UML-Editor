package Mode;

import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;

import CanvasArea.*;
import Scenarios.*;

public class ClassMode extends Mode
{
	private int mouseX;
	private int mouseY;
	
	/*public ClassMode(){
		setBackground(Color.WHITE);
		setIcon(new ImageIcon("image/class.png"));
		addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			for(Component _p : Canvas.modespanel.getComponents())
			{
				JButton p = (JButton) _p;
				p.setBackground(Color.WHITE);
			}
			setBackground(Color.BLACK);
			while (Canvas.canvaspanel.getMouseListeners().length > 0) {
				Canvas.canvaspanel.removeMouseListener(Canvas.canvaspanel
						.getMouseListeners()[0]);// �����listeners
			}
			while (Canvas.canvaspanel.getMouseMotionListeners().length > 0) {
				Canvas.canvaspanel.removeMouseMotionListener(Canvas.canvaspanel
						.getMouseMotionListeners()[0]);// �����listeners
			}
			Canvas.canvaspanel.addMouseListener(new MouseAdapter()
			{
				@Override
				public void mousePressed(MouseEvent e)//������canvas
				{
					mouseX = e.getX();
					mouseY = e.getY();
					JComponent Class = new classComponent();
					Class.setLocation(new Point(mouseX-Class.getWidth()/2,mouseY-Class.getHeight()/2));//�ƹ��y��
					Canvas.canvaspanel.add(Class,0);
					Canvas.canvaspanel.repaint();//�A�]�@��paintComponent
				}
			});
		}});
	setBounds(10, 358, 108, 77);
	}*/

	@Override
	public void mousePressed(MouseEvent e)//������canvas
	{
		mouseX = e.getX();
		mouseY = e.getY();
		BasicObject Class = new classComponent();
		Class.setLocation(new Point(mouseX-Class.getWidth()/2,mouseY-Class.getHeight()/2));//�ƹ��y��
		Canvas.canvaspanel.add(Class,0);
		Canvas.canvaspanel.basic.add(Class);
		Canvas.canvaspanel.repaint();//�A�]�@��paintComponent
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
