// Import assertion methods used to check expected test results.
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

// Import Test so methods can be marked as JUnit test cases.
import org.junit.jupiter.api.Test;

public class ContactTest {

    // Tests that a contact can be created succesfully with valid values.
    @Test
    public void testContactCreatedSuccessfully() {
        Contact contact = new Contact("1234567890", "John", "Smith", "1234567890", "123 Main Street");

        // Checks that each field was stored correctly.
        assertEquals("1234567890", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main Street", contact.getAddress());
    }

    // Tests that the contact ID cannot be null.
    @Test
    public void testContactIdCannotBeNull() {

        // A null contact ID should throw an IllegalArgumentException.
        assertThrows(IllegalArgumentException.class, () -> new Contact(null, "John", "Smith", "1234567890", "123 Main Street"));
    }

    // Tests that the contact ID cannot be longer than 10 characters.
    @Test
    public void testContactIdCannotBeLongerThanTenCharacters() {

        // This contact ID is too long, so it should throw an exception.
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345678901", "John", "Smith", "1234567890", "123 Main Street"));
    }

    // Tests that the first name cannot be null.
    @Test
    public void testFirstNameCannotBeNull() {

        // A null first name should throw an IllegalArgumentException.
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", null, "Smith", "1234567890", "123 Main Street"));
    }

    // Tests that the first name cannot be longer than 10 characters.
    @Test
    public void testFirstNameCannotBeLongerThanTenCharacters() {

        // This first name is too long, so it should throw an exeption.
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "Johnathan11", "Smith", "1234567890", "123 Main Street"));
    }

    // Tests that the last name cannot be null.
    @Test
    public void testLastNameCannotBeNull() {

        // A null last name should throw an IllegalArgumentException.
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "John", null, "1234567890", "123 Main Street"));
    }

    // Tests that the last name cannot be longer than 10 characters.
    @Test
    public void testLastNameCannotBeLongerThanTenCharacters() {

        // This last name is too long, so it should throw an exception.
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "John", "Smithfield1", "1234567890", "123 Main Street"));
    }

    // Tests that the phone number cannot be null.
    @Test
    public void testPhoneCannotBeNull() {

        // A null phone number should throw an IllegalArgumentException.
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "John", "Smith", null, "123 Main Street"));
    }

    // Tests that the phone number must be exactly 10 digits.
    @Test
    public void testPhoneMustBeExactlyTenDigits() {

        // Phone number is too short, so it should throw an exception.
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "John", "Smith", "123456789", "123 Main Street"));

        // Phone number is too long, so it should throw an exception.
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "John", "Smith", "12345678901", "123 Main Street"));

        // Phone number has letters, so it should throw an exeption.
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "John", "Smith", "12345abc90", "123 Main Street"));
    }

    // Tests that the address cannot be null.
    @Test
    public void testAddressCannotBeNull() {

        // A null address should throw an IllegalArgumentException.
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "John", "Smith", "1234567890", null));
    }

    // Tests that the address cannot be longer than 30 characters.
    @Test
    public void testAddressCannotBeLongerThanThirtyCharacters() {

        // This address is longer than 30 charcters, so it should throw an exception.
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "John", "Smith", "1234567890", "1234567890123456789012345678901"));
    }

    // Tests that contact fields can be updated with valid values.
    @Test
    public void testFieldsCanBeUpdatedWithValidValues() {
        Contact contact = new Contact("12345", "John", "Smith", "1234567890", "123 Main Street");

        // Update each editable field.
        contact.setFirstName("Jane");
        contact.setLastName("Jones");
        contact.setPhone("0987654321");
        contact.setAddress("456 Oak Road");

        // Checks that the updated values were saved corectly.
        assertEquals("Jane", contact.getFirstName());
        assertEquals("Jones", contact.getLastName());
        assertEquals("0987654321", contact.getPhone());
        assertEquals("456 Oak Road", contact.getAddress());
    }

    // Tests that setters reject invalid values.
    @Test
    public void testSettersRejectInvalidValues() {
        Contact contact = new Contact("12345", "John", "Smith", "1234567890", "123 Main Street");

        // Invalid first names should throw an exception.
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName("Johnathan11"));

        // Invalid last names should throw an exception.
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName("Smithfield1"));

        // Invalid phone numbers should throw an exception.
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone("123456789"));
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone("12345abc90"));

        // Invalid addresses should throw an exception.
        assertThrows(IllegalArgumentException.class, () -> contact.setAddress(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setAddress("1234567890123456789012345678901"));
    }
}