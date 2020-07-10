import java.awt.event.*;
import javax.swing.*;
import java.awt.Font;

public class Temporizador extends JFrame implements ActionListener{

	private JLabel label;
	private JButton btnIniciar;
	public static boolean finalizado = false;
	static int minuto = 0, segundo =0, centesimasegundo = 1;
	static boolean iniciarHilo = true;
	boolean corriendo = false;

	public Temporizador(){
		initialize();
		setSize(228,150);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setVisible(true);
		if(finalizado==true){
			System.out.println(finalizado);
			this.setVisible(false);
			this.dispose();
		}
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


	private void iniciarHiloTemporizador(){
		if(iniciarHilo==true){
			ThreadTemporizador threadt= new ThreadTemporizador(label);
			threadt.start();
			if(finalizado==true){
				System.out.println("sleep");
			}
			
		}

		
	}
}