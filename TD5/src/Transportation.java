import vehicle.*;
import journey.*;

public class Transportation {
	
	public static void main(String[] args){
				
		Vehicle[] vehicles = new Vehicle[4];
		vehicles[0] = new Train("tgv", 1032, 300, 100);
		vehicles[1] = new Train ("ter", 500, 100, 50);
		vehicles[2] = new Bus("ouibus", 40, 80, 10);
		vehicles[3] = new Airplane("a320", 186, 800, 1, 200);
		
		for (Vehicle v : vehicles)
			System.out.println(v);
		System.out.println();
		
		City paris = new City("Paris", true, true);
		City bordeaux = new City ("Bordeaux", true, true);
		City brive = new City("Brive", false, true);
		
		Journey[] journeys = new Journey[2];
		journeys[0] = new Journey(paris, bordeaux, 600, 100);
		journeys[1] = new Journey(bordeaux, brive, 200, 30);
		
		for (Vehicle v: vehicles){
			for (Journey j : journeys){
				if (j.addVehicle(v))
					System.out.println(v.getName()+ " added to " + j);
			}
		}
		
		System.out.println();
		
		int benefit = 0;
		for (Journey j : journeys){
			
			System.out.println(j + " -> passengers/day:"+ j.passengersPerDay()+
					" income/day:" + j.incomePerDay() + " cost/day:"+j.costPerDay());
			benefit += j.benefitPerDay();
		}
		
		System.out.println("benefit : "+ benefit );
		
		Bus myBus = new Bus("flexbus", 10000, 500, 1);
		journeys[0].addVehicle(myBus);
		
		for (Journey j : journeys){
			
			System.out.println(j + " -> passengers/day:"+ j.passengersPerDay()+
					" income/day:" + j.incomePerDay() + " cost/day:"+j.costPerDay());
			benefit += j.benefitPerDay();
		}
		
		System.out.println("benefit : "+ benefit );
		
		if(journeys[0].contains(myBus)) {
			System.out.println("Test Passed!");
		}
		
	}
}