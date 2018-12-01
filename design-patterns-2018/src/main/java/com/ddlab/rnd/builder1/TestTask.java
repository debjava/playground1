package com.ddlab.rnd.builder1;

import java.util.Date;

public class TestTask {
  public static void main(String[] args) {
    Task task =
        new Task.TaskBuilder(11)
            .name("taksName")
            .dueDate(new Date())
            .desc("some desc")
            .status("pending")
            .build();
    System.out.println("Task : " + task);
  }
}
