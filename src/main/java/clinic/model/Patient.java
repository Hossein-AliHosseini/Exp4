package clinic.model;

public class Patient {
    private final String type;
    private final String insuranceStatus;

    public Patient(String type, String insuranceStatus) {
        this.type = type;
        this.insuranceStatus = insuranceStatus;
    }

    // Getters
    public String getType() { return type; }
    public String getInsuranceStatus() { return insuranceStatus; }
}