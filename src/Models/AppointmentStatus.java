package Models;

public enum AppointmentStatus {
    NEW("new"),
    IN_PROGRESS("in_progress"),
    CANCELLED("cancelled"),
    WAIT_FOR_PAY("wait_for_pay"),
    COMPLETED("completed");

    private final String appointmentStatus;

    AppointmentStatus(String appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }

    public String getAppointmentStatus() {
        return appointmentStatus;
    }
}
