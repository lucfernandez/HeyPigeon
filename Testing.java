
public class Testing {
	public static void main(String[] args) {
		
		// creation of Locations and stations
		
		Location newYorkCity = new Location(40.730610, -73.935242);
		Station s1 = new Station(1, 12, newYorkCity);
		
		Location miltonPark = new Location(45.5106, -73.5760);
		Station s2 = new Station(2, 14, miltonPark);
		
		Location mileEnd = new Location(45.5240, -73.6005);
		Station s3 = new Station(3, 14, mileEnd);
		
		Location oldPort = new Location(45.5043, -73.5496 );
		
		Location myCurrentLocation = new Location(41.170156, -73.7313684);
		
		//add stations to geomaps of NYC and Montreal
		
		GeoMap montreal = new GeoMap();
		GeoMap newYork = new GeoMap();
		
		montreal.addStation(s2);
		montreal.addStation(s3);
		
		newYork.addStation(s1);
		
		Drone d1 = new Drone(s1);
		Drone d2 = new Drone(s2);
		
		d1.updateDestination(myCurrentLocation);
		d2.updateDestination(oldPort);
		
		System.out.println(d1.getDestination());
		System.out.println(d2.getDestination());
	}
}
