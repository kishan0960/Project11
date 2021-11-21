/*
 * This program uses the person.bin file to read and write data on it. Using the array it ask user to enter the person's data. 
 * if not file found then it will create new file each time program runs. 
 * With those data it can be printed on output screen, edit it, delete it or you can write new person and save it to the file. 
 * 
 * Assignment# : 11 
 * Name: Kishan Patel
 * Date: 11/13/2021
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author
 */
public class SerializationDriver {

    private static Scanner input;

    /**
     * Helper function used to load array of persons from file
     * @param persons
     * @return
     */
    public static int readAll(Person[] persons) {
        int count = 0;
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("persons.bin"));
            count = inputStream.readInt();
            for (int i = 0; i < count; i++) {
                persons[i] = (Person) inputStream.readObject();
            }
            inputStream.close();

        } catch (IOException ex) {
            System.out.println("Read error");
        } catch (ClassNotFoundException ex) {
            //
            System.out.println("Read error");
        }
        return count;
    }

    /**
     * Helper function used to save array of persons into file
     * @param persons
     * @param count
     */
    public static void saveAll(Person[] persons, int count) {
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("persons.bin"));
            output.writeInt(count);
            for (int i = 0; i < count; i++) {
                output.writeObject(persons[i]);
            }
            output.close();

        } catch (IOException ex) {
            Logger.getLogger(SerializationDriver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Add information into a file
     */
    public static void addInformation() {
        Person[] persons = new Person[100];
        int count = readAll(persons);

        System.out.print("Enter Name           : ");
        String name = input.nextLine();
        System.out.print("Enter Phone Number   : ");
        String phoneNumber = input.nextLine();
        System.out.print("Enter  Date of birth : ");
        String dateOfBirth = input.nextLine();
        System.out.print("Enter  Email Address : ");
        String emailAddress = input.nextLine();
        persons[count++] = new Person(name, phoneNumber, dateOfBirth, emailAddress);
        saveAll(persons, count);
    }

    /**
     * Retrieve information from a file and display them.
     */
    public static void retrieveInformation() {
        Person[] persons = new Person[100];
        int count = readAll(persons);
        for (int i = 0; i < count; i++) {
            System.out.println(persons[i]);
        }
    }

    /**
     *
     */
    public static void deleteInformation() {
        Person[] persons = new Person[100];
        int count = readAll(persons);
        if (count > 0) {
            for (int i = 0; i < count; i++) {
                System.out.println(persons[i]);
            }
            System.out.print("Select person to delete 1-" + count + ": ");
            int index = input.nextInt();
            while (index < 1 || index > count) {
                System.out.print("Select person to delete 1-" + count + ": ");
                index = input.nextInt();
            }
            input.nextLine();// to consume end line
            for (int i = index; i < count; i++) {
                persons[i - 1] = persons[i];
            }
            count--;
            saveAll(persons, count);
        }
    }

    /**
     *
     */
    public static void updateInformation() {
        Person[] persons = new Person[100];
        int count = readAll(persons);
        if (count > 0) {
            for (int i = 0; i < count; i++) {
                System.out.println(persons[i]);
            }
            System.out.print("Select person to update 1-" + count + ": ");
            int index = input.nextInt();
            while (index < 1 || index > count) {
                System.out.print("Select person to update 1-" + count + ": ");
                index = input.nextInt();
            }
            input.nextLine();// to consume end line
            System.out.println("Enter Name           : ");
            String name = input.nextLine();
            System.out.println("Enter Phone Number   : ");
            String phoneNumber = input.nextLine();
            System.out.println("Enter  Date of birth : ");
            String dateOfBirth = input.nextLine();
            System.out.println("Enter  Email Address : ");
            String emailAddress = input.nextLine();
            persons[index - 1] = new Person(name, phoneNumber, dateOfBirth, emailAddress);
            saveAll(persons, count);
        }
    }

    /**
     * menu driven program
     *
     * @param args
     */
    public static void main(String[] args) {
        input = new Scanner(System.in);
        int option;
        int count = 0;
        do {
        	System.out.println("Select from below");
        	System.out.println("-----------------");
            System.out.println("1) Add information into a file.");
            System.out.println("2) Retrieve information from a file and display them.");
            System.out.println("3) Delete information.");
            System.out.println("4) Update information.");
            System.out.println("5) Exit.\n");
            System.out.print("Enter Choice from menu : ");
            option = input.nextInt();
            input.nextLine();// to consume end line
            System.out.print("\n\n");
            switch (option) {
                case 1:
                    addInformation();
                    break;
                case 2:
                    retrieveInformation();
                    break;
                case 3:
                    deleteInformation();
                    break;
                case 4:
                    updateInformation();
                    break;
                case 5:
                    break;
            }
        } while (option != 5);
    }

}
