import javax.swing.*;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.util.Vector;

public class Evaluacion extends JFrame implements ActionListener{

	ArrayList <String> contenidoArchivo;
	ArrayList <JLabel> lecturaArchivo;
	JLabel titulo, instruccion;
	JLabel [] pregunta = new JLabel[5];
	JLabel lecturaTemporal;
	Color fondo;
	Font font1, font2, font3;
	JButton btnInicio;
	Cronometro cronometro;

	Vector<Object> listaPregunta1,listaPregunta2,listaPregunta3,listaPregunta4,listaPregunta5;
	JComboBox  [] preguntaBox = new JComboBox[5];
	static int contador=0;

	public Evaluacion(){

		this.setLayout(null);

		font1 = new Font("Arial",Font.BOLD,18);
		font2 = new Font("Arial",Font.ITALIC,16);
		font3 = new Font("Arial",Font.PLAIN,16);

		btnInicio = new JButton("Evaluar");
		btnInicio.setVisible(true);
		btnInicio.setBounds(500,500,100,30);
		btnInicio.addActionListener(this);
		this.add(btnInicio);


		listaPregunta1=new Vector<Object>();
		listaPregunta2=new Vector<Object>();
		listaPregunta3=new Vector<Object>();
		listaPregunta4=new Vector<Object>();
		listaPregunta5=new Vector<Object>();


		contenidoArchivo = new ArrayList<String>();
		lecturaArchivo = new ArrayList<JLabel>();
		fondo = new Color(225,218,209);

		titulo = new JLabel("Evaluacion de la Unidad");
		titulo.setVisible(true);
		titulo.setBounds(250,15,230,50);
		titulo.setFont(font1);
		this.add(titulo);

		instruccion = new JLabel("En base a la lectura anterior, responde de manera correcta las siguientes preguntas");
		instruccion.setVisible(true);
		instruccion.setBounds(15,60,650,50);
		instruccion.setFont(font2);
		this.add(instruccion);

		for(int i = 0; i<5;i++){
			pregunta[i] = new JLabel();
			pregunta[i].setVisible(true);
			pregunta[i].setBounds(15,120+(i*80),650,40);
			pregunta[i].setFont(font3);
			this.add(pregunta[i]);

			preguntaBox[i]= new JComboBox();
	    	preguntaBox[i].setBounds(15,160+(80*i),240,20);
	    	preguntaBox[i].setVisible(true);
	    	this.add(preguntaBox[i]);

		}

		pregunta[0].setText("De los primeros hombres y mujeres, cual era el volumen de sus cerebros?");
		pregunta[1].setText("Especie del genero homo que tenia mayor volumen cerebral que el sapiens:");	
		pregunta[2].setText("Con que familia compara el texto en volumen cerebral al nuestro?");	
		pregunta[3].setText("Que porcentaje de nuestra energia consume el cerebro en reposo?");	
		pregunta[4].setText("Mencione los costos que ha llevado el mantenimiento de nuestro cerebro:");			


		this.setTitle("Ejercicio de Evaluacion");
		this.setResizable(true);
		this.setBounds(350,90,690,600);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setVisible(true);	
		this.getContentPane().setBackground(fondo);

		listaAddVector();


	}


	public void listaAddVector(){
		listaPregunta1.add("Ochocientos centimetros cubicos");
        listaPregunta1.add("Seiscientos centimetros cubicos");
        listaPregunta1.add("Mil doscientos centimetros cubicos");
        listaPregunta1.add("Sesenta centimetros cubicos");
        for(int i=0;i<listaPregunta1.size();i++)
        {
            preguntaBox[0].addItem(listaPregunta1.get(i));
        } 

        listaPregunta2.add("Homo Cromagnon");
        listaPregunta2.add("Homo Erectus");
        listaPregunta2.add("Homo Neadertal");
        listaPregunta2.add("Homo Habilis");
        for(int i=0;i<listaPregunta1.size();i++)
        {
            preguntaBox[1].addItem(listaPregunta2.get(i));
        }

        listaPregunta3.add("Marsupiales");
        listaPregunta3.add("Caninos");
        listaPregunta3.add("Gatos");
        listaPregunta3.add("Felinos");
        for(int i=0;i<listaPregunta1.size();i++)
        {
            preguntaBox[2].addItem(listaPregunta3.get(i));
        } 

        listaPregunta4.add("Veinticinco");
        listaPregunta4.add("Cinco");
        listaPregunta4.add("Ocho");
        listaPregunta4.add("Cuarenta");
        for(int i=0;i<listaPregunta1.size();i++)
        {
            preguntaBox[3].addItem(listaPregunta4.get(i));
        } 
        listaPregunta5.add("Atrofia muscular y gasto de energia");
        listaPregunta5.add("Busqueda de alimentos y necesidad de reposo");
        listaPregunta5.add("Busqueda de alimentos y atrofia muscular");
        listaPregunta5.add("Atrofia muscular y mayor retencion cerebral");
        for(int i=0;i<listaPregunta1.size();i++)
        {
            preguntaBox[4].addItem(listaPregunta5.get(i));
        } 
    }

	public void actionPerformed (ActionEvent event){
		if(event.getSource()==btnInicio){
			if(preguntaBox[0].getSelectedItem().equals("Seiscientos centimetros cubicos")){contador+=20;}
			if(preguntaBox[1].getSelectedItem().equals("Homo Neadertal")){contador+=20;}
			if(preguntaBox[2].getSelectedItem().equals("Felinos")){contador+=20;}
			if(preguntaBox[3].getSelectedItem().equals("Veinticinco")){contador+=20;}
			if(preguntaBox[4].getSelectedItem().equals("Busqueda de alimentos y atrofia muscular")){contador+=20;}
			System.out.println(contador);
			this.dispose();

		}

	}
	
}