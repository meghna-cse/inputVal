package com.inputvalidation.springphonebook.model;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class AuditLog {
    @Id
    private String id;
    @Column(nullable = false, name = "USERNAME")
    private String username;
    @Column( name = "PROCESSED_DATA")
    private String processedData;
    @Column( name = "USER_ACTION")
    private String action;
    @Column( name = "LOG_TIMESTAMP")
    private LocalDateTime timestamp;

    public AuditLog() {
    }

    public AuditLog(String id, String username, String processedData, String action, LocalDateTime timestamp) {
        this.id = id;
        this.username = username;
        this.processedData = processedData;
        this.action = action;
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    //processedData
    public String getProcessedData(){
        return processedData;
    }

    public void setProcessedData(String processedData){
        this.processedData = processedData;
    }

    //action
    public String getAction(){
        return action;
    }

    public void setAction(String action){
        this.action = action;
    }

    //timestamp
    public LocalDateTime getTimestamp(){
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp){
        this.timestamp = timestamp;
    }
}
