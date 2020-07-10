import java.awt.event.*;
import javax.swing.*;
import java.awt.Font;

public class Cronometro extends JFrame implements ActionListener{

	private JLabel label;
	private JButton btnIniciar;
	private JButton btnDetener;

	static int minuto = 0, segundo =0, centesimasegundo = 0;
	static boolean iniciarHilo = true;
	static boolean corriendo = false;

	EjercicioVelocidadLectura e;

	public Cronometro(){

		e= new EjercicioVelocidadLectura();
		initialize();
		setSize(228,120);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void initialize(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		label = new JLabel("00:00:00");
		label.setFont(new Font("Traditional Arabic",Font.PLAIN,25));
		label.setBounds(60,11,137,45);
		getContentPane().add(label);

		btnIniciar=new JButton("Iniciar");
		btnIniciar.setBounds(119,54,89,23);
		btnIniciar.addActionListener(this);
		getContentPane().add(btnIniciar);

		btnDetener=new JButton("Detener");
		btnDetener.setBounds(10,54,89,23);
		btnDetener.addActionListener(this);
		getContentPane().add(btnDetener);
		requestFocus();
	}

	public void actionPerformed(ActionEvent event){
		if(event.getSource()==btnIniciar){
			if(corriendo==false){
				iniciarHilo=true;
				corriendo=true;
				iniciarHiloCronometro();

				
			}
		}
		if(event.getSource()==btnDetener){
			corriendo=false;
			iniciarHilo=false;
			setVisible(false);
			System.out.println(minuto+":"+segundo+":"+centesimasegundo);
			dispose();
			}
	
	}

	private void iniciarHiloCronometro(){
		if(iniciarHilo==true){
			ThreadCronometro threadc= new ThreadCronometro(label);
			threadc.start();
		}

		
	}

}