package com.labs;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;

@Singleton
public class StatisticsBean implements StatisticsRemote {

	private int quantity;
	
    @PostConstruct
    public void init() {
    	quantity = 0;
    	System.out.println("@PostConstruct - starting quantity:"+quantity);
    }
    
    @PreDestroy
    public void shutdown() { 
    	System.out.println("@PreDestroy - shutdown. quantity:"+quantity); 
    }
    
	public int getLoggedUsers() {
		return quantity;
	}
	
	public void addUser(String user) {
		quantity++;
	}
}
