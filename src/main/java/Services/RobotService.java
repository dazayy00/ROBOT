/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Model.*;

public class RobotService {
    public void instalarComponente(Robot robot, ComponenteRobot componente){
        if(robot != null && componente != null){
            robot.agregarComponente(componente);
        }
    }
    
    public String obtenerEspecificacionesTecnicas(Robot robot){
        if(robot == null) return "Sin robot asignado";
        
        StringBuilder specs = new StringBuilder();
        specs.append("Robot ID: ").append(robot.getIdRobot()).append("\n");
        
        if(robot.getComponentes().isEmpty()){
            specs.append("Sin componentes instalados \n");
        } else {
            specs.append("Componentes instalados \n");
            for(ComponenteRobot componente : robot.getComponentes()) {
                specs.append("  - ").append(componente.getDetalles()).append("\n");
            }
        }
        return specs.toString();
    }
}
