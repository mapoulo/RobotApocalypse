package robot.apocalypse.survivor.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import robot.apocalypse.survivor.Entities.Resources;
import robot.apocalypse.survivor.Entities.Survivor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SurvivorPojo {

	private Survivor survivor;
	private Resources resource;
	private LocationPojo location;
	private boolean infected;

}
