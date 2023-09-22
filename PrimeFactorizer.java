/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package q5;

import java.util.*;
import java.io.*;

/**
 *
 * @author brandonhyppolite
 */
public class PrimeFactorizer {
    int n;
    ArrayList<Integer> primes;
    ArrayList<Integer> exponents;
    Boolean computed = false;
 
  /** 
   * Initialize the object with target number n. 
   * @param n 
   */
  public PrimeFactorizer(int n) {
      this.n = n;
      primes = new ArrayList<Integer>();
      exponents = new ArrayList<Integer>();
  } 
  
  /**
   * Return n, the target number.
   * @return n
   */
  public int getN() {
      return n;
  }
  
  /**
   * Compute factorization. Do not repeat operation if it was called before.
   */
  public void compute() {
      if (computed == true){
          return;
      }
      
      int number = getN();
      
       if (number <= 0) {
           throw new IllegalArgumentException("N must be a positive integer");
       } else if (number == 1) {
            throw new ArithmeticException(" 1 is not a prime number");
          } else{
              for(int i = 2; i <= number; i++) {
                  int exponent = 0;
                  while(number % i == 0 ) {
                      number /= i;
                      exponent++;
                  }
                  if (exponent > 0){
                      primes.add(i);
                      exponents.add(exponent);
                  }
              }
          }
  }
  
  /**
   * Return the factors and exponents in two arraylists. Call compute() first, if necessary.
   * For instance, if n=60, primes=[2,3,5], and exponents=[2,1,1].
   * This function overwrites the 'n' parameter passed to the constructor.
   * @param n
   * @param primes
   * @param exponents
   */
  public void getFactorsAndExponents(int n, ArrayList<Integer> primes, ArrayList<Integer> exponents) {
     if (computed == false | this.n != n) {
         this.n = n;
         computed = false;
         compute();
    }
    
      this.primes = primes;
      this.exponents = exponents;
  }
  
  
  /**
   * Return a string with the "pretty" representation of the prime factorization.
   * For instance, if n is 60, then toString() for the PrimeFactorizer(60) object
   * should be "60 = 2^2*3*5". Call compute() if not done before.
   */
  public String toString() {
    if (computed == false) {
        computed = false;
        compute();
    }
    
    String factorization = "";
    for (int i = 0; i < primes.size(); i++) {
        if (i >= 1) {
            factorization = factorization.concat("*");
        }
        int exp = exponents.get(i);
        if (exp == 1) {
            factorization = factorization.concat("" + primes.get(i));
        }
        else {
            factorization = factorization.concat(primes.get(i) + "^" + exponents.get(i));
        }

    }
    return factorization;
  }

}
