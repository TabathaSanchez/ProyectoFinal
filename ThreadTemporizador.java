import javax.swing.JLabel;

public class ThreadTemporizador extends Thread{

	static JLabel etiqueta;
	public boolean finalizado=false;


	public ThreadTemporizador(JLabel cronometro){
		this.etiqueta=cronometro;
	}

	public void run(){
		try{
			while(Temporizador.iniciarHilo==true){
				Thread.sleep(10);
				ejecutarHiloTemporizador();
				terminarTemporizador();
			}

		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void ejecutarHiloTemporizador(){
		if(Temporizador.centesimasegundo>0)
			{Temporizador.centesimasegundo--;}
		else{Temporizador.centesimasegundo=99;
			if(Temporizador.segundo>0) Temporizador.segundo--;
			else{
				Temporizador.segundo=59;
				if(Temporizador.minuto>0)Temporizador.minuto--;
				else{
					finalizado=true;
				}
			}
		}

		String textCent = "", textSeg = "", textMin = "";

		if(Cronometro.centesimasegundo<10){textCent="0"+Temporizador.centesimasegundo;}
		else{textCent=""+Temporizador.centesimasegundo;}

		if(Temporizador.segundo<10){textSeg="0"+Temporizador.segundo;}
		else{textSeg=""+Temporizador.segundo;}

		if(Temporizador.minuto<10){textMin="0"+Temporizador.minuto;}
		else {textMin=""+Temporizador.minuto;}

		String reloj = textMin+":"+textSeg+":"+textCent;

		etiqueta.setText(reloj);
	}

	public void terminarTemporizador(){
		if(Temporizador.centesimasegundo==0&&Temporizador.segundo==0&&Temporizador.minuto==0){
			Temporizador.finalizado=true;
			Temporizador.iniciarHilo=false;
			finalizado=true;
			System.out.println(Temporizador.finalizado);
			System.out.println(finalizado);
			try{
				join();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}