package com.gui;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Health {
	
	private int x,y;
	private int hp;
	private Image img;
	
	public Health(int hp) {
		this.hp = hp;
		this.x = 0;
		this.y = 421;
	}
	
	public void load() {		
		ImageIcon i = new ImageIcon("res\\hp_bar.png");
		img = i.getImage();
	}
	
	public void update() {
		//hp 100
		if(hp > 90 && hp <= 100) {
		ImageIcon i = new ImageIcon("res\\hp_bar.png");
		img = i.getImage();
		}
		
		//hp 90
		else if(hp > 80 && hp <= 90) {
			ImageIcon i = new ImageIcon("res_hp\\hp_bar90.png");
			img = i.getImage();
		}
		
		//hp 80
		else if(hp > 70 && hp <= 80) {
			ImageIcon i = new ImageIcon("res_hp\\hp_bar80.png");
			img = i.getImage();
		}
		
		//hp 70
		else if(hp > 60 && hp <= 70) {
			ImageIcon i = new ImageIcon("res_hp\\hp_bar70.png");
			img = i.getImage();
		}
		
		else if(hp > 50 && hp <= 60) {
			ImageIcon i = new ImageIcon("res_hp\\hp_bar60.png");
			img = i.getImage();
		}
		
		else if(hp > 40 && hp <= 50) {
			ImageIcon i = new ImageIcon("res_hp\\hp_bar50.png");
			img = i.getImage();
		}
		
		else if(hp > 30 && hp <= 40) {
			ImageIcon i = new ImageIcon("res_hp\\hp_bar40.png");
			img = i.getImage();
		}
		
		else if(hp > 20 && hp <= 30) {
			ImageIcon i = new ImageIcon("res_hp\\hp_bar30.png");
			img = i.getImage();
		}
		
		else if(hp > 10 && hp <= 20) {
			ImageIcon i = new ImageIcon("res_hp\\hp_bar20.png");
			img = i.getImage();
		}
		
		else if(hp > 0 && hp <= 10) {
			ImageIcon i = new ImageIcon("res_hp\\hp_bar10.png");
			img = i.getImage();
		}
		
		else {
			ImageIcon i = new ImageIcon("res_hp\\hp_bar_gameover.png");
			img = i.getImage();
		}
	}


	public int getX() {
		return x;
	}


	public int getY() {
		return y;
	}
	
	public int getHP() {
		return hp;
	}
	
	public void setHP(int hp) {
		this.hp = hp;
	}
	
	public void showHealth() {
			System.out.println("hp: "+this.hp);		
	}
	
	public Image getImage() {
		return img;
	}
}
