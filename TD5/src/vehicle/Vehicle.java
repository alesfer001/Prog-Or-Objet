package vehicle;

import journey.City;

public abstract class Vehicle {
	protected String name;
	protected int passengers, speed, kmCost;

	public String getName() {
		return name;
	}

	public int getPassengers() {
		return passengers;
	}

	public int getSpeed() {
		return speed;
	}

	public int getKmCost() {
		return kmCost;
	}

	public int nbJourneyPerDay(int distance) {
		float time = distance / speed;
		return (int) (24 / time);
	}
	
	public boolean compatibleWitch(City c) {
		return true;
	}
	
	public boolean equals(Vehicle myVehicle) {
		return name == myVehicle.getName() && passengers == myVehicle.getPassengers() && speed == myVehicle.getSpeed() && kmCost == myVehicle.getKmCost();
	}
}
