import java.util.*;

public class Drone {
	
	private int battery;
	private Station location;
	private boolean isDocked;
	private Station destination;
	private ArrayList<Station> listOfStations = new ArrayList<>();
	
	//generic constructor
	public Drone(Station aLocation) {
		this.location = aLocation;
		this.battery = 100;
		
	}
	
	//copy constructor 
	public Drone(Drone aDrone) {
		this.location = aDrone.getLocation();
		this.battery = aDrone.getBattery();
	}
	
	/***************************** GETTER METHODS *****************************/
	
	public Station getLocation() {
		Station copy = new Station(this.location);
		return copy;
	}
	
	public int getBattery() {
		return this.battery;
	}
	
	public Station getDestination() {
		Station copy = new Station(this.destination);
		return copy;
	}
	
	
	//will chose the closest station based on customer location
	public void updateDestination(Location customerLocation) {
		
		//first, compile all Locations into one list
		ArrayList<Location> potentialLocations = new ArrayList<>();
		for(Station s: GeoMap.allStations()) {
			potentialLocations.add(s.getLocation());
		}
		
		//determine Station closest to customer as crow flies
		//this will now become the Destination of the drone
		double[] distances = new double[potentialLocations.size()];
		for(int i = 0; i<potentialLocations.size() ; i++) {
			distances[i] = customerLocation.distanceTo(potentialLocations.get(i));
		}
		
		
		Location closest = potentialLocations.get(0);
		double closestNumber = distances[0];
		for (int i = 0; i< potentialLocations.size() ; i++) {
			if(closestNumber > distances[i] && GeoMap.matchStation(potentialLocations.get(i)).isAvailable() ) {
				closestNumber = distances[i];
				closest = potentialLocations.get(i);
			}
		}
		
		this.destination = GeoMap.matchStation(closest);
	}
	
	//method to dock the drone in destination
	
	public void arrival() {
		this.destination.dockDrone(this);
		this.isDocked = true;
	}
	
	
	
	//calculate the amount of time in minutes for the drone to get from its current station
	//to Destination
	
	public double timeToDestination() {
		double distanceMiles = this.location.getLocation().distanceTo(this.destination.getLocation());
		
		//top speed of a drone is 65km/h, or about 40 mph
		// add 5 minutes to calculated amount to account for takeoff/landing + processing
		double minutes = Math.ceil((distanceMiles/40)*60 + 5);
		
		return minutes;
		
	}
	
	
	
	
}
