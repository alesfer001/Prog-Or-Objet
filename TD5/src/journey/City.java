package journey;

public class City {
	private String name;
	private boolean airport, gare;
	
	public City(String name, boolean airport, boolean gare) {
		this.name = name;
		this.airport = airport;
		this.gare = gare;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isAirport() {
		return airport;
	}

	public void setAirport(boolean airport) {
		this.airport = airport;
	}

	public boolean isGare() {
		return gare;
	}

	public void setGare(boolean gare) {
		this.gare = gare;
	}

	public String toString() {
		return name;
	}
	
	
}
