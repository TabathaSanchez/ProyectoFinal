import java.awt.event.*;
import javax.swing.*;
import java.awt.Font;

public class TemporizadorE4 extends JFrame implements ActionListener{

	private JLabel label;
	private JButton btnIniciar;
	public static boolean finalizado = false;
	static int minuto = 0, segundo =0, centesimasegundo = 1;
	static boolean iniciarHilo = true;
	boolean corriendo = false;
	ThreadTemporizadorE4 threadt;

	public TemporizadorE4(){
		initialize();
		setSize(228,150);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setVisible(true);
		JOptionPane.showMessageDialog(this, "Al dar click en 'Iniciar' , se iniciara el ejercicio. Cuenta con 10 segundos para leer las instrucciones");
	}

	private void initialize(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		label = new JLabel("00:00:00");
		label.setFont(new Font("Traditional Arabic",Font.PLAIN,25));
		label.setBounds(60,11,137,45);
		getContentPane().add(label);

		btnIniciar=new JButton("Iniciar");
		btnIniciar.setBounds(119,80,89,23);
		btnIniciar.addActionListener(this);
		getContentPane().add(btnIniciar);

	}

	public void actionPerformed(ActionEvent event){
		btnIniciar.setVisible(false);
		if(event.getSource()==btnIniciar){
			if(corriendo==false){
				iniciarHilo=true;
				corriendo=true;
				iniciarHiloTemporizador();

				
			}

		}
	}

	private void finalizarHiloTemporizador(){
		try{
			threadt.stop();
		}catch(Exception e){e.printStackTrace();}

	}


	private void iniciarHiloTemporizador(){
		if(iniciarHilo==true){
			threadt= new ThreadTemporizadorE4(label);
			threadt.start();
			if(finalizado==true){
				System.out.println("sleep");
			}
			
		}

		
	}
}
