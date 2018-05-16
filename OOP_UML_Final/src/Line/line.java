package Line;

import java.util.ArrayList;

import Scenarios.GroupObject;
import Scenarios.Port;

public class line extends GroupObject {
	Port startC,endC;
	public void setLine(Port a,Port b)
	{
		startC = a;
		endC = b;
	}
	@Override
	public void showport() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public ArrayList<GroupObject> unGroup()
	{
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void addGroup(GroupObject g)
	{
		// TODO Auto-generated method stub
		
	}
	
}