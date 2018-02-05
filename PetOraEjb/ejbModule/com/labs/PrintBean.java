package com.labs;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Remote
public class PrintBean {//implements PrintRemote {
    public String sayHello(String name) {
    	System.out.println("say hello " + name + " works!");
        return "Hello, "  + name;
    }
    
    @PostConstruct
    public void init() {
    	System.out.println("@PostConstruct PrintBean");
    }
    
    @PreDestroy
    public void shutdown() { System.out.println("@PreDestroy PrintBean"); }
}

