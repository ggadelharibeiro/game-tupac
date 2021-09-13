package com.window;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Container extends JFrame {

	private static final long serialVersionUID = -483406587086335023L;
	
	public Container() {
		
		ImageIcon x = new ImageIcon("res\\icon.png");
		
		this.add(new LevelA());
		this.setSize(640, 480);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("$ All EyeZ ON ME $");
		this.setIconImage(x.getImage());
		
		
	}
	
	
}
