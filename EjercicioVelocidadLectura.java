import javax.swing.*;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.lang.*;
import java.awt.Point;
import javax.imageio.*;
import java.awt.Image;

public class EjercicioVelocidadLectura extends JFrame implements KeyListener{

	ArrayList <String> contenidoArchivo;
	ArrayList <JLabel> lecturaArchivo;
	JLabel titulo;
	JLabel [] instruccion = new JLabel[3];
	JLabel lecturaTemporal;
	Color fondo;
	Font font1, font2, font3;
	JLabel linea;
	public EjercicioVelocidadLectura(){

		this.setLayout(null);
		
		linea=new JLabel(new ImageIcon("linea.png"));
		linea.setBounds(17,175,50,10);
		this.add(linea);

		font1 = new Font("Arial",Font.BOLD,18);
		font2 = new Font("Arial",Font.ITALIC,16);
		font3 = new Font("Arial",Font.PLAIN,16);

		contenidoArchivo = new ArrayList<String>();
		lecturaArchivo = new ArrayList<JLabel>();
		fondo = new Color(225,218,209);

		titulo = new JLabel("Educando El Ojo");
		titulo.setVisible(true);
		titulo.setBounds(275,15,200,50);
		titulo.setFont(font1);
		this.add(titulo);		

		instruccion[0] = new JLabel("Con ayuda del apoyo visual recorra el texto de izquiera a derecha atendiendo al");
		instruccion[0].setVisible(true);
		instruccion[0].setBounds(15,60,650,50);
		instruccion[0].setFont(font2);
		this.add(instruccion[0]);

		instruccion[1] = new JLabel("contenido y no solamente desplazando la mirada; el objetivo es que se pueda comprender");
		instruccion[1].setVisible(true);
		instruccion[1].setBounds(15,80,650,50);
		instruccion[1].setFont(font2);
		this.add(instruccion[1]);

		instruccion[2] = new JLabel("informacion con mayor facilidad. No se debe regresar a corroborar informacion.");
		instruccion[2].setVisible(true);
		instruccion[2].setBounds(15,100,650,50);
		instruccion[2].setFont(font2);
		this.add(instruccion[2]);

		this.setTitle("Ejercicio 1: Velocidad Lectora");
		this.setResizable(false);
		this.setBounds(350,90,690,870);
		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		this.setVisible(true);	
		this.getContentPane().setBackground(fondo);
		addKeyListener(this);
		obtenerArchivoEjercicio();
	}

	public void obtenerArchivoEjercicio(){
		contenidoArchivo = Archivo.leerTodo("EjercicioVelocidadLectura.txt");
		for(int i=0; i<contenidoArchivo.size();i++){

			lecturaTemporal=new JLabel(contenidoArchivo.get(i));
			add(lecturaTemporal,SwingConstants.CENTER);
			lecturaTemporal.setHorizontalTextPosition(SwingConstants.CENTER);
			lecturaTemporal.setFont(font3);

			lecturaTemporal.setText(contenidoArchivo.get(i));
			lecturaArchivo.add(lecturaTemporal);
			lecturaArchivo.get(i).setBounds(15,150+(30*i),1000,30);
			lecturaArchivo.get(i).setVisible(true);
			this.add(lecturaArchivo.get(i));
		}
	}

	public void keyPressed(KeyEvent e)
	{
		int t = e.getKeyCode();
		Point pos = linea.getLocation();
		int x = (int)pos.getX();
		int y = (int)pos.getY();
		if(t==68){
			x = x+5;
			if(x >=600)
		{
			y = y+30;
			x =17;
		}
		}
		linea.setLocation(x,y);
	}
	public void keyReleased(KeyEvent e)
	{}
	public void keyTyped(KeyEvent e)
	{}

}