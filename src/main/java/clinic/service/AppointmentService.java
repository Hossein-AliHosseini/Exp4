package clinic.service;

import clinic.model.Appointment;

public class AppointmentService {
    public static String checkAppointmentStatus(Appointment appointment) {
        // Rule 0: Doctor availability
        if (appointment.getTime().isAfter(appointment.getDoctor().getAvailableUntil())) {
            return "لغو";
        }

        // Rule 1: Emergency patient
        if ("اورژانسی".equals(appointment.getPatient().getType())) {
            return "تایید";
        }

        // Rule 2: Normal patient with approved insurance
        if ("عادی".equals(appointment.getPatient().getType())
                && "تاییدشده".equals(appointment.getPatient().getInsuranceStatus())) {
            return "تایید";
        }

        // Rule 3: Rejected insurance
        if ("ردشده".equals(appointment.getPatient().getInsuranceStatus())) {
            return "لغو";
        }

        return "نامشخص"; // Default case (shouldn't happen with proper input validation)
    }
}