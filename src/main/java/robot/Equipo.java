/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package robot;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author johan
 */
public class Equipo {
    public String nombre;
    private final List<Alumno> alumnos;
    private Robot robot;
    private Mentor mentor;
    
    public Equipo(String nombre){
        this.nombre = nombre;
        this.alumnos = new ArrayList<>();
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void agregarAlumno(Alumno alumno){
        this.alumnos.add(alumno);
    }
    
    public void asignarMentor(Mentor mentor){
        this.mentor = mentor;
    }
    
    public void asignarRobot(Robot robot){
        this.robot = robot;
    }
    
    public void mostrarInfo(){
        System.out.println("========================================");
        System.out.println("Equipo: " + nombre);
        if (mentor != null) {
            System.out.println("Mentor: " + mentor.getNombre());
        }
        if (robot != null) {
            System.out.println("Robot Asignado: " + robot.idRobot);
        }
        System.out.println("Integrantes:");
        alumnos.forEach(alumno -> System.out.println("- " + alumno.getNombre()));
        System.out.println("========================================");
    }
}
