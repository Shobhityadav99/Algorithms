package Graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Remove_Invalid_Parentheses {
	static boolean isParentheses(char c) {
		return ((c=='(')||(c==')'));
	}
	static boolean isValid(String str) {
		int count=0;
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='(')
				count++;
			if(str.charAt(i)==')')
				count--;
			if(count<0)
				return false;
		}
		return (count==0);
	}
	static void RemoveInvalid(String str) {
		if(str.isEmpty())
			return;
		HashSet<String> visit=new HashSet<>();
		Queue<String> q=new LinkedList<>();
		String temp;
		boolean level=false;
		q.add(str);
		visit.add(str);
		while(!q.isEmpty()) {
			str=q.peek();
			q.remove();
			if(isValid(str)) {
				System.out.println(str);
				level=true;
			}
			if(level)
				continue;
			for(int i=0;i<str.length();i++){
				if(!isParentheses(str.charAt(i)))
					continue;
				temp=str.substring(0, i)+str.substring(i+1);
				if(!visit.contains(temp)) {
					q.add(temp);
					visit.add(temp);
				}
			}
		}
		
	}
	public static void main(String[] args) {
		 String expression = "()())()"; 
		 RemoveInvalid(expression); 
		  
		    expression = "()v)"; 
		    RemoveInvalid(expression); 
	}

}
