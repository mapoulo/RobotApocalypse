package robot.apocalypse.survivor.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import robot.apocalypse.survivor.Entities.Survivor;

public interface SurvivorRepo  extends JpaRepository<Survivor, Long>{

	Survivor findByIdentificationNumber(int id);
}
