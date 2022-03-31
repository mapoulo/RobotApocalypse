package robot.apocalypse.CPU.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import robot.apocalypse.CPU.RobotPojo;

@Service
public class RobotService {
	
	@Autowired
	RestTemplate restTemplate;
	
	
	@CircuitBreaker(name="robot", fallbackMethod = "failedTogetRobotInfo")
	public List<RobotPojo> getAllRobotInfo(){
		
		List<RobotPojo> robotInfoList = new ArrayList<>();
		
		ResponseEntity<List<RobotPojo>> robotInfo =
		        restTemplate.exchange("https://robotstakeover20210903110417.azurewebsites.net/robotcpu",
		                    HttpMethod.GET, null, new ParameterizedTypeReference<List<RobotPojo>>() {
		            });
		
		robotInfo.getBody().forEach(robotInfoList::add);
		return robotInfoList;
		
	}
	
	
	public List<RobotPojo> failedTogetRobotInfo(Exception e){
		List<RobotPojo> robots = new ArrayList<>();
		return robots;
	}
	
	
	
	@CircuitBreaker(name="robot", fallbackMethod = "failedTogetgetAllRobotsOnLand")
public List<RobotPojo> getAllRobotsOnLand(){
		
		List<RobotPojo> robotInfoList = new ArrayList<>();
		
		ResponseEntity<List<RobotPojo>> robotInfo =
		        restTemplate.exchange("https://robotstakeover20210903110417.azurewebsites.net/robotcpu",
		                    HttpMethod.GET, null, new ParameterizedTypeReference<List<RobotPojo>>() {
		            });
		
		robotInfo.getBody().stream().parallel().filter(robot -> robot.getCategory().equals("Land")).forEach(robotInfoList::add);
		return robotInfoList;
		
	}
	
	
	public List<RobotPojo> failedTogetgetAllRobotsOnLand(Exception e){
		List<RobotPojo> robots = new ArrayList<>();
		return robots;
	}
	
	
@CircuitBreaker(name="robot", fallbackMethod = "failedTogetgetgetAllRobotsFlying")	
public List<RobotPojo> getAllRobotsFlying(){
	
	List<RobotPojo> robotInfoList = new ArrayList<>();
	
	ResponseEntity<List<RobotPojo>> robotInfo =
	        restTemplate.exchange("https://robotstakeover20210903110417.azurewebsites.net/robotcpu",
	                    HttpMethod.GET, null, new ParameterizedTypeReference<List<RobotPojo>>() {
	            });
	
	robotInfo.getBody().stream().parallel().filter(robot -> robot.getCategory().equals("Flying")).forEach(robotInfoList::add);
	return robotInfoList;
	
}
	


public List<RobotPojo> failedTogetgetgetAllRobotsFlying(Exception e){
	List<RobotPojo> robots = new ArrayList<>();
	return robots;
}
	

}
