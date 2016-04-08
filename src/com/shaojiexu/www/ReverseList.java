package com.shaojiexu.www;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReverseList {

	
	
	static class Node {
		
	    private int val;
	    private Node next;

	    private Node(int value) {
	        val = value;
	        next = null;
	    }
	    
	}; 
	
	
	public static Node reverseList(Node list) {
		
		Node focusNode = list;
		Deque<Node> stack = new ArrayDeque<>();
		
		while(focusNode != null) {
			
			stack.push(new Node(focusNode.val));
			focusNode = focusNode.next;
		}
		
		Node reversedList = stack.pop();
		focusNode = reversedList;
		while(!stack.isEmpty()) {
			focusNode.next = stack.pop();
			focusNode = focusNode.next;
		}
		
		return reversedList;


    }
	
	public static void main(String... args){
		
		Node node1 = new Node(12);
		Node node2 = new Node(45);
		Node node3 = new Node(56);
		
		node1.next = node2;
		node2.next = node3;
		
		reverseList(node1);
		
	}

	
}


