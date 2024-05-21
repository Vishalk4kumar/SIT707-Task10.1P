package tasksubmission;

import java.util.HashMap;
import java.util.Map;

public class TaskSubmission {

    private Map<String, Task> tasks = new HashMap<>();
    private Map<String, String> feedbacks = new HashMap<>();

    public String submitTask(String studentId, String taskDescription, String file, String deadline) {
        tasks.put(studentId, new Task(taskDescription, file, deadline, "submitted"));
        return "Task submitted successfully";
    }

    public String viewTaskStatus(String studentId) {
        return tasks.get(studentId).getStatus();
    }

    public String provideFeedback(String studentId, String feedback) {
        feedbacks.put(studentId, feedback);
        tasks.get(studentId).setStatus("feedback provided");
        return "Feedback provided successfully";
    }

    private static class Task {
        private String description;
        private String file;
        private String deadline;
        private String status;

        public Task(String description, String file, String deadline, String status) {
            this.description = description;
            this.file = file;
            this.deadline = deadline;
            this.status = status;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}
