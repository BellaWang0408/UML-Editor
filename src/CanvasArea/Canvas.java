package CanvasArea;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JMenuItem;

import Mode.AssociationMode;
import Mode.ClassMode;
import Mode.CompositionMode;
import Mode.GeneralizationMode;
import Mode.Mode;
import Mode.SelectMode;
import Mode.UseCaseMode;
import Scenarios.*;
import Button.*;

import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;

public class Canvas {

	private JFrame frame;
	JButton selectButton;
	JButton associationButton;
	JButton generaButton;
	JButton compositionButton;
	JButton classButton;
	JButton usecaseButton;
	public static CanvasPanel canvaspanel = new CanvasPanel();
	public static JPanel modespanel = new JPanel();
	private JMenu mnEdit;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	private JMenuItem mntmNewMenuItem_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Canvas window = new Canvas();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Canvas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 913, 717);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		canvaspanel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				e.getX();
				e.getY();
			}
		});

		canvaspanel.setBackground(Color.WHITE);
		canvaspanel.setBounds(148, 31, 739, 637);
		frame.getContentPane().add(canvaspanel);
		canvaspanel.setLayout(null);

		modespanel.setBackground(Color.WHITE);
		modespanel.setBounds(10, 133, 128, 535);
		frame.getContentPane().add(modespanel);
		modespanel.setLayout(null);

		selectButton = new selectButton();
		modespanel.add(selectButton);

		associationButton = new associationlineButton();
		modespanel.add(associationButton);

		classButton = new classButton();
		modespanel.add(classButton);

		generaButton = new generalizationlineButton();
		modespanel.add(generaButton);

		compositionButton = new compositionlineButton();
		modespanel.add(compositionButton);

		usecaseButton = new usecaseButton();
		modespanel.add(usecaseButton);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 58, 21);
		frame.getContentPane().add(menuBar);

		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem);

		mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);

		mntmNewMenuItem_1 = new JMenuItem("Group")
		{
			{
				addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent arg0) 
					{
						/*while (Canvas.canvaspanel.getMouseListeners().length > 0) {
							Canvas.canvaspanel.removeMouseListener(Canvas.canvaspanel
									.getMouseListeners()[0]);// р场listeners
						}*/
						/*while (Canvas.canvaspanel.getMouseMotionListeners().length > 0) {
							Canvas.canvaspanel.removeMouseMotionListener(Canvas.canvaspanel
									.getMouseMotionListeners()[0]);// р场listeners
						}*/
						Composite group = new Composite();
						for (GroupObject p : Canvas.canvaspanel.basic) {
							//if (p instanceof GroupObject) {
								if (p.Catch == true) {
									p.Catch = false;
									group.add(p);
									group.addGroup(p);
								}
							//}
						}
						/*for (GroupObject p : Canvas.canvaspanel.composites) {
							//if (p instanceof GroupObject) {
								if (p.Catch == true) {
									p.Catch = false;
									//group.add(p);
									group.composites.add(p);
								}
							//}
						}*/
						for(Component p : group.getComponents())
						{
							Canvas.canvaspanel.basic.remove(p);
							//Canvas.canvaspanel.composites.remove(p);
							
						}
						Canvas.canvaspanel.add(group);
						Canvas.canvaspanel.basic.add(group);
						group.changesize();
						group.showport();
						System.out.println(group);
						Canvas.canvaspanel.repaint();
						
					}
				});
			}
		};
		mnEdit.add(mntmNewMenuItem_1);

		mntmNewMenuItem_2 = new JMenuItem("Un Group")
		{
			{
				addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						/*while (Canvas.canvaspanel.getMouseListeners().length > 0) {
							Canvas.canvaspanel.removeMouseListener(Canvas.canvaspanel
									.getMouseListeners()[0]);// р场listeners
						}
						while (Canvas.canvaspanel.getMouseMotionListeners().length > 0) {
							Canvas.canvaspanel.removeMouseMotionListener(Canvas.canvaspanel
									.getMouseMotionListeners()[0]);// р场listeners
						}*/
						ArrayList<GroupObject> test = new ArrayList<GroupObject>();
						ArrayList<GroupObject> test2 = new ArrayList<GroupObject>();
						
						for (GroupObject p : Canvas.canvaspanel.basic) {
						//	if (p instanceof GroupObject) {
								if (p.Catch == true) {
									p.Catch = false;
									p.still();
									ArrayList<GroupObject> components = p.unGroup();
									for(GroupObject com : components)
									{
										canvaspanel.add(com);
										com.Catch = false;
										test2.add(com);
									}
									test.add(p);
									//Canvas.canvaspanel.basic.remove(p);
									Canvas.canvaspanel.remove(p);
								}
							//}
						}
						for(GroupObject p : test)
						{
							Canvas.canvaspanel.basic.remove(p);
						}
						for(GroupObject p : test2)
						{
							Canvas.canvaspanel.basic.add(p);
						}
						/*for (Component p : Canvas.canvaspanel
								.getComponents()) {
							if (p instanceof Composite) {
								if (((GroupObject) p).Catch == true) {
									((GroupObject) p).Catch = false;
										((Composite) p).still();
									for(Component pq : ((Composite) p).getComponents())
									{
										canvaspanel.add(pq);
									}
								}
								Canvas.canvaspanel.remove(p);
								Canvas.canvaspanel.basic.remove(p);
							}
						}*/
						//Canvas.canvaspanel.remove(group);
						//group.setLocation(-100,-100);
						//group.changesize();
						//group.showport();
						//System.out.println(group);
						Canvas.canvaspanel.repaint();
					}
				});
			}
		};
		mnEdit.add(mntmNewMenuItem_2);

		mntmNewMenuItem_3 = new JMenuItem("Change Object Name")
		{
			{
				addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String name = JOptionPane.showInputDialog("Name:");
						if (name != null) {
							for (GroupObject p : Canvas.canvaspanel.basic) {
								//if (p instanceof BasicObject) {
									if (p.Catch == true) {
										p.UseName.setText(name);
									}
								//}
							}
						}
					}
				});
			}
		};
		mnEdit.add(mntmNewMenuItem_3);
	}
}
