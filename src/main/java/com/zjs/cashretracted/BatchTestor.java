package com.zjs.cashretracted;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BatchTestor {

	public static void main(String[] args) throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		System.out.println("Context : ");
		ConfigurableApplicationContext  context = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println("jobLuncher : ");
		JobLauncher jobLauncher =(JobLauncher)context.getBean("jobLuncher");
		System.out.println("job : ");
		Job job=(Job)context.getBean("cashRetractedOperations");
		System.out.println("Lancer Job : ");
		jobLauncher.run(job, new JobParameters());
		context.close();
	}

}
