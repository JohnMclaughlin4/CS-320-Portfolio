import java.util.HashMap;
import java.util.Map;

public class AppointmentService {

    // Stores all Appointment objects in memory.
    // The String key is the appointment ID, and the Appointment value is the acutal appointment object.
    private final Map<String, Appointment> appointments;

    // Constructor creates a new empty HashMap when the service is Created.
    public AppointmentService() {
        appointments = new HashMap<>();
    }

    // Adds a new appointment to the service.
    public void addAppointment(Appointment appointment) {

        // A null appointment should not be added because it would not meet the requirments.
        if (appointment == null) {
            throw new IllegalArgumentException("Appointment cannot be null.");
        }

        // Checks whether an appointment with the same ID already exists.
        // Appointment IDs must be unique.
        if (appointments.containsKey(appointment.getAppointmentId())) {
            throw new IllegalArgumentException("Appointment ID must be unique.");
        }

        // Adds the appointment to the HashMap using the appointment ID as the key.
        appointments.put(appointment.getAppointmentId(), appointment);
    }

    // Deletes an appointment based on its appointment ID.
    public void deleteAppointment(String appointmentId) {

        // If the appointment ID is not found, throw an exception.
        if (!appointments.containsKey(appointmentId)) {
            throw new IllegalArgumentException("Appointment ID was not found.");
        }

        // Removes the appointment from the HashMap.
        appointments.remove(appointmentId);
    }

    // Returns an appointment by its appointment ID.
    // If the appointment does not exsist, this returns null.
    public Appointment getAppointment(String appointmentId) {
        return appointments.get(appointmentId);
    }
}