package golf.tournament.classes.tourtanment;

import golf.tournament.classes.member.Member;
import golf.tournament.classes.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/allTournaments")
    public ResponseEntity<List<Tournament>> getAllTournaments() {
        List<Tournament> tournaments = tournamentService.getAllTournaments();
        if (tournaments.isEmpty()) {
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.ok(tournaments);
    }

    @PostMapping("/addTournament")
    public ResponseEntity<Tournament> addTournament(@RequestBody TournamentRequest tournamentRequest) {
        try {
            List<Long> memberIds = tournamentRequest.getParticipatingMemberIds();
            Iterable<Member> iterableMembers = memberRepository.findAllById(memberIds);
            List<Member> participatingMembers = new ArrayList<>();
            iterableMembers.forEach(participatingMembers::add);

            // Log the tournament creation
            System.out.println("Adding tournament: " + tournamentRequest.getLocation());

            Tournament newTournament = new Tournament(
                    tournamentRequest.getStartDate(),
                    tournamentRequest.getEndDate(),
                    tournamentRequest.getLocation(),
                    tournamentRequest.getEntryFee(),
                    tournamentRequest.getCashPrizeAmount(),
                    participatingMembers
            );
            Tournament tournament = tournamentService.createTournament(newTournament);
            return ResponseEntity.status(201).body(tournament);
        } catch (Exception e) {
            System.err.println("Error while adding tournament: " + e.getMessage());
            return ResponseEntity.status(500).body(null);
        }
    }


    @GetMapping("/getTournamentByStartDate/{startDate}")
    public ResponseEntity<List<Tournament>> getTournamentByStartDate(@PathVariable String startDate) {
        List<Tournament> tournaments = tournamentService.getTournamentByStartDate(startDate);
        if (tournaments.isEmpty()) {
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.ok(tournaments);
    }

    @GetMapping("/getTournamentByLocation/{location}")
    public ResponseEntity<List<Tournament>> getTournamentByLocation(@PathVariable String location) {
        List<Tournament> tournaments = tournamentService.getTournamentByLocation(location);
        if (tournaments.isEmpty()) {
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.ok(tournaments);
    }

    @GetMapping("/getMembersInTournamentWithId/{id}")
    public ResponseEntity<?> getMembersInTournamentWithId(@PathVariable long id) {
        Tournament tournament = tournamentService.getTournamentById(id);
        if (tournament == null) {
            return ResponseEntity.status(404).body("Tournament not found for ID: " + id);
        }
        return ResponseEntity.ok(tournament.getParticipatingMembers());
    }

    @GetMapping("/getMembersByTournamentStartDate/{startDate}")
    public ResponseEntity<List<Member>> getMembersByTournamentStartDate(@PathVariable String startDate) {
        List<Tournament> tournaments = tournamentService.getTournamentByStartDate(startDate);
        if (tournaments.isEmpty()) {
            return ResponseEntity.status(404).body(null);
        }

        Set<Member> uniqueMembers = new HashSet<>();
        for (Tournament tournament : tournaments) {
            uniqueMembers.addAll(tournament.getParticipatingMembers());
        }

        return ResponseEntity.ok(new ArrayList<>(uniqueMembers));
    }

    public static class TournamentRequest {

        private String startDate;
        private String endDate;
        private String location;
        private double entryFee;
        private double cashPrizeAmount;
        private List<Long> participatingMemberIds;

        public String getStartDate() {
            return startDate;
        }

        public void setStartDate(String startDate) {
            this.startDate = startDate;
        }

        public String getEndDate() {
            return endDate;
        }

        public void setEndDate(String endDate) {
            this.endDate = endDate;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public double getEntryFee() {
            return entryFee;
        }

        public void setEntryFee(double entryFee) {
            this.entryFee = entryFee;
        }

        public double getCashPrizeAmount() {
            return cashPrizeAmount;
        }

        public void setCashPrizeAmount(double cashPrizeAmount) {
            this.cashPrizeAmount = cashPrizeAmount;
        }

        public List<Long> getParticipatingMemberIds() {
            return participatingMemberIds;
        }

        public void setParticipatingMemberIds(List<Long> participatingMemberIds) {
            this.participatingMemberIds = participatingMemberIds;
        }
    }

}
