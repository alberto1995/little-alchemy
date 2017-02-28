import java.io.*;
import org.json.*;
import java.util.HashMap;


public class WriterText{

public static void main (String[] args){
	try{

		//Pezzo che serve per leggere

		File f = new File("ResultList.json");
		FileInputStream is = new FileInputStream(f);

		JSONTokener jt = new JSONTokener(is);

		JSONArray input = new JSONArray (jt);

		JSONObject in;

		String[][] str = new String[input.length()][3];

		String tmp = "blabla";
		int tot = 0;

		for(int i=0; i<input.length(); i++){
			in = input.getJSONObject(i);
			str[i][0]=(String)in.get("result");
			str[i][1]=(String)in.get("first");
			str[i][2]=(String)in.get("second");

			if(!str[i][0].equals(tmp)){
				tot++;
				tmp = str[i][0];

			}
			System.out.println("risultato: "+str[i][0]+"    Primo: "+str[i][1]+"     Secondo: "+str[i][2]);

		}

		System.out.println("risultati totali: "+tot+"      contro i: "+input.length());


		//Pezo che serve per scrivere il file


	FileOutputStream out = new FileOutputStream("CombinationList.json");

	JSONArray end = new JSONArray();
			int tmparr = 0;
			String s = str[0][0];
			int j=0;
			int k;

			boolean stop = true;

			while(stop){
				JSONObject z = new JSONObject();
				z.put("result",str[j][0]);
				JSONArray m = new JSONArray();
				k=0;


				while (j<input.length() && s.equals(str[j][0])){
					JSONObject v = new JSONObject();
					v.put("first",str[j][1]);
					v.put("second",str[j][2]);

					m.put(k,v);

					k++;
					j++;


					//else
					//break;
				}




				z.put("combination",m);
				end.put(tmparr,z);
				tmparr++;

				if(j<input.length())
				s = str[j][0];
				else
				stop=false;
			}


			System.out.println(end.getJSONObject(0).get("result"));






	Writer wr = end.write(new OutputStreamWriter(out));
	wr.flush();
	wr.close();

}catch(Exception exc){
	System.out.println("PROBLEMA RILEVATO!!");
	};




}



}

/*
		metodo put(chiave,valore) mette in fila dentro un  object una chiave e un valore, se do put(chiave,array) mi crea un array, poi nell'array ci metto delle hashmap con chiave valore corrispondenti.

		put("risultato", valore);
		put("combinazioni,jsonarray);

		jsonarray =>

		put(i,jsonobject)
		put(i,jsonobjecy)

		jsonobject =>
		put("primo",valore)
		put("secondo",valore)


		JSONArray end = new JSONArray();
		int tmp = 0;

		for(){

			JSONObject z = new JSONObject();
			z.put("result",array[i][]);
			JSONArray m = new JSONArray();


			for(){
				JSONObject v = new JSONObject();
				v.put("first",array[i][1]);
				v.put("second",array[i][2]);

				m.put(i,v);
			}




			z.put("combination",m);
			end.put(tmp, z);
			tmp++;
		}






*/