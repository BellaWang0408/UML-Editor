package CanvasArea;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JPanel;

import Line.line;
import Mode.Mode;
import Scenarios.BasicObject;
import Scenarios.Composite;
import Scenarios.GroupObject;
import Scenarios.classComponent;

public class CanvasPanel extends JPanel {
	Shape lineshape = null;
	public ArrayList<line> lines = new ArrayList<line>();
	public ArrayList<GroupObject> basic = new ArrayList<GroupObject>();
	//public ArrayList<GroupObject> composites = new ArrayList<GroupObject>();
	public Mode mode;
	public void changeshape(Shape change) {
		lineshape = change;
		repaint();
	}
	public CanvasPanel(){
		addMouseListener(new MouseAdapter()
		{
			@Override
			public void mousePressed(MouseEvent e)//元件放到canvas
			{
				mode.mousePressed(e);
			}
			public void mouseReleased(MouseEvent e)
			{
				mode.mouseReleased(e);
			}
		});
		addMouseMotionListener(new MouseAdapter()
		{
			public void mouseDragged(MouseEvent e)
			{
				mode.mouseDragged(e);
			}
		});
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		if (lineshape != null) {
			g2d.draw(lineshape);

		}
	}
}
