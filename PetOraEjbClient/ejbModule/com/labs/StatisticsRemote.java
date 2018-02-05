package com.labs;

import javax.ejb.Local;
import javax.ejb.Remote;

@Remote
@Local
public interface StatisticsRemote {

	int getLoggedUsers();
	
	void addUser(String user);
    
}
