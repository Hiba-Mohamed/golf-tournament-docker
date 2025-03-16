package golf.tournament.classes.member;
import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "members")
public class Member {
    @Id
    @SequenceGenerator(name = "member_sequence", sequenceName = "member_sequence", allocationSize = 1, initialValue=1)
    @GeneratedValue(generator = "member_sequence")
    private long id;

    private String name;

    private String address;

    @Email
    private String emailAddress;

    private String phoneNumber;

    @DateTimeFormat
    private String startOfMembershipDate;

    private int durationOfMembershipInDays;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

