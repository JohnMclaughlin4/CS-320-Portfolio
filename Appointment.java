import java.util.Date;

public class Appointment {

    // The appointment ID is final because it should not be updated after creation.
    private final String appointmentId;

    // The appointment date is final because no update Requirment was given for appointments.
    private final Date appointmentDate;

    // The description is final because no update requirement was given for Appointments.
    private final String description;

    // Constructor used to create a new Appointment object.
    public Appointment(String appointmentId, Date appointmentDate, String description) {

        // Validate all fields before assinging them.
        validateAppointmentId(appointmentId);
        validateAppointmentDate(appointmentDate);
        validateDescription(description);

        // Assign the appointment ID after validation.
        this.appointmentId = appointmentId;

        // Create a copy of the Date object instead of storing the original directly.
        // This protects the appointment date from being changed outside the class.
        this.appointmentDate = new Date(appointmentDate.getTime());

        // Assign the description after validation.
        this.description = description;
    }

    // Returns the appointment ID.
    public String getAppointmentId() {
        return appointmentId;
    }

    // Returns a copy of the appointment date.
    // This prevents outside code from changing the orginal date stored in the object.
    public Date getAppointmentDate() {
        return new Date(appointmentDate.getTime());
    }

    // Returns the appointment description.
    public String getDescription() {
        return description;
    }

    // Checks that the appointment ID is not null and is not longer than 10 characters.
    private void validateAppointmentId(String appointmentId) {
        if (appointmentId == null || appointmentId.length() > 10) {
            throw new IllegalArgumentException("Appointment ID cannot be null or longer than 10 characters.");
        }
    }

    // Checks that the appointment date is not null and is not in the past.
    private void validateAppointmentDate(Date appointmentDate) {
        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Appointment date cannot be null or in the past.");
        }
    }

    // Checks that the description is not null and is not longer than 50 characters.
    private void validateDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description cannot be null or longer than 50 characters.");
        }
    }
}