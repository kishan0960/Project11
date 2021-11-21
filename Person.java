/*
 *This class creates the person that store the information to display, add or edit based on 
 *user's input choice. Also prints the data using tostring class called. 
 * 
 * Assignment# :  11
 * Name: Kishan Patel
 * Date: 11/13/2021
 */
import java.io.Serializable;
/**
 *Class to store the following information
 *Name Phone Number Date of birth Email Address
 * @author 
 */
public class Person implements Serializable {

    private String name;
    private String phoneNumber;
    private String dateOfBirth;
    private String emailAddress;

    public Person(String name, String phoneNumber, String dateOfBirth, String emailAddress) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "Person\n---------------------------" + 
               "\nName          : " + name + 
               "\nPhoneNumber   : " + phoneNumber + 
               "\nDateOfBirth   : " + dateOfBirth + 
               "\nEmailAddress  : " + emailAddress + 
               "\n---------------------------\n";
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    
    

    
}
