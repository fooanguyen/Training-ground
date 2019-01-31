public class Main {
    public static void main(String[] args) {
        Generate_Password password = new Generate_Password();
        int input = password.input();
        // System.out.println(input);
        password.password_gen(input);
        password.display();
    }

}
