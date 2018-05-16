package Mode;

import java.awt.event.MouseEvent;

public abstract class Mode
{
	public abstract void mousePressed(MouseEvent e);
	public abstract void mouseReleased(MouseEvent e);
	public abstract void mouseDragged(MouseEvent e);
}
