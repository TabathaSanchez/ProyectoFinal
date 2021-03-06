import javax.swing.JLabel;

public class ThreadCronometro extends Thread{

	static JLabel etiqueta;

	public ThreadCronometro(JLabel cronometro){
		this.etiqueta=cronometro;
	}

	public void run(){
		try{
			while(Cronometro.iniciarHilo==true){
				Thread.sleep(10);
				ejecutarHiloCronometro();
			}

		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void ejecutarHiloCronometro(){
		Cronometro.centesimasegundo++;

		if(Cronometro.centesimasegundo>99){Cronometro.centesimasegundo=0; Cronometro.segundo++;}
		if(Cronometro.segundo>59){Cronometro.segundo=0; Cronometro.minuto++;}
		if(Cronometro.minuto>59){Cronometro.minuto=0;}

		String textCent = "", textSeg = "", textMin = "";

		if(Cronometro.centesimasegundo<10)
			{textCent="0"+Cronometro.centesimasegundo;}
		else{
			textCent=""+Cronometro.centesimasegundo;
		}

		if(Cronometro.segundo<10)
			{textSeg="0"+Cronometro.segundo;}
		else{
			textSeg=""+Cronometro.segundo;
		}

		if(Cronometro.minuto<10)
			{textMin="0"+Cronometro.minuto;}
		else {
			textMin=""+Cronometro.minuto;
		}

		String reloj = textMin+":"+textSeg+":"+textCent;

		etiqueta.setText(reloj);
	}


	
}