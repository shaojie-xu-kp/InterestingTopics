package com.shaojie.www.designpattern.observer;

import java.util.Observable;

public class Blackboard extends Observable {

	private String message;

	public String getMessage() {
		return message;
	}

	public void changeMessage(String message) {
		this.message = message;
		this.setChanged();
		notifyObservers(message);
	}

	public static void main(String[] args) {
		Blackboard board = new Blackboard();
		Student bob = new Student();
		Student joe = new Student();
		board.addObserver(bob);
		board.addObserver(joe);
		board.changeMessage("More Homework!");
	}

}
