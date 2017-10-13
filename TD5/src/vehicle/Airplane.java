package vehicle;

import journey.City;

public class Airplane extends Vehicle {
	private int extratime;
	
	public Airplane(String name, int passengers, int speed, int extratime, int kmCost) {
		this.name = name;
		this.passengers = passengers;
		this.speed = speed;
		this.kmCost = kmCost;
		this.extratime = extratime;
	}
	
	public int getExtratime() {
		return extratime;
	}

	public int nbJourneyPerDay(int distance) {
		float time = (distance / speed) + extratime;
		return (int) (24 / time);
	}
	
	public boolean compatibleWitch(City c) {
		return c.isAirport();
	}
	
	public boolean equals(Airplane myVehicle) {
		return name == myVehicle.getName() && passengers == myVehicle.getPassengers() && speed == myVehicle.getSpeed() && kmCost == myVehicle.getKmCost() && extratime == myVehicle.getExtratime();
	}
	
	public String toString() {
		return "Airplane " + name + " - nb passengers:" + passengers + " - speed:" + speed + " km/h - cost:" + kmCost + " euros/km - extraTime:" + extratime + " h";
	}
}
