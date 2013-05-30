package com.clrvynt.service;

import java.util.List;

import com.clrvynt.domain.User;
import com.clrvynt.domain.UserAttachment;
import com.clrvynt.dto.LoginDto;
import com.clrvynt.dto.SaveUserDto;

public interface AppService {

    public User login(LoginDto dto);

    public User saveUser(SaveUserDto saveUserDto);

    public UserAttachment getAttachmentById(String attachmentId);

    public List<User> getAllUsers();

    public void runLongProcess();

}
