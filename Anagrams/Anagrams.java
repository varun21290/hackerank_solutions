import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class anagrams {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
    	
    	HashMap<Integer, String []> substringsmap = new HashMap<Integer, String []>();
    	
    	String substrings[] = new String[s.length()];
    	char c [] = s.toCharArray();
    	int i =0,j=0,k=0,anagramcount=0;
    	
    	for (i = 0;i< s.length();i++) substrings[i] = Character.toString(c[i]);
    	
    	substringsmap.put(1,substrings);
    	
    	
    	for (i = 2;i < s.length();i++) {
    		j = 0;
    		substrings = new String[s.length()-i+1];
    		for (k =0;k<s.length()-i+1;k++) {
    			substrings[j] = slice(c,k,i);
    			j=j+1;
    		}
    		substringsmap.put(i,substrings);
    	}
    	
    	for (Map.Entry<Integer, String[]> entry : substringsmap.entrySet()) {
    		int key=entry.getKey();
    		substrings=entry.getValue();
    		for (i=0;i<substrings.length;i++) {
    			for (k=i+1;k<substrings.length;k++) {
    				if(substrings[i].equals(substrings[k])) {
    					anagramcount=anagramcount+1;
    				}
    			}
    		}
    		
    	}
    	
    	
		return anagramcount;
    }
    
    static String slice(char[] c,int from, int count) {
    	String s = null;
    	char slice[] = new char[count];
    	for (int i = 0;i<count;i++) slice[i] = c[from + i];
    	Arrays.sort(slice);
    	s = new String(slice);
    	return s;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);
            
            System.out.println(String.valueOf(result));
        }

        scanner.close();
    }
}
