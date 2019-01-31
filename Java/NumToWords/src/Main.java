
/*
Number letter counts
Problem 17 
If the numbers 1 to 5 are written out in words: 
one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.

If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?


NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters 
and 115 (one hundred and fifteen) contains 20 letters. 
The use of "and" when writing out numbers is in compliance with British usage.

More examples:
1,345,612 = one million, three hundred and forty five thousand, six hundred and twelve
153,200 = one hundred and fifty three thousand, two hundred
*/

import java.util.Scanner;

public class Main {
    private int input1;
    private int input2;

    public static void main(String[] args) {
        new Main().run();
    }

    // constructor
    Main() {
        this.input1 = 0;
        this.input2 = 0;
    }

    // run the program
    private void run() {
        NumToWords num2Words = new NumToWords();

        // read in inputs
        this.readInput(num2Words);

        // set the countIteration from input1
        num2Words.setIteration(this.input1, this.input2);

        // get the count of letters
        for (int i = this.input1; i <= this.input2; i++) {
            num2Words.countNumOfLetters();
        }

        System.out.println("Total word count is: " + num2Words.getWordCount());
    }

    // read in inputs
    private void readInput(NumToWords num2Words) {

        Scanner scan = new Scanner(System.in);

        do {
            System.out.println("If the numbers 1 to 5 are written out in words: one, two,"
                    + "three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.\n"
                    + "Examples of writing number:\n"
                    + "1,345,612 = one million, three hundred and forty five thousand, six hundred and twelve\n"
                    + "153,200 = one hundred and fifty three thousand, two hundre\n\n");

            System.out.print("Please enter the starting integer (between 0 - 9,999,999):  ");
            this.input1 = num2Words.input(scan);

            System.out.print("Please enter the ending integer (between 0 - 9,999,999):  ");
            this.input2 = num2Words.input(scan);

            if (this.input1 > this.input2) {
                System.out.println("PLEASE RE-ENTER!");
                System.out.println("Starting value cannot be greater than Ending value!");
            }
        } while (this.input1 > this.input2);

        scan.close();
    }

}