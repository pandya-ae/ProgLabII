package plo;

import java.util.LinkedList; 
import java.util.Queue; 

public class PLO 
{  
	static class Node 
	{ 
		int data; 
		Node left; 
		Node right; 
		
		Node(int data){ 
			this.data = data; 
			left = null; 
			right =null; 
		} 
	} 
	
	public static void printLevelOrder(Node root) 
	{  
		if(root == null) 
			return; 
		 
		Queue<Node> q =new LinkedList<Node>(); 
		
		q.add(root); 
		
		
		while(true) 
		{ 
			
			int nodeCount = q.size(); 
			if(nodeCount == 0) 
				break; 
			
			while(nodeCount > 0) 
			{ 
				Node node = q.peek(); 
				System.out.print(node.data + " "); 
				q.remove(); 
				if(node.left != null) 
					q.add(node.left); 
				if(node.right != null) 
					q.add(node.right); 
				nodeCount--; 
			} 
			System.out.println(); 
		} 
	} 
	
	public static void main(String[] args) 
	{ 
		
		Node root = new Node(54); 
		root.left = new Node(31); 
		root.right = new Node(78); 
		root.left.left = new Node(20);
                root.left.left.left = new Node(14);
                root.left.left.right = new Node(22);
		root.left.right = new Node(49);
                root.left.right.left = new Node(35);
                root.left.right.right = new Node(52);
		root.right.left = new Node(65);
                root.right.left.left = new Node(60);
                root.right.left.right = new Node(70);
                root.right.right = new Node(89);
                root.right.right.left = new Node(80);
                root.right.right.right = new Node(100);
		
		printLevelOrder(root); 
	} 
} 