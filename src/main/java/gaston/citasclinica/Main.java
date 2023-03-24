/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package gaston.citasclinica;

/**
 *
 * @author gasto
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import com.opencsv.CSVWriter;

public class Main {
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Doctor> doctores = new ArrayList<>();
        List<Paciente> pacientes = new ArrayList<>();
        List<Cita> citas = new ArrayList<>();
        int DoctorId = 1;
        int PacienteId = 1;
        int CitaId = 1;

        while (true) {
            System.out.println("¿Qué acción quieres realizar?");
            System.out.println("1. Dar de alta un doctor.");
            System.out.println("2. Dar de alta un paciente.");
            System.out.println("3. Crear una cita.");
            System.out.println("4. Salir.");

            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            if (opcion == 1) {
                System.out.println("Introduce el nombre completo del doctor:");
                String nombre = scanner.nextLine();

                System.out.println("Introduce la especialidad del doctor:");
                String especialidad = scanner.nextLine();

                Doctor doctor = new Doctor(DoctorId, nombre, especialidad);
                doctores.add(doctor);
                
                
                 String[] datosDoctor = {nombre, String.valueOf(DoctorId), especialidad };
                
                 try {
                    CSVWriter writer = new CSVWriter(new FileWriter("doctores.csv", true));
                    writer.writeNext(datosDoctor);
                    writer.close();
            } catch (IOException e) {
                System.out.println("Error al guardar los datos del doctor en el archivo CSV.");
        }

                System.out.println("Doctor añadido correctamente.");
                System.out.println("El ID del Doctor es: " + doctor.getId());
                DoctorId++;
                
            } else if (opcion == 2) {
                System.out.println("Introduce el nombre completo del paciente:");
                String nombre = scanner.nextLine();

                Paciente paciente = new Paciente(PacienteId, nombre);
                pacientes.add(paciente);
                
                System.out.println("Paciente añadido correctamente.");
                System.out.println("El ID del Paciente es: " + paciente.getId());
                
                String[] datosPaciente = {nombre, String.valueOf(PacienteId)};
                
                 try {
                    CSVWriter writer = new CSVWriter(new FileWriter("pacientes.csv", true));
                    writer.writeNext(datosPaciente);
                    writer.close();
                 }catch (IOException e) {
                System.out.println("Error al guardar los datos del doctor en el archivo CSV.");
                
                PacienteId++;
                
            }
            }else if (opcion == 3) {
                System.out.println("Introduce el ID del doctor que atenderá la cita:");
                int doctorId = scanner.nextInt();
                scanner.nextLine(); 

                System.out.println("Introduce el ID del paciente que solicita la cita:");
                int pacienteId = scanner.nextInt();
                scanner.nextLine(); 

                System.out.println("Introduce la fecha y hora de la cita Dia/Mes/AÑO (numerico), Hora:Minuto ");
                String fecha = scanner.nextLine();
                Date date = null;
                try {
                    date = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(fecha);
                } catch (ParseException e) {
                    System.out.println("Formato de fecha incorrecto. Inténtalo de nuevo.");
                    continue;
                }

                System.out.println("Introduce el motivo de la cita:");
                String motivo = scanner.nextLine();
                
                String[] datosCita = {String.valueOf(doctorId), String.valueOf(pacienteId), motivo};
                
                 try {
                    CSVWriter writer = new CSVWriter(new FileWriter("citas.csv", true));
                    writer.writeNext(datosCita);
                    writer.close();
                 }catch (IOException e) {
                System.out.println("Error al guardar los datos del doctor en el archivo CSV.");
                

                Doctor doctor = null;
                Paciente paciente = null;
                for (Doctor d : doctores) {
                    if (d.getId() == doctorId) {
                        doctor = d;
                        break;
                    }
                }
                for (Paciente p : pacientes) {
                    if (p.getId() == pacienteId) {
                        paciente = p;
                        break;
                    }
                }

                if (doctor == null) {
                    System.out.println("No se ha encontrado un doctor con ese identificador. Inténtalo de nuevo.");
                    continue;
                }
                if (paciente == null) {
                    System.out.println("No se ha encontrado un paciente con ese identificador. Inténtalo de nuevo.");
                
                }
            }
            }
                else if (opcion == 4) {
                    System.exit(0);
                    break;
                    
                }
        }
    }
}

                