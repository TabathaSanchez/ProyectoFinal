import java.io.*;
import java.util.ArrayList;

class Archivo{

		public static ArrayList<String> leerTodo(String ruta_archivo)
	{
					ArrayList<String> contenido = new ArrayList<String>();
					String cadena = new String();
					
					try(FileInputStream fis = new FileInputStream(ruta_archivo);
					DataInputStream din = new DataInputStream(fis);
					BufferedReader br = new BufferedReader(new InputStreamReader(din));)
				{
					cadena = br.readLine();
					while(cadena!=null)
					{
						contenido.add(cadena);
						cadena=br.readLine();

					}
					
				}
				catch(Exception e)
				{
					e.printStackTrace();

				}
				return contenido;
	}

		/*public static ArrayList<String> guardarTodo(String ruta_archivo, String contenido)
		{
			ArrayList<String> archivo_texto= new ArrayList<String>();
			String cadena_1 = new String(contenido);
			try
			{
				File archivo = new File(ruta_archivo);
				archivo.createNewFile();
				FileWriter fw =new FileWriter(archivo);
				BufferedWriter bw = new BufferedWriter(fw);

				archivo_texto.add(cadena_1);
				bw.write(cadena_1);
				bw.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}

			return archivo_texto;


		}*/

		public static void guardarTodo(String informacion){
			try{
				FileOutputStream fos = new FileOutputStream("archivo_creado_1.txt");
				BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
				out.write(informacion);
				out.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.exit(1);
			}

		}


		public static void guardarTodo(String nombre, String informacion){
			try{
				FileOutputStream fos = new FileOutputStream(nombre);
				BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
				out.write(informacion);
				out.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.exit(1);
			}

		}


}
				
			












