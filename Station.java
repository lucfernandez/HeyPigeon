import java.util.*;

public class Station {
	private int ID;
	private ArrayList<Drone> currentInventory = new ArrayList<>();
	private boolean isAvailable;
	private int aCapacity;
	private Location aLocation;
	
	//constructor
	public Station(int aID, int aCapacity, Location aLocation ) {
		this.ID = aID;
		this.isAvailable = true;
		this.aCapacity = aCapacity;
		this.aLocation = aLocation;
	}
	
	//copy constructor 
	public Station( Station sample) {
		this.ID = sample.getID();
		this.isAvailable = sample.isAvailable();
		this.aCapacity = sample.getCapacity();
		this.aLocation = sample.getLocation();
	}

	//updates availability boolean
	private void updateAvailability() {
		if (currentInventory.size() >= this.aCapacity ) {
			this.isAvailable = false;
		}
		else {
			this.isAvailable = true;
		}
	}


	
	//called when docking drone at station
	public void dockDrone(Drone aDrone) {
		
		if (isAvailable()) {
			//need to add copy constructor 
			Drone toAdd = new Drone(aDrone);
			currentInventory.add(toAdd);
			updateAvailability();
		}
		
		//when there is no more space in the station
		else {
			System.out.println("Sorry, no more room in this station!");
		}
		
	}
	
	//takes out drone that has been resting the longest, or the first drone in the list
	public Drone undockDrone() {
		Drone sendOut = new Drone(currentInventory.get(0));
		currentInventory.remove(0);
		return sendOut;
	}
	
	/* *************** GETTER METHODS ********************************/
	
	// get longitude
	
	public Location getLocation() {
		Location copy = new Location(this.aLocation);
		return copy;
	}

	public int getID() {
		return this.ID;
	}
	
	public int getCapacity() {
		return this.aCapacity;
	}
	
	//returns boolean to drone to let it know if it can dock there
	public boolean isAvailable() {
			return isAvailable;
	}
	
	public String toString() {
		return "Station ID is: " + this.ID;
	}
	
	
	
	
}
