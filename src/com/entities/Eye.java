package com.entities;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Eye {

	private int x, y;
	private int dx, dy;
	private Image img;
	private int altura, largura;
	private int p_x, p_y;
	private boolean facingLeft, facingRight;
	private int dmg = 5;
	private int hp;
	private int bullet_x, bullet_y;

	
	public Eye() {
		this.x = 500;
		this.y = 250;	
	}
	
	public void load() {
		ImageIcon i = new ImageIcon("res\\eye_f_left.gif");
		this.hp = 200;
		this.img = i.getImage();
		this.setAltura(this.img.getHeight(null));
		this.setLargura(this.img.getWidth(null));
	}
	
	public void update() {	
		
		this.chasePlayer();
		this.x += dx;
		this.y += dy;
		
		if(x == bullet_x && y == bullet_y) {
		this.receiveDmg(dmg);
		System.out.println(this.hp);
		} 
		
		if(facingRight) {
			ImageIcon i = new ImageIcon("res\\eye_f_right.gif");
			this.img = i.getImage();
		}
		
		else if(facingLeft) {
			ImageIcon i = new ImageIcon("res\\eye_f_left.gif");
			this.img = i.getImage();
		}
		
		
		
	}
	
	
	public void chasePlayer() {
		if(this.x < p_x && this.y == p_y) {
			dx = 1;
			dy = 0;
			this.facingRight = true;
			this.facingLeft = false;
		}
		
		else if(this.x > p_x && this.y == p_y) {
			dx = -1;
			dy = 0;
			this.facingLeft = true;
			this.facingRight = false;
		}
		
		else if(this.y < p_y && this.x == p_x) {
			dy = 1;
			dx = 0;
		}
		
		else if(this.y > p_y && this.x == p_x) {
			dy = -1;
			dx = 0;
		}	
		
		else if(this.x < p_x && y < p_y) {
			dy = 1;
			dx = 1;
			this.facingLeft = false;
			this.facingRight = true;
		}
		
		else if(this.x > p_x && y > p_y) {
			dy = -1;
			dx = -1;
			this.facingLeft = true;
			this.facingRight = false;
		}
		
		else if(this.x > p_x && y < p_y) {
			dy = 1;
			dx = -1;
			this.facingLeft = true;
			this.facingRight = false;
		}
		
		else if(this.x < p_x && y > p_y) {
			dy = -1;
			dx = 1;
			this.facingLeft = false;
			this.facingRight = true;
		}
		
		else {
			dx = 0;
			dy = 0;
		}
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public int getLargura() {
		return largura;
	}

	public void setLargura(int largura) {
		this.largura = largura;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public Image getImage() {
		return img;
	}
	
	public int getHP() {
		return this.hp;
	}
	
	public void getPlayerPos(int x, int y) {
		this.p_x = x;
		this.p_y = y;	
	}
	
	public int getDamage() {
		if(this.p_x == this.x && this.p_y == this.y) {
			return dmg;
		}
		else return 0;
	}
	
	public void receiveDmg(int dmg) {
		this.hp = this.hp - dmg;
	}

	public void getBulletPos(int x, int y) {
		this.bullet_x = x;
		this.bullet_y = y;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, largura, altura);
	}
}
