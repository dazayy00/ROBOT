/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Model.Equipo;
import Model.Torneo;

/**
 *
 * @author johan
 */
public class TorneoService {
    
    public String obtenerInfoEquipo(Equipo equipo){
        StringBuilder info = new StringBuilder();
        info.append("===================\n");
        info.append("Equipo : ").append(equipo.getNombre()).append("\n");
        
        if(equipo.getMentor() != null){
            info.append("Mentor : ").append(equipo.getMentor().getNombre()).append("\n");
        }
        if(equipo.getRobot() != null){
            info.append("Robot asignado : ").append(equipo.getRobot().getIdRobot()).append("\n");
            info.append("Componentes del robot \n");
            equipo.getRobot().getComponentes().forEach(componente ->
                    info.append(" - ").append(componente.getDetalles()).append("\n")
            );
        }
        
        info.append("Integrantes:\n");
        equipo.getAlumnos().forEach(alumno ->
                info.append(" - ").append(alumno.getNombre()).append("\n")
        );
        info.append("=======================\n");
        return info.toString();
    }
    
    public String obtenerEquiposParticipantes(Torneo torneo){
        StringBuilder lista = new StringBuilder();
        lista.append("\n Equipos participantes en el torneo: ")
                .append(torneo.getNombre())
                .append("(").append(torneo.getSede()).append(") ----");
        
        torneo.getEquiposInscritos().forEach(equipo ->
                lista.append(" \n* ").append(equipo.getNombre())
        );
        return lista.toString();
    }
}
