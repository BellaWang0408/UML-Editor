package Button;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import CanvasArea.Canvas;
import Mode.AssociationMode;
import Mode.ClassMode;

public class associationlineButton extends JButton{
	
	public associationlineButton()
	{
		setBackground(Color.WHITE);
		setIcon(new ImageIcon("image/assocation.png"));
		setFocusPainted(false);
		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(Component _p : Canvas.modespanel.getComponents())
				{
					JButton p = (JButton) _p;
					p.setBackground(Color.WHITE);
				}
				Canvas.canvaspanel.mode = new AssociationMode();
				setBackground(Color.BLACK);
			}
		});
		setBounds(10, 97, 108, 77);
	}
}
