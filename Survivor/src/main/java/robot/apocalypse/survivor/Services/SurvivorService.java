package robot.apocalypse.survivor.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import robot.apocalypse.survivor.Entities.Resources;
import robot.apocalypse.survivor.Entities.Survivor;
import robot.apocalypse.survivor.Pojo.LocationPojo;
import robot.apocalypse.survivor.Pojo.SurvivorPojo;
import robot.apocalypse.survivor.Repositories.SurvivorRepo;


@Service
public class SurvivorService {
	
	@Autowired
	private SurvivorRepo repo;
	@Autowired
	private ResourceService resourceService;
	@Autowired
	private RestTemplate restTemplate;
	@Value("${location.url}")
	private String url;
	
	
	

	public Survivor saveSurvivor(Survivor survivor) {
		return repo.save(survivor);
	}
	
	
	
	public List<Survivor> getAllSurvivors(){
		List<Survivor>  survivorList = new ArrayList<>();
		repo.findAll().stream().parallel().forEach(survivorList::add);
		return survivorList;
	}
	
	
	@CircuitBreaker(name="locationService", fallbackMethod = "failedTogetLocation")
	public LocationPojo getLocation(int id) {
		return  restTemplate.getForObject(url+id, LocationPojo.class);
	}
	
	
	public LocationPojo failedTogetLocation(Exception e) {
	LocationPojo location =	new LocationPojo();
	location.setIdentificationNumber(0);
	location.setLatitude(0);
	location.setLongitude(0);
	return location;
	}
	
	public SurvivorPojo getSurvivorById(int id) {
		
		Resources resource = new Resources();
		SurvivorPojo survivorPojo = new SurvivorPojo();
		LocationPojo locationPojo = new LocationPojo();
		Resources   survivorResource = resourceService.getResourceByIdentificationNumber(id);
		
		Optional<LocationPojo>  location = Optional.of(getLocation(id));
		Optional<Survivor>   survivor = Optional.of(repo.findByIdentificationNumber(id));
		

		
		if(survivor.isPresent()) {
			survivorPojo.setSurvivor(survivor.get());
		}else {
			survivorPojo.setSurvivor(new Survivor());
		}
		
		if(location.isPresent()) {
			survivorPojo.setLocation(location.get());
		}else {
			survivorPojo.setLocation(new LocationPojo());
		}
		
		if(survivorResource != null) {
			resource = survivorResource;
			survivorPojo.setResource(resource);
		}else {
			survivorPojo.setResource(new Resources());
		}
	
		return survivorPojo;
	}

	
	public double getPercentageOfInfectedPeople() {
		
		List<Survivor> infectedSurvivorsList = new ArrayList<>();
		
		getAllSurvivors().stream().parallel().forEach(survivor -> {
			if(survivor.isInfected()) {
				infectedSurvivorsList.add(survivor);
			}
		});
		
		double  infectedSurvivors =  infectedSurvivorsList.size()/100;
		
		return infectedSurvivors;
		
	}
	
	
	public double getPercentageOfNonInfectedPeople() {
		
		List<Survivor> nonInfectedSurvivorsList = new ArrayList<>();
		
		getAllSurvivors().stream().parallel().forEach(survivor -> {
			if(survivor.isInfected()) {
				nonInfectedSurvivorsList.add(survivor);
			}
		});
		
		double  noninfectedSurvivors =  nonInfectedSurvivorsList.size()/100;
		
		return noninfectedSurvivors;
		
	}
	
	
	
	public List<Survivor> getNonInfectedSurviors() {
		
		List<Survivor> nonInfectedSurvivorsList = new ArrayList<>();
		
		getAllSurvivors().stream().parallel().forEach(survivor -> {
			if(!survivor.isInfected()) {
				nonInfectedSurvivorsList.add(survivor);
			}
		});
		
		
		return nonInfectedSurvivorsList;
		
	}
	
	
	public List<Survivor> getInfectedSurviors() {
		
		List<Survivor> infectedSurvivorsList = new ArrayList<>();
		
		getAllSurvivors().stream().parallel().forEach(survivor -> {
			if(survivor.isInfected()) {
				infectedSurvivorsList.add(survivor);
			}
		});
		
		
		return infectedSurvivorsList;
		
	}
	
	
}
