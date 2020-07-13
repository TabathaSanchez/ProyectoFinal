import javax.swing.JLabel;

public class ThreadCronometro1 extends Thread{

	static JLabel etiqueta;

	public ThreadCronometro1(JLabel Cronometro1){
		this.etiqueta=Cronometro1;
	}

	public void run(){
		try{
			while(Cronometro1.iniciarHilo==true){
				Thread.sleep(10);
				ejecutarHiloCronometro1();
			}

		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void ejecutarHiloCronometro1(){
		Cronometro1.centesimasegundo++;

		if(Cronometro1.centesimasegundo>99){Cronometro1.centesimasegundo=0; Cronometro1.segundo++;}
		if(Cronometro1.segundo>59){Cronometro1.segundo=0; Cronometro1.minuto++;}
		if(Cronometro1.minuto>59){Cronometro1.minuto=0;}

		String textCent = "", textSeg = "", textMin = "";

		if(Cronometro1.centesimasegundo<10)
			{textCent="0"+Cronometro1.centesimasegundo;}
		else{
			textCent=""+Cronometro1.centesimasegundo;
		}

		if(Cronometro1.segundo<10)
			{textSeg="0"+Cronometro1.segundo;}
		else{
			textSeg=""+Cronometro1.segundo;
		}

		if(Cronometro1.minuto<10)
			{textMin="0"+Cronometro1.minuto;}
		else {
			textMin=""+Cronometro1.minuto;
		}

		String reloj = textMin+":"+textSeg+":"+textCent;

		etiqueta.setText(reloj);
	}


	
}