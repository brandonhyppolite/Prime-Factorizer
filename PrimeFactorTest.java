/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package q5;

import java.util.*;

/**
 *
 * @author brandonhyppolite
 */
public class PrimeFactorTest {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number you want to factor: ");
        
        try {
            int n = sc.nextInt();
            PrimeFactorizer primenum = new PrimeFactorizer(n);
            System.out.println(primenum);
        } catch (InputMismatchException | IllegalArgumentException e) {
            System.out.println("Error, must be a positive non-zero integer.");
            System.exit(1);
        } catch (ArithmeticException e) {
            System.out.println("1 is neither prime nor composite.");
            System.exit(1);
        }
    }
    
}
