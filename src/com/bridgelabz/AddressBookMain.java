package com.bridgelabz;

import java.util.*;
import java.util.stream.Collectors;

/*********************************************************************
 * Purpose: Class for Address Book .
 *
 * @author Rohit Bansod
 * @version 1.0
 * @since 06-04-2022
 *
 **********************************************************************/
public class AddressBookMain {
    private static final Scanner scanner = new Scanner(System.in);
    private static final AddressBook addressBookValue = new AddressBook();

    private static final AddressBookMain addressBookMain = new AddressBookMain();
    private final Map<String, AddressBook> addressBookSystem = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program\n");

        addressBookMain.addContacts();

    }

    public void addContacts() {

        System.out.println("Enter your choice");
        System.out.println(
                "1 : Add new contact    2 : Edit contact  3 : Delete contact  4: Add Multiple Contacts 5: Display Contacts 6: Search Person 7: Person with City and State"
                        + " 8: Count person by city and state 9: Sorted Person's by alphabetically in Address Book 10: Sorted Person's by alphabetically by City State And Zip Code");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:

                List<Contact> contacts = new ArrayList<>();
                System.out.println("Enter Your Address Book name ");
                String addresBookname = scanner.next();

                System.out.println("Enter the First Name");
                String firstName = scanner.next();

                System.out.println("Enter the Last Name");
                String lastName = scanner.next();

                System.out.println("Enter the Address Name");
                String address = scanner.next();

                System.out.println("Enter the City Name");
                String city = scanner.next();

                System.out.println("Enter the State Name");
                String state = scanner.next();

                System.out.println("Enter the Zip Name");
                int zip = scanner.nextInt();

                System.out.println("Enter the PhoneNumber");
                long phoneNumber = scanner.nextLong();

                System.out.println("Enter the email");
                String email = scanner.next();

                Contact contact = new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email);
                contacts.add(contact);
                addressBookValue.setContacts(contacts);
                addressBookSystem.put(addresBookname, addressBookValue);
                addressBookMain.addContacts();

                break;
            case 2:
                System.out.println("Enter Your Address Book name ");
                String findAddressBook = scanner.next();

                System.out.println("Enter the name of user to Edit");
                String nameToEdit = scanner.next();

                System.out.println("Enter the First Name");
                String editFirstName = scanner.next();

                System.out.println("Enter the Last Name");
                String editLastName = scanner.next();

                System.out.println("Enter the Address Name");
                String editAddress = scanner.next();

                System.out.println("Enter the City Name");
                String editCity = scanner.next();

                System.out.println("Enter the State Name");
                String editState = scanner.next();

                System.out.println("Enter the Zip Name");
                int editZip = scanner.nextInt();

                System.out.println("Enter the PhoneNumber");
                long editPhoneNumber = scanner.nextLong();

                System.out.println("Enter the email");
                String editEmail = scanner.next();
                addressBookMain.editContact(findAddressBook, nameToEdit, editFirstName, editLastName, editAddress, editCity,
                        editState, editZip, editPhoneNumber, editEmail);
                addressBookMain.addContacts();

            case 3:
                System.out.println("Enter Your Address Book name ");
                String yourBookname = scanner.next();
                System.out.println("Enter the person Name");
                String deletename = scanner.next();

                addressBookMain.deleteContactDetails(deletename, yourBookname);
                addressBookMain.addContacts();
                break;
            case 4:

                addressBookMain.addMultipleContacts();
                addressBookMain.addContacts();
                break;
            case 5:
                addressBookMain.displayContacts(addressBookSystem);
                addressBookMain.addContacts();
                break;

            case 6:
                System.out.println("Search the person in perticular city or state ");
                System.out.println("Please Enter the City Name ");
                String cityname = scanner.next();
                System.out.println("Please Enter the State Name ");
                String statename = scanner.next();
                addressBookMain.searchPerson(cityname, statename);
                addressBookMain.addContacts();
                break;
            case 7:
                viewCityAndPersonAsWellAsStateAndPerson();
                addressBookMain.addContacts();
                break;
            case 8:
                addressBookMain.numberOfContactsCountByCityAndState();
                addressBookMain.addContacts();
                break;
            case 9:
                addressBookMain.sortEntriesInAddressBookByName();
                addressBookMain.addContacts();
                break;
            case 10:
                addressBookMain.sortEntriesInAddressBookByCitySateAndZip();
                addressBookMain.addContacts();

                break;
            default:
                System.out.println("Please Enter correct choice");
        }

    }

    public void editContact(String findAddressBook, String name, String editFirstName, String editLastName,
                            String editAddress, String editCity, String editState, int editZip, long editPhoneNumber,
                            String editEmail) {

        AddressBook addressbook = new AddressBook();

        AddressBook addressBookDetails = addressBookSystem.get(findAddressBook);
        List<Contact> contactDetails = addressBookDetails.getContacts();
        for (int i = 0; i <= contactDetails.size() - 1; i++) {

            Contact contactPerson = contactDetails.get(i);
            if (contactPerson.getFirstName().equals(name)) {

                contactPerson.setFirstName(editFirstName);
                contactPerson.setLastName(editLastName);
                contactPerson.setAddress(editAddress);
                contactPerson.setCity(editCity);
                contactPerson.setPhoneNumber(editPhoneNumber);
                contactPerson.setState(editState);
                contactPerson.setZip(editZip);
                contactPerson.setEmail(editEmail);
                contactDetails.set(i, contactPerson);
                addressbook.setContacts(contactDetails);
                addressBookSystem.put(findAddressBook, addressbook);
            }
        }
        addressBookMain.displayContacts(addressBookSystem);
    }

    public void displayContacts(Map<String, AddressBook> addressBookSystem) {

        for (Map.Entry<String, AddressBook> set : addressBookSystem.entrySet()) {

            AddressBook values = set.getValue();
            List<Contact> contactDetails = values.getContacts();

            for (int i = 0; i <= contactDetails.size() - 1; i++) {
                Contact contactPerson = contactDetails.get(i);
                if (!contactPerson.getFirstName().equals("")) {

                    System.out.println("Contact Details :");
                    System.out.println("Book  Name --- " + set.getKey());
                    System.out.println("FirstName :" + contactPerson.getFirstName() + "      LastName :"
                            + contactPerson.getLastName() + "     Address :" + contactPerson.getAddress()
                            + "      City :" + contactPerson.getCity() + "       State :" + contactPerson.getState()
                            + "     Zip :" + contactPerson.getZip() + "     Phone Number :"
                            + contactPerson.getPhoneNumber());
                } else {

                    System.out.println("No Contact Details available :");
                }
            }
        }

    }

    public void deleteContactDetails(String name, String yourBookName) {

        AddressBook addressbook = new AddressBook();

        AddressBook values = addressBookSystem.get(yourBookName);
        List<Contact> contactDetails = values.getContacts();

        for (int i = 0; i <= contactDetails.size() - 1; i++) {
            Contact contactPerson = contactDetails.get(i);
            if (contactPerson.getFirstName().equals(name)) {
                contactDetails.remove(i);
                addressbook.setContacts(contactDetails);
                addressBookSystem.put(yourBookName, addressbook);
            }
        }

        System.out.println("Contact deleted Successfully");
    }

    public void addMultipleContacts() {

        List<Contact> contacts = new ArrayList<>();
        System.out.println("Enter Your Address Book name ");
        String findAddressBook = scanner.next();

        System.out.println("Enter the First Name");
        String firstName = scanner.next();

        System.out.println("Enter the Last Name");
        String lastName = scanner.next();

        System.out.println("Enter the Address Name");
        String address = scanner.next();

        System.out.println("Enter the City Name");
        String city = scanner.next();

        System.out.println("Enter the State Name");
        String state = scanner.next();

        System.out.println("Enter the Zip Name");
        int zip = scanner.nextInt();

        System.out.println("Enter the PhoneNumber");
        long phoneNumber = scanner.nextLong();

        System.out.println("Enter the email");
        String email = scanner.next();
        Contact contact = new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email);
        contacts.add(contact);

        addToOurAddressBook(contact, findAddressBook);

        System.out.println("Do you want add one more Contact Details");
        System.out.println("1 :Yes     2 :No");
        int choice = scanner.nextInt();
        switch (choice) {

            case 1:
                addressBookMain.addMultipleContacts();
                break;
            case 2:
                addressBookMain.displayContacts(addressBookSystem);
                addressBookMain.addContacts();
                break;
            default:
                System.out.println("Please Enter correct choice");

        }

        addressBookMain.displayContacts(addressBookSystem);
        addressBookMain.addContacts();

    }

    public void addToOurAddressBook(Contact contact, String addressBookName) {
        List<Contact> contactsLis = new ArrayList<>();
        AddressBook AddressValues = new AddressBook();
        boolean isKeyPresent = addressBookSystem.containsKey(addressBookName);
        if (isKeyPresent) {
            AddressBook values = addressBookSystem.get(addressBookName);
            List<Contact> contactDetails = values.getContacts();
            boolean isPresent = contactDetails.stream()
                    .anyMatch(con -> con.getFirstName().equals(contact.getFirstName()));
            if (isPresent) {

                System.out.println("This person name already present");

            } else {
                contactDetails.add(contact);
                values.setContacts(contactDetails);
                addressBookSystem.put(addressBookName, values);
            }

        } else {
            contactsLis.add(contact);
            AddressValues.setContacts(contactsLis);
            addressBookSystem.put(addressBookName, AddressValues);
        }
    }

    public void searchPerson(String cityName, String stateName) {
        List<Contact> contactsList = new ArrayList<>();
        for (Map.Entry<String, AddressBook> set : addressBookSystem.entrySet()) {
            AddressBook addressBook = set.getValue();
            contactsList = addressBook.getContacts();
            boolean isPresent = contactsList.stream()
                    .anyMatch(con -> con.getCity().equals(cityName) || con.getState().equals(stateName));
            if (isPresent) {
                contactsList.stream().filter(s -> s.getCity().equals(cityName) || s.getState().equals(stateName))
                        .sorted().forEachOrdered(conts -> System.out.println("User name :" + conts.getFirstName()));

            } else {

                System.out.println("This peson not present in this city or state");
            }

        }
    }

    public void viewCityAndPersonAsWellAsStateAndPerson() {
        List<Contact> contactsList = new ArrayList<>();
        for (Map.Entry<String, AddressBook> set : addressBookSystem.entrySet()) {
            AddressBook addressBook = set.getValue();
            contactsList = addressBook.getContacts();
            System.out.println("Person Name and His/her city");
            contactsList.stream()
                    .forEachOrdered(con -> System.out.println(con.getFirstName() + "     " + con.getCity()));
            System.out.println("Person Name and His/her State");
            contactsList.stream()
                    .forEachOrdered(con -> System.out.println(con.getFirstName() + "     " + con.getState()));
        }

    }

    public void numberOfContactsCountByCityAndState() {
        List<Contact> contactsList = new ArrayList<>();
        for (Map.Entry<String, AddressBook> set : addressBookSystem.entrySet()) {
            AddressBook addressBook = set.getValue();
            contactsList = addressBook.getContacts();
            Map<Object, Integer> list = contactsList.parallelStream()
                    .collect(Collectors.toConcurrentMap(w -> w.getCity(), w -> 1, Integer::sum));
            Map<Object, Integer> state = contactsList.parallelStream()
                    .collect(Collectors.toConcurrentMap(w -> w.getState(), w -> 1, Integer::sum));
            System.out.println("City Name" + list.keySet() + ":  Number of persons in City " + list.values()
                    + "        State Name" + state.keySet() + ":  Number of persons in State " + state.values());

        }

    }

    public void sortEntriesInAddressBookByName() {
        List<Contact> contactsList = new ArrayList<>();
        for (Map.Entry<String, AddressBook> set : addressBookSystem.entrySet()) {
            AddressBook addressBook = set.getValue();
            contactsList = addressBook.getContacts();
            System.out.println("Sorted Person's by alphabetically in Address Book");
            List<Contact> sortedList = contactsList.stream().sorted(Comparator.comparing(Contact::getFirstName))
                    .collect(Collectors.toList());
            sortedList.forEach(con -> System.out.println(con.getFirstName()));
        }

    }

    public void sortEntriesInAddressBookByCitySateAndZip() {
        List<Contact> contactsList = new ArrayList<>();
        for (Map.Entry<String, AddressBook> set : addressBookSystem.entrySet()) {
            AddressBook addressBook = set.getValue();
            contactsList = addressBook.getContacts();
            System.out.println("Sorted Person's by alphabetically in Address Book");
            System.out.println("Sorted Person's by City Name");
            List<Contact> sortedListCity = contactsList.stream().sorted(Comparator.comparing(Contact::getCity))
                    .collect(Collectors.toList());
            sortedListCity.forEach(con -> System.out.println(con.getCity()));
            System.out.println("Sorted Person's by State Name");
            List<Contact> sortedListState = contactsList.stream().sorted(Comparator.comparing(Contact::getCity))
                    .collect(Collectors.toList());
            sortedListState.forEach(con -> System.out.println(con.getState()));
            System.out.println("Sorted Person's by Zip Code");
            List<Contact> sortedListZip = contactsList.stream().sorted(Comparator.comparing(Contact::getZip))
                    .collect(Collectors.toList());
            sortedListZip.forEach(con -> System.out.println(con.getZip()));

        }

    }
}
