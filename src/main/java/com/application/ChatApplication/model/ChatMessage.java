package com.application.ChatApplication.model;

public class ChatMessage {

    private String sender;
    private String content;

    // Getters and setters
    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    // Optional: Overriding toString() for better log readability
    @Override
    public String toString() {
        return "ChatMessage [sender=" + sender + ", content=" + content + "]";
    }
}

