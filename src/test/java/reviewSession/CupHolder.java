package reviewSession;

public class CupHolder {

    // Data: Information: e.g. name, email, phone number
    // Data types:

    // 2 types of Data types

    // 1. Primitive Data Type
    // 2. Object/reference Data type

    public static void main(String[] args) {
        String name = "James";
        int age = 34;
        boolean check = false;

        if (age < 35){
            System.out.println("Acdtion taken");

        }else{
            System.out.println("Taking some other action");
        }

        // Loop
        for (int i = 0; i < 5; i++){
            System.out.println("Looping here...");
        }
    }


    // Methods: group of statements that can be put togehter and do certain function
    // method signature
    public void login(String email, String password){
        // write a code here that goes to the app
        // then somehow use here given email and password to login
        System.out.println("login successful");
    }

    // String manipulation: to play around with some string

}
