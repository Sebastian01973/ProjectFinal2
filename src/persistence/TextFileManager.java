package persistence;

import models.Diagnostic;
import models.ManagePatients;
import utilities.Utilities;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TextFileManager implements IFileManager{


	@Override
	public ArrayList<Object> readFile(String name) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	public void writeFile(String name, ManagePatients managePatients) {
		FileWriter fileWriter = null;
		ArrayList<Diagnostic> diagnostics = managePatients.getDiagnosticList();
		ArrayList<Object[]> reports = managePatients.getDatasDepartaments();
		try {
			fileWriter = new FileWriter(name);
			ArrayList<String> auxString = new ArrayList<>();
			for (Diagnostic diagnostic : diagnostics) {
				auxString.add(String.valueOf(diagnostic.getIdCases())+"#"+diagnostic.getPatient().getGender().getGender()+
						"#"+String.valueOf(diagnostic.getPatient().getAge())+"#"+diagnostic.getPatient().getStates().getKey()+
						"#"+diagnostic.getPatient().getLocation()+"#"
						+diagnostic.getPatient().getHealthCondition().getKey()+
						"#"+ Utilities.dateToString(diagnostic.getDateOfDiagnostic())+"#"+Utilities.dateToString(diagnostic.getDateOfRecovered())+"#"+
						Utilities.dateToString(diagnostic.getDateOfDeath()));
			}
			ArrayList<String> auxString2 = new ArrayList<>();
			for (Object[] objects:reports) {
				auxString2.add(String.valueOf(objects[0])+"#"+String.valueOf(objects[1])+"#"+
						String.valueOf(objects[2])+"#"+String.valueOf(objects[3]));
			}
			for (String string:auxString){
				fileWriter.write(string + "\n");
			}
			for (String string:auxString2) {
				fileWriter.write(string+"\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void writeFile(String nameList,ArrayList<String> datas) {
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(nameList);
			for (String data : datas) {
				fileWriter.write(data + "\n");
			}
		}catch(IOException e){
			e.printStackTrace();
		} finally {
			try {
				fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
