package clinic.model;

import java.time.LocalDateTime;

public class Doctor {
    private final String name;
    private final String department;
    private final LocalDateTime availableUntil;

    public Doctor(String name, String department, LocalDateTime availableUntil) {
        this.name = name;
        this.department = department;
        this.availableUntil = availableUntil;
    }

    // Getters
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public LocalDateTime getAvailableUntil() { return availableUntil; }
}