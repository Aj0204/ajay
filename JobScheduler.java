package wiprotraining;

	import java.util.ArrayList;
	import java.util.Collections;
	import java.util.List;

	public class JobScheduler {

	  public static class Job {
	    int Id;
	    int Deadline;
	    int Profit;

	    public Job(int id, int deadline, int profit) {
	      this.Id = id;
	      this.Deadline = deadline;
	      this.Profit = profit;
	    }

	    @Override
	    public String toString() {
	      return "Job[Id=" + Id + ", Deadline=" + Deadline + ", Profit=" + Profit + "]";
	    }
	  }

	  public static List<Job> jobSequencing(List<Job> jobs) {
	    Collections.sort(jobs, (a, b) -> b.Profit - a.Profit);
	    int maxDeadline = 0;
	    for (Job job : jobs) {
	      if (job.Deadline > maxDeadline) {
	        maxDeadline = job.Deadline;
	      }
	    }
	    Job[] result = new Job[maxDeadline + 1];
	    boolean[] slot = new boolean[maxDeadline + 1];
	    for (Job job : jobs) {
	      for (int j = Math.min(maxDeadline, job.Deadline); j > 0; j--) {
	        if (!slot[j]) {
	          slot[j] = true;
	          result[j] = job;
	          break;
	        }
	      }
	    }
	    List<Job> jobSequence = new ArrayList<>();
	    for (int i = 1; i <= maxDeadline; i++) {
	      if (slot[i]) {
	        jobSequence.add(result[i]);
	      }
	    }

	    return jobSequence;
	  }

	  public static void main(String[] args) {
	    List<Job> jobs = new ArrayList<>();
	    jobs.add(new Job(1, 2, 100));
	    jobs.add(new Job(2, 1, 19));
	    jobs.add(new Job(3, 2, 27));
	    jobs.add(new Job(4, 1, 25));
	    jobs.add(new Job(5, 3, 15));

	    List<Job> jobSequence = jobSequencing(jobs);

	    System.out.println("The job sequence to maximize profit is:");
	    for (Job job : jobSequence) {
	      System.out.println(job);
	    }
	  }
	}
