package utilities;

import com.github.javafaker.Faker;

import java.util.Random;

public class UtilityTester {

    public static void main(String[] args) {
        String name1 = "James ";
        String name2 = "jame";

        System.out.println(StringCompare.compare(name1, name2));

        Random random = new Random();
        System.out.println(random.nextInt(0, 1000));

        Faker faker = new Faker();

        System.out.println(faker.name().fullName());
        System.out.println(faker.address().fullAddress());


    }

}
