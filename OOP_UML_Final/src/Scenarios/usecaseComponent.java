package Scenarios;

import java.awt.Graphics;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JLabel;

public class usecaseComponent extends BasicObject{
	
	public usecaseComponent(){
		setSize(100,70);
		UseName = new JLabel("PlaceanOrder");
		UseName.setBounds(10, 0, 100, 100);
		add(UseName);
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		try{
			g.drawImage(ImageIO.read(new File("image/useCase.png")),0,-22,getWidth(),(int)(getHeight()*1.7),null);
		}
		catch(IOException e){
			e.printStackTrace();
		}	
	}

	@Override
	public ArrayList<GroupObject> unGroup()
	{
		// TODO Auto-generated method stub
		return null;
	}
}
