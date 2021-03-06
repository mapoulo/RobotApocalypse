package robot.apocalypse.location.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import robot.apocalypse.location.Entities.Location;

public interface LocationRepository extends JpaRepository<Location, Long>{

	Location findByIdentificationNumber(int idNumber);

}
