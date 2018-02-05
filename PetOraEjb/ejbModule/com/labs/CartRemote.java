package com.labs;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface CartRemote {

	void add(String item);

	int getQuantity();

	List<String> getItens();

}