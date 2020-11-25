package by.home.hospital.service;

import by.home.hospital.domain.Appointment;

import java.util.List;

public interface AppointmentRepository {
    List<Appointment> getAppointment();

    void addAppointment(Appointment appointment);

    void deleteAppointment(Integer number);
}
