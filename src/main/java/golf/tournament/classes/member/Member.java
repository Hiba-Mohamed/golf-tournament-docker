package golf.tournament.classes.member;
import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name = "members")
public class Member {
    @Id
    @SequenceGenerator(name = "member_sequence", sequenceName = "member_sequence", allocationSize = 1, initialValue=4)
    @GeneratedValue(generator = "member_sequence")
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String address;

    @Email
    private String emailAddress;

    private String phoneNumber;

    @DateTimeFormat
    private String startOfMembershipDate;

    private int durationOfMembershipInDays;

    public Member() {}

    public Member(String firstName, String lastName, String emailAddress, String phoneNumber, String startOfMembershipDate, int durationOfMembershipInDays, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.startOfMembershipDate = startOfMembershipDate;
        this.durationOfMembershipInDays = durationOfMembershipInDays;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(){
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStartOfMembershipDate() {
        return startOfMembershipDate;
    }

    public void setStartOfMembershipDate(String startOfMembershipDate) {
        this.startOfMembershipDate = startOfMembershipDate;
    }

    public int getDurationOfMembershipInDays() {
        return durationOfMembershipInDays;
    }

    public void setDurationOfMembershipInDays(int durationOfMembershipInDays) {
        this.durationOfMembershipInDays = durationOfMembershipInDays;
    }




}

