package robot.apocalypse.survivor.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Resources {

	
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long Id;
	
	private boolean haveWater;
	private boolean haveFood;
	private boolean haveMedication;
	private boolean haveAmmunition;
	private int IdentificationNumber;
}
