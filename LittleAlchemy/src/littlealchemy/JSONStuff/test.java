import java.io.*;
import org.json.*;
import java.util.HashMap;


public class test{

public static void main (String[] args){
	try{

	FileOutputStream out = new FileOutputStream("output.txt");



	HashMap<String,String> hm = new HashMap<String,String>();
	HashMap<String,HashMap> hm2 = new HashMap<String,HashMap>();
	HashMap<String,String[][]> hm1 = new HashMap<String,String[][]>();


	HashMap[] ahm = new HashMap[2];

	ahm[0] = hm;
	ahm[1] = hm;

	String[][] str = new String[2][2];
	str[0][0] = "primo";
	str[0][1] = "fuoco";
	str[1][0] = "secondo";
	str[1][1] = "acqua";

	hm1.put("test",str);

	hm2.put("test",hm);

	hm.put("risultato","vapore");
	hm.put("primo","fuoco");
	hm.put("secondo","acqua");

	JSONObject jo = new JSONObject();
	jo.put("test2","xxx");
	jo.put("test3","xxx");
	jo.put("test4",ahm);






	Writer wr = jo.write(new OutputStreamWriter(out));
	wr.flush();
	wr.close();

}catch(Exception exc){};




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