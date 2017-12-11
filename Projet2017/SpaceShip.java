package simpleUIApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

class SpaceShip extends Item implements java.io.Serializable{

	private Item objective;
	private int speed = 1;
	private int prod_time = 1;
	private int power = 1;
	private int ownerId;
	private Planet origin;

	public SpaceShip(double x, double y, int w, int ownerId, Planet origin) {
		super(x, y, w);
		objective = this;
		this.ownerId = ownerId;
		this.origin = origin;
	}

	public void setObjective(Item o) {
		this.objective = o;
	}
	
	public Item getObjective() {
		return objective;
	}
/*
	private static double squareDistance(Point2D p1, Point2D p2) {
		double dx = p1.getX() - p2.getX();
		double dy = p1.getY() - p2.getY();
		return dx * dx + dy * dy;
	}
*/
	@Override
	public boolean contains(Point2D p) {
        double w = getWidth() / 2;
        return (this.center.getX() - w <= p.getX() && p.getX() <= this.center.getX() + w)
                && (this.center.getY() - w <= p.getY() && p.getY() <= this.center.getY() + w);
    }

	public void move() {
		if(ownerId != -1){
			if (!objective.contains(this.center)) {
				double newx = center.getX();
				double newy = center.getY();
				if (newx > objective.getLocation().getX()) {
					newx--;
				} else {
					newx++;
				}
				if (newy > objective.getLocation().getY()) {
					newy--;
				} else {
					newy++;
				}
				center.setLocation(newx, newy);
			} else {
				if(objective.getClass().getName() == (Planet.class.getName())){
					if(objective.getOwnerId() == ownerId){
						troopMovement();
					}
					else{
						troopAttack();
					}
				}			
				objective = this;
			}
		}
	}

	@Override
	public void draw(Graphics2D arg0) {
		Point2D pos = this.center;
		int x = (int) pos.getX(), y = (int) pos.getY(), w = this.getWidth();
		arg0.setColor(Color.blue);
		arg0.fillRect(x - w / 2, y - w / 2, w, w);
	}
	
	public void troopMovement(){
		((Planet) objective).getSpaceShips().add(this);
		origin.getSpaceShips().remove(this);
	}
	
	public synchronized void troopAttack(){
		Planet planetAttacked = ((Planet) objective);
		if(planetAttacked.getSpaceShips().size() == 0){
			planetAttacked.setOwnerId(ownerId);
			planetAttacked.setMyColor(origin.getMyColor());
		}
		else{
			origin.getSpaceShips().remove(this);
			SpaceShip objectiveSpaceShip = planetAttacked.getSpaceShips().get(0);
			if(objectiveSpaceShip.getObjective() != objectiveSpaceShip){
				int i=0;
				do{
					objectiveSpaceShip = planetAttacked.getSpaceShips().get(i);
					i++;
				}while(objectiveSpaceShip.getObjective() != objectiveSpaceShip && i<planetAttacked.getSpaceShips().size());
			}
			if(objectiveSpaceShip.getObjective() != objectiveSpaceShip){
				planetAttacked.setOwnerId(ownerId);
				planetAttacked.setMyColor(origin.getMyColor());
			}
			planetAttacked.getSpaceShips().remove(objectiveSpaceShip);
			CopyOnWriteArrayList<Item> ItemList = Game.getItemList();
			ItemList.remove(objectiveSpaceShip);
			ItemList.remove(this);
		}
		
	}

	
}
