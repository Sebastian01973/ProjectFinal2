package persistence;

import java.io.*;
import java.util.ArrayList;

import models.Diagnostic;
import models.ManagePatients;
import org.json.simple.DeserializationException;
import org.json.simple.JsonArray;
import org.json.simple.JsonObject;
import org.json.simple.Jsoner;
import utilities.Utilities;
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
	public void writeFile(String name, ManagePatients managePatients) {
		File file = new File(name);
		try {
			file.createNewFile();
			FileWriter fileWriter = new FileWriter(file);
			JsonObject jsonObjectMax = new JsonObject();
			JsonObject jsonObject = new JsonObject();
			JsonArray jsonArray = new JsonArray();
			ArrayList<Diagnostic> diagnostics = managePatients.getDiagnosticList();
			for (Diagnostic diagnostic : diagnostics) {
				JsonObject jsonObject1 = new JsonObject();
				jsonObject1.put(ConstantsPersistence.NUMER_CASE,diagnostic.getIdCases());
				jsonObject1.put(ConstantsPersistence.GENDER,diagnostic.getPatient().getGender().getGender());
				jsonObject1.put(ConstantsPersistence.AGE,diagnostic.getPatient().getAge());
				jsonObject1.put(ConstantsPersistence.ATTENTION,diagnostic.getPatient().getStates().getKey());
				jsonObject1.put(ConstantsPersistence.HEALTH,diagnostic.getPatient().getHealthCondition().getKey());
				jsonObject1.put(ConstantsPersistence.D_DIAGNOSTIC, Utilities.dateToString(diagnostic.getDateOfDiagnostic()));
				jsonObject1.put(ConstantsPersistence.D_RECOVERED, Utilities.dateToString(diagnostic.getDateOfRecovered()));
				jsonObject1.put(ConstantsPersistence.D_DEATH, Utilities.dateToString(diagnostic.getDateOfDeath()));
				jsonObject1.put(ConstantsPersistence.DEPARTMENT,diagnostic.getPatient().getLocation());
				jsonArray.add(jsonObject1);
			}
			jsonObject.put(ConstantsPersistence.DATAS,jsonArray);

			JsonArray jsonArray1 = new JsonArray();
			ArrayList<Object[]> reports = managePatients.getDatasDepartaments();
			for (Object[] o:reports) {
				JsonObject jsonObject2 = new JsonObject();
				jsonObject2.put(ConstantsPersistence.DEPARTAMENT,o[0]);
				jsonObject2.put(ConstantsPersistence.DIAGNOSTIC,o[1]);
				jsonObject2.put(ConstantsPersistence.RECOVERED,o[2]);
				jsonObject2.put(ConstantsPersistence.DEATH,o[3]);
				jsonArray1.add(jsonObject2);
			}
			jsonObject.put(ConstantsPersistence.REPORTS,jsonArray1);
			jsonObjectMax.put(ConstantsPersistence.META,jsonObject);
			fileWriter.write(jsonObjectMax.toJson());
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Object[]> readWebService(String webService) {
		ArrayList<Object[]> listDatas = new ArrayList<>();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(FilesManager.getInputStream(false, webService)));

		try {
			JsonObject jSonObj = (JsonObject) Jsoner.deserialize(bufferedReader);
			JsonArray data = (JsonArray) jSonObj.get("data");
			for (int i = 0; i < data.size(); i++) {
				JsonArray array = (JsonArray) data.get(i);
				Object[] datas = new Object[] {
						array.get(12),
						array.get(13),
						array.get(14),
						array.get(15),
						UtilitiesViews.toCutHealthCondition(String.valueOf(array.get(17))),
						array.get(21),array.get(20),array.get(22)
					};
				listDatas.add(datas);
			}
			System.out.println(listDatas.size());
		} catch (DeserializationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listDatas;
	}
}
