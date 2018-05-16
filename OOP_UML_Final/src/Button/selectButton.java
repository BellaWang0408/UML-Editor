package Button;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import CanvasArea.Canvas;
import Mode.ClassMode;
import Mode.SelectMode;

public class selectButton extends JButton{
	
	public selectButton(){
		setBackground(Color.WHITE);
		setIcon(new ImageIcon("image/select.png"));
		setFocusPainted(false);
		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (Component _p : Canvas.modespanel.getComponents()) {
					JButton p = (JButton) _p;
					p.setBackground(Color.WHITE);
					//rect=null;
				}
				Canvas.canvaspanel.mode = new SelectMode();
				setBackground(Color.BLACK);
			}
		});
		setBounds(10, 10, 108, 77);
	}
}
