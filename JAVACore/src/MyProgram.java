import java.util.Arrays;

public class MyProgram {
    public static void main(String[] args) {
//        System.out.println("hello java ");
//        System.out.println("Total = " + 5 + 7);

        System.out.println(" The number of arguments is " + args.length);
        for(int i = 0 ; i < args.length; i++){
            System.out.println(" Value at " + i + " is " + args[i]);
        }
        System.out.println("length of arguments");

        Arrays.stream(args).forEach((String value) -> {
            System.out.println("Value is " + value);
        });
    }
}
