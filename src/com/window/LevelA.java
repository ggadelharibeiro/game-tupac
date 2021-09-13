package com.window;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.entities.Bullet;
import com.entities.Eye;
import com.entities.Player;
import com.gui.Health;

public class LevelA extends JPanel implements ActionListener, Runnable{

	private static final long serialVersionUID = 1L;

	private Image background;
	private Player player;
	private Eye eye;
	private Timer timer;
	private Health hp;
	
	public LevelA() {
		
		this.setFocusable(true);
		this.setDoubleBuffered(true);
		
		ImageIcon img = new ImageIcon("res\\background.gif");
		this.background = img.getImage();
		
		eye = new Eye();
		player = new Player();
		hp = new Health(player.getHealth());
		player.load();
		eye.load();
		hp.load();
		
		
		addKeyListener(new TcAdapter());
		
		timer = new Timer(1, this);
		timer.start();
		
	}
	
	public void paint(Graphics g) {
		Graphics2D grafico = (Graphics2D) g;
		grafico.drawImage(background, 0, 0, null);
		grafico.drawImage(player.getImage(), player.getX(), player.getY(), this);
		grafico.drawImage(eye.getImage(), eye.getX(), eye.getY(), this);
		grafico.drawImage(hp.getImage(), hp.getX(), hp.getY(), this);
		
		List<Bullet> tiros = player.getBullet();
		for(int i = 0; i < tiros.size(); i++) {
			Bullet m = tiros.get(i);
			m.load();
			grafico.drawImage(m.getImg(), m.getX(), m.getY(), this);
		}
		
		g.dispose();
	}
	
	
	
	
	public class TcAdapter extends KeyAdapter{
		
		public void keyPressed(KeyEvent e) {
			player.keyPressed(e);
		}
		
		public void keyReleased(KeyEvent e) {
			player.keyReleased(e);
		}
		
	}
	
	public void checarColisao() {
		Rectangle recPlayer = player.getBounds();
		Rectangle recEye = eye.getBounds();
		
		List<Bullet> tiros = player.getBullet();
		for( int i = 0; i < tiros.size(); i++) {
			Bullet tempBullet = tiros.get(i);
			if(tempBullet.getBounds() == recEye) {
				eye.receiveDmg(2);
			}
		}
		
		if(recEye == recPlayer) {
			player.receiveDmg(1);
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		player.update();
		eye.getPlayerPos(player.getX(), player.getY());
		eye.update();
		hp.setHP(player.getHealth());
		hp.update();
		hp.showHealth();
		this.checarColisao();
		System.out.println(eye.getHP());
		
		
		
		if(player.shootingRight()) {
		List<Bullet> tiros = player.getBullet();
		for(int i = 0; i<tiros.size(); i++) {
			Bullet m = tiros.get(i);
			m.setFacingRight(true);
			
				if(m.isVisible()) {
					m.update();
				}else {
					tiros.remove(i);
				}
			}
		}
		
		if(!player.shootingRight()) {
		List<Bullet> tiros1 = player.getBullet();
		for(int i = 0; i<tiros1.size(); i++) {
			Bullet m = tiros1.get(i);
			m.setFacingRight(true);
				if(m.isVisible()) {
					m.update2();
				}else {
					tiros1.remove(i);
				}
		}
		}
		
		
		repaint();
		
		}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
	

