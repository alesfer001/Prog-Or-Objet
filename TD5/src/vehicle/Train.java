package vehicle;

import journey.City;

public class Train extends Vehicle {
	
	public Train (String name, int passengers, int speed, int kmCost) {
		this.name = name;
		this.passengers = passengers;
		this.speed = speed;
		this.kmCost = kmCost;
	}
	
	public boolean compatibleWitch(City c) {
		return c.isGare();
	}

	public String toString() {
		return "Train " + name + " - nb passengers:" + passengers + " - speed:" + speed + " km/h - cost:" + kmCost + " euros/km";
	}
	
	
}
