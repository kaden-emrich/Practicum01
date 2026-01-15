import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int age;

        age = SafeInput.getInt(in, "Enter age");

        System.out.println("You entered " + age + " years old");
    }
}