package clinic;

import clinic.model.Appointment;
import clinic.model.Doctor;
import clinic.model.Patient;
import clinic.service.AppointmentService;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

import java.time.LocalDateTime;
import static org.junit.Assert.assertEquals;
import java.io.*;

public class MyStepdefs {
    private Patient patient;
    private Doctor doctor;
    private Appointment appointment;
    private String actualResult;
    private String patientType;
    private String insuranceStatus;
    private String doctorName;
    private String department;
    private String availableUntil;
    private String appointmentTime;
    private String expectedResult;


    @Given("^a (.+) patient with (.+) insurance$")
    public void aPatientTypePatientWithInsuranceStatusInsurance(String arg0, String arg1) {
        patientType = arg0;
        insuranceStatus = arg1;
        System.out.println(patientType);
        System.out.println(insuranceStatus);
        patient = new Patient(patientType, insuranceStatus);
    }

    @And("^Doctor (.+) from (.+) department is available until (.+)$")
    public void doctorDoctorNameFromDepartmentDepartmentIsAvailableUntilAvailableUntil(String arg0, String arg1, String arg2) {
        doctorName = arg0;
        department = arg1;
        availableUntil = arg2;
        doctor = new Doctor(doctorName, department, LocalDateTime.parse(availableUntil + "T00:00"));
    }

    @When("^requesting an appointment at (.+)$")
    public void requestingAnAppointmentAtAppointmentTime(String arg0) {
        appointmentTime = arg0;
        LocalDateTime time = LocalDateTime.parse(appointmentTime.replace(" ", "T"));
        appointment = new Appointment(patient, doctor, time);
        actualResult = AppointmentService.checkAppointmentStatus(appointment);
    }

    @Then("^the appointment should be (.+)$")
    public void theAppointmentShouldBeExpectedResult(String arg0) {
        expectedResult = arg0;
        assertEquals(expectedResult, actualResult);
    }
}