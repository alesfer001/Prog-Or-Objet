package vehicle;
public class Bus extends Vehicle {

	public Bus(String name, int passengers, int speed, int kmCost) {
		this.name = name;
		this.passengers = passengers;
		this.speed = speed;
		this.kmCost = kmCost;
	}

	public String toString() {
		return "Bus " + name + " - nb passengers:" + passengers + " - speed:" + speed + " km/h - cost:" + kmCost + " euros/km";
	}

	
}
