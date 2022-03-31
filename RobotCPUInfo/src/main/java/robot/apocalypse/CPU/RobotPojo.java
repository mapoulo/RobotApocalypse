package robot.apocalypse.CPU;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder("Search")
public class RobotPojo {
	
	@JsonProperty("model")
	private String model;
	@JsonProperty("serialNumber")
	private String serialNumber;
	@JsonProperty("manufacturedDate")
	private Date manufacturedDate;
	@JsonProperty("category")
	private String category;

}
