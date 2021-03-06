import javax.swing.*;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.lang.*;
import java.awt.Point;
import javax.imageio.*;
import java.awt.Image;

public class EjercicioMovimientoOjoCerebro extends JPanel implements KeyListener {

	JFrame frame;

	ArrayList <String> contenidoArchivo1,contenidoArchivo2,contenidoArchivo3,contenidoArchivo4;
	ArrayList <JLabel> lecturaArchivo1,lecturaArchivo2,lecturaArchivo3,lecturaArchivo4;
	JLabel titulo, linea,linea2;
	JLabel [] instruccion = new JLabel[3];
	JLabel lecturaTemporal;
	Color fondo;
	Font font1, font2, font3;
	static int contador=0;



	public EjercicioMovimientoOjoCerebro(){
		frame = new JFrame();

		this.setLayout(null);

		font1 = new Font("Arial",Font.BOLD,18);
		font2 = new Font("Arial",Font.ITALIC,16);
		font3 = new Font("Arial",Font.PLAIN,16);

		contenidoArchivo1 = new ArrayList<String>();
		contenidoArchivo2 = new ArrayList<String>();
		contenidoArchivo3 = new ArrayList<String>();
		contenidoArchivo4 = new ArrayList<String>();

		lecturaArchivo1 = new ArrayList<JLabel>();
		lecturaArchivo2 = new ArrayList<JLabel>();
		lecturaArchivo3 = new ArrayList<JLabel>();
		lecturaArchivo4 = new ArrayList<JLabel>();


		fondo = new Color(225,218,209);

		titulo = new JLabel("El Rapido Movimiento Ojo-Cerebro");
		titulo.setVisible(true);
		titulo.setBounds(190,15,310,50);
		titulo.setFont(font1);
		this.add(titulo);		                                                                                        

		instruccion[0] = new JLabel("Con ayuda del apoyo visual recorra el texto de arriba hacia abajo y deslice la mirada");
		instruccion[0].setVisible(true);
		instruccion[0].setBounds(15,60,650,50);
		instruccion[0].setFont(font2);
		this.add(instruccion[0]);

		instruccion[1] = new JLabel("sin detenerse. El objetivo es que se perciban las palabras de una manera veloz,");
		instruccion[1].setVisible(true);
		instruccion[1].setBounds(15,80,650,50);
		instruccion[1].setFont(font2);
		this.add(instruccion[1]);

		instruccion[2] = new JLabel("tratando de comprender la informacion. Presione 'a' para mover apoyo visual.");
		instruccion[2].setVisible(true);
		instruccion[2].setBounds(15,100,650,50);
		instruccion[2].setFont(font2);
		this.add(instruccion[2]);

		linea = new JLabel(new ImageIcon("linea2.png"));
		linea.setBounds(0,175,120,10);
		this.add(linea);


		frame.add(this);
		frame.setTitle("Ejercicio 2: El Rapido Movimiento Ojo-Cerebro");
		frame.setResizable(true);
		frame.setBounds(200,0,660,950);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);	
		frame.getContentPane().setBackground(fondo);
		frame.addKeyListener(this);

		obtenerArchivoEjercicio();


	}


	public void obtenerArchivoEjercicio(){
		contenidoArchivo1 = Archivo.leerTodo("EjercicioMovimientoOjoCerebro1.txt");
		contenidoArchivo2 = Archivo.leerTodo("EjercicioMovimientoOjoCerebro2.txt");
		contenidoArchivo3 = Archivo.leerTodo("EjercicioMovimientoOjoCerebro3.txt");
		contenidoArchivo4 = Archivo.leerTodo("EjercicioMovimientoOjoCerebro4.txt");

		for(int i=0; i<contenidoArchivo1.size();i++){

			lecturaTemporal=new JLabel(contenidoArchivo1.get(i));
			add(lecturaTemporal,SwingConstants.CENTER);
			lecturaTemporal.setHorizontalTextPosition(SwingConstants.CENTER);
			lecturaTemporal.setFont(font3);

			lecturaTemporal.setText(contenidoArchivo1.get(i));
			lecturaArchivo1.add(lecturaTemporal);
			lecturaArchivo1.get(i).setBounds(15,150+(22*i),1000,30);
			lecturaArchivo1.get(i).setVisible(true);
			this.add(lecturaArchivo1.get(i));
		}

		for(int i=0; i<contenidoArchivo2.size();i++){

			lecturaTemporal=new JLabel(contenidoArchivo2.get(i));
			add(lecturaTemporal,SwingConstants.CENTER);
			lecturaTemporal.setHorizontalTextPosition(SwingConstants.CENTER);
			lecturaTemporal.setFont(font3);

			lecturaTemporal.setText(contenidoArchivo2.get(i));
			lecturaArchivo2.add(lecturaTemporal);
			lecturaArchivo2.get(i).setBounds(150,150+(22*i),1000,30);
			lecturaArchivo2.get(i).setVisible(true);
			this.add(lecturaArchivo2.get(i));
		}
		for(int i=0; i<contenidoArchivo3.size();i++){

			lecturaTemporal=new JLabel(contenidoArchivo3.get(i));
			add(lecturaTemporal,SwingConstants.CENTER);
			lecturaTemporal.setHorizontalTextPosition(SwingConstants.CENTER);
			lecturaTemporal.setFont(font3);

			lecturaTemporal.setText(contenidoArchivo3.get(i));
			lecturaArchivo3.add(lecturaTemporal);
			lecturaArchivo3.get(i).setBounds(300,150+(22*i),1000,30);
			lecturaArchivo3.get(i).setVisible(true);
			this.add(lecturaArchivo3.get(i));
		}
		for(int i=0; i<contenidoArchivo4.size();i++){

			lecturaTemporal=new JLabel(contenidoArchivo4.get(i));
			add(lecturaTemporal,SwingConstants.CENTER);
			lecturaTemporal.setHorizontalTextPosition(SwingConstants.CENTER);
			lecturaTemporal.setFont(font3);

			lecturaTemporal.setText(contenidoArchivo4.get(i));
			lecturaArchivo4.add(lecturaTemporal);
			lecturaArchivo4.get(i).setBounds(450,150+(22*i),1000,30);
			lecturaArchivo4.get(i).setVisible(true);
			this.add(lecturaArchivo4.get(i));
		}



	}

public void keyPressed(KeyEvent e)
	{
		int a=0;
		int t = e.getKeyCode();
		Point pos = linea.getLocation();
		int x = (int)pos.getX();
		int y = (int)pos.getY();
		if(t==65)
		{
			y+=22;
			if(y>(175+((lecturaArchivo1.size()-1)*22))){
				x+=145;
				y=175;
				contador++;
				if(x>500){x=0;}
				}
			
		}
		linea.setLocation(x,y);
	}

public void keyReleased(KeyEvent e)
	{
		//System.out.println("Tecla liberada.");
	}

public void keyTyped(KeyEvent e)
	{
		//System.out.println("Tecla en el buffer.");

	}
	
}