import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Date;

import org.junit.jupiter.api.Test;

public class AppointmentTest {

    // Helper method that creates a future date for valid appointment tests.
    private Date getFutureDate() {

        // Adds one day in milliseconds so the date is not in the past.
        return new Date(System.currentTimeMillis() + 86400000L);
    }

    // Helper method that creates a past date for invalid appointment tests.
    private Date getPastDate() {

        // Subtracts one day in milliseconds so the date is in the past.
        return new Date(System.currentTimeMillis() - 86400000L);
    }

    // Tests that an appointment can be created succesfully with valid values.
    @Test
    public void testAppointmentCreatedSuccessfully() {
        Date futureDate = getFutureDate();
        Appointment appointment = new Appointment("APT123", futureDate, "Annual checkup appointment");

        // Checks that each field was stored corectly.
        assertEquals("APT123", appointment.getAppointmentId());
        assertEquals(futureDate, appointment.getAppointmentDate());
        assertEquals("Annual checkup appointment", appointment.getDescription());
    }

    // Tests that the appointment ID cannot be null.
    @Test
    public void testAppointmentIdCannotBeNull() {

        // A null appointment ID should throw an IllegalArgumentException.
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, getFutureDate(), "Annual checkup appointment");
        });
    }

    // Tests that the appointment ID cannot be longer than 10 characters.
    @Test
    public void testAppointmentIdCannotBeLongerThanTenCharacters() {

        // This appointment ID has more than 10 characters, so it should throw an exception.
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("APT12345678", getFutureDate(), "Annual checkup appointment");
        });
    }

    // Tests that the appointment date cannot be null.
    @Test
    public void testAppointmentDateCannotBeNull() {

        // A null appointment date should throw an IllegalArgumentException.
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("APT123", null, "Annual checkup appointment");
        });
    }

    // Tests that the appointment date cannot be in the past.
    @Test
    public void testAppointmentDateCannotBeInThePast() {

        // A past appointment date should throw an exeption.
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("APT123", getPastDate(), "Annual checkup appointment");
        });
    }

    // Tests that the description cannot be null.
    @Test
    public void testDescriptionCannotBeNull() {

        // A null description should throw an IllegalArgumentException.
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("APT123", getFutureDate(), null);
        });
    }

    // Tests that the description cannot be longer than 50 characters.
    @Test
    public void testDescriptionCannotBeLongerThanFiftyCharacters() {

        // This description has more than 50 characters, so it should throw an exeption.
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("APT123", getFutureDate(), "This description is definitely longer than fifty characters total.");
        });
    }
}