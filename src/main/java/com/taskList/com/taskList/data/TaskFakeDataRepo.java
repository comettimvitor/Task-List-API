package com.taskList.com.taskList.data;

import com.taskList.com.taskList.data.repository.TaskRepository;
import com.taskList.com.taskList.entity.Task;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
@EnableAutoConfiguration
public class TaskFakeDataRepo {

    @Autowired
    private TaskRepository taskRepository;

    /**
     * Initializes tasks in the H2 Database upon the application startup.
     */
    @PostConstruct
    public Task populatesH2Database() {
        Task t1 = new Task();
        t1.setTaskName("Task1");
        t1.setBeginDate(new Timestamp(System.currentTimeMillis()));
        t1.setEndDate(null);
        t1.setNotes("No observations.");

        Task t2 = new Task();
        t2.setTaskName("Task2");
        t2.setBeginDate(new Timestamp(System.currentTimeMillis()));
        t2.setEndDate(null);
        t2.setNotes("1 note.");

        Task t3 = new Task();
        t3.setTaskName("Task3");
        t3.setBeginDate(new Timestamp(System.currentTimeMillis()));
        t3.setEndDate(null);
        t3.setNotes("No notes, for now.");

        taskRepository.insertNewTask(t1);
        taskRepository.insertNewTask(t2);
        taskRepository.insertNewTask(t3);

        return t1;
    }
}
