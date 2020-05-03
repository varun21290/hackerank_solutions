import java.io.*;
import java.util.*;

public class minimumBribes {


	    // Complete the minimumBribes function below.
	    static void findMinimumBribes(int[] q) {
	        int swaps=0,flag=0,n_move=0;
	        for(int i = 0;i<q.length;i++){
	            if(q[i]-i-1>2){
	                flag=1;
	                break;
	            }
	            else{
	                n_move=0;
	                for(int j=max(0,q[i]-2);j<i;j++){
	                    if(q[j]>q[i]) n_move=n_move+1;
	                }
	                if(q[i]>i+1) swaps=swaps+q[i]-i-1;
	                else {
	                    if(q[i]+n_move>i+1) swaps = swaps+q[i]+n_move-i-1;
	                    else continue;
	                }
	                
	            }
	        }
	        if(flag==1) System.out.println("Too chaotic");
	        else System.out.println(swaps);

	    }
	    
	    static int max(int a,int b) {
	    	if(a>=b) return a;
	    	else return b;
	    }

	    private static final Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) {
	        int t = scanner.nextInt();
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        for (int tItr = 0; tItr < t; tItr++) {
	            int n = scanner.nextInt();
	            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	            int[] q = new int[n];

	            String[] qItems = scanner.nextLine().split(" ");
	            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	            for (int i = 0; i < n; i++) {
	                int qItem = Integer.parseInt(qItems[i]);
	                q[i] = qItem;
	            }

	            findMinimumBribes(q);
	        }

	        scanner.close();
	    }
	}
