/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Model.*;

/**
 *
 * @author johan
 */
public class EquipoService {
    private final RobotService robotService;
    
    public EquipoService(){
        this.robotService = new RobotService();
    }
    
    public void registrarAlumno(Equipo equipo, Alumno alumno){
        equipo.agregarAlumno(alumno);
    }
    
    public String obtenerFichaCompleta( Equipo equipo ){
        StringBuilder info = new StringBuilder();
        
        info.append("Ficha de equipo ");
        info.append("nombre : ").append(equipo.getNombre()).append("\n");
        
        if(equipo.getMentor() != null){
            info.append("Mentor: ").append(equipo.getMentor().getNombre())
                    .append(" ID: ").append(equipo.getMentor().getId()).append("\n");
        } else {
            info.append("Mentor: [VACANTE]\n");
        }
        
        info.append("Integrantes:\n");
        if (equipo.getAlumnos().isEmpty()) {
            info.append(" - Sin alumnos inscritos\n");
        } else {
            equipo.getAlumnos().forEach(a -> 
                info.append(" - ").append(a.getNombre())
                    .append(" [").append(a.getMatricula()).append("]\n")
            );
        }
        
        info.append("--- HARDWARE ---\n");
        if (equipo.getRobot() != null) {
            // Usamos el servicio del robot para obtener los detalles
            info.append(robotService.obtenerEspecificacionesTecnicas(equipo.getRobot()));
        } else {
            info.append("No se ha asignado un robot aún.\n");
        }
        
        info.append("----------------------\n");
        return info.toString();
    }
}
