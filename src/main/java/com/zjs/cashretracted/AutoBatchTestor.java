package com.zjs.cashretracted;

import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutoBatchTestor {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		System.out.println("Context : ");
		ClassPathXmlApplicationContext  context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
	}

}
