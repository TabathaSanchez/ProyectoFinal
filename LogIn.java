//package proyectofinal;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.Font; 
import java.awt.event.*;
import java.lang.String;
import javax.swing.ImageIcon;
import javax.imageio.*;
import java.util.*;
import javax.swing.JOptionPane;

    public  class LogIn extends JFrame implements ActionListener 
{
    public boolean mostrar = true;
    public int posicionc;
    public int posicionu;
    public static String nombreUsuario;
    public int cont =0;
    public char [] contra;
    public String clave;
    public ArrayList <String> contenidoUser = new  ArrayList <String>();
    public ArrayList <String> contenidoPass = new  ArrayList <String>();

    JPanel panel;
    Color fondo,fondoMenu;
    JLabel texto,usuario,contrasena;
    JTextField txtusuario,txtcontrasenavis;
    JPasswordField txtcontrasena;
    JButton inicio,registro,ver;

    public LogIn()
    {
        try
        {   setIconImage(new ImageIcon(getClass().getResource("libros.png")).getImage());   }
        catch(Exception e) {    System.out.println("Error: NO SE ECONTRO IMAGEN");} 

        fondo = new Color(189,169,121);
        texto = new JLabel("Iniciar Sesion");
        texto.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN,30));
        texto.setBounds(100,50,200,30);

        usuario = new JLabel("Usuario:");
        usuario.setFont(new Font("Arial Unicode MS", Font.PLAIN,20));
        usuario.setBounds(40,110,80,30);

        txtusuario = new JTextField();
        txtusuario.setBounds(120,110,180,30);
        txtusuario.setBorder(null);

        contrasena = new JLabel("Clave:");
        contrasena.setFont(new Font("Arial Unicode MS", Font.PLAIN,20));
        contrasena.setBounds(50,160,70,30);

        txtcontrasena = new JPasswordField();
        txtcontrasena.setBounds(120,160,180,30);
        txtcontrasena.setVisible(true);
        txtcontrasena.setBorder(null);
        txtcontrasenavis = new JTextField();
        txtcontrasenavis.setBounds(120,160,180,30);
        txtcontrasenavis.setDisabledTextColor(Color.BLACK);
        txtcontrasenavis.setEnabled(false);
        txtcontrasenavis.setBorder(null);
        txtcontrasenavis.setVisible(false);
        
        ver = new JButton();
        ver.setBounds(303,160,30,30);
        ver.setBackground(Color.WHITE);
        ver.setBorder(null);        
       try
        {
            ImageIcon verc = new ImageIcon("ojo.png");
            ver.setIcon(new ImageIcon(verc.getImage().getScaledInstance(ver.getWidth(),ver.getHeight(),Image.SCALE_SMOOTH)));
        } 
        catch(Exception e)  {   System.out.println("no se encontro imagen para colocar.");  }
        
        registro = new JButton("Registro");
        registro.setBounds(35,230,120,30);
        registro.setFont(new Font("Copperplate Gothic Bold",Font.PLAIN,15));
        registro.setBackground(new Color(227,219,198));

        inicio = new JButton("iniciar");
        inicio.setBounds(255,230,110,30);
        inicio.setFont(new Font("Copperplate Gothic Bold",Font.PLAIN,15));
        inicio.setBackground(new Color(227,219,198));

        this.add(ver);
        this.add(registro);
        this.add(inicio);
        this.add(texto);
        this.add(usuario);
        this.add(txtusuario);
        this.add(contrasena);
        this.add(txtcontrasena);
        this.add(txtcontrasenavis);
        this.setResizable(false);
        this.setTitle("MEJORAR LECTURA");
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(450,100,400,450);
        this.getContentPane().setBackground(fondo);
        this.setVisible(true);

        ver.addActionListener(this);
        registro.addActionListener(this);
        inicio.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) 
    {
        if(event.getSource()== this.ver) 
        {
            clave = "";
            contra = txtcontrasena.getPassword();
            for (int i=0; i<contra.length; i++) 
            {
                clave+=contra[i];
            }

            if(mostrar==true)
            {
                txtcontrasenavis.setVisible(true);
                txtcontrasena.setVisible(false);
                txtcontrasenavis.setText(clave);
                mostrar=false;
            }
            else
            {
                txtcontrasenavis.setVisible(false);
                txtcontrasena.setVisible(true);
                txtcontrasena.setText(clave);
                mostrar=true;
            }
        }

        else if (event.getSource()== this.registro)
        {
           contenidoUser = Archivo.leerTodo("Usuarios.txt");
          if(contenidoUser != null)
          {
            for (int i=0;i<contenidoUser.size() ; i++) 
            {
              if(txtusuario.getText().equals(contenidoUser.get(i)))
              {
                JOptionPane.showMessageDialog(null,"El usuario ya existe intente con otro");
                txtcontrasenavis.setText("");
                txtusuario.setText("");
                txtcontrasena.setText("");
                cont++;
              } 
            }
            if(cont ==0)
              {
                Archivo.CrearArchivo(txtusuario.getText(),"Usuarios.txt");
                Archivo.CrearArchivo(txtcontrasena.getText(),"Claves.txt");
                txtcontrasenavis.setText("");
                txtusuario.setText("");
                txtcontrasena.setText("");
                JOptionPane.showMessageDialog(null,"REGISTRO EXITOSO");
              }
          }else{
            Archivo.CrearArchivo(txtusuario.getText(),"Usuarios.txt");
            Archivo.CrearArchivo(txtcontrasena.getText(),"Claves.txt");
            txtcontrasenavis.setText("");
            txtusuario.setText("");
            txtcontrasena.setText("");
            JOptionPane.showMessageDialog(null,"REGISTRO EXITOSO");
          }
        }
    
        else if (event.getSource()== this.inicio) 
        {  
            contenidoUser = Archivo.leerTodo("Usuarios.txt");
            contenidoPass = Archivo.leerTodo("Claves.txt");
            if(contenidoUser!= null && contenidoPass!=null)
            {
                for (int i=0; i<contenidoUser.size(); i++)
                {
                    if(txtusuario.getText().equals(contenidoUser.get(i)))
                    {
                        posicionu = i;
                        System.out.println("usuario encontrado: " + contenidoUser.get(i)+ " "+ i);
                    }  
                }   

                for (int i=0; i<contenidoPass.size(); i++)
                {
                    if( txtcontrasena.getText().equals(contenidoPass.get(i)))
                    {
                        posicionc = i;
                        System.out.println("Clave encontrado: "+ contenidoPass.get(i)+ " "+ i); 
                    }  

                }
            }
             if(posicionc == posicionu)
            {   nombreUsuario = txtusuario.getText();
                Menu menu = new Menu();
                this.dispose();
                nombreUsuario = txtusuario.getText();
                txtcontrasenavis.setText("");
                txtusuario.setText("");
                txtcontrasena.setText("");
            }
            else 
            {  JOptionPane.showMessageDialog (null, "clave y/o Usuario incorrecto.", "ERROR", JOptionPane.ERROR_MESSAGE);
                txtcontrasenavis.setText("");
                txtcontrasena.setText("");
            }
        }
    }
}