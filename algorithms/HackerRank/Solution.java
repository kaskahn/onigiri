import java.io.*;
import java.util.*;
import java.math.*;
/**
 * 
 * Find if a given number is a Fibonacci.
 * 1st line - total number of test cases
 * Remaining - the test cases
 * #hackerRank problem
 * 18
8341170321
2370416826
49796557
5937368629
1397237810
6067799625
4946561131
7571837992
1599236396
8426627685
3111072649
7938064811
7047702685
8183472175
5113131111
4660962706
650547201
9253734625
 * @author Abhishek
 *
 */

public class Solution {
    static Set<BigInteger> fiboList = new TreeSet<BigInteger>();
    static BigInteger beforeLast;
    static BigInteger last;
    static{
    	beforeLast = new BigInteger("0");
    	last = new BigInteger("1");
    	fiboList.add(beforeLast);
    	fiboList.add(last);
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine().trim());
        for(int i=0; i<total;i++){
            BigInteger t = new BigInteger(br.readLine().trim());
            System.out.println(isFibo(t));
        }
        br.close();
    }
    public static String isFibo(BigInteger t){
       if(fiboList.contains(t)){
           return "IsFibo";
       } 
       if(t.compareTo(last) < 0){
           return "IsNotFibo";
       }
       boolean exit = false;
       while(!exit){
           BigInteger next = beforeLast.add(last);
           beforeLast = last;
           last = next;
           fiboList.add(next);
           if (next.compareTo(t) == 0){
               return "IsFibo";
           }
           if(t.compareTo(next) < 0){
               return "IsNotFibo";
           }
       }
       return null;
    }
}