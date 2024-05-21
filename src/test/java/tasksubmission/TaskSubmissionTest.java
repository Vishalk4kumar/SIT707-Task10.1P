package tasksubmission;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TaskSubmissionTest {

    private TaskSubmission taskSubmission;

    @Before
    public void setUp() {
        taskSubmission = new TaskSubmission();
    }

    @Test
    public void testSubmitTask() {
        String result = taskSubmission.submitTask(
            "S12345", "Math Assignment", "math_assignment.pdf", "2024-06-01"
        );
        assertEquals("Task submitted successfully", result);
    }

    @Test
    public void testViewTaskStatus() {
        taskSubmission.submitTask("S12345", "Math Assignment", "math_assignment.pdf", "2024-06-01");
        String status = taskSubmission.viewTaskStatus("S12345");
        assertEquals("submitted", status);
    }

    @Test
    public void testProvideFeedback() {
        taskSubmission.submitTask("S12345", "Math Assignment", "math_assignment.pdf", "2024-06-01");
        String feedbackResult = taskSubmission.provideFeedback("S12345", "Good work, but needs more explanation in section 2.");
        assertEquals("Feedback provided successfully", feedbackResult);
    }
}
