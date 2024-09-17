package com.taskList.com.taskList.entity;

import org.springframework.context.annotation.Bean;

import java.util.Date;

/**
 * This entity represents a task with a name, a starting and ending date and some notes/observations.
 */
public class Task {

    private int id;
    private String taskName;
    private Date beginDate;
    private Date endDate;
    private String notes;

    public int getId(int id) {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
