package robot.apocalypse.survivor.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import robot.apocalypse.survivor.Entities.Resources;
import robot.apocalypse.survivor.Repositories.ResourceRepo;

@Service
public class ResourceService {
	
	@Autowired
	private ResourceRepo repo;
	
	
	public Resources saveResource(Resources resources) {
		return repo.save(resources);
	}
	
	
	 Resources  resource;
	public  Resources  getResourceByIdentificationNumber(double identificationNumber) {
		repo.findAll().parallelStream().forEach(MyResource -> {
			if(MyResource.getIdentificationNumber() == identificationNumber) {
				resource = MyResource;
			}
		});
		
		return resource;
	}
	
	
	
	public List<Resources> getAllResources(){
		List<Resources>  resources = new ArrayList<>();
		repo.findAll().parallelStream().forEach(resources::add);
		return resources;
	}
	
	
	public Resources updateResource(Resources resources) {
		return repo.save(resources);
	}
	
	
	public String deleteAllResources() {
		repo.deleteAll();
		return "Deleted";
	}

}
