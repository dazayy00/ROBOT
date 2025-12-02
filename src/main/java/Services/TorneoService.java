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
        info.append("--- DETALLE EQUIPO ---\n");
        info.append("Nombre: ").append(equipo.getNombre()).append("\n");
        if(equipo.getMentor() != null) info.append("Mentor: ").append(equipo.getMentor().getNombre()).append("\n");
        if(equipo.getRobot() != null){
            info.append("Robot: ").append(equipo.getRobot().getIdRobot()).append("\n");
            info.append("  Componentes:\n");
            equipo.getRobot().getComponentes().forEach(c -> info.append("   - ").append(c.getDetalles()).append("\n"));
        }
        info.append("Integrantes:\n");
        equipo.getAlumnos().forEach(a -> info.append(" - ").append(a.getNombre()).append("\n"));
        info.append("----------------------\n");
        return info.toString();
    }
    
    public String obtenerEquiposParticipantes(Torneo torneo){
        StringBuilder lista = new StringBuilder();
        lista.append("TORNEO: ").append(torneo.getNombre()).append(" | SEDE: ").append(torneo.getSede()).append("\n");
        torneo.getEquiposInscritos().forEach(e -> lista.append("* ").append(e.getNombre()).append("\n"));
        return lista.toString();
    }
}
