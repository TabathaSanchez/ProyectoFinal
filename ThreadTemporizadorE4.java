import javax.swing.JLabel;
import javax.swing.JFrame;

public class ThreadTemporizadorE4 extends Thread{

	static JLabel etiqueta;
	public boolean finalizado=false;
	public EjercicioAgilidadMental e;



	public ThreadTemporizadorE4(JLabel cronometro){
		e=new EjercicioAgilidadMental();
		this.etiqueta=cronometro;
	}

	public void run(){
		try{
			while(TemporizadorE4.iniciarHilo==true){
				Thread.sleep(10);
				ejecutarHiloTemporizador();
				terminarTemporizador();
			}

		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void ejecutarHiloTemporizador(){
		if(TemporizadorE4.centesimasegundo>0)
			{TemporizadorE4.centesimasegundo--;}
		else{TemporizadorE4.centesimasegundo=99;
			if(TemporizadorE4.segundo>0) TemporizadorE4.segundo--;
			else{
				TemporizadorE4.segundo=59;
				if(TemporizadorE4.minuto>0)TemporizadorE4.minuto--;
				else{
					finalizado=true;
				}
			}
		}

		String textCent = "", textSeg = "", textMin = "";

		if(TemporizadorE4.centesimasegundo<10){textCent="0"+TemporizadorE4.centesimasegundo;}
		else{textCent=""+TemporizadorE4.centesimasegundo;}

		if(TemporizadorE4.segundo<10){textSeg="0"+TemporizadorE4.segundo;}
		else{textSeg=""+TemporizadorE4.segundo;}

		if(TemporizadorE4.minuto<10){textMin="0"+TemporizadorE4.minuto;}
		else {textMin=""+TemporizadorE4.minuto;}

		String reloj = textMin+":"+textSeg+":"+textCent;

		etiqueta.setText(reloj);
		//System.out.println(e.contador);
	}

	public void terminarTemporizador(){
		if(TemporizadorE4.centesimasegundo==0&&TemporizadorE4.segundo==0&&TemporizadorE4.minuto==0){
			e.setVisible(false);
			e.dispose();
			Archivo.CrearArchivo(String.valueOf(e.contador),LogIn.nombreUsuario+Menu.numeroEjercicio+".txt");
			System.out.println(e.contador);
			TemporizadorE2.finalizado=true;
			TemporizadorE2.iniciarHilo=false;
			System.out.println("terminado");
			finalizado=true;
			try{join();}catch(Exception e){e.printStackTrace();}


			
		}
	}
}