package Scenarios;

import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JLabel;

public abstract class GroupObject extends JComponent{
	public JLabel UseName;
	public Boolean Catch;
	public Port right,left,up,down;
	//public ArrayList<GroupObject> composites = new ArrayList<GroupObject>();
	//public ArrayList<GroupObject> basic = new ArrayList<GroupObject>();
	public ArrayList<GroupObject> objects = new ArrayList<GroupObject>();
	public abstract void showport();
	public void hideport()
	{
	}
	public void still() {
		for (Component p : getComponents()) {
			//if(p instanceof GroupObject)
			//{
			((GroupObject) p).hideport();
			p.setLocation(p.getX() + getX(), p.getY() + getY());
			//}
		}
	}

	public abstract void addGroup(GroupObject g);
	public abstract ArrayList<GroupObject> unGroup();
}
