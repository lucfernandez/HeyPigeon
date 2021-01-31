import java.util.*;

public class GeoMap {
	private static ArrayList<Station> listOfStations = new ArrayList<>();
	
	public void addStation(Station aStation) {
	
		Station copy = new Station(aStation);
		listOfStations.add(copy);
	}
	
	//allows us to match coordinates with specific station
	public static Station matchStation(Location toBeMatched) {
		for(Station s: listOfStations) {
			if(s.getLocation().getLongitude() == toBeMatched.getLongitude() && s.getLocation().getLatitude() == toBeMatched.getLatitude()) {
				Station copy = new Station(s);
				return copy; 
			}
		}
		return null;
	}
	
	//returns list of stations
	
	public static ArrayList<Station> allStations() {
		ArrayList<Station> copy = new ArrayList<>();
		for (Station s: listOfStations) {
			copy.add(new Station(s));
		}
		return copy;
	}
	
}
