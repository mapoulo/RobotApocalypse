package robot.apocalypse.CPU.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import robot.apocalypse.CPU.RobotPojo;
import robot.apocalypse.CPU.Services.RobotService;

@RestController
@RequestMapping("/api/robot")
public class RobotController {
	
	
	@Autowired
	private RobotService service;
	
	
	@GetMapping("/")
	public List<RobotPojo> getAllRobotInfo(){
		return service.getAllRobotInfo();
	}
	
	
	@GetMapping("/land")
	public List<RobotPojo> getAllRobotsOnLand(){
		return service.getAllRobotsOnLand();
	}
	
	
	@GetMapping("/flying")
	public List<RobotPojo> getAllRobotsFlying(){
		return service.getAllRobotsFlying();
	}

}
