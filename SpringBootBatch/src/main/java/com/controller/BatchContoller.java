package com.controller;



import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="batch")
public class BatchContoller {

	@Autowired
	private JobExplorer explorer;
	
	@Autowired
	private JobLauncher launcher;
	
	@Autowired
	//@Qualifier(value="csvReaderToWriter")
	private Job job;
	
	
	@GetMapping(path="list")
	public String getAllJobs() {
		return explorer.getJobNames().toString();
	}
	
	@GetMapping(path="launchJob")
	public void launchJob() {
		try {
			JobExecution exec =launcher.run(job, new JobParameters());
			System.out.println("Exec is "+exec);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
