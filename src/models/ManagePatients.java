package models;

import java.time.LocalDate;
import java.util.ArrayList;

public class ManagePatients {

	private ArrayList<Diagnostic> diagnosticList;

	public ManagePatients() {
		this.diagnosticList = new ArrayList<>();
	}

	public Diagnostic createDiagnostic( Departments location, Attention attention, int age, Gender gender, HealthCondition healthCondition, LocalDate...dates){
		return new Diagnostic(size()+1,new Patient(location,attention,age,gender,healthCondition),dates[0],dates[1],dates[2]);
	}

	public void addDiagnostic(Diagnostic diagnostic) {
		diagnosticList.add(diagnostic);
	}

	public Object[] getIndexSearchDeps(String object,int index){
		if (Integer.parseInt(object) == diagnosticList.get(index).getPatient().getAge()){
			return diagnosticList.get(index).toObjectVector();
		}
		return null;
	}

	public int sizeForSearch(Object object){
		int size = size(),count = 0;
		for (int i = 0; i < size(); i++) {
			count += ((int)object == diagnosticList.get(i).getPatient().getAge()) ? 1:0;
		}
		return count;
	}

	public ArrayList<Object[]> getMatrixSearchDeps(String object){
		String auxString = object;
		ArrayList<Object[]> auxObjects = new ArrayList<>();
		int size = size();
		for (int i = 0; i < size; i++) {
			if (getIndexSearchDeps(auxString,i) != null){
				auxObjects.add(getIndexSearchDeps(auxString,i));
			}
		}
		return auxObjects;
	}

	public int[] countTotalCases(Departments department){
		int size = size();
		int[] count = new int[3];
		for (int i = 0,j = 0; i < size; i++) {
			count[0] += (diagnosticList.get(i).isValidateDepartments(department)) ? 1:0;
			count[1] += (diagnosticList.get(i).isValidateDepartments(department) && diagnosticList.get(i).getDateOfRecovered() != null) ? 1:0;
			count[2] += (diagnosticList.get(i).isValidateDepartments(department) && diagnosticList.get(i).getDateOfDeath() != null) ? 1:0;
		}
		return count;
	}

	public Object[] getDatasDepartament(int index){
		Departments[] dep = Departments.values();
			return new Object[]{
					dep[index].getKeys(),
					countTotalCases(dep[index])[0],
					countTotalCases(dep[index])[1],
					countTotalCases(dep[index])[2],
			};
	}

	public ArrayList<Object[]> getDatasDepartaments(){
		ArrayList<Object[]> tableDatas = new ArrayList<>();
		Departments[] dep = Departments.values();
		int size = dep.length;
		for (int i = 0; i < size; i++) {
			tableDatas.add(getDatasDepartament(i));
		}
		return tableDatas;
	}

	public ArrayList<Object[]> getMatrixList(){
		ArrayList<Object[]> matrix = new ArrayList<>();
		for (Diagnostic diagnostic: diagnosticList) {
			matrix.add(diagnostic.toObjectVector());
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
	
	public int countMonths() {
		int count = 0;
		for (int i = 1; i < 13; i++) {
			count += isMonth(i)?1:0;
		}
		return count;
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
	
	public int calPercentageAge(int age1,int age2) {
		int value=0;
		int size = diagnosticList.size();
		for (Diagnostic diagnostic : diagnosticList) {
			int age = diagnostic.getPatient().getAge();
			if(age >= age1 && age <= age2) {
				value++;
			}
		}
		return (value*100/size);
	}
	
	public int[] getPercentagesAges() {
		int[] ages = new int[] {
				calPercentageAge(1, 12),calPercentageAge(13, 30),
				calPercentageAge(31, 60),calPercentageAge(60, 100),
		};
		return ages;
	}

	public int size(){
		return diagnosticList.size();
	}

	public ArrayList<Diagnostic> getDiagnosticList(){
		return diagnosticList;
	}
}
