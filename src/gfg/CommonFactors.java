package gfg;

import java.util.Scanner;

public class CommonFactors {

  static int gcd(int a, int b) {
    if (a == 0)
      return b;

    return gcd(b % a, a);
  }

  public static void main(String args[]) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        */
    //Scanner
    Scanner s = new Scanner(System.in);
    String numbers = s.nextLine();                 // Reading input from STDIN
    String[] numArray = numbers.split(" ");
    Integer a = Integer.parseInt(numArray[0]);
    Integer b = Integer.parseInt(numArray[1]);

    Integer min = Math.min(a, b);
    int result = 0;
    int gcdVal = gcd(a, b);

    for (int i = 1; i <= Math.sqrt(gcdVal); i++) {
      // if 'i' is factor of n
      if (gcdVal % i == 0) {
        // check if divisors are equal
        if (gcdVal / i == i)
          result += 1;
        else
          result += 2;
      }
    }

    System.out.println(result);

    // Write your code here

  }

}
