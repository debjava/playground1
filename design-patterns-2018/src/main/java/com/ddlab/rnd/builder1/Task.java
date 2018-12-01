package com.ddlab.rnd.builder1;

import java.util.Date;

public class Task {
  private int id;
  private String name;
  private String desc;
  private String status;
  private Date dueDate;

  public Task(int id) {
    this.id = id;
  }

  private Task(int id, String name, String desc, String status, Date dueDate) {
    this.id = id;
    this.name = name;
    this.desc = desc;
    this.status = status;
    this.dueDate = dueDate;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getDesc() {
    return desc;
  }

  public String getStatus() {
    return status;
  }

  public Date getDueDate() {
    return dueDate;
  }

  @Override
  public String toString() {
    return "Task{"
        + "id="
        + id
        + ", name='"
        + name
        + '\''
        + ", desc='"
        + desc
        + '\''
        + ", status='"
        + status
        + '\''
        + ", dueDate="
        + dueDate
        + '}';
  }

  // ~~~~~~~~~~ Create a TaskBuilder ~~~~~~~~~~~
  public static class TaskBuilder {
    private int id;
    private String name;
    private String desc;
    private String status;
    private Date dueDate;

    public TaskBuilder(int id) {
      this.id = id;
    }

    public TaskBuilder name(String name) {
      this.name = name;
      return this;
    }

    public TaskBuilder desc(String desc) {
      this.desc = desc;
      return this;
    }

    public TaskBuilder status(String status) {
      this.status = status;
      return this;
    }

    public TaskBuilder dueDate(Date dueDate) {
      this.dueDate = dueDate;
      return this;
    }

    public Task build() {
      return new Task(id, name, desc, status, dueDate);
    }
  }
}
