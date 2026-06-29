// Import assertion methods used to check expected test results.
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

// Import BeforeEach so setup code can run before every test.
import org.junit.jupiter.api.BeforeEach;

// Import Test so methods can be marked as JUnit test cases.
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    // ContactService object used in each test.
    private ContactService contactService;

    // Contact object used as a sample contact in each test.
    private Contact contact;

    // Runs before each test method.
    // This gives every test a fresh ContactService and Contact object.
    @BeforeEach
    public void setUp() {
        contactService = new ContactService();
        contact = new Contact("12345", "John", "Smith", "1234567890", "123 Main Street");
    }

    // Tests that a contact can be added with a unique ID.
    @Test
    public void testAddContactWithUniqueId() {
        contactService.addContact(contact);

        // Checks that one contact was added.
        assertEquals(1, contactService.getContactCount());

        // Checks that the correct contact was stored.
        assertEquals(contact, contactService.getContact("12345"));
    }

    // Tests that a null contact cannot be added.
    @Test
    public void testAddContactRejectsNullContact() {

        // Adding null should throw an IllegalArgumentException.
        assertThrows(IllegalArgumentException.class, () -> contactService.addContact(null));
    }

    // Tests that duplicate contact IDs are rejected.
    @Test
    public void testAddContactRejectsDuplicateId() {
        Contact duplicateContact = new Contact("12345", "Jane", "Jones", "0987654321", "456 Oak Road");

        // Add the first contact.
        contactService.addContact(contact);

        // Adding another contact with the same ID should throw an exeption.
        assertThrows(IllegalArgumentException.class, () -> contactService.addContact(duplicateContact));

        // Makes sure only one contact is still stored.
        assertEquals(1, contactService.getContactCount());
    }

    // Tests that a contact can be deleted by ID.
    @Test
    public void testDeleteContactById() {
        contactService.addContact(contact);
        contactService.deleteContact("12345");

        // Checks that the contact count goes back to zero.
        assertEquals(0, contactService.getContactCount());

        // Checks that the contact no longer exsists.
        assertNull(contactService.getContact("12345"));
    }

    // Tests that deleting an unknown contact ID throws an exception.
    @Test
    public void testDeleteContactRejectsUnknownId() {

        // The ID 99999 does not exist, so this should throw an exception.
        assertThrows(IllegalArgumentException.class, () -> contactService.deleteContact("99999"));
    }

    // Tests that the first name can be updated by contact ID.
    @Test
    public void testUpdateFirstNameById() {
        contactService.addContact(contact);
        contactService.updateFirstName("12345", "Jane");

        // Checks that the first name was updated corectly.
        assertEquals("Jane", contactService.getContact("12345").getFirstName());
    }

    // Tests that the last name can be updated by contact ID.
    @Test
    public void testUpdateLastNameById() {
        contactService.addContact(contact);
        contactService.updateLastName("12345", "Jones");

        // Checks that the last name was updated correctly.
        assertEquals("Jones", contactService.getContact("12345").getLastName());
    }

    // Tests that the phone number can be updated by contact ID.
    @Test
    public void testUpdatePhoneById() {
        contactService.addContact(contact);
        contactService.updatePhone("12345", "0987654321");

        // Checks that the phone number was updated correctly.
        assertEquals("0987654321", contactService.getContact("12345").getPhone());
    }

    // Tests that the address can be updated by contact ID.
    @Test
    public void testUpdateAddressById() {
        contactService.addContact(contact);
        contactService.updateAddress("12345", "456 Oak Road");

        // Checks that the address was updated correctly.
        assertEquals("456 Oak Road", contactService.getContact("12345").getAddress());
    }

    // Tests that update methods reject an unknown contact ID.
    @Test
    public void testUpdateRejectsUnknownId() {

        // Each update should fail because ID 99999 does not exsist.
        assertThrows(IllegalArgumentException.class, () -> contactService.updateFirstName("99999", "Jane"));
        assertThrows(IllegalArgumentException.class, () -> contactService.updateLastName("99999", "Jones"));
        assertThrows(IllegalArgumentException.class, () -> contactService.updatePhone("99999", "0987654321"));
        assertThrows(IllegalArgumentException.class, () -> contactService.updateAddress("99999", "456 Oak Road"));
    }

    // Tests that invalid update values are rejected.
    @Test
    public void testUpdateRejectsInvalidValues() {
        contactService.addContact(contact);

        // First name is too long, so it should throw an exception.
        assertThrows(IllegalArgumentException.class, () -> contactService.updateFirstName("12345", "Johnathan11"));

        // Last name is too long, so it should throw an exception.
        assertThrows(IllegalArgumentException.class, () -> contactService.updateLastName("12345", "Smithfield1"));

        // Phone number is too short, so it should throw an exception.
        assertThrows(IllegalArgumentException.class, () -> contactService.updatePhone("12345", "123456789"));

        // Phone number has letters, so it should throw an exception.
        assertThrows(IllegalArgumentException.class, () -> contactService.updatePhone("12345", "12345abc90"));

        // Address is longer than 30 characters, so it should throw an exeption.
        assertThrows(IllegalArgumentException.class, () -> contactService.updateAddress("12345", "1234567890123456789012345678901"));
    }
}