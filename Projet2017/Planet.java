package simpleUIApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class Planet extends Item implements java.io.Serializable {
	public void setSpaceShips(ArrayList<SpaceShip> spaceShips) {
		this.spaceShips = spaceShips;
	}
	private static final long serialVersionUID = -2325653399861863486L;
	private static int prodRate = 5;
	private int nbShips = 5;
	private int maxShips = 20;
	private ArrayList<SpaceShip> spaceShips;
	private Color myColor;
	private int ownerId;
	
	public Planet(double x, double y, int w, Color myColor, int ownerId) {
		super(x, y, w);
		this.myColor = myColor;
		this.ownerId = ownerId;
	}
	
	public ArrayList<SpaceShip> getSpaceShips() {
		return spaceShips;
	}
	
	@Override
	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public Color getMyColor() {
		return myColor;
	}

	public void setMyColor(Color myColor) {
		this.myColor = myColor;
	}

	public static int getProdRate() {
		return prodRate;
	}

	@Override
	public boolean contains(Point2D p) {
        double w = getWidth() / 2;
        return (this.center.getX() - w <= p.getX() && p.getX() <= this.center.getX() + w)
                && (this.center.getY() - w <= p.getY() && p.getY() <= this.center.getY() + w);
    }
	
	@Override
	public void draw(Graphics2D arg0) {
		Point2D pos = this.center;
		int x = (int) pos.getX(), y = (int) pos.getY(), w = this.getWidth();
		arg0.setColor(myColor);
		arg0.fillRect(x - w / 2, y - w / 2, w, w);
		arg0.setColor(Color.WHITE);
		arg0.drawString(String.valueOf(this.spaceShips.size()),((int)x),((int)y));
	}
	
	public void init(){
		spaceShips = new ArrayList<SpaceShip>();
		for (int i = 0; i < nbShips; i++) {
			SpaceShip mySpaceShip = new SpaceShip(center.getX() + this.getWidth()/2 - (i+1)*12, center.getY() + this.getWidth()/2 + 6, 10, ownerId, this);
			spaceShips.add(mySpaceShip);
			Game.getItemList().add(mySpaceShip);
		}
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
	}

	@Override
	public void setObjective(Item o) {
		// TODO Auto-generated method stub
		
	}
	
	public void produceShips(){
		ReentrantLock lock = new ReentrantLock();
		
		if(spaceShips.size() < maxShips){
			SpaceShip mySpaceShip = new SpaceShip(center.getX(), center.getY()+20, 10, ownerId, Planet.this);
			spaceShips.add(mySpaceShip);
			lock.lock();
			try {
		        Game.getItemList().add(mySpaceShip);
		    } catch (Exception e) {
		    	e.printStackTrace();
		    }
			finally {
		        lock.unlock();
		    }
		}
		/*Thread t = new Thread(new produceShipThread());
		t.start();*/
	}
	/*
	private class produceShipThread implements Runnable{
		
		public void run() {
			while(true){
				if(spaceShips.size() < maxShips){
					try {
						Thread.sleep(prodRate*2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
							}
					SpaceShip mySpaceShip = new SpaceShip(center.getX(), center.getY()+20, 10, ownerId, Planet.this);
					spaceShips.add(mySpaceShip);
					lock.lock();
					try {
				        ItemList.add(mySpaceShip);
				    } catch (Exception e) {
				    	e.printStackTrace();
				    }
					finally {
				        lock.unlock();
				    }
				}
			}
		}
		
	}
	*/
	public void got_attacked(int id, int attackPower){
		
	}
}
