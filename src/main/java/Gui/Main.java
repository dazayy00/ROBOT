/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Gui;

import Model.*;
import Services.TorneoService;

/**
 *
 * @author johan
 */
public class Main {
    public static void main(String[] args) {
        
        Torneo torneo = new Torneo ("Robocup 2025", "CDMX");
        
        Mentor mentor1 = new Mentor("m45", "Dr Alan Turing");
        Alumno alu1 = new Alumno("s5456", "Johan Baltazar");
        Alumno alu2 = new Alumno("s8796", "Valeria Rivera");
        
        Mentor mentor2 = new Mentor("d89", "Dr Adolfo Parada");
        Alumno alu3 = new Alumno("s5623", "David Trinidad");
        Alumno alu4 = new Alumno("s45102", "Angelica Torree");
        
        Robot robot1 = new Robot("RD-D2");
        robot1.agregarComponente(new Sensor("Infrarojo"));
        robot1.agregarComponente(new Actuador("Brazo Mecanico"));
        robot1.agregarComponente(new Controlador("v2.0", "Raspberry pi"));
        
        Robot robot2 = new Robot("C-3PO");
        robot2.agregarComponente(new Sensor("Infraazul"));
        robot2.agregarComponente(new Actuador("Ruedas Veloces"));
        
        Equipo equipo1 = new Equipo("LOS UXAS");
        equipo1.asignarMentor(mentor1);
        equipo1.agregarAlumno(alu1);
        equipo1.agregarAlumno(alu2);
        equipo1.asignarRobot(robot1);
        
        Equipo equipo2 = new Equipo("DAMELO PAP");
        equipo2.asignarMentor(mentor2);
        equipo2.agregarAlumno(alu3);
        equipo2.agregarAlumno(alu4);
        equipo2.asignarRobot(robot2);
        
        TorneoService servicio = new TorneoService();
        
        torneo.inscribirEquipo(equipo1);
        System.out.println("El equipo "+ equipo1.getNombre() + " Ha sido inscrito");
        
        torneo.inscribirEquipo(equipo2);
        System.out.println("El equipo "+ equipo2.getNombre() + " Ha sido inscrito");
        
        System.out.println(servicio.obtenerEquiposParticipantes(torneo));
        
        System.out.println("\n--- Información detallada de los equipos ---");
        System.out.println(servicio.obtenerInfoEquipo(equipo1));
        System.out.println(servicio.obtenerInfoEquipo(equipo2));
    }
    
}
