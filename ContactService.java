// Import HashMap so contacts can be stored in memory using key-value pairs.
import java.util.HashMap;

// Import Map so the contacts collection can use the Map interface.
import java.util.Map;

public class ContactService {

    // Stores all Contact objects in memory.
    // The String key is the contact ID, and the Contact value is the actual contact object.
    private final Map<String, Contact> contacts = new HashMap<>();

    // Adds a new contact to the service.
    public void addContact(Contact contact) {

        // A null contact should not be added because it would not meet the requirments.
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null.");
        }

        // Gets the contact ID from the contact object.
        String contactId = contact.getContactId();

        // Checks whether a contact with this ID already exsists.
        if (contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID already exists.");
        }

        // Adds the contact to the HashMap using the contact ID as the key.
        contacts.put(contactId, contact);
    }

    // Deletes a contact based on its contact ID.
    public void deleteContact(String contactId) {

        // If the contact ID is not found, throw an exception.
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID does not exist.");
        }

        // Removes the contact from the HashMap.
        contacts.remove(contactId);
    }

    // Updates the first name for an existing contact.
    public void updateFirstName(String contactId, String firstName) {

        // Finds the contact and uses the setter so validation still Happens.
        getExistingContact(contactId).setFirstName(firstName);
    }

    // Updates the last name for an existing contact.
    public void updateLastName(String contactId, String lastName) {

        // Finds the contact and uses the setter so validation still happens.
        getExistingContact(contactId).setLastName(lastName);
    }

    // Updates the phone number for an existing contact.
    public void updatePhone(String contactId, String phone) {

        // Finds the contact and uses the setter so phone validation still happens.
        getExistingContact(contactId).setPhone(phone);
    }

    // Updates the address for an existing contact.
    public void updateAddress(String contactId, String address) {

        // Finds the contact and uses the setter so address validation still happends.
        getExistingContact(contactId).setAddress(address);
    }

    // Returns a contact by its contact ID.
    // If the contact does not exist, this returns null.
    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }

    // Returns the total number of contacts currently stored.
    public int getContactCount() {
        return contacts.size();
    }

    // Helper method used to find a contact before updating it.
    private Contact getExistingContact(String contactId) {

        // Try to find the contact in the HashMap.
        Contact contact = contacts.get(contactId);

        // If no contact is found, throw an exception.
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID does not exist.");
        }

        // Return the contact if it exsists.
        return contact;
    }
}