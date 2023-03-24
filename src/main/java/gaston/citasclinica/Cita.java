/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gaston.citasclinica;

import java.util.Date;

/**
 *
 * @author gasto
 */
public class Cita {
    private int id;
    private Date fecha;
    private String motivo;
    private Doctor doctor;
    private Paciente paciente;

    public Cita(int id, Date fecha, String razon, Doctor doctor, Paciente paciente) {
        this.id = id;
        this.fecha = fecha;
        this.motivo = motivo;
        this.doctor = doctor;
        this.paciente = paciente;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date date) {
        this.fecha = fecha;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
