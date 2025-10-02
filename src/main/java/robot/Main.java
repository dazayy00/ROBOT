/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package robot;

/**
 *
 * @author johan
 */
public class Main {
    
    public static void main(String[] args) {
        System.out.println("🚀 Iniciando simulación del proyecto WRO...");

        System.out.println("\nPASO 1: Creando participantes y mentores...");
        Alumno alumno1 = new Alumno("A01", "Juan Perez");
        Alumno alumno2 = new Alumno("A02", "Maria Lopez");
        Mentor mentor = new Mentor("M01", "Dr. Alan Turing");
        System.out.println(" -> " + alumno1);
        System.out.println(" -> " + mentor);

        System.out.println("\nPASO 2: Construyendo un robot y sus componentes...");
        Robot robotAlpha = new Robot("R-ALPHA-01");
        robotAlpha.agregarSensor("Infrarrojo");
        robotAlpha.agregarSensor("Ultrasónico");
        robotAlpha.agregarActuador("Motor DC");
        robotAlpha.agregarControlador("v1.2", "Arduino UNO");
        System.out.println(" -> Robot '" + robotAlpha.getIdRobot() + "' construido.");


        System.out.println("\nPASO 3: Formando los equipos de robótica...");
        Equipo equipoA = new Equipo("RoboMasters");
        equipoA.agregarAlumno(alumno1);
        equipoA.agregarAlumno(alumno2);
        equipoA.asignarMentor(mentor);
        equipoA.asignarRobot(robotAlpha);
        System.out.println(" -> Equipo '" + equipoA.getNombre() + "' formado.");

        Equipo equipoB = new Equipo("CyberKnights");
        equipoB.agregarAlumno(new Alumno("A03", "Carlos Sanchez"));
        equipoB.asignarRobot(new Robot("R-BETA-02"));
        System.out.println(" -> Equipo '" + equipoB.getNombre() + "' formado.");
        
        System.out.println("\nPASO 4: Creando un torneo e inscribiendo equipos...");
        Torneo torneoWRO = new Torneo("WRO Nacional", "Ciudad de México");
        torneoWRO.inscribirEquipo(equipoA);
        torneoWRO.inscribirEquipo(equipoB);

        System.out.println("\n--- 📝 RESUMEN FINAL ---");
        
        System.out.println("\n[Info Detallada de los Equipos]");
        equipoA.mostrarInfo();
        equipoB.mostrarInfo();
        
        System.out.println("\n[Componentes del Robot del Equipo A]");
        robotAlpha.mostrarComponentes();
        
        torneoWRO.mostrarEquiposParticipantes();
    }
    
}
