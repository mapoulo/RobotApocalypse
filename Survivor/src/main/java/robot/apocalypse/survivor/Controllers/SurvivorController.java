package robot.apocalypse.survivor.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import robot.apocalypse.survivor.Entities.Resources;
import robot.apocalypse.survivor.Entities.Survivor;
import robot.apocalypse.survivor.Pojo.SurvivorPojo;
import robot.apocalypse.survivor.Services.ResourceService;
import robot.apocalypse.survivor.Services.SurvivorService;

@RestController
@RequestMapping("/api/survivor")
public class SurvivorController {
	
	
	@Autowired
	private SurvivorService service;
	@Autowired
	private ResourceService resourceService;
	

	
	
	@PostMapping("/save")
	public Survivor saveSurvivor(@RequestBody Survivor survivor) {
		return service.saveSurvivor(survivor);
	}
	
	@PostMapping("/saveResource")
	public Resources saveResource(@RequestBody Resources resources) {
		return resourceService.saveResource(resources);
	}
	
	
	@PostMapping("/update")
	public Survivor update(@RequestBody Survivor survivor) {
		return service.saveSurvivor(survivor);
	}
	
	
	@GetMapping("/")
	public List<Survivor> getAllSurvivors(){
		return service.getAllSurvivors();
	}
	
	
	@GetMapping("/{identificationNumber}")
	public SurvivorPojo getSurvivorById(@PathVariable  int identificationNumber) {
		return service.getSurvivorById(identificationNumber);
	}
	
	@GetMapping("/getPercentageOfInfectedPeople")
	public double getPercentageOfInfectedPeople() {
		return service.getPercentageOfInfectedPeople();
	}
	
	
	@GetMapping("/getPercentageOfNonInfectedPeople")
	public double getPercentageOfNonInfectedPeople() {
		return service.getPercentageOfNonInfectedPeople();
	}

	
	@GetMapping("/getNonInfectedSurviovor")
	public List<Survivor> getNonInfectedSurviovor() {
		return service.getNonInfectedSurviors();
	}
	
	
	@GetMapping("/geInfectedSurviovor")
	public List<Survivor> geInfectedSurviovor() {
		return service.getInfectedSurviors();
	}
}
