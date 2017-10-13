package journey;
import vehicle.Vehicle;

public class Journey {
	private City city1, city2;
	private int distance, passengerTicket;
	private Vehicle[] vehicles = new Vehicle[100];
	private int nbVehicles;
	
	public Journey(City city1, City city2, int distance, int passengerTicket) {
		this.city1 = city1;
		this.city2 = city2;
		this.distance = distance;
		this.passengerTicket = passengerTicket;
		this.nbVehicles = 0;
	}

	public boolean addVehicle(Vehicle myVehicle) {
		if(myVehicle.compatibleWitch(city1) && myVehicle.compatibleWitch(city2)) {
			vehicles[nbVehicles] = myVehicle;
			nbVehicles++;
			return true;
		}
		return false;
	}
	
	public int passengersPerDay() {
		int total = 0;
		for(int i=0; i<nbVehicles; i++) {
			total += vehicles[i].getPassengers() * vehicles[i].nbJourneyPerDay(distance);
		}
		return total;
	}
	
	public boolean contains(Vehicle myVehicle) {
		for(int i=0; i<nbVehicles; i++) {
			if(vehicles[i].equals(myVehicle)) {
				return true;
			}
		}
		return false;
	}
	
	public int costPerDay() {
		int total = 0;
		for(int i=0; i<nbVehicles; i++) {
			total += vehicles[i].getKmCost() * distance * vehicles[i].nbJourneyPerDay(distance);
		}
		return total;
	}
	
	public int incomePerDay() {
		return this.passengersPerDay() * passengerTicket;
	}
	
	public int benefitPerDay() {
		return this.incomePerDay() - this.costPerDay();
	}

	public String toString() {
		return city1 + "-" + city2;
	}
	
	
}
