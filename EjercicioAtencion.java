import javax.swing.*;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Canvas;

public class EjercicioAtencion extends JPanel{

	JFrame frame;

	ArrayList <String> contenidoArchivo1,contenidoArchivo2,contenidoArchivo3;
	ArrayList <JLabel> lecturaArchivo1,lecturaArchivo2,lecturaArchivo3;
	JLabel titulo;
	JLabel [] instruccion = new JLabel[3];
	JLabel [] palabraClave = new JLabel[8];
	//JButton [] btnSeparacion = new JButton[8];
	JLabel lecturaTemporal;
	Color fondo;
	Font font1, font2, font3;


	public EjercicioAtencion(){

		frame = new JFrame();
		this.setLayout(null);


		font1 = new Font("Arial",Font.BOLD,18);
		font2 = new Font("Arial",Font.ITALIC,16);
		font3 = new Font("Arial",Font.PLAIN,16);

		contenidoArchivo1 = new ArrayList<String>();
		lecturaArchivo1 = new ArrayList<JLabel>();
		contenidoArchivo2 = new ArrayList<String>();
		lecturaArchivo2 = new ArrayList<JLabel>();
		contenidoArchivo3 = new ArrayList<String>();
		lecturaArchivo3 = new ArrayList<JLabel>();
		fondo = new Color(225,218,209);

		titulo = new JLabel("Dedicar Atencion");
		titulo.setVisible(true);
		titulo.setBounds(275,15,200,50);
		titulo.setFont(font1);
		this.add(titulo);		

		instruccion[0] = new JLabel("Vea las palabras clave y busque el o los sinonimos; se deben mover los ojos sin regresar.");
		instruccion[0].setVisible(true);
		instruccion[0].setBounds(15,60,650,50);
		instruccion[0].setFont(font2);
		this.add(instruccion[0]);

		instruccion[1] = new JLabel("Por medio de la practica se podra efectuar con mayor rapidez. El objetivo es que el nivel");
		instruccion[1].setVisible(true);
		instruccion[1].setBounds(15,80,650,50);
		instruccion[1].setFont(font2);
		this.add(instruccion[1]);

		instruccion[2] = new JLabel("de atencion aumente, eliminando gradualmente distractores.");
		instruccion[2].setVisible(true);
		instruccion[2].setBounds(15,100,650,50);
		instruccion[2].setFont(font2);
		this.add(instruccion[2]);

		palabraClave[0]= new JLabel("      Crisis");
		palabraClave[1]= new JLabel("     Valentia");
		palabraClave[2]= new JLabel("      Calma");
		palabraClave[3]= new JLabel("      Regalo");
		palabraClave[4]= new JLabel("   Inteligencia");
		palabraClave[5]= new JLabel("    Estrategia");
		palabraClave[6]= new JLabel("Responsabilidad");

		frame.add(this);
		//this.setLayout(null);
		frame.setTitle("Ejercicio 4: Dedicar Atencion");
		frame.setResizable(false);
		frame.setBounds(200,0,690,870);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);	
		frame.getContentPane().setBackground(fondo);
		obtenerArchivoEjercicio();
	}

	public void obtenerArchivoEjercicio(){
		contenidoArchivo1=Archivo.leerTodo("EjercicioAtencion1.txt");
		contenidoArchivo2=Archivo.leerTodo("EjercicioAtencion2.txt");
		contenidoArchivo3=Archivo.leerTodo("EjercicioAtencion3.txt");

		for(int i=0;i<7;i++){
			add(palabraClave[i],SwingConstants.CENTER);
			palabraClave[i].setHorizontalTextPosition(SwingConstants.CENTER);
			palabraClave[i].setFont(font3);
			palabraClave[i].setBounds(15,150+(i*80),150,50);
			this.add(palabraClave[i]);
		}

		for(int i=0;i<contenidoArchivo1.size();i++){
			lecturaTemporal=new JLabel(contenidoArchivo1.get(i));
			add(lecturaTemporal,SwingConstants.CENTER);
			lecturaTemporal.setHorizontalTextPosition(SwingConstants.CENTER);
			lecturaTemporal.setFont(font3);

			lecturaTemporal.setText(contenidoArchivo1.get(i));
			lecturaArchivo1.add(lecturaTemporal);
			lecturaArchivo1.get(i).setBounds(200,150+(40*i),120,50);
			lecturaArchivo1.get(i).setVisible(true);
			this.add(lecturaArchivo1.get(i));
		}
		
		for(int i=0;i<contenidoArchivo2.size();i++){
			lecturaTemporal=new JLabel(contenidoArchivo2.get(i));
			add(lecturaTemporal,SwingConstants.CENTER);
			lecturaTemporal.setHorizontalTextPosition(SwingConstants.CENTER);
			lecturaTemporal.setFont(font3);

			lecturaTemporal.setText(contenidoArchivo2.get(i));
			lecturaArchivo2.add(lecturaTemporal);
			lecturaArchivo2.get(i).setBounds(350,150+(40*i),120,50);
			lecturaArchivo2.get(i).setVisible(true);
			this.add(lecturaArchivo2.get(i));
		}

		for(int i=0;i<contenidoArchivo3.size();i++){
			lecturaTemporal=new JLabel(contenidoArchivo3.get(i));
			add(lecturaTemporal,SwingConstants.CENTER);
			lecturaTemporal.setHorizontalTextPosition(SwingConstants.CENTER);
			lecturaTemporal.setFont(font3);

			lecturaTemporal.setText(contenidoArchivo3.get(i));
			lecturaArchivo3.add(lecturaTemporal);
			lecturaArchivo3.get(i).setBounds(500,150+(40*i),120,50);
			lecturaArchivo3.get(i).setVisible(true);
			this.add(lecturaArchivo3.get(i));
		}


	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		for(int i=0;i<8;i++){
			g.drawLine(175,160+(i*80),650,160+(i*80));
		}
		
	}
	
}