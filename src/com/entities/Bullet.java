package com.entities;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Bullet {
	
	private int x,y;
	private Image img;
	private int altura, largura;
	private boolean isVisible;
	private boolean facingRight;
	
	private final static int DAMAGE = 5;
	private final static int LARGURA = 600;
	private static int VELOCIDADE = 10;
	private static int VELOCIDADE2 = -10;
	
	
	public Bullet(int x, int y) {
		this.x = x;
		this.y = y;
		this.isVisible = true;
	}
	
	public void load() {
		ImageIcon i = new ImageIcon("res\\bullet.png");
		img = i.getImage();
		
		this.largura = img.getWidth(null);
		this.altura = img.getHeight(null);			
	}
	
	public void update() {
		this.x += VELOCIDADE;


		if(this.x > LARGURA) {
			isVisible = false;
		}
		
		else if(this.x < 0) {
			isVisible=false;
		}
		
	}
	
	public void update2() {
		this.x += VELOCIDADE2;


		if(this.x > LARGURA) {
			isVisible = false;
		}
		
		else if(this.x < 0) {
			isVisible=false;
		}
		
		
		
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Image getImg() {
		return img;
	}

	public int getAltura() {
		return altura;
	}

	public int getLargura() {
		return largura;
	}

	public boolean isVisible() {
		return isVisible;
	}

	public boolean isFacingRight() {
		return facingRight;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public void setLargura(int largura) {
		this.largura = largura;
	}
	
	public void setFacingRight(boolean f) {
		this.facingRight = f;
	}
	
	public int getDamage() {
		return DAMAGE;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, largura, altura);
	}
	
}
