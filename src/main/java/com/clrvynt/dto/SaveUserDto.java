package com.clrvynt.dto;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import com.clrvynt.validation.FileSize;

public class SaveUserDto {

    @Email
    @NotEmpty
    private String email;

    @NotEmpty
    @Size(min = 2, max = 20)
    private String firstName;

    @NotEmpty
    @Size(min = 2, max = 30)
    private String lastName;

    @FileSize(10000)
    private MultipartFile userAttachment;

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
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

    public MultipartFile getUserAttachment() {
	return userAttachment;
    }

    public void setUserAttachment(MultipartFile userAttachment) {
	this.userAttachment = userAttachment;
    }

}
