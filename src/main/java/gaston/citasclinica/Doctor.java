/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gaston.citasclinica;

/**
 *
 * @author gasto
 */
public class Doctor {
    private int id;
    private String nombre;
    private String especialidad;

    public Doctor(int id, String name, String specialty) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String name) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String specialty) {
        this.especialidad = especialidad;
    }
}