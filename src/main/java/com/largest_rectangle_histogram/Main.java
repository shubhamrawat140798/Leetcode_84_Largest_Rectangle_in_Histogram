package com.largest_rectangle_histogram;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
/**
 * for taking input from user.
 * And passing input value to method.
 * to finding out the largest rectangle area in the histogram.
 */
final class Main {
    /**
     * for taking input from user.
     * @param args for taking input from command line.
     */
    public static void main(final String[] args) {
       try (Scanner scanner = new Scanner(System.in)) {
           final List<Integer> histogram = new ArrayList<>();
           final AreaOfRectangle areaOfRectangle = new AreaOfRectangle();
           char choice = 'y';
           int serialNoOfHistogram = 1;
           while (choice == 'y') {
               System.out.print("\nEnter the " + serialNoOfHistogram + ": ");
               histogram.add(scanner.nextInt());
               System.out.print("\nDo you want to continue? y/n: ");
               choice = scanner.next().charAt(0);
               while (choice != 'y' && choice != 'n') {
                   System.out.print("\nWrong Input: " + choice);
                   System.out.print("\nDo you want to continue? y/n: ");
                   choice = scanner.next().charAt(0);
               }
               serialNoOfHistogram++;
           }
           System.out.print("Maximum area of rectangle is: "
                   + areaOfRectangle.getLargestRectangleArea(histogram));
       } catch (InputMismatchException exception) {
           System.out.println("Wrong Input type : Enter interger.\n"
                   + exception);
       } catch (Exception exception) {
           System.out.println("Exception occur:\n" + exception);
       }
    }
    private Main() {
        // to remove:
        // Utility classes should not have a public or default constructor.
    }
}
