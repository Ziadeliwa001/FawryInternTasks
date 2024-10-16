import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;


public class Main {
    public static void main(String[] args) {

        // Assigning Function to variables
        //(a, b) -> a + b;
        BiFunction<Integer, Integer, Integer> add = Integer::sum;
        System.out.println(add.apply(3, 4));


        //Function as Arguments
        Consumer<String> sendWelcomeMail = mail -> System.out.println("MAILING " + mail);
        register("Ziad", sendWelcomeMail);


        //Function as a return type
        Function<Integer, Integer> multiplyBy5 = multiplyBy(5);
        System.out.println(multiplyBy5.apply(10));
    }




    public static void register(String name, Consumer<String> callback) {

        String email = name + "@gmail.com";
        callback.accept(email);
    }



    public static Function<Integer, Integer> multiplyBy(int x) {return y -> x * y;}

}


