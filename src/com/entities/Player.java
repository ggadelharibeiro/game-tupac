package com.entities;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;


public class Player {
	
	private Image imagem;
	private int x, y;
	private int dx, dy;
	private int altura, largura;
	private boolean facingLeft, facingRight;
	private int health;
	private List<Bullet> shoot;
	private boolean shootingRight;
	
	public Player() {
		this.x = 5;
		this.y = 250;
		this.health = 100;
		shoot = new ArrayList<Bullet>();
	}
	
	public void load() {
	ImageIcon img = new ImageIcon("res\\tupac_standing_right.png");
	this.imagem = img.getImage();
	this.setAltura(this.imagem.getHeight(null));
	this.setLargura(this.imagem.getWidth(null));
	}
	
	public void update() {
		this.x += dx;
		this.y += dy;
		
		if(isWalking() && facingRight == true) {
			ImageIcon img = new ImageIcon("res\\walking_right.gif");
			this.imagem = img.getImage();
		}
		
		else if(isStanding() && facingRight == true){
			ImageIcon img = new ImageIcon("res\\tupac_standing_right.png");
			this.imagem = img.getImage();
		}
		
		
		if(isWalking() && facingLeft == true) {
			ImageIcon img = new ImageIcon("res\\walking_left.gif");
			this.imagem = img.getImage();
		}
		
		else if(isStanding() && facingLeft == true){
			ImageIcon img = new ImageIcon("res\\tupac_standing_left.png");
			this.imagem = img.getImage();
		}
		

		
	}
	
	public void shootRight() {
		this.shoot.add(new Bullet(x+largura-15, y+(altura/5)));
	}
	
	public void shootLeft() {
		this.shoot.add(new Bullet((x-largura/4)+30, y+(altura/5)+2));
	}
	
	public void keyPressed(KeyEvent e) {
		int cod = e.getKeyCode();
		
		if(cod == KeyEvent.VK_D) {
			facingRight = true;
			facingLeft = false;
			
			if(this.x > 600) {
				this.x = 580;
			}			
			dx = 5;
		}
		
		if(cod == KeyEvent.VK_A) {
			facingRight = false;
			facingLeft = true;
			
			if(this.x < -5) {
				this.x = 0;
			}
			dx = -5;
			
		}
		
		if(cod == KeyEvent.VK_W) {
			if(this.y > 80) {
			dy = -5;			
			}
			else if (this.y >70 && this.y < 80) {
				dy = -2;
			}
			else if (this.y >50 && this.y < 70) {
				dy = -1;
			}
			else {
				this.y = 60;
			}
		}
		
		if(cod == KeyEvent.VK_S) {
			if(this.y < 290) {
			dy = -1;
			}
			else if(this.y < 300) {
			dy = -2;
			}
			if(this.y < 320) {
		    dy = +5;
			}
			else {
				this.y = 320;
			}
		}
		
		if(cod == KeyEvent.VK_SPACE) {
			if(facingRight) {
				this.shootRight();
				shootingRight = true;
			}
			else {
				this.shootLeft();
				shootingRight = false;
			}
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int cod = e.getKeyCode();
		
		if(cod == KeyEvent.VK_D) {
			if(this.x > 600) {
				this.x = 580;
			}	
			dx = 0;
		}
		
		if(cod == KeyEvent.VK_A) {
			if(this.x < -5) {
				this.x = 0;
			}
			
			dx = 0;
		}
		
		if(cod == KeyEvent.VK_W) {
			if(this.y <= 60) this.y = 60;
			dy = 0;
		}
		
		if(cod == KeyEvent.VK_S) {
			if(this.y >= 290) this.y = 320;
			dy = 0;
		}
	}

	
	public void setAltura(int h) {
		this.altura = h;
	}
	
	public int getAltura() {
		return this.altura;
	}
	
	public void setLargura(int l) {
		this.largura = l;
	}
	
	public int getLargura() {
		return largura;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	
	public Image getImage() {
		return this.imagem;
	}
	
	public boolean isWalking() {
		if(dx > 0) return true;
		else if(dx < 0) return true;
		else if(dy > 0) return true;
		else if(dy < 0) return true;
		else return false;
	}
	
	public boolean isStanding() {
		if(dx == 0 && dy == 0) return true;
		else return false;
	}
	
	public int getHealth() {
		return this.health;
	}
	
	public List<Bullet> getBullet(){
		return shoot;
	}
	
	public boolean facingRight() {
		return facingRight;
	}
	
	public boolean shootingRight() {
		return shootingRight;
	}
	
	public void receiveDmg(int x) {
		this.health -= x;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, largura, altura);
	}
	
	public boolean isDead() {
		if(this.health <= 0) {
			return true;	
		}
		else {
			return false;
		}
	}
}
