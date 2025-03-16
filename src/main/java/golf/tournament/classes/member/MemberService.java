package golf.tournament.classes.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;
//- add new Members
    public Member createMember (Member newMember){return memberRepository.save(newMember);}
//- get Members
    public List<Member> getAllMembers(){ return (List<Member>) memberRepository.findAll();}
//- Search member by:
//    -  by name
    public Member getMemberByName(String memberName){
        return memberRepository.findByName(memberName);
    }
//    -  phone number
    public Member getMemberByPhoneNumber(String memberPhoneNumber){
        return memberRepository.findByPhoneNumber(memberPhoneNumber);
    }
//    - tournament start date
    public Member getMemberByMembershipStartDate(String date){
        return memberRepository.findByStartOfMembershipDate(date);
    }

}
