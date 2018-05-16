package Button;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import CanvasArea.Canvas;
import Mode.ClassMode;
import Mode.CompositionMode;

public class compositionlineButton extends JButton {
	
	public compositionlineButton()
	{
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
				Canvas.canvaspanel.mode = new CompositionMode();
				setBackground(Color.BLACK);
			}
		});
		setBounds(10, 271, 108, 77);
	}
}
