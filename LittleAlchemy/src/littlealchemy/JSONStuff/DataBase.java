import java.io.File;
import java.io.FileInputStream;
import org.json.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;



public class DataBase{

	public static void main(String[] args){
		try{

		File f = new File("CombinationList.json");
		FileInputStream is = new FileInputStream(f);

		JSONTokener jt = new JSONTokener(is);

		HashMap<String, HashMap> ResMap = new HashMap<String, HashMap>();

		JSONArray ja = new JSONArray(jt);
		JSONObject jo, jot;
		JSONArray jat;

		for (int i=0; i<ja.length(); i++){
			jo = ja.getJSONObject(i);
			HashMap<Combination, Boolean> tmp = new HashMap<Combination, Boolean>();
			jat = (JSONArray)jo.get("combination");
			for (int j=0; j<jat.length(); j++){
				jot = jat.getJSONObject(j);
				Combination cmb = new Combination ((String)jot.get("first"),(String)jot.get("second"));
				tmp.put(cmb, false);
			}
			ResMap.put((String)jo.get("result"),tmp);
		}


			Iterator it = ResMap.entrySet().iterator();

			// Verifica con il metodo hasNext() che nella hashmap
			// ci siano altri elementi su cui ciclare
			while (it.hasNext()) {
				// Utilizza il nuovo elemento (coppia chiave-valore)
				// dell'hashmap
				Map.Entry entry = (Map.Entry)it.next();

				// Stampa a schermo la coppia chiave-valore;
				System.out.println("\n\nRisultato = " + entry.getKey()+"\n");
				Iterator its = ResMap.get(entry.getKey()).entrySet().iterator();
				while (its.hasNext()) {
						// Utilizza il nuovo elemento (coppia chiave-valore)
						// dell'hashmap
						Map.Entry entry2 = (Map.Entry)its.next();

						// Stampa a schermo la coppia chiave-valore;
						System.out.println("Elementi combinanti = " + entry2.getKey());
						System.out.println("Valore = " + entry2.getValue());
				}
			}









	}catch(Exception exc){};
	}



}