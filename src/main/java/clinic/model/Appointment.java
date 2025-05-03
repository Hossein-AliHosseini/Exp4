package clinic.model;

import java.time.LocalDateTime;

public class Appointment {
    private final Patient patient;
    private final Doctor doctor;
    private final LocalDateTime time;

    public Appointment(Patient patient, Doctor doctor, LocalDateTime time) {
        this.patient = patient;
        this.doctor = doctor;
        this.time = time;
    }

    // Getters
    public Patient getPatient() { return patient; }
    public Doctor getDoctor() { return doctor; }
    public LocalDateTime getTime() { return time; }
}