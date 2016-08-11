package nl.bos.design_patterns.impl;

import static nl.bos.design_patterns.IConstants.*;

public class SingleObject {
	private static SingleObject instance = new SingleObject();
	
	private SingleObject() {};
	
	public static SingleObject getInstance() {
		return instance;
	}
	
	public void showMessage() {
		System.out.println(STR_HELLO_WORLD);
	}
}
