import java.util.Random;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;

public class Generate_Password {

    final private String number;
    final private String alpha_lower;
    final private String alpha_upper;
    final private String symbols;
    private String combine_strings;
    private List<Character> string_list = new ArrayList<Character>();
    String password;

    // constructor
    Generate_Password() {
        this.number = "0123456789";
        this.alpha_lower = "abcdefghijklmnopqrstuvwxyz";
        this.alpha_upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        this.symbols = "`~!@#$%^&*-_+=?.,";
        this.combine_strings = this.number + this.alpha_lower + this.alpha_upper + this.symbols;
        this.password = "";
    }

    int input() {
        Scanner scan = new Scanner(System.in);
        int input = 0;
        boolean status = true;
        do {
            try {
                System.out.print("How long is the password? ");
                input = Integer.parseInt(scan.nextLine());
                if (!(input <= 0)) {
                    status = false;
                } else {
                    System.out.println("Invalid number");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number");
                scan.reset();
            }
        } while (status == true);

        scan.close();
        return input;
    }

    void addChar() {
        for (char character : this.combine_strings.toCharArray()) {
            this.string_list.add(character);
        }
    }

    int random_gen() {
        Random rnd = new Random();

        // generate random integer number in range of 0-78
        int random_num = rnd.nextInt(this.combine_strings.length());
        return random_num;
    }

    void shuffleArr() {
        Collections.shuffle(this.string_list);
    }

    void password_gen(int input) {
        addChar();
        for (int i = 0; i < input; i++) {
            int rand = random_gen();
            shuffleArr();
            this.password += Character.toString(this.string_list.get(rand));
        }
    }

    void display() {
        System.out.println("Password is: " + this.password);
    }

}
