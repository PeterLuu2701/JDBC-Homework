package crm08.service;

import java.util.List;

import crm08.repository.JobRepository;
import entity.JobEntity;

public class JobServices {
	private JobRepository jobRepository = new JobRepository();
		
		public List<JobEntity> getJob(){
			List<JobEntity> job = jobRepository.findAll();
			
			return job;
		}
		
		public boolean insertJob(String name, String start_date, String end_date) {
			return jobRepository.insertJob(name, start_date, end_date) > 0;
	    }
		
}
