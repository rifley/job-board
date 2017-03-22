import org.junit.*;
import static org.junit.Assert.*;

public class JobTest {

  @Test
  public void job_instantiateJob() {
    Job myJob = new Job("Clean toilets", "Worker", "myemail");
    assertEquals(true, myJob instanceof Job);
  }

  @Test
  public void job_instantiateJobWithDescription_String() {
    Job myJob = new Job("Clean toilets", "Worker", "myemail");
    assertEquals("Clean toilets", myJob.getDescription());
  }

}
