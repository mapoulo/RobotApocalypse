package robot.apocalypse.location.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import robot.apocalypse.location.Entities.Location;
import robot.apocalypse.location.Repositories.LocationRepository;


@Service
public class LocationService {
	
	
	@Autowired
	private LocationRepository repo;
	
	
	public Location saveLocation(Location location) {
		return repo.save(location);
	}
	
	
	public List<Location> getAllLocations(){
		List<Location> locations = new ArrayList<>();
		repo.findAll().parallelStream().forEach(locations::add);
		return locations;
	}
	
	
	public Location getLocationByIdNumber(int IdNumber) {
		return repo.findByIdentificationNumber(IdNumber);
	}
	
	
	

}
