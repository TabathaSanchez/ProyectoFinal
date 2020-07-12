import javax.swing.*;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

public class EjercicioEvaluacion extends JFrame implements ActionListener{

	ArrayList <String> contenidoArchivo;
	ArrayList <JLabel> lecturaArchivo;
	JLabel titulo;
	JLabel [] instruccion = new JLabel[3];
	JLabel lecturaTemporal;
	Color fondo;
	Font font1, font2, font3;
	JButton btnInicio, btnEvaluacion;
	Cronometro cronometro;
	Evaluacion e;
	int palabrasTexto = 305;
	int palabrasReferencia= palabrasTexto*60;
	int palabrasPorMinuto=0;
	int tiempo;

	public EjercicioEvaluacion(){

		this.setLayout(null);

		font1 = new Font("Arial",Font.BOLD,18);
		font2 = new Font("Arial",Font.ITALIC,16);
		font3 = new Font("Arial",Font.PLAIN,16);

		btnInicio = new JButton("Iniciar");
		btnInicio.setVisible(true);
		btnInicio.setBounds(500,250,100,30);
		btnInicio.addActionListener(this);
		this.add(btnInicio);

		btnEvaluacion = new JButton("Evaluar");
		btnEvaluacion.setVisible(false);
		btnEvaluacion.setBounds(500,820,100,30);
		this.add(btnEvaluacion);
		btnEvaluacion.addActionListener(this);


		contenidoArchivo = new ArrayList<String>();
		lecturaArchivo = new ArrayList<JLabel>();
		fondo = new Color(225,218,209);

		titulo = new JLabel("Evaluacion de la Unidad");
		titulo.setVisible(true);
		titulo.setBounds(250,15,230,50);
		titulo.setFont(font1);
		this.add(titulo);		

		instruccion[0] = new JLabel("Con unicamente la mirada, sin mover la cabeza, recorra el texto de izquiera a derecha ");
		instruccion[0].setVisible(true);
		instruccion[0].setBounds(15,60,650,50);
		instruccion[0].setFont(font2);
		this.add(instruccion[0]);

		instruccion[1] = new JLabel("atendiendo al contenido y no solamente desplazando la mirada. No se debe regresar ");
		instruccion[1].setVisible(true);
		instruccion[1].setBounds(15,80,650,50);
		instruccion[1].setFont(font2);
		this.add(instruccion[1]);

		instruccion[2] = new JLabel("a corroborar informacion.");
		instruccion[2].setVisible(true);
		instruccion[2].setBounds(15,100,650,50);
		instruccion[2].setFont(font2);
		this.add(instruccion[2]);



		this.setTitle("Ejercicio de Evaluacion");
		this.setResizable(true);
		this.setBounds(350,90,690,400);
		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		this.setVisible(true);	
		this.getContentPane().setBackground(fondo);

		System.out.println(Cronometro.detenido);


	}

	public void obtenerArchivoEjercicio(){
		contenidoArchivo = Archivo.leerTodo("EjercicioEvaluacion.txt");
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
			btnEvaluacion.setVisible(true);

		}

	}

	public void actionPerformed (ActionEvent event){
		if(event.getSource()==btnInicio){
			this.setBounds(350,90,690,900);
			this.remove(btnInicio);
			obtenerArchivoEjercicio();
			cronometro = new Cronometro();
			cronometro.iniciarHilo=true;
			cronometro.iniciarHiloCronometro();

		}

		if(event.getSource()==btnEvaluacion){
			tiempo=((Cronometro.minuto*60)+Cronometro.segundo);
			palabrasPorMinuto=palabrasReferencia/tiempo;
			this.dispose();
			e= new Evaluacion();

		}

	}
	
}