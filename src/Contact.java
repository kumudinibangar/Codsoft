import java.util.ArrayList;
import java.util.Scanner;
class Contact {
    private String name;
    private String age;
    private String phoneNumber;
    private String emailAddress;
    public Contact(String name, String age, String phoneNumber, String emailAddress) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }
    public String getName() {
        return name;
    }
    public String getage(){
        return age;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getEmailAddress() {
        return emailAddress;
    }
    public String toString() {
        return "Name: " + name + "\nAge:" + age + "\nPhone Number: " + phoneNumber + "\nEmail: " + emailAddress;
    }
}
class AddressBook {
    private ArrayList<Contact> contacts;

    public AddressBook() {
        contacts = new ArrayList<>();
    }
    public void addContact(Contact contact) {
        contacts.add(contact);
    }
    public void removeContact(Contact contact) {
        contacts.remove(contact);
    }
    public Contact searchContact(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                return contact;
            }
        }
        return null;
    }
    public void displayAllContacts() {
        for (Contact contact : contacts) {
            System.out.println(contact);
            System.out.println("---------------------------");
        }
    }
}
class AddressBookApp {
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Address Book Menu:");
            System.out.println("1. Add Contact");
            System.out.println("2. Remove Contact");
            System.out.println("3. Search Contact");
            System.out.println("4. Display All Contacts");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter age: ");
                    String age = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter email address: ");
                    String emailAddress = scanner.nextLine();
                    Contact newContact = new Contact(name, age, phoneNumber, emailAddress);
                    addressBook.addContact(newContact);
                    System.out.println("Contact added.");
                    break;
                case 2:
                    System.out.print("Enter the name of the contact to remove: ");
                    String removeName = scanner.nextLine();
                    Contact contactToRemove = addressBook.searchContact(removeName);
                    if (contactToRemove != null) {
                        addressBook.removeContact(contactToRemove);
                        System.out.println("Contact removed.");
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter the name of the contact to search: ");
                    String searchName = scanner.nextLine();
                    Contact searchedContact = addressBook.searchContact(searchName);
                    if (searchedContact != null) {
                        System.out.println("Contact found:\n" + searchedContact);
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;
                case 4:
                    addressBook.displayAllContacts();
                    break;
                case 5:
                    System.out.println("Exiting Address Book. Thank you!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}