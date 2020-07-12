//package proyectofinal;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.imageio.*;
import java.util.*;

public class Menu extends JFrame implements ActionListener 
{
	Color fondo, fondoMenu;
	JMenuBar menuBarra;
    JMenu tiempos;
    JLabel usuario,menu;
    JButton btn1,btn2,btn3,btn4,btn5,btn6;
    static String numeroEjercicio ="";
    JMenuItem ejer1,ejer3,examen;
     ArrayList<String> contenidoEjercicio_1 = new ArrayList<String>();
     ArrayList<String> contenidoEjercicio_3 = new ArrayList<String>();
  
	public Menu()
	{
		try
        {   setIconImage(new ImageIcon(getClass().getResource("libros.png")).getImage());   }
        catch(Exception e) {    System.out.println("Error: NO SE ECONTRO IMAGEN");} 

        fondo = new Color(189,169,121);
        fondoMenu = new Color(201,184,143);
        menuBarra = new JMenuBar();
        menuBarra.setBackground(fondoMenu);
        tiempos = new JMenu("Tiempos");
        tiempos.setFont(new Font("Centaur", Font.PLAIN,15)); 
        ejer1 =new JMenuItem("Ejercicio 1");
        ejer1.addActionListener(this);
        ejer3 =new JMenuItem("Ejercicio 3");
        ejer3.addActionListener(this);
        examen =new JMenuItem("Examen");
        examen.addActionListener(this);
        tiempos.add(ejer1);
        tiempos.add(ejer3);
        tiempos.add(examen);
        menuBarra.add(tiempos);

        menu = new JLabel("MENU");	
        menu.setFont(new Font("Castellar", Font.PLAIN,30));
        menu.setBounds(295,30,110,30);

        usuario = new JLabel("Usuario: "+ LogIn.nombreUsuario);	
        usuario.setFont(new Font("Copperplate Gothic Light", Font.PLAIN,15));
        usuario.setBounds(5,10,400,15);

        btn1 = new JButton("Ejercicio 1");
        btn1.setFont(new Font("Perpetua Titling MT", Font.PLAIN,20));
        btn1.setBounds(100,100,200,50);
        btn1.setBorder(null);
        btn1.addActionListener(this);
        btn2 = new JButton("Ejercicio 2");
        btn2.setFont(new Font("Perpetua Titling MT", Font.PLAIN,20));
        btn2.setBounds(400,100,200,50);
        btn2.setBorder(null);
        btn2.addActionListener(this);
        btn3 = new JButton("Ejercicio 3");
        btn3.setFont(new Font("Perpetua Titling MT", Font.PLAIN,20));
        btn3.setBounds(100,200,200,50);
        btn3.setBorder(null);
        btn3.addActionListener(this);
        btn4 = new JButton("Ejercicio 4");
        btn4.setFont(new Font("Perpetua Titling MT", Font.PLAIN,20));
        btn4.setBounds(400,200,200,50);
        btn4.setBorder(null);
        btn4.addActionListener(this);
        btn5 = new JButton("Examen Final");
        btn5.setFont(new Font("Perpetua Titling MT", Font.PLAIN,20));
        btn5.setBounds(250,300,200,50);
        btn5.setEnabled(false);
        btn5.addActionListener(this);

        this.setJMenuBar(menuBarra);
        this.add(menu);
        this.add(usuario);
        this.add(btn1); this.add(btn2); this.add(btn3); this.add(btn4); this.add(btn5);
		this.setResizable(false);
        this.setTitle("MEJORAR LECTURA");
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(350,90,700,500);
        this.getContentPane().setBackground(fondo);
        this.setVisible(true);

		if(contenidoEjercicio_1.size()>=5 && contenidoEjercicio_3.size()>=5)
			 btn5.setEnabled(true);

	}
	public void actionPerformed(ActionEvent event) 
    {
    	if(event.getSource()== this.ejer1) 
        {	numeroEjercicio="_1";
        	Tiempos tiempos = new Tiempos();
        }
        else if (event.getSource()== this.ejer3) 
        {
        	numeroEjercicio="_3";
        	Tiempos tiempos = new Tiempos();
        }
         else if (event.getSource()== this.examen) 
        {
        	numeroEjercicio="_examen";
        	Tiempos tiempos = new Tiempos();
        }
        else if(event.getSource()== this.btn1) 
        {	EjercicioVelocidadLectura ejercicio_1 = new EjercicioVelocidadLectura ();
        	numeroEjercicio="_1";
        	Cronometro cro = new Cronometro();
        	contenidoEjercicio_1 = Archivo.leerTodo(LogIn.nombreUsuario+"_1"+".txt");
        }
       else if(event.getSource()== this.btn2) 
        {	EjercicioMovimientoOjoCerebro ejercicio_2 = new EjercicioMovimientoOjoCerebro ();
        	
        }
        else if(event.getSource()== this.btn3) 
        {	EjercicioAtencion ejercicio_3 = new EjercicioAtencion  ();
			numeroEjercicio="_3";
        	Cronometro cro = new Cronometro();
        	contenidoEjercicio_3 = Archivo.leerTodo(LogIn.nombreUsuario+"_3"+".txt");
        }
        else if(event.getSource()== this.btn4) 
        {	EjercicioAgilidadMental ejercicio_4= new  EjercicioAgilidadMental();
			
        }
        else if(event.getSource()== this.btn5) 
        {	EjercicioEvaluacion examen_final = new  EjercicioEvaluacion();
			numeroEjercicio="_examen";
        }
    }
		
}