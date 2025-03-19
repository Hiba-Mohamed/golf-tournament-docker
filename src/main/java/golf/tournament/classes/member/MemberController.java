package golf.tournament.classes.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/allMembers")
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }

    @PostMapping("/addMember")
    public Member addMember(@RequestBody Member newMember) {
        return memberService.createMember(newMember);
    }

    @GetMapping("/getMemberByFirstName/{firstName}")
    public ResponseEntity<Member> getMemberByFirstName(@PathVariable String firstName) {
        Member member = memberService.getMemberByFirstName(firstName);
        if (member == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    @GetMapping("/getMemberByLastName/{lastName}")
    public ResponseEntity<Member> getMemberByLastName(@PathVariable String lastName) {
        Member member = memberService.getMemberByLastName(lastName);
        if (member == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    @GetMapping("/getMemberByPhoneNumber/{phoneNumber}")
    public ResponseEntity<Member> getMemberByPhoneNumber(@PathVariable String phoneNumber) {
        Member member = memberService.getMemberByPhoneNumber(phoneNumber);
        if (member == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    @GetMapping("/getMemberByStartDate/{startDate}")
    public ResponseEntity<Member> getMemberByStartDate(@PathVariable String startDate) {
        Member member = memberService.getMemberByMembershipStartDate(startDate);
        if (member == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(member, HttpStatus.OK);
    }
}
