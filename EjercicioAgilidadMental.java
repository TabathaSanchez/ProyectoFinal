import javax.swing.*;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Font;
import java.util.Random;
import java.awt.event.*;

public class EjercicioAgilidadMental extends JFrame implements ActionListener {


	JLabel titulo;
	JLabel [] instruccion = new JLabel[3];
	JLabel labelReactivo1,labelReactivo2, labelOperacion;
	JButton btnRespuesta;
	Color fondo;
	Font font1, font2, font3;
	Random aleatorio;
	JTextField campo;
	int reactivo1, reactivo2, respuesta, operacion, respuestaEstudiante;
	static int contador =0;


	public EjercicioAgilidadMental(){

		this.setLayout(null);

		aleatorio=new Random();


		font1 = new Font("Arial",Font.BOLD,18);
		font2 = new Font("Arial",Font.ITALIC,16);
		font3 = new Font("Arial",Font.PLAIN,16);

		fondo = new Color(225,218,209);

		titulo = new JLabel("Agilidad Mental");
		titulo.setVisible(true);
		titulo.setBounds(275,15,200,50);
		titulo.setFont(font1);
		this.add(titulo);		

		instruccion[0] = new JLabel("Durante un minuto apareceran operaciones basicas diferentes; usted debera resolver la");
		instruccion[0].setVisible(true);
		instruccion[0].setBounds(15,60,650,50);
		instruccion[0].setFont(font2);
		this.add(instruccion[0]);

		instruccion[1] = new JLabel("mayor cantidad posible antes de que el tiempo termine. El objetivo principal de este ");
		instruccion[1].setVisible(true);
		instruccion[1].setBounds(15,80,650,50);
		instruccion[1].setFont(font2);
		this.add(instruccion[1]);

		instruccion[2] = new JLabel("ejercicio es que la mente despierte.");
		instruccion[2].setVisible(true);
		instruccion[2].setBounds(15,100,650,50);
		instruccion[2].setFont(font2);
		this.add(instruccion[2]);

		btnRespuesta = new JButton("Respuesta");
		btnRespuesta.setVisible(true);
		btnRespuesta.setBounds(500,350,100,30);
		btnRespuesta.addActionListener(this);
		this.add(btnRespuesta);

		campo = new JTextField();
		campo.setVisible(true);
		campo.setBounds(230,190,50,30);
		this.add(campo);

		obtenerVariable();
		obtenerOperacion();



		this.setTitle("Ejercicio 4: Agilidad Mental");
		this.setResizable(true);
		this.setBounds(350,90,670,500);
		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		this.setVisible(true);	
		this.getContentPane().setBackground(fondo);

	}

	public void actionPerformed (ActionEvent event){


		if(event.getSource()==btnRespuesta){
			this.remove(labelReactivo1);
			this.remove(labelOperacion);
			this.remove(labelReactivo2);
			obtenerResultado();
		}

	}


	public void obtenerVariable(){

		reactivo1 = 1+ aleatorio.nextInt(15);
		reactivo2 = 1+ aleatorio.nextInt(15);


		labelReactivo1=new JLabel(String.valueOf(reactivo1));
		add(labelReactivo1,SwingConstants.CENTER);
		labelReactivo1.setVisible(true);
		labelReactivo1.setBounds(15,180,50,50);
		labelReactivo1.setFont(font3);
		this.add(labelReactivo1);

		labelReactivo2=new JLabel(String.valueOf(reactivo2));
		add(labelReactivo2,SwingConstants.CENTER);
		labelReactivo2.setVisible(true);
		labelReactivo2.setBounds(120,180,50,50);
		labelReactivo2.setFont(font3);
		this.add(labelReactivo2);

		System.out.println(contador);
	}

	public void  obtenerOperacion(){

		operacion =  aleatorio.nextInt(4);


		try{
			if(operacion==0)
			{
				labelOperacion = new JLabel("+");
				add(labelOperacion,SwingConstants.CENTER);
				labelOperacion.setVisible(true);
				labelOperacion.setBounds(60,180,50,50);
				labelOperacion.setFont(font3);
				this.add(labelOperacion);
				respuesta=reactivo1+reactivo2;

			}else if(operacion==1)
			{
				labelOperacion = new JLabel("-");
				add(labelOperacion,SwingConstants.CENTER);
				labelOperacion.setVisible(true);
				labelOperacion.setBounds(60,180,50,50);
				labelOperacion.setFont(font3);
				this.add(labelOperacion);
				respuesta=reactivo1-reactivo2;

			}else if(operacion==2)
			{
				labelOperacion = new JLabel("x");
				add(labelOperacion,SwingConstants.CENTER);
				labelOperacion.setVisible(true);
				labelOperacion.setBounds(60,180,50,50);
				labelOperacion.setFont(font3);
				this.add(labelOperacion);
				respuesta=reactivo1*reactivo2;

			}else
			{
				labelOperacion = new JLabel("/");
				add(labelOperacion,SwingConstants.CENTER);
				labelOperacion.setVisible(true);
				labelOperacion.setBounds(60,180,50,50);
				labelOperacion.setFont(font3);
				this.add(labelOperacion);
				respuesta=reactivo1/reactivo2;
			}

		}catch(Exception e){e.printStackTrace();}

	}

	public void obtenerResultado(){

		respuestaEstudiante=Integer.parseInt(campo.getText());

		if(respuesta==respuestaEstudiante){contador++;}
		obtenerVariable();
		obtenerOperacion();

	}

	
}