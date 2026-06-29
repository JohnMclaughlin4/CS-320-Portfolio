import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AppointmentServiceTest {

    // AppointmentService object used in each test.
    private AppointmentService appointmentService;

    // Appointment object used as a sample appointment in each test.
    private Appointment appointment;

    // Helper method that creates a future date for the appointment.
    private Date getFutureDate() {

        // Adds one day in milliseconds so the date is not in the past.
        return new Date(System.currentTimeMillis() + 86400000L);
    }

    // Runs before each test method.
    // This gives every test a fresh AppointmentService and Appointment object.
    @BeforeEach
    public void setUp() {
        appointmentService = new AppointmentService();
        appointment = new Appointment("APT123", getFutureDate(), "Annual checkup appointment");
    }

    // Tests that an appointment can be added succesfully.
    @Test
    public void testAddAppointmentSuccessfully() {
        appointmentService.addAppointment(appointment);

        // Checks that the appointment was actully added.
        assertNotNull(appointmentService.getAppointment("APT123"));

        // Checks that the stored appointment has the correct appointment ID.
        assertEquals("APT123", appointmentService.getAppointment("APT123").getAppointmentId());
    }

    // Tests that a null appointment cannot be added.
    @Test
    public void testCannotAddNullAppointment() {

        // Adding null should throw an IllegalArgumentException.
        assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.addAppointment(null);
        });
    }

    // Tests that two appointments cannot have the same appointment ID.
    @Test
    public void testCannotAddDuplicateAppointmentId() {
        Appointment duplicateAppointment = new Appointment("APT123", getFutureDate(), "Dentist appointment");

        // Add the first appointment.
        appointmentService.addAppointment(appointment);

        // Adding another appointment with the same ID should throw an exeption.
        assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.addAppointment(duplicateAppointment);
        });
    }

    // Tests that an appointment can be deleted successfully.
    @Test
    public void testDeleteAppointmentSuccessfully() {
        appointmentService.addAppointment(appointment);
        appointmentService.deleteAppointment("APT123");

        // After deleting, the appointment should no longer exsist.
        assertNull(appointmentService.getAppointment("APT123"));
    }

    // Tests that deleting an appointment with an invalid ID throws an exception.
    @Test
    public void testDeleteAppointmentWithInvalidIdThrowsException() {

        // BADID does not exist, so this should throw an exception.
        assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.deleteAppointment("BADID");
        });
    }
}