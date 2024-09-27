package com.taskList.com.taskList.data.repository;

import com.taskList.com.taskList.entity.Task;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Repository
@EnableAutoConfiguration
public class TaskRepository {
    private JdbcTemplate jdbcTemplate;

    private static String SELECT_ALL_TASKS = "SELECT * FROM task";

    private static String SELECT_BY_NAME = "SELECT * FROM task WHERE taskName = ?";

    private static String SELECT_BY_ID = "SELECT * FROM task WHERE id = ?";

    private static String INSERT_NEW_TASK = "INSERT INTO task(taskName, beginDate, endDate, notes) VALUES (?, ?, ?, ?)";

    private static String DELETE_TASK = "DELETE FROM task WHERE id = ?";

    private static String UPDATE_TASK = "UPDATE task SET taskName = ?, beginDate = ?, endDate = ?, notes = ? WHERE id = ?";

    public TaskRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Task insertNewTask(Task task){
        Object[] attributes = new Object[]{
                task.getTaskName(),
                task.getBeginDate(),
                task.getEndDate(),
                task.getNotes()
        };

        jdbcTemplate.update(INSERT_NEW_TASK, attributes);
        return task;
    }

    public List<Task> selectTasks() {
        return jdbcTemplate.query(SELECT_ALL_TASKS, new RowMapper<Task>() {
            @Override
            public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
                Task task = new Task();
                task.setId(rs.getInt("id"));
                task.setTaskName(rs.getString("taskName"));
                task.setBeginDate(rs.getDate("beginDate"));
                task.setEndDate(rs.getDate("endDate"));
                task.setNotes(rs.getString("notes"));
                return task;
            }
        });
    }

    public List<Task> selectTaskByName(String taskName) {
        Object[] attribute = new Object[]{taskName};

        return jdbcTemplate.query(SELECT_BY_NAME, new RowMapper<Task>() {
            @Override
            public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
                Task task = new Task();
                task.setId(rs.getInt("id"));
                task.setTaskName(rs.getString("taskName"));
                task.setBeginDate(rs.getDate("beginDate"));
                task.setEndDate(rs.getDate("endDate"));
                task.setNotes(rs.getString("notes"));
                return task;
            }
        }, attribute);
    }

    public List<Task> selectTaskById(int id) {
        Object[] attribute = new Object[]{id};

        return jdbcTemplate.query(SELECT_BY_ID, new RowMapper<Task>() {
            @Override
            public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
                Task task = new Task();
                task.setId(rs.getInt("id"));
                task.setTaskName(rs.getString("taskName"));
                task.setBeginDate(rs.getDate("beginDate"));
                task.setEndDate(rs.getDate("endDate"));
                task.setNotes(rs.getString("notes"));
                return task;
            }
        }, attribute);
    }

    public int delete(int id) {
        return jdbcTemplate.update(DELETE_TASK, id);
    }

    public Task update(Task task, int id) {
        Object[] attributes = new Object[]{
                task.getTaskName(),
                task.getBeginDate(),
                task.getEndDate(),
                task.getNotes(),
                id
        };

        jdbcTemplate.update(UPDATE_TASK, attributes);
        return task;
    }
}
