package persistence;

import models.Diagnostic;
import models.ManagePatients;
import utilities.Utilities;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class BinaryFileManager implements IFileManager{

	@Override
	public ArrayList<Object> readFile(String name) throws IOException {
		return null;
	}
		
	public void writeFile(String name, ManagePatients managePatients) {
		FileOutputStream fileOutputStream = null;
		DataOutputStream dataOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(name,false);
			dataOutputStream = new DataOutputStream(fileOutputStream);
			ArrayList<Diagnostic> diagnostics = managePatients.getDiagnosticList();
			ArrayList<Object[]> reports = managePatients.getDatasDepartaments();
			for (Diagnostic diagnostic:diagnostics) {
				try {
					dataOutputStream.writeInt(diagnostic.getIdCases());
					dataOutputStream.writeUTF(diagnostic.getPatient().getGender().getGender());
					dataOutputStream.writeInt(diagnostic.getPatient().getAge());
					dataOutputStream.writeUTF(diagnostic.getPatient().getStates().getKey());
					dataOutputStream.writeUTF(String.valueOf(diagnostic.getPatient().getLocation()));
					dataOutputStream.writeUTF(diagnostic.getPatient().getHealthCondition().getKey());
					dataOutputStream.writeUTF(Utilities.dateToStringByte(diagnostic.getDateOfDiagnostic()));
					dataOutputStream.writeUTF(Utilities.dateToStringByte(diagnostic.getDateOfRecovered()));
					dataOutputStream.writeUTF(Utilities.dateToStringByte(diagnostic.getDateOfDeath()));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			for (Object[] objects:reports) {
				try {
					dataOutputStream.writeUTF(String.valueOf(objects[0]));
					dataOutputStream.writeUTF(String.valueOf(objects[1]));
					dataOutputStream.writeUTF(String.valueOf(objects[2]));
					dataOutputStream.writeUTF(String.valueOf(objects[3]));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				if(fileOutputStream != null) {
					fileOutputStream.close();
				}
				if(dataOutputStream != null) {
					dataOutputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
