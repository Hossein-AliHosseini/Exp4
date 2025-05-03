package clinic.service;

import clinic.model.Appointment;

public class AppointmentService {
    public static String checkAppointmentStatus(Appointment appointment) {
        if (appointment.getTime().isAfter(appointment.getDoctor().getAvailableUntil())) {
            return "لغو";
        }

        if ("اورژانسی".equals(appointment.getPatient().getType())) {
            return "تایید";
        }

        if ("عادی".equals(appointment.getPatient().getType())
                && "تاییدشده".equals(appointment.getPatient().getInsuranceStatus())) {
            return "تایید";
        }

        if ("ردشده".equals(appointment.getPatient().getInsuranceStatus())) {
            return "لغو";
        }

        return "نامشخص";
    }
}