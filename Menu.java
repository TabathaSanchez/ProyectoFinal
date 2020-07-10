//package proyectofinal;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.imageio.*;

public class Menu extends JFrame
{
	Color fondo, fondoMenu;
	JMenuBar menuBarra;
    JMenu avance,tiempos;
    JLabel usuario,menu;
    JButton btn1,btn2,btn3,btn4,btn5,btn6;

	public Menu()
	{
		try
        {   setIconImage(new ImageIcon(getClass().getResource("libros.png")).getImage());   }
        catch(Exception e) {    System.out.println("Error: NO SE ECONTRO IMAGEN");} 

        fondo = new Color(189,169,121);
        fondoMenu = new Color(201,184,143);
        menuBarra = new JMenuBar();
        menuBarra.setBackground(fondoMenu);
        avance = new JMenu("Logros");
        avance.setFont(new Font("Centaur", Font.PLAIN,15));
        tiempos = new JMenu("Tiempos");
        tiempos.setFont(new Font("Centaur", Font.PLAIN,15));
        menuBarra.add(avance); 
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
        btn2 = new JButton("Ejercicio 2");
        btn2.setFont(new Font("Perpetua Titling MT", Font.PLAIN,20));
        btn2.setBounds(400,100,200,50);
        btn2.setBorder(null);
        btn3 = new JButton("Ejercicio 3");
        btn3.setFont(new Font("Perpetua Titling MT", Font.PLAIN,20));
        btn3.setBounds(100,200,200,50);
        btn3.setBorder(null);
        btn4 = new JButton("Ejercicio 4");
        btn4.setFont(new Font("Perpetua Titling MT", Font.PLAIN,20));
        btn4.setBounds(400,200,200,50);
        btn4.setBorder(null);
        btn5 = new JButton("Ejercicio 5");
        btn5.setFont(new Font("Perpetua Titling MT", Font.PLAIN,20));
        btn5.setBounds(100,300,200,50);
        btn5.setBorder(null);
        btn6 = new JButton("Ejercicio 6");
        btn6.setFont(new Font("Perpetua Titling MT", Font.PLAIN,20));
        btn6.setBounds(400,300,200,50);
        btn6.setBorder(null);

        this.setJMenuBar(menuBarra);
        this.add(menu);
        this.add(usuario);
        this.add(btn1); this.add(btn2); this.add(btn3); this.add(btn4); this.add(btn5); this.add(btn6);
		this.setResizable(false);
        this.setTitle("prueba");
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(350,90,700,500);
        this.getContentPane().setBackground(fondo);
        this.setVisible(true);
	}
		
}