package com.shaojie.www.designpattern.observer;

import java.util.Observable;
import java.util.Observer;

public class Student implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		if((o instanceof Blackboard)){
			Blackboard bb = (Blackboard)o;
			System.out.println("Message board changed: " + bb.getMessage());
		}
			
	}

}
