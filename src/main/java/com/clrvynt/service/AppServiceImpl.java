package com.clrvynt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Transactional;

import com.clrvynt.dao.AppDao;
import com.clrvynt.domain.User;
import com.clrvynt.domain.UserAttachment;
import com.clrvynt.dto.LoginDto;
import com.clrvynt.dto.SaveUserDto;

public class AppServiceImpl implements AppService {

    @Autowired
    private AppDao appDao;

    @Override
    public User login(LoginDto dto) {

	User user = appDao.login(dto.getEmail(), dto.getPassword());
	if (user == null)
	    throw new RuntimeException("Invalid username or password");

	return user;
    }

    @Override
    @Transactional
    public User saveUser(SaveUserDto saveUserDto) {
	User user = appDao.findUserByEmail(saveUserDto.getEmail());

	if (user == null)
	    throw new RuntimeException("Could not find user");

	user.setEmail(saveUserDto.getEmail());
	user.setFirstName(saveUserDto.getFirstName());
	user.setLastName(saveUserDto.getLastName());

	if (saveUserDto.getUserAttachment() != null && !saveUserDto.getUserAttachment().isEmpty()) {
	    UserAttachment attachment = new UserAttachment();
	    attachment.setContentType(saveUserDto.getUserAttachment().getContentType());
	    try {
		attachment.setAttachmentBytes(saveUserDto.getUserAttachment().getBytes());
	    } catch (Exception e) {
		throw new RuntimeException("An unknown exception occurred");
	    }
	    attachment = appDao.save(attachment);
	    user.setUserAttachment(attachment);
	}
	return user;
    }

    @Override
    public UserAttachment getAttachmentById(String attachmentId) {
	return appDao.getById(new Integer(attachmentId), UserAttachment.class);
    }

    @Override
    public List<User> getAllUsers() {
	return appDao.findAll(User.class);
    }

    @Override
    @Async
    public void runLongProcess() {
	try {
	    Thread.sleep(60000);
	} catch (Exception e) {

	}

    }

}
