package robot.apocalypse.survivor.Repositories;



import org.springframework.data.jpa.repository.JpaRepository;

import robot.apocalypse.survivor.Entities.Resources;

public interface ResourceRepo extends JpaRepository<Resources, Long> {


}
