package golf.tournament.classes;
import golf.tournament.classes.member.Member;
import golf.tournament.classes.member.MemberService;
import golf.tournament.classes.tourtanment.TournamentService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.SpringApplication;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class GolfServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(GolfServiceApplication.class, args);

    }
}
