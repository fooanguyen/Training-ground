import java.util.Scanner;

public class NumToWords {

    private int wordCount;
    private int startIteration;
    //private int endIteration;

    final private int MILLION;
    final private int THOUSAND;
    final private int HUNDRED;
    final private int TEN;

    // constructor
    NumToWords() {
        this.wordCount = 0;
        this.startIteration = 0;
        //this.endIteration = 0;

        this.MILLION = 1000000;
        this.THOUSAND = 1000;
        this.HUNDRED = 100;
        this.TEN = 10;
    }

    public int getWordCount() {
        return this.wordCount;
    }

    // set iterations
    public void setIteration(int input1, int input2) {
        this.startIteration = input1;
        //this.endIteration = input2;
    }

    // increment count for each iteration
    private int incrementCount() {
        return this.startIteration++;
    }

    // return inputs from user prompt
    public int input(Scanner scan) {
        int input = 0;
        boolean status = true;
        do {
            try {
                input = Integer.parseInt(scan.nextLine());
                if (!(input < 0 || input > 9999999)) {
                    status = false;
                } else {
                    System.out.println("Invalid number");
                    System.out.print("Please re-enter:  ");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number");
                System.out.print("Please re-enter:  ");
                scan.reset();
            }
        } while (status == true);

        return input;
    }

    // count the letters
    public void countNumOfLetters() {
        String numWord = "";
        int index = 0;
        int remainder = this.startIteration;

        // 0-9
        if (remainder < this.TEN) {
            index = remainder % this.TEN;
            remainder = remainder - index;
            EnumData.Ones oneVal = EnumData.Ones.values()[index];
            numWord += oneVal.toString();
        } else {
            // 9,999,999 -> nine million
            if (remainder >= this.MILLION) {
                // set the starting value of million
                index = remainder / this.MILLION;
                EnumData.Ones oneVal = EnumData.Ones.values()[index];
                numWord += oneVal.toString();

                // set the million word
                EnumData.ByPower milVal = EnumData.ByPower.million;
                numWord += milVal.toString();

                // set remainder
                remainder = this.startIteration - (index * this.MILLION);

            }

            if (remainder >= this.THOUSAND) {
                // 999,999
                if ((remainder / this.THOUSAND) >= this.HUNDRED) {
                    index = remainder / (this.HUNDRED * this.THOUSAND);
                    EnumData.Ones oneVal = EnumData.Ones.values()[index];
                    numWord += oneVal.toString();

                    EnumData.ByPower hundredVal = EnumData.ByPower.hundred;
                    numWord += hundredVal.toString();

                    // set remainder
                    remainder = remainder - (index * this.HUNDRED * this.THOUSAND);

                    if (remainder > 0) {
                        numWord += "and";
                    }
                }

                // 99,999
                if ((remainder / this.THOUSAND) >= this.TEN) {
                    if ((remainder / this.THOUSAND) >= (this.TEN * 2)) {
                        index = remainder / (this.TEN * this.THOUSAND);
                        EnumData.ByTen TenVal = EnumData.ByTen.values()[index];
                        numWord += TenVal.toString();
                        remainder = remainder - (index * this.TEN * this.THOUSAND);
                    } else if ((remainder / this.THOUSAND) < (this.TEN * 2)
                            && (remainder / this.THOUSAND) >= this.TEN) {
                        index = remainder / this.THOUSAND;
                        remainder = remainder - (index * this.THOUSAND);
                        index = index - this.TEN;
                        EnumData.Twos twosVal = EnumData.Twos.values()[index];
                        numWord += twosVal.toString();
                    }

                }

                // 9,999
                if ((remainder / this.THOUSAND) < this.TEN && (remainder / this.THOUSAND) > 0) {
                    index = remainder / this.THOUSAND;
                    EnumData.Ones oneVal = EnumData.Ones.values()[index];
                    numWord += oneVal.toString();
                    remainder = remainder - (index * this.THOUSAND);
                }

                EnumData.ByPower thousandVal = EnumData.ByPower.thousand;
                numWord += thousandVal.toString();
            }

            // 999
            if (remainder >= this.HUNDRED) {
                index = remainder / this.HUNDRED;
                EnumData.Ones oneVal = EnumData.Ones.values()[index];
                numWord += oneVal.toString();

                EnumData.ByPower hundredVal = EnumData.ByPower.hundred;
                numWord += hundredVal.toString();

                // set remainder
                remainder = remainder - (index * this.HUNDRED);

                if (remainder > 0) {
                    numWord += "and";
                }
            }

            // 99
            if (remainder >= this.TEN) {
                if (remainder >= (this.TEN * 2)) {
                    index = remainder / this.TEN;
                    EnumData.ByTen TenVal = EnumData.ByTen.values()[index];
                    numWord += TenVal.toString();
                    remainder = remainder - (index * this.TEN);
                } else if (remainder < (this.TEN * 2) && (remainder >= this.TEN)) {
                    index = remainder;
                    remainder = remainder - index;
                    index = index - this.TEN;
                    EnumData.Twos twosVal = EnumData.Twos.values()[index];
                    numWord += twosVal.toString();
                }
            }

            // 9
            if (remainder < this.TEN && remainder > 0) {
                index = remainder % this.TEN;
                remainder = remainder - index;
                EnumData.Ones oneVal = EnumData.Ones.values()[index];
                numWord += oneVal.toString();
            }
        }

        // add to word count
        this.wordCount += numWord.length();
        // System.out.println("word: " + numWord);
        // System.out.println("wordCount: " + this.wordCount);
        // System.out.println("remainder: " + remainder);

        // System.out.println("startIteration: " + this.startIteration);
        this.incrementCount();
        // System.out.println("startIteration increment: " + this.startIteration);

        // recursion approach---bad practice---causes overflow
        /*
         * if (this.startIteration <= this.endIteration) { this.countNumOfLetters(); }
         */

    }
}