package com.labs;

import javax.ejb.Remote;

@Remote
public interface PrintRemote {
    public String sayHello(String name);
}

