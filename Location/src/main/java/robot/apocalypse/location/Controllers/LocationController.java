package robot.apocalypse.location.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import robot.apocalypse.location.Entities.Location;
import robot.apocalypse.location.Repositories.LocationRepository;
import robot.apocalypse.location.Services.LocationService;

@RestController
@RequestMapping("/api/location")
public class LocationController {
	
	
	@Autowired
	private LocationService service;
	
	


	@PostMapping("/save")
	public Location saveLocation(@RequestBody Location location) {
		return service.saveLocation(location);
	}
	
	
	@GetMapping("/")
	public List<Location> getAllLocations(){
		return service.getAllLocations();
	}
	
	
	@GetMapping("/{identificationNumber}")
	public Location getLocationByIdNumber(@PathVariable int identificationNumber) {
		return service.getLocationByIdNumber(identificationNumber);
	}
	
	
	@PostMapping("/update")
	public Location updateLocation(@RequestBody Location location) {
		return service.saveLocation(location);
	}
}
