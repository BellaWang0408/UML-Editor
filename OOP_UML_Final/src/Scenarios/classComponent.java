package Scenarios;

import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JLabel;

public class classComponent extends BasicObject{
	
	public classComponent(){
		setSize(100,100);
		UseName = new JLabel("Order");
		UseName.setBounds(30, 0, 100, 40);
		add(UseName);
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		try{
			g.drawImage(ImageIO.read(new File("image/class.png")),0,0,getWidth(),getHeight(),null);
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
