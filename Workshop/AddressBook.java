import java.io.*;
import java.util.*;

class Contact {
    String name;
    String phone;
    String email;
    String address;

    Contact(String name, String phone, String email, String address) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public String toString() {
        return name + "," + phone + "," + email + "," + address;
    }

    public static Contact fromString(String line) {
        String[] parts = line.split(",");
        return new Contact(parts[0], parts[1], parts[2], parts[3]);
    }
}

class AddressBook<T extends Contact> {
    HashMap<String, T> contacts = new HashMap<>();

    void addContact(T contact) {
        contacts.put(contact.phone, contact);
    }

    void removeContact(String phone) {
        contacts.remove(phone);
    }

    T searchByName(String name) {
        for (T contact : contacts.values()) {
            if (contact.name.equalsIgnoreCase(name)) return contact;
        }
        return null;
    }

    T searchByPhone(String phone) {
        return contacts.get(phone);
    }

    List<T> listContacts() {
        return new ArrayList<>(contacts.values());
    }

    void saveToFile(String filename) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        for (T contact : contacts.values()) {
            writer.write(contact.toString());
            writer.newLine();
        }
        writer.close();
    }

    void loadFromFile(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            T contact = (T) Contact.fromString(line);
            contacts.put(contact.phone, contact);
        }
        reader.close();
    }

    boolean hasSameAddress(T c1, T c2) {
        return c1.address.equalsIgnoreCase(c2.address);
    }
}

class NameComparator implements Comparator<Contact> {
    public int compare(Contact c1, Contact c2) {
        return c1.name.compareToIgnoreCase(c2.name);
    }
}

class PhoneComparator implements Comparator<Contact> {
    public int compare(Contact c1, Contact c2) {
        return c1.phone.compareTo(c2.phone);
    }
}

public class AddressBook {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        AddressBook<Contact> book = new AddressBook<>();
        String filename = "contacts.txt";
        File file = new File(filename);
        if (file.exists()) book.loadFromFile(filename);

        while (true) {
            System.out.println("1.Add 2.Remove 3.Search by Name 4.Search by Phone 5.List 6.Save 7.Has-A 8.Sort by Name 9.Sort by Phone 10.Exit");
            int choice = sc.nextInt();
            sc.nextLine();
            if (choice == 1) {
                String name = sc.nextLine();
                String phone = sc.nextLine();
                String email = sc.nextLine();
                String address = sc.nextLine();
                book.addContact(new Contact(name, phone, email, address));
            } else if (choice == 2) {
                String phone = sc.nextLine();
                book.removeContact(phone);
            } else if (choice == 3) {
                String name = sc.nextLine();
                Contact c = book.searchByName(name);
                if (c != null) System.out.println(c.toString());
            } else if (choice == 4) {
                String phone = sc.nextLine();
                Contact c = book.searchByPhone(phone);
                if (c != null) System.out.println(c.toString());
            } else if (choice == 5) {
                for (Contact c : book.listContacts()) System.out.println(c.toString());
            } else if (choice == 6) {
                book.saveToFile(filename);
            } else if (choice == 7) {
                String phone1 = sc.nextLine();
                String phone2 = sc.nextLine();
                Contact c1 = book.searchByPhone(phone1);
                Contact c2 = book.searchByPhone(phone2);
                if (c1 != null && c2 != null) {
                    System.out.println(book.hasSameAddress(c1, c2));
                }
            } else if (choice == 8) {
                List<Contact> list = book.listContacts();
                list.sort(new NameComparator());
                for (Contact c : list) System.out.println(c.toString());
            } else if (choice == 9) {
                List<Contact> list = book.listContacts();
                list.sort(new PhoneComparator());
                for (Contact c : list) System.out.println(c.toString());
            } else if (choice == 10) {
                break;
            }
        }
        book.saveToFile(filename);
    }
}
