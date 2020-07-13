import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.util.*;

class Repeticiones extends JFrame
{
	Color fondo;
	JTextArea lista;
	JLabel tiempo;
	public Repeticiones()
	{	
		fondo = new Color(189,169,121);

		tiempo = new JLabel("SUS REPETICIONES FUERON:");
		tiempo.setFont(new Font("Centaur", Font.PLAIN,20));
		tiempo.setBounds(60,10,180,30);
		
		lista = new JTextArea();
		lista.setBounds(20,40,260,120);
		lista.setDisabledTextColor(Color.BLACK);
		lista.setEnabled(false);

		this.add(tiempo);
		this.add(lista);
		this.setResizable(false);
        this.setTitle("Tiempos");
        this.setLayout(null);
        this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        this.setBounds(420,110,300,200);
        this.getContentPane().setBackground(fondo);
        this.setVisible(true);

        ArrayList<String> contenido = new ArrayList<String>();
			contenido = Archivo.leerTodo(LogIn.nombreUsuario+Menu.numeroEjercicio+".txt");
			String cadena= "";
				for (int i=0; i<contenido.size(); i++)
				{
					cadena = cadena + contenido.get(i) + "\n";					
				}
			lista.setText(cadena);
	}
}