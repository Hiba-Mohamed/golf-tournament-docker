package golf.tournament.classes.member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends CrudRepository<Member, Long> {
    public Member findByFirstName(String firstName);
    public Member findByLastName(String lastName);
    public Member findByPhoneNumber(String phoneNumber);
    public Member findByStartOfMembershipDate(String startOfMembershipDate);

}
