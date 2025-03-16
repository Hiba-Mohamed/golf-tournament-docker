package golf.tournament.classes.tourtanment;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TournamentRepository extends CrudRepository<Tournament, Long> {
    public Tournament findById(long id);
    public List<Tournament> findByStartDate(String name);
    public List<Tournament> findByLocation(String phoneNumber);

}

