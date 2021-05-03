package com.github.pawelsli.recipeswebapplication.service.dto;

public class MessageResponse {
    private String message;

    public MessageResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean containError(){
        if(this.message.contains("Error"))
            return true;
        return false;
    }
}
