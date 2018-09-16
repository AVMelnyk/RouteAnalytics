package ua.pp.avmelnyk.routeanalytics.web.dto;

import ua.pp.avmelnyk.routeanalytics.validation.PasswordMatches;
import ua.pp.avmelnyk.routeanalytics.validation.ValidEmail;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@PasswordMatches
public class UserDto {

    @NotNull
    @Size(min=1, max=16)
    private String userName;

    @NotNull
    @Size(min=1, max=16)
    private String firstName;

    @NotNull
    @Size(min=1, max=16)
    private String lastName;

    @ValidEmail
    @NotNull
    private String email;

    @NotNull
    @Size(min=5, max=16)
    private String password;

    @NotNull
    @Size(min=5, max=16)
    private String matchingPassword;

    public String getUserName() {
        return userName;
    }

    public void setUserName( String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }



    @Override
    public String toString() {
        return "UserDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", matchingPassword='" + matchingPassword + '\'' +
                '}';
    }


}
