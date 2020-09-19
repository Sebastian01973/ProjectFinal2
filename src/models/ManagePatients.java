package models;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

public class ManagePatients {

	private ArrayList<Diagnostic> diagnosticList;

	public ManagePatients() {
		this.diagnosticList = new ArrayList<>();
	}

	public Diagnostic createDiagnostic( Departments location, Attention attention, int age, Gender gender, HealthCondition healthCondition, LocalDate...dates){
		return new Diagnostic(0,new Patient(location,attention,age,gender,healthCondition),dates[0],dates[1],dates[2]);
	}

	public void addDiagnostic(Diagnostic diagnostic) {
		diagnosticList.add(diagnostic);
	}
	


	public Object[] toObjectVector(int index) {
		Diagnostic diagnostic = diagnosticList.get(index);
		return new Object[] {
				diagnostic.getIdCases(),
				diagnostic.getPatient().getGender().getGender(),
				diagnostic.getPatient().getAge(),
				diagnostic.getPatient().getStates().toString(),
				diagnostic.getPatient().getLocation(),
				diagnostic.getPatient().getHealthCondition().toString(),
				diagnostic.getDateOfDiagnostic(),
				diagnostic.getDateOfRecovered(),
				diagnostic.getDateOfDeath()
		};
	}
	
	public ArrayList<Object[]> getMatrixList(){
		ArrayList<Object[]> matrix = new ArrayList<>();
		int size = diagnosticList.size();
		for (int i = 0; i < size; i++) {
			matrix.add(toObjectVector(i));
		}
		return matrix;
	}
	
	public int countCasesMonth(int numberMonth) {
		int count = 0;
		int size = diagnosticList.size();
		for (int i = 0; i < size; i++) {
			if(diagnosticList.get(i).getDateOfDiagnostic().getMonth().getValue() == numberMonth) {
				count++;
			}
		}
		return count;
	}
	
	public int[] getCasesMonth() {
		int[] months = getMonths();
		int[] data = new int[countMonths()];
		for (int j = 0; j < months.length; j++) {
			int count = countCasesMonth(months[j]); 
			if(count > 0) {
				data[j] = count;
			}
		}	
		return data;
	}
	
	public int countMonths() {
		int count = 0;
		for (int i = 1; i < 13; i++) {
			count += isMonth(i)?1:0;
		}
		return count;
	}
	
	public int[] getMonths() {
		int[] data = new int[countMonths()];
		int count = 0;
		for (int i = 0; i < 12; i++) {
			if(isMonth(i+1)) {
				data[count] = i+1;
				count++;
			}
		}
		return data;
	}
	
	public boolean isMonth(int value) {
		int size = diagnosticList.size();
		for (int i = 1; i < size; i++) {
			if(diagnosticList.get(i).getDateOfDiagnostic().getMonth().getValue() == value) {
				return true;
			}
		}
		return false;
	}
}
