package Gui;

import Model.*;
import Services.TorneoService;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.*;
import javax.swing.*;

public class GestorTorneoApp extends JFrame {

    private ArrayList<Alumno> listaAlumnos = new ArrayList<>();
    private ArrayList<Mentor> listaMentores = new ArrayList<>();
    private ArrayList<Robot> listaRobots = new ArrayList<>();
    private ArrayList<Equipo> listaEquipos = new ArrayList<>();
    private Torneo torneoActual;
    private TorneoService servicio = new TorneoService();

    private JComboBox<Mentor> comboMentoresEquipo;
    private JComboBox<Robot> comboRobotsEquipo;
    private JComboBox<Robot> comboRobotsComponente;
    private JComboBox<Alumno> comboAlumnosEquipo;
    private JComboBox<Equipo> comboEquiposTorneo;
    
    private JTextArea areaResultados;

    public GestorTorneoApp() {
        setTitle("Sistema de Gestión de Robótica");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane tabs = new JTabbedPane();

        tabs.addTab("1. Registros Básicos", crearPanelRegistros());

        tabs.addTab("2. Configurar Robot", crearPanelComponentes());

        tabs.addTab("3. Armar Equipos", crearPanelEquipos());

        tabs.addTab("4. Gestión Torneo", crearPanelTorneo());

        add(tabs);
    }

    private JPanel crearPanelRegistros() {
        JPanel panel = new JPanel(new GridLayout(1, 2, 10, 10));
        
        JPanel panelPersonas = new JPanel(new GridLayout(6, 2, 5, 5));
        panelPersonas.setBorder(BorderFactory.createTitledBorder("Registrar Persona"));
        
        JTextField txtNombre = new JTextField();
        JTextField txtId = new JTextField();
        JRadioButton rbAlumno = new JRadioButton("Alumno", true);
        JRadioButton rbMentor = new JRadioButton("Mentor");
        ButtonGroup grupoRol = new ButtonGroup();
        grupoRol.add(rbAlumno); grupoRol.add(rbMentor);
        JButton btnCrearPersona = new JButton("Guardar Persona");

        panelPersonas.add(new JLabel("Nombre:")); panelPersonas.add(txtNombre);
        panelPersonas.add(new JLabel("ID / Matrícula:")); panelPersonas.add(txtId);
        panelPersonas.add(rbAlumno); panelPersonas.add(rbMentor);
        panelPersonas.add(new JLabel("")); panelPersonas.add(btnCrearPersona);

        btnCrearPersona.addActionListener(e -> {
            if(txtNombre.getText().isEmpty() || txtId.getText().isEmpty()) return;
            
            if (rbAlumno.isSelected()) {
                listaAlumnos.add(new Alumno(txtId.getText(), txtNombre.getText()));
                JOptionPane.showMessageDialog(this, "Alumno registrado.");
            } else {
                listaMentores.add(new Mentor(txtId.getText(), txtNombre.getText()));
                JOptionPane.showMessageDialog(this, "Mentor registrado.");
            }
            limpiarCampos(txtNombre, txtId);
            actualizarCombos();
        });

        JPanel panelRobot = new JPanel(new GridLayout(6, 2, 5, 5));
        panelRobot.setBorder(BorderFactory.createTitledBorder("Registrar Robot Base"));
        
        JTextField txtIdRobot = new JTextField();
        JButton btnCrearRobot = new JButton("Crear Robot");

        panelRobot.add(new JLabel("ID Robot:")); panelRobot.add(txtIdRobot);
        panelRobot.add(new JLabel("")); panelRobot.add(btnCrearRobot);

        btnCrearRobot.addActionListener(e -> {
            if(txtIdRobot.getText().isEmpty()) return;
            listaRobots.add(new Robot(txtIdRobot.getText()));
            JOptionPane.showMessageDialog(this, "Robot creado. Ve a la pestaña 2 para agregar componentes.");
            limpiarCampos(txtIdRobot);
            actualizarCombos();
        });

        panel.add(panelPersonas);
        panel.add(panelRobot);
        return panel;
    }

    private JPanel crearPanelComponentes() {
        JPanel panel = new JPanel(new BorderLayout());
        JPanel form = new JPanel(new GridLayout(5, 2, 5, 5));
        form.setBorder(BorderFactory.createTitledBorder("Agregar Componentes a Robot Existente"));

        comboRobotsComponente = new JComboBox<>();
        String[] tipos = {"Sensor", "Actuador", "Controlador"};
        JComboBox<String> comboTipoComp = new JComboBox<>(tipos);
        JTextField txtDetalle1 = new JTextField();
        JTextField txtDetalle2 = new JTextField();
        JButton btnAgregarComp = new JButton("Agregar Componente");

        form.add(new JLabel("Seleccionar Robot:")); form.add(comboRobotsComponente);
        form.add(new JLabel("Tipo Componente:")); form.add(comboTipoComp);
        form.add(new JLabel("Tipo/Firmware:")); form.add(txtDetalle1);
        form.add(new JLabel("Modelo (Solo Controlador):")); form.add(txtDetalle2);
        form.add(new JLabel("")); form.add(btnAgregarComp);

        btnAgregarComp.addActionListener(e -> {
            Robot r = (Robot) comboRobotsComponente.getSelectedItem();
            if (r == null) {
                JOptionPane.showMessageDialog(this, "Selecciona un robot primero.");
                return;
            }
            String seleccion = (String) comboTipoComp.getSelectedItem();
            ComponenteRobot comp = null;
            
            switch (seleccion) {
                case "Sensor":
                    comp = new Sensor(txtDetalle1.getText());
                    break;
                case "Actuador":
                    comp = new Actuador(txtDetalle1.getText());
                    break;
                case "Controlador":
                    comp = new Controlador(txtDetalle1.getText(), txtDetalle2.getText());
                    break;
            }
            r.agregarComponente(comp);
            JOptionPane.showMessageDialog(this, "Componente agregado al robot " + r.getIdRobot());
            limpiarCampos(txtDetalle1, txtDetalle2);
        });

        panel.add(form, BorderLayout.NORTH);
        return panel;
    }

    private JPanel crearPanelEquipos() {
        JPanel panel = new JPanel(new BorderLayout());
        JPanel form = new JPanel(new GridLayout(6, 2, 5, 5));
        form.setBorder(BorderFactory.createTitledBorder("Armar Equipo"));

        JTextField txtNombreEquipo = new JTextField();
        comboMentoresEquipo = new JComboBox<>();
        comboRobotsEquipo = new JComboBox<>();
        
        ArrayList<Alumno> alumnosTemp = new ArrayList<>();
        comboAlumnosEquipo = new JComboBox<>();
        JButton btnAddAlumnoList = new JButton("Añadir Alumno al Grupo");
        JTextArea txtListaAlumnos = new JTextArea(3, 20);
        txtListaAlumnos.setEditable(false);

        JButton btnCrearEquipo = new JButton("Finalizar Creación Equipo");

        form.add(new JLabel("Nombre Equipo:")); form.add(txtNombreEquipo);
        form.add(new JLabel("Mentor:")); form.add(comboMentoresEquipo);
        form.add(new JLabel("Robot:")); form.add(comboRobotsEquipo);
        form.add(new JLabel("Seleccionar Alumno:")); 
        
        JPanel pnlAlumnoBtn = new JPanel(new BorderLayout());
        pnlAlumnoBtn.add(comboAlumnosEquipo, BorderLayout.CENTER);
        pnlAlumnoBtn.add(btnAddAlumnoList, BorderLayout.EAST);
        form.add(pnlAlumnoBtn);
        
        form.add(new JLabel("Miembros añadidos:")); form.add(new JScrollPane(txtListaAlumnos));
        form.add(new JLabel("")); form.add(btnCrearEquipo);

        btnAddAlumnoList.addActionListener(e -> {
            Alumno a = (Alumno) comboAlumnosEquipo.getSelectedItem();
            if(a != null && !alumnosTemp.contains(a)){
                alumnosTemp.add(a);
                txtListaAlumnos.append(a.getNombre() + "\n");
            }
        });

        btnCrearEquipo.addActionListener(e -> {
            if(txtNombreEquipo.getText().isEmpty() || alumnosTemp.isEmpty()){
                JOptionPane.showMessageDialog(this, "Nombre o alumnos faltantes.");
                return;
            }
            Equipo nuevoEquipo = new Equipo(txtNombreEquipo.getText());
            nuevoEquipo.asignarMentor((Mentor) comboMentoresEquipo.getSelectedItem());
            nuevoEquipo.asignarRobot((Robot) comboRobotsEquipo.getSelectedItem());
            
            for(Alumno a : alumnosTemp) nuevoEquipo.agregarAlumno(a);
            
            listaEquipos.add(nuevoEquipo);
            JOptionPane.showMessageDialog(this, "Equipo " + nuevoEquipo.getNombre() + " creado!");
            
            alumnosTemp.clear();
            txtListaAlumnos.setText("");
            txtNombreEquipo.setText("");
            actualizarCombos();
        });

        panel.add(form, BorderLayout.CENTER);
        return panel;
    }

    private JPanel crearPanelTorneo() {
        JPanel panel = new JPanel(new BorderLayout());
        
        JPanel top = new JPanel(new GridLayout(3, 2));
        JTextField txtTorneo = new JTextField("Torneo Regional");
        JTextField txtSede = new JTextField("CDMX");
        JButton btnInitTorneo = new JButton("Inicializar Torneo");
        
        top.add(new JLabel("Nombre Torneo:")); top.add(txtTorneo);
        top.add(new JLabel("Sede:")); top.add(txtSede);
        top.add(new JLabel("")); top.add(btnInitTorneo);

        JPanel middle = new JPanel(new GridLayout(2, 2));
        comboEquiposTorneo = new JComboBox<>();
        JButton btnInscribir = new JButton("Inscribir Equipo");
        JButton btnVerEquipos = new JButton("Ver Lista Equipos");
        JButton btnVerDetalle = new JButton("Ver Detalle Equipo Seleccionado");

        middle.add(new JLabel("Seleccionar Equipo:")); middle.add(comboEquiposTorneo);
        middle.add(btnInscribir); middle.add(btnVerEquipos);
        
        areaResultados = new JTextArea();
        
        btnInitTorneo.addActionListener(e -> {
            torneoActual = new Torneo(txtTorneo.getText(), txtSede.getText());
            JOptionPane.showMessageDialog(this, "Torneo inicializado.");
            areaResultados.setText("Torneo listo para inscripciones.");
        });

        btnInscribir.addActionListener(e -> {
            if(torneoActual == null) {
                JOptionPane.showMessageDialog(this, "Primero inicializa el torneo.");
                return;
            }
            Equipo eq = (Equipo) comboEquiposTorneo.getSelectedItem();
            if(eq != null) {
                torneoActual.inscribirEquipo(eq);
                areaResultados.append("\nEquipo " + eq.getNombre() + " inscrito.");
            }
        });

        btnVerEquipos.addActionListener(e -> {
            if(torneoActual != null) 
                areaResultados.setText(servicio.obtenerEquiposParticipantes(torneoActual));
        });

        btnVerDetalle.addActionListener(e -> {
             Equipo eq = (Equipo) comboEquiposTorneo.getSelectedItem();
             if(eq != null) areaResultados.setText(servicio.obtenerInfoEquipo(eq));
        });

        panel.add(top, BorderLayout.NORTH);
        
        JPanel centerContainer = new JPanel(new BorderLayout());
        centerContainer.add(middle, BorderLayout.NORTH);
        centerContainer.add(btnVerDetalle, BorderLayout.SOUTH);
        
        panel.add(centerContainer, BorderLayout.CENTER);
        panel.add(new JScrollPane(areaResultados), BorderLayout.SOUTH);

        return panel;
    }

    private void actualizarCombos() {
        comboMentoresEquipo.removeAllItems();
        listaMentores.forEach(comboMentoresEquipo::addItem);

        comboRobotsEquipo.removeAllItems();
        comboRobotsComponente.removeAllItems();
        for(Robot r : listaRobots){
            comboRobotsEquipo.addItem(r);
            comboRobotsComponente.addItem(r);
        }

        comboAlumnosEquipo.removeAllItems();
        listaAlumnos.forEach(comboAlumnosEquipo::addItem);
        
        comboEquiposTorneo.removeAllItems();
        listaEquipos.forEach(comboEquiposTorneo::addItem);
    }

    private void limpiarCampos(JTextField... campos) {
        for (JTextField c : campos) c.setText("");
    }

    public static void main(String[] args) {
        try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); } catch (Exception ignored) {}
        
        SwingUtilities.invokeLater(() -> {
            new GestorTorneoApp().setVisible(true);
        });
    }
}
