package com.clrvynt.dto;

import java.util.List;

import com.clrvynt.domain.User;

public class ResponseDto {

    private List<User> users;
    private boolean actionFailed;
    private String errorMessage;

    public List<User> getUsers() {
	return users;
    }

    public void setUsers(List<User> users) {
	this.users = users;
    }

    public boolean isActionFailed() {
	return actionFailed;
    }

    public void setActionFailed(boolean actionFailed) {
	this.actionFailed = actionFailed;
    }

    public String getErrorMessage() {
	return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
	this.errorMessage = errorMessage;
    }

}
