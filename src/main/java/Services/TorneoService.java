/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Model.Equipo;
import Model.Torneo;

public class TorneoService {
    
    public void registrarEquipoEnTorneo(Torneo torneo, Equipo equipo) {
        if (equipo.getAlumnos().size() < 1) {
            System.out.println("Error: El equipo " + equipo.getNombre() + " no tiene alumnos.");
            return;
        }
        torneo.inscribirEquipo(equipo);
    }

    public String obtenerReporteInscritos(Torneo torneo) {
        StringBuilder lista = new StringBuilder();
        lista.append("=== REPORTE DE TORNEO ===\n");
        lista.append("Evento: ").append(torneo.getNombre()).append("\n");
        lista.append("Sede: ").append(torneo.getSede()).append("\n");
        lista.append("Total Equipos: ").append(torneo.getEquiposInscritos().size()).append("\n");
        lista.append("-------------------------\n");
        
        if(torneo.getEquiposInscritos().isEmpty()){
            lista.append("No hay equipos inscritos.\n");
        } else {
            torneo.getEquiposInscritos().forEach(e -> 
                lista.append("* ").append(e.getNombre()).append("\n")
            );
        }
        return lista.toString();
    }
}
