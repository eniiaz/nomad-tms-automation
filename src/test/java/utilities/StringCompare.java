package utilities;

public class StringCompare {

    // useful method that can compare 2 strings
    // method doesn't have to have an object.
    // Static: this means it belongs to the class not to Object
    public static boolean compare(String s1, String s2){
        s1 = s1.trim().toLowerCase();
        s2 = s2.trim().toLowerCase();

        if (s1.equals(s2)){
            return true;
        }else{
            return false;
        }
    }


}
