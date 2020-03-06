package com.mostafatarek.mobileappws.ui.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDetailsRequestModel {
    @NotNull(message = "firstName can't be null")
    @Size(min = 5, max = 24, message = "this should be between 5 characters min and 24 character max")
    private String firstName;
    @NotNull(message = "lastName can't be null")
    private String lastName;
    @NotNull(message = "emil can't be null")
    @Email
    private String email;


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

}
