package Models;

public enum AppointmentStatus {
    NEW("новый"),
    IN_PROGRESS("в_процессе"),
    CANCELLED("отменен"),
    WAIT_FOR_PAY("ожидает_оплаты"),
    COMPLETED("завершен");

    private final String appointmentStatus;

    AppointmentStatus(String appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }

    public String getAppointmentStatus() {
        return appointmentStatus;
    }
}
