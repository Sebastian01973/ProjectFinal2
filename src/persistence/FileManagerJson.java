package persistence;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.json.simple.DeserializationException;
import org.json.simple.JsonArray;
import org.json.simple.JsonObject;
import org.json.simple.Jsoner;
import utilities.UtilitiesViews;

public class FileManagerJson implements IFileManager{



	@Override
	public ArrayList<Object> readFile(String pathFile) throws IOException {
		ArrayList<Object> listData = new ArrayList<>();
		try {
			JsonObject jSonObj = (JsonObject)Jsoner.deserialize(new FileReader(pathFile));
			JsonArray data = (JsonArray) jSonObj.get("data");
			for (int i = 0; i < data.size(); i++) {
				JsonArray array = (JsonArray) data.get(i);
				for (int j = 0; j < array.size(); j++) {
					System.out.println(array.get(j));
				}
				System.out.println("|||||||||||||||");
			}
		} catch (DeserializationException | IOException e) {
			e.printStackTrace();
		}
		return listData;
	}

	@Override
	public void writeFile(String name, ArrayList<Object> list) {
		
	}
	
	public ArrayList<Object[]> readWebService(String webService) {
		ArrayList<Object[]> listDatas = new ArrayList<>();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(FilesManager.getInputStream(false, webService)));
		System.out.println("--------------------Output------------------------");
		try {
			System.out.println("raiz");
			JsonObject jSonObj = (JsonObject) Jsoner.deserialize(bufferedReader);
			System.out.println("entro raiz");
			JsonArray data = (JsonArray) jSonObj.get("data");
			for (int i = 0; i < data.size(); i++) {
				JsonArray array = (JsonArray) data.get(i);
				Object[] datas = new Object[] {
						array.get(12),
						array.get(13),
						array.get(14),
						array.get(15),
						UtilitiesViews.toCutHealthCondition(String.valueOf(array.get(17))),
//						array.get(21), array.get(22),array.get(23)
					};
				System.out.println(String.valueOf(array.get(12)));
				listDatas.add(datas);
			}
		} catch (DeserializationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listDatas;
	}
}
