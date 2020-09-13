package Graphs;
import java.util.*;
public class WordLadder {
	static int shortestChain(String start,String target,Set<String> D) {
		if(!D.contains(target))
			return 0;
		int level=0;
		int length=start.length();
		Queue<String> q=new LinkedList<String>();
		q.add(start);
		while(!q.isEmpty()) {
			++level;
			int sizeq=q.size();
			for(int i=0;i<sizeq;i++) {
				char word[]=q.peek().toCharArray();
				q.remove();
				for(int pos=0;pos<length;pos++) {
					char orig=word[pos];
					for(char c='a';c<='z';c++) {
						word[pos]=c;
						if(String.valueOf(word).equals(target))
							return level+1;
						if(!D.contains(String.valueOf(word)))
							continue;
						D.remove(String.valueOf(word));
						q.add(String.valueOf(word));
					}
					word[pos]=orig;
				}
			}
		}
		return 0;
	}
	public static void main(String[] args) {
		 Set<String> D = new HashSet<String>(); 
		    D.add("poon"); 
		    D.add("plee"); 
		    D.add("same"); 
		    D.add("poie"); 
		    D.add("plie"); 
		    D.add("poin"); 
		    D.add("plea"); 
		    String start = "toon"; 
		    String target = "plea"; 
		    System.out.print("Length of shortest chain is: " + shortestChain(start, target, D)); 
	}
}