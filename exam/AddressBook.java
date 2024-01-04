package exam;


import java.util.HashMap;
import java.util.Scanner;

public class AddressBook {

    private HashMap<String, Contact> contacts = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);



    public void run() {
        while (true) {
            displayMenu();
            int choice = getChoice();
            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    findContactByName();
                    break;
                case 3:
                    displayContacts();
                    break;
                case 4:
                    System.out.println("Finish!");
                    System.exit(0);
                default:
                    System.out.println("Try Again!");
            }
        }
    }

    private void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Add new contact");
        System.out.println("2. Find a contact by name");
        System.out.println("3. Display contacts");
        System.out.println("4. Exit");
    }

    private int getChoice() {
        System.out.print("Enter your choice: ");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1; // Handle invalid input
        }
    }

    private void addContact() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine();
        Contact contact = new Contact(name, phone);
        contacts.put(name, contact);
        System.out.println("Contact added successfully!");
    }

    private void findContactByName() {
        System.out.print("Enter name to search: ");
        String name = scanner.nextLine();
        Contact contact = contacts.get(name);
        if (contact != null) {
            System.out.println("Name: " + contact.getName());
            System.out.println("Phone Number: " + contact.getPhone());
        } else {
            System.out.println("Contact not found.");
        }
    }

    private void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
        } else {
            System.out.println("Address Book:");
            for (Contact contact : contacts.values()) {
                System.out.println("Name: " + contact.getName());
                System.out.println("Phone Number: " + contact.getPhone());
                System.out.println("-------------------");
            }
        }
    }
}



