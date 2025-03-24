import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Preguntados extends JFrame implements ActionListener {

    private int puntaje = 0;
    private int preguntaActual = 0;
    private String[] respuestasUsuario;

    private JButton botonIniciar;
    private JLabel etiquetaPregunta;
    private ButtonGroup grupoOpciones;
    private JRadioButton[] opciones;
    private JButton botonSiguiente;

    private Pregunta[] preguntas = {
        new Pregunta("¿Cuál es la capital de Francia?", new String[]{"París", "Londres", "Madrid", "Berlín"}, "París"),
        new Pregunta("¿Cuántos planetas hay en nuestro sistema solar?", new String[]{"8", "9", "10", "7"}, "8"),
        new Pregunta("¿Cuál es el animal más grande del mundo?", new String[]{"Elefante", "Ballena Azul", "Jirafa", "Hipopótamo"}, "Ballena Azul"),
        new Pregunta("¿En qué año comenzó la Segunda Guerra Mundial?", new String[]{"1939", "1941", "1945", "1935"}, "1939"),
        new Pregunta("¿Quién escribió 'Cien años de soledad'?", new String[]{"Gabriel García Márquez", "Pablo Neruda", "Isabel Allende", "Mario Vargas Llosa"}, "Gabriel García Márquez"),
        new Pregunta("¿Cuál es el río más largo del mundo?", new String[]{"Amazonas", "Nilo", "Misisipi", "Yangtsé"}, "Amazonas"),
        new Pregunta("¿Qué planeta es conocido como 'el planeta rojo'?", new String[]{"Marte", "Venus", "Júpiter", "Saturno"}, "Marte"),
        new Pregunta("¿Cuál es la montaña más alta del mundo?", new String[]{"Monte Everest", "K2", "Kangchenjunga", "Lhotse"}, "Monte Everest"),
        new Pregunta("¿En qué año se fundó la Organización de las Naciones Unidas (ONU)?", new String[]{"1945", "1955", "1935", "1965"}, "1945"),
        new Pregunta("¿Cuál es la capital de Australia?", new String[]{"Canberra", "Sídney", "Melbourne", "Brisbane"}, "Canberra"),
        new Pregunta("¿Cuál es la capital de Argentina?", new String[]{"Buenos Aires", "Montevideo", "Santiago", "Asunción"}, "Buenos Aires"),
        new Pregunta("¿En qué año se firmó la Declaración de Independencia de los Estados Unidos?", new String[]{"1776", "1789", "1800", "1750"}, "1776"),
        new Pregunta("¿Cuál es el océano más grande de la Tierra?", new String[]{"Océano Pacífico", "Océano Atlántico", "Océano Índico", "Océano Antártico"}, "Océano Pacífico"),
        new Pregunta("¿Cuál es el componente principal del aire que respiramos?", new String[]{"Nitrógeno", "Oxígeno", "Dióxido de carbono", "Argón"}, "Oxígeno"),
        new Pregunta("¿Quién fue el primer presidente de Estados Unidos?", new String[]{"George Washington", "Thomas Jefferson", "Abraham Lincoln", "John Adams"}, "George Washington"),
        new Pregunta("¿Cuál es el libro más vendido de todos los tiempos?", new String[]{"La Biblia", "Don Quijote de la Mancha", "Harry Potter y la piedra filosofal", "El Señor de los Anillos"}, "La Biblia"),
        new Pregunta("¿En qué año se llevó a cabo la Revolución Rusa?", new String[]{"1917", "1905", "1923", "1930"}, "1917"),
        new Pregunta("¿Cuántos continentes hay en el mundo?", new String[]{"7", "5", "6", "8"}, "7"),
        new Pregunta("¿Quién pintó la Mona Lisa?", new String[]{"Leonardo da Vinci", "Vincent van Gogh", "Pablo Picasso", "Claude Monet"}, "Leonardo da Vinci"),
        new Pregunta("¿Cuál es la velocidad de la luz?", new String[]{"299,792,458 metros por segundo", "150,000,000 metros por segundo", "500,000,000 metros por segundo", "200,000,000 metros por segundo"}, "299,792,458 metros por segundo"),
        new Pregunta("¿En qué año se llevó a cabo la Revolución Industrial?", new String[]{"Siglo XVIII", "Siglo XIX", "Siglo XX", "Siglo XVII"}, "Siglo XVIII"),
        new Pregunta("¿Cuál es el país más grande del mundo en términos de superficie terrestre?", new String[]{"Rusia", "Canadá", "Estados Unidos", "China"}, "Rusia"),
        new Pregunta("¿Cuántos huesos tiene el cuerpo humano adulto?", new String[]{"206", "180", "230", "250"}, "206"),
        new Pregunta("¿Cuál es el metal más abundante en la corteza terrestre?", new String[]{"Aluminio", "Hierro", "Cobre", "Plomo"}, "Aluminio"),
        new Pregunta("¿Quién escribió 'Romeo y Julieta'?", new String[]{"William Shakespeare", "Jane Austen", "Charles Dickens", "Homer"}, "William Shakespeare"),
        new Pregunta("¿Cuál es el instrumento musical más antiguo del mundo?", new String[]{"Flauta", "Lira", "Tambor", "Arpa"}, "Flauta"),
        new Pregunta("¿En qué año se inauguró el Canal de Panamá?", new String[]{"1914", "1900", "1925", "1930"}, "1914"),
        new Pregunta("¿Cuántos colores tiene el arco iris?", new String[]{"7", "6", "8", "5"}, "7"),
        new Pregunta("¿Qué gas es necesario para la fotosíntesis de las plantas?", new String[]{"Dióxido de carbono (CO2)", "Oxígeno (O2)", "Nitrógeno (N2)", "Metano (CH4)"}, "Dióxido de carbono (CO2)"),
        // Agrega más preguntas según sea necesario
    };

    public Preguntados() {
        setTitle("Juego de Preguntas y Respuestas");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        respuestasUsuario = new String[preguntas.length];

        getContentPane().setBackground(new Color(44, 62, 80)); // Color: Midnight Blue

        botonIniciar = crearBoton("Iniciar Juego");
        botonIniciar.addActionListener(this);

        botonSiguiente = crearBoton("Siguiente");
        botonSiguiente.addActionListener(this);

        JPanel panelInicio = new JPanel(new GridBagLayout());

        // Añade el botón de inicio
        GridBagConstraints gbcBotonInicio = new GridBagConstraints();
        gbcBotonInicio.gridx = 0;
        gbcBotonInicio.gridy = 0;
        panelInicio.add(botonIniciar, gbcBotonInicio);

        // Añade la etiqueta de versión
        JLabel etiquetaVersion = new JLabel("Version: Beta-1.1.0.2");
        etiquetaVersion.setForeground(Color.gray); // Color: Gris oscuro
        GridBagConstraints gbcEtiquetaVersion = new GridBagConstraints();
        gbcEtiquetaVersion.gridx = 0;
        gbcEtiquetaVersion.gridy = 1;
        gbcEtiquetaVersion.anchor = GridBagConstraints.LINE_END; // Alinea a la derecha
        panelInicio.add(etiquetaVersion, gbcEtiquetaVersion);

        add(panelInicio);

        setVisible(true);
    }

    private JButton crearBoton(String texto) {
        JButton boton = new JButton(texto);
        boton.setBackground(new Color(34, 167, 240)); // Color: Dodger Blue
        boton.setForeground(Color.white);
        boton.setFocusPainted(false);
        boton.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25));
        return boton;
    }

    private void iniciarJuego() {
        getContentPane().removeAll();
        getContentPane().setBackground(null);

        etiquetaPregunta = new JLabel();
        grupoOpciones = new ButtonGroup();
        opciones = new JRadioButton[4];
        botonSiguiente = crearBoton("Siguiente");
        botonSiguiente.addActionListener(this);

        JPanel panelPregunta = new JPanel(new BorderLayout());
        panelPregunta.add(etiquetaPregunta, BorderLayout.NORTH);

        JPanel panelOpciones = new JPanel(new GridLayout(0, 1));
        for (int i = 0; i < opciones.length; i++) {
            opciones[i] = new JRadioButton();
            grupoOpciones.add(opciones[i]);
            panelOpciones.add(opciones[i]);
        }

        panelPregunta.add(panelOpciones, BorderLayout.CENTER);
        add(panelPregunta, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel(new FlowLayout());
        panelBotones.add(botonSiguiente);
        add(panelBotones, BorderLayout.SOUTH);

        mostrarSiguientePregunta();
        repaint();
    }


    private void mostrarOpciones(String[] opciones) {
        for (int i = 0; i < this.opciones.length; i++) {
            if (i < opciones.length) {
                this.opciones[i].setText(opciones[i]);
                this.opciones[i].setVisible(true);
            } else {
                this.opciones[i].setVisible(false);
            }
        }
    }

    private void mostrarSiguientePregunta() {
        if (preguntaActual < preguntas.length) {
            etiquetaPregunta.setText(preguntas[preguntaActual].getEnunciado());
            mostrarOpciones(preguntas[preguntaActual].getOpciones());
        } else {
            finalizarJuego();
        }
    }

    private void finalizarJuego() {
        int preguntasTotales = preguntas.length;
        int aciertos = puntaje;
    
        String mensajeFinal = "Juego terminado. Haz acertado " + aciertos + " de " + preguntasTotales + " preguntas.";
    
        JButton botonAceptar = crearBoton("Reiniciar Juego");
        botonAceptar.addActionListener(this);
        botonAceptar.setBackground(new Color(46, 204, 113)); // Color: Emerald Green
        botonAceptar.setForeground(Color.white);
        botonAceptar.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25));
    
        // Utiliza un cuadro de diálogo personalizado
        JDialog dialog = new JDialog(this, "Partida Finalizada", true);
        dialog.setLayout(new BorderLayout());
    
        JLabel labelMensaje = new JLabel(mensajeFinal);
        labelMensaje.setHorizontalAlignment(JLabel.CENTER);
    
        JPanel panelBoton = new JPanel();
        panelBoton.add(botonAceptar);
    
        dialog.add(labelMensaje, BorderLayout.CENTER);
        dialog.add(panelBoton, BorderLayout.SOUTH);
    
        dialog.setSize(500, 600);
        dialog.setLocationRelativeTo(this);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    
        botonAceptar.addActionListener(e -> {
            dialog.dispose(); // Cierra el cuadro de diálogo al hacer clic en el botón
            reiniciarJuego();
        });
    
        // Hace visible el cuadro de diálogo
        dialog.setVisible(true);
    }

    private void reiniciarJuego() {
        preguntaActual = 0;
        puntaje = 0;
        getContentPane().removeAll();
        getContentPane().setBackground(new Color(44, 62, 80));
    
        // Añade el botón de inicio y la etiqueta de versión
        JPanel panelInicio = new JPanel(new GridBagLayout());
    
        GridBagConstraints gbcBotonInicio = new GridBagConstraints();
        gbcBotonInicio.gridx = 0;
        gbcBotonInicio.gridy = 0;
        panelInicio.add(botonIniciar, gbcBotonInicio);
    
        JLabel etiquetaVersion = new JLabel("Version: Beta-1.1.0.2");
        etiquetaVersion.setForeground(Color.gray); // Color: Gris oscuro
        GridBagConstraints gbcEtiquetaVersion = new GridBagConstraints();
        gbcEtiquetaVersion.gridx = 0;
        gbcEtiquetaVersion.gridy = 1;
        gbcEtiquetaVersion.anchor = GridBagConstraints.LINE_END; // Alinea a la derecha
        panelInicio.add(etiquetaVersion, gbcEtiquetaVersion);
    
        JButton botonIdiomas = crearBoton("Idiomas");
        botonIdiomas.addActionListener(this);
        GridBagConstraints gbcBotonIdiomas = new GridBagConstraints();
        gbcBotonIdiomas.gridx = 0;
        gbcBotonIdiomas.gridy = 2;
        panelInicio.add(botonIdiomas, gbcBotonIdiomas);
    
        add(panelInicio);
    
        revalidate();
        repaint();
    
        // Inicia automáticamente el juego después de reiniciar
        iniciarJuego();
    }

    private void actualizarInterfaz() {
        mostrarSiguientePregunta();
        for (JRadioButton opcion : opciones) {
            opcion.setSelected(false);
        }
        repaint();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonIniciar) {
            iniciarJuego();
        } else if (e.getSource() == botonSiguiente) {
            if (opcionSeleccionadaCorrecta()) {
                puntaje++;
            }
            guardarRespuestaUsuario();
            preguntaActual++;
            actualizarInterfaz();
        }
    }


    private boolean opcionSeleccionadaCorrecta() {
        for (JRadioButton opcion : opciones) {
            if (opcion.isSelected() && opcion.getText().equals(preguntas[preguntaActual].getRespuestaCorrecta())) {
                return true;
            }
        }
        return false;
    }

    private void guardarRespuestaUsuario() {
        for (int i = 0; i < opciones.length; i++) {
            if (opciones[i].isSelected()) {
                respuestasUsuario[preguntaActual] = opciones[i].getText();
                break;
            }
        }
    }

   public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Preguntados());
    }

    private static class Pregunta {
        private String enunciado;
        private String[] opciones;
        private String respuestaCorrecta;

        public Pregunta(String enunciado, String[] opciones, String respuestaCorrecta) {
            this.enunciado = enunciado;
            this.opciones = opciones;
            this.respuestaCorrecta = respuestaCorrecta;
        }

        public String getEnunciado() {
            return enunciado;
        }

        public String[] getOpciones() {
            return opciones;
        }

        public String getRespuestaCorrecta() {
            return respuestaCorrecta;
        }
    }
}