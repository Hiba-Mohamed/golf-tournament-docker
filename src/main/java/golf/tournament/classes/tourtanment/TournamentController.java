package golf.tournament.classes.tourtanment;
import golf.tournament.classes.member.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

@RestController
@CrossOrigin
public class TournamentController {
    @Autowired
    private TournamentService tournamentService;

    @GetMapping("/allTournaments")
    public List<Tournament> getAllTournaments(){return tournamentService.getAllTournaments();}

    @PostMapping("/addTournament")
    public Tournament addTournament(@RequestBody Tournament newTournament){return tournamentService.createTournament(newTournament);}

    @GetMapping("/getTournamentByStartDate/{startDate}")
    public List<Tournament> getTournamentByStartDate(@PathVariable String startDate){return tournamentService.getTournamentByStartDate(startDate);}

    @GetMapping("/getTournamentByLocation/{location}")
    public List<Tournament> getTournamentByLocation(@PathVariable String location){return tournamentService.getTournamentByLocation(location);}

    @GetMapping("/getMembersInTournamentWithId/{id}")
    public List<Member> getMembersInTournamentWithId(@PathVariable long id){return tournamentService.getTournamentById(id).getParticipatingMembers();}

    @GetMapping("/getMembersByTournamentStartDate/{startDate}")
    public List<Member> getMembersByTournamentStartDate(@PathVariable String startDate) {
        List<Tournament> tournaments = tournamentService.getTournamentByStartDate(startDate);

        Set<Member> uniqueMembers = new HashSet<>();

        for (Tournament tournament : tournaments) {
            uniqueMembers.addAll(tournament.getParticipatingMembers());
        }

        return new ArrayList<>(uniqueMembers);
    }

}
