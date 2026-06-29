public class Contact {

    // The contact ID is final because it should not be updated after the contact is created.
    private final String contactId;

    // First name can be updated, so it is not final.
    private String firstName;

    // Last name can be updated, so it is not final.
    private String lastName;

    // Phone number can be updated, so it is not final.
    private String phone;

    // Address can be updated, so it is not final.
    private String address;

    // Constructor used to create a new Contact object.
    public Contact(String contactId, String firstName, String lastName, String phone, String address) {

        // Validate all fields before assinging them.
        validateContactId(contactId);
        validateFirstName(firstName);
        validateLastName(lastName);
        validatePhone(phone);
        validateAddress(address);

        // Assign values only after they pass validation.
        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    // Returns the contact ID.
    public String getContactId() {
        return contactId;
    }

    // Returns the contact's first name.
    public String getFirstName() {
        return firstName;
    }

    // Updates the first name after validating it.
    public void setFirstName(String firstName) {
        validateFirstName(firstName);
        this.firstName = firstName;
    }

    // Returns the contact's last Name.
    public String getLastName() {
        return lastName;
    }

    // Updates the last name after validating it.
    public void setLastName(String lastName) {
        validateLastName(lastName);
        this.lastName = lastName;
    }

    // Returns the contact's phone number.
    public String getPhone() {
        return phone;
    }

    // Updates the phone number after validating it.
    public void setPhone(String phone) {
        validatePhone(phone);
        this.phone = phone;
    }

    // Returns the contact's address.
    public String getAddress() {
        return address;
    }

    // Updates the address after validating it.
    public void setAddress(String address) {
        validateAddress(address);
        this.address = address;
    }

    // Checks that the contact ID is not null and is not longer than 10 characters.
    private static void validateContactId(String contactId) {
        if (contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException("Contact ID must not be null and must be 10 characters or fewer.");
        }
    }

    // Checks that the first name is not null and is not longer than 10 characters.
    private static void validateFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("First name must not be null and must be 10 characters or fewer.");
        }
    }

    // Checks that the last name is not null and is not longer than 10 characters.
    private static void validateLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Last name must not be null and must be 10 characters or fewer.");
        }
    }

    // Checks that the phone number is not null and is exactly 10 digits.
    private static void validatePhone(String phone) {
        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone number must not be null and must be exactly 10 digits.");
        }
    }

    // Checks that the address is not null and is not longer than 30 charcters.
    private static void validateAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Address must not be null and must be 30 characters or fewer.");
        }
    }
}