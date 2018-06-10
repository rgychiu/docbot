package user;

import java.util.Calendar;
import java.util.Date;

public class User {
    private static int id;
    private int age;
    private String name;
    private boolean sex;
    private Ethnicity ethnicity;

    public enum Ethnicity {NATIVE, ASIAN, BLACK, LATINO, PACIFIC, WHITE}

    /**
     * Constructor to create and store a new user.
     */
    public User() {

    }

    /**
     * Method to store user data in file.
     */
    public void storeData() {

    }
}
