package clinic;

import clinic.model.Appointment;
import clinic.model.Doctor;
import clinic.model.Patient;
import clinic.service.AppointmentService;
import org.junit.Test;
import java.time.LocalDateTime;
import static org.junit.Assert.*;

public class AppointmentServiceTest {

    @Test
    public void testNormalPatientWithApprovedInsurance() {
        Patient patient = new Patient("عادی", "تاییدشده");
        Doctor doctor = new Doctor("دکتر رضوی", "قلب",
                LocalDateTime.parse("2023-12-31T00:00"));
        LocalDateTime appointmentTime = LocalDateTime.parse("2023-10-10T10:00");
        Appointment appointment = new Appointment(patient, doctor, appointmentTime);

        String result = AppointmentService.checkAppointmentStatus(appointment);

        assertEquals("تایید", result);
    }

    @Test
    public void testEmergencyPatientBypassesInsuranceCheck() {
        Patient patient = new Patient("اورژانسی", "ردشده");
        Doctor doctor = new Doctor("دکتر حسینی", "اطفال",
                LocalDateTime.parse("2023-11-15T00:00"));
        LocalDateTime appointmentTime = LocalDateTime.parse("2023-11-20T09:30");
        Appointment appointment = new Appointment(patient, doctor, appointmentTime);

        String result = AppointmentService.checkAppointmentStatus(appointment);

        assertEquals("لغو", result);
    }

    @Test
    public void testNormalPatientWithRejectedInsurance() {
        Patient patient = new Patient("عادی", "ردشده");
        Doctor doctor = new Doctor("دکتر محمدی", "ارتوپدی",
                LocalDateTime.parse("2024-01-10T00:00"));
        LocalDateTime appointmentTime = LocalDateTime.parse("2023-12-25T14:00");
        Appointment appointment = new Appointment(patient, doctor, appointmentTime);

        String result = AppointmentService.checkAppointmentStatus(appointment);

        assertEquals("لغو", result);
    }
}