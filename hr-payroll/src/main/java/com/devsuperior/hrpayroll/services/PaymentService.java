package com.devsuperior.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.hrpayroll.entities.Payment;
import com.devsuperior.hrpayroll.entities.Worker;
import com.devsuperior.hrpayroll.feignclients.WorkerFeignClients;

@Service
public class PaymentService {
	
	@Autowired
	private WorkerFeignClients workerFeignClient;
	
	public Payment getPayments(long workerId, int days) {

		Worker worker = workerFeignClient.findById(workerId).getBody();
		
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
