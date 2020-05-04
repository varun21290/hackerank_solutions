
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;


public class CountTriplets {

    // Complete the countTriplets function below.
	static long countTriplets(List<Long> arr, long r) {
		long count =0,e=0;
		Map <Long,Long> potential = new HashMap<Long,Long>();
		Map <Long,Long> triplet = new HashMap<Long,Long>();
		
		for (int i =0;i<arr.size();i++) {
			e=arr.get(i);
			if(triplet.get(e) != null) { 
				count+=triplet.get(e);
			}
			if(potential.get(e) != null) {
				if(triplet.get(e*r)!=null) triplet.put(e*r, triplet.get(e*r)+potential.get(e));
				else triplet.put(e*r, potential.get(e));
			}
			if(potential.get(e*r)!=null) potential.put(e*r, potential.get(e*r)+1);
			else potential.put(e*r, (long) 1);
			
		}
		
		return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Long::parseLong)
            .collect(toList());

        long ans = countTriplets(arr, r);
        

    	System.out.println(ans);


        bufferedReader.close();
    }
}

