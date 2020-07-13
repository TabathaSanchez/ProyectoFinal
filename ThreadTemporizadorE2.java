import javax.swing.JLabel;
import javax.swing.JFrame;

public class ThreadTemporizadorE2 extends Thread{

	static JLabel etiqueta;
	public boolean finalizado=false;
	public EjercicioMovimientoOjoCerebro e;



	public ThreadTemporizadorE2(JLabel cronometro){
		e=new EjercicioMovimientoOjoCerebro();
		this.etiqueta=cronometro;
	}

	public void run(){
		try{
			while(TemporizadorE2.iniciarHilo==true){
				Thread.sleep(10);
				ejecutarHiloTemporizador();
				terminarTemporizador();
			}

		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void ejecutarHiloTemporizador(){
		if(TemporizadorE2.centesimasegundo>0)
			{TemporizadorE2.centesimasegundo--;}
		else{TemporizadorE2.centesimasegundo=99;
			if(TemporizadorE2.segundo>0) TemporizadorE2.segundo--;
			else{
				TemporizadorE2.segundo=59;
				if(TemporizadorE2.minuto>0)TemporizadorE2.minuto--;
				else{
					finalizado=true;
				}
			}
		}

		String textCent = "", textSeg = "", textMin = "";

		if(TemporizadorE2.centesimasegundo<10){textCent="0"+TemporizadorE2.centesimasegundo;}
		else{textCent=""+TemporizadorE2.centesimasegundo;}

		if(TemporizadorE2.segundo<10){textSeg="0"+TemporizadorE2.segundo;}
		else{textSeg=""+TemporizadorE2.segundo;}

		if(TemporizadorE2.minuto<10){textMin="0"+TemporizadorE2.minuto;}
		else {textMin=""+TemporizadorE2.minuto;}

		String reloj = textMin+":"+textSeg+":"+textCent;

		etiqueta.setText(reloj);
		//System.out.println(e.contador);
	}

	public void terminarTemporizador(){
		if(TemporizadorE2.centesimasegundo==0&&TemporizadorE2.segundo==0&&TemporizadorE2.minuto==0){
			e.setVisible(false);
			e.frame.dispose();
			Archivo.CrearArchivo(String.valueOf(e.contador),LogIn.nombreUsuario+Menu.numeroEjercicio+".txt");
			System.out.println(e.contador);
			TemporizadorE2.finalizado=true;
			TemporizadorE2.iniciarHilo=false;
			finalizado=true;
			try{join();}catch(Exception e){e.printStackTrace();}


			
		}
	}
}