package golf.tournament.classes.member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
public class MemberController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/allMembers")
    public List<Member> getAllMembers(){return memberService.getAllMembers();}

    @PostMapping("/addMember")
    public Member addMember(@RequestBody Member newMember){return memberService.createMember(newMember);}

    @GetMapping("/getMemberByName/{name}")
    public Member getMemberByName(@PathVariable String name){return memberService.getMemberByName(name);}

    @GetMapping("/getMemberByPhoneNumber/{phoneNumber}")
    public Member getMemberByPhoneNumber(@PathVariable String phoneNumber){return memberService.getMemberByPhoneNumber(phoneNumber);}

    @GetMapping("/getMemberByStartDate/{startDate}")
    public Member getMemberByStartDate(@PathVariable String startDate){return memberService.getMemberByMembershipStartDate(startDate);}


}
