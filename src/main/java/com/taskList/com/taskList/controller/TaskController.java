package com.taskList.com.taskList.controller;

import com.taskList.com.taskList.entity.Task;
import com.taskList.com.taskList.data.repository.TaskRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    /**
     * Inserts a new task with the data provided.
     * @param task is the task created, with all of its details to be stored in the database.
     * @return an answer that indicates the success of this transaction with HTTP status 201 (CREATED) if it succeeds,
     *         or a HTTP status 500 (INTERNAL_SERVER_ERROR) if it fails.
     */
    @PostMapping()
    public ResponseEntity post(@RequestBody Task task) {
        try{
            task.setBeginDate(new Timestamp(System.currentTimeMillis()));
            return new ResponseEntity<>(taskRepository.insertNewTask(task), HttpStatus.CREATED);
        }catch(Exception ex){
            return new ResponseEntity(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Retrieves all tasks in the database.
     * @return an answer that indicates the success of this transaction with HTTP status 200 (OK) if it succeeds,
     *         or a HTTP status 404 (NOT_FOUND) if it fails.
     */
    @GetMapping()
    public ResponseEntity getAll() {
        try{
            return new ResponseEntity(taskRepository.selectTasks(), HttpStatus.OK);
        }catch(Exception ex){
            return new ResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Retrieves a task based on its name.
     * @param taskName is the identifier of this method, used to filter which tasks are shown.
     * @return an answer that indicates the success of this transaction with HTTP status 200 (OK) if it succeeds,
     *         or a HTTP status 404 (NOT_FOUND) if it fails.
     */
    @GetMapping(params = "taskName")
    public ResponseEntity getByName(@RequestParam String taskName) {
        try{
            return new ResponseEntity<>(taskRepository.selectTaskByName(taskName), HttpStatus.OK);
        }catch(Exception ex){
            return new ResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Retrieves a task based on its id.
     * @param id is the identifier of this method, used to filter which tasks are shown.
     * @return an answer that indicates the success of this transaction with HTTP status 200 (OK) if it succeeds,
     *         or a HTTP status 404 (NOT_FOUND) if it fails.
     */
    @GetMapping(params = "id")
    public ResponseEntity getById(@RequestParam int id) {
        try{
            return new ResponseEntity<>(taskRepository.selectTaskById(id), HttpStatus.OK);
        }catch(Exception ex){
            return new ResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Deletes an existing task based on its id.
     * @param id is the identifier of this method, used to filter which tasks are shown.
     * @return an answer that indicates the success of this transaction with HTTP status 200 (OK) if it succeeds,
     *         or a HTTP status 500 (INTERNAL_SERVER_ERROR) if it fails.
     */
    @DeleteMapping(params = "id")
    public ResponseEntity delete(@RequestParam int id) {
        try{
            return new ResponseEntity<>(taskRepository.delete(id), HttpStatus.OK);
        }catch(Exception ex){
            return new ResponseEntity(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Updates an existing task based on its id.
     * @param task is the task with updated data, its id must be provided by consulting parameter.
     * @param id is the identifier of this method, used to filter which tasks are shown.
     * @return an answer that indicates the success of this transaction with HTTP status 200 (OK) if it succeeds,
     *         or a HTTP status 500 (INTERNAL_SERVER_ERROR) if it fails.
     */
    @PutMapping(params = "id")
    public ResponseEntity update(@RequestBody Task task, @RequestParam int id) {
        try{
            task.setBeginDate(new Timestamp(System.currentTimeMillis()));
            return new ResponseEntity<>(taskRepository.update(task, id), HttpStatus.OK);
        }catch(Exception ex){
            return new ResponseEntity(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
