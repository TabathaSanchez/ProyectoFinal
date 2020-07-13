import javax.swing.JLabel;

public class ThreadCronometro3 extends Thread{

	static JLabel etiqueta;

	public ThreadCronometro3(JLabel cronometro){
		this.etiqueta=cronometro;
	}

	public void run(){
		try{
			while(Cronometro3.iniciarHilo==true){
				Thread.sleep(10);
				ejecutarHiloCronometro3();
			}

		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void ejecutarHiloCronometro3(){
		Cronometro3.centesimasegundo++;

		if(Cronometro3.centesimasegundo>99){Cronometro3.centesimasegundo=0; Cronometro3.segundo++;}
		if(Cronometro3.segundo>59){Cronometro3.segundo=0; Cronometro3.minuto++;}
		if(Cronometro3.minuto>59){Cronometro3.minuto=0;}

		String textCent = "", textSeg = "", textMin = "";

		if(Cronometro3.centesimasegundo<10)
			{textCent="0"+Cronometro3.centesimasegundo;}
		else{
			textCent=""+Cronometro3.centesimasegundo;
		}

		if(Cronometro3.segundo<10)
			{textSeg="0"+Cronometro3.segundo;}
		else{
			textSeg=""+Cronometro3.segundo;
		}

		if(Cronometro3.minuto<10)
			{textMin="0"+Cronometro3.minuto;}
		else {
			textMin=""+Cronometro3.minuto;
		}

		String reloj = textMin+":"+textSeg+":"+textCent;

		etiqueta.setText(reloj);
	}


	
}