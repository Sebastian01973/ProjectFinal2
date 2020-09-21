package models;

import utilities.Utilities;

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

	public boolean isValidateCode(int code) {
		for (Diagnostic register : diagnosticList) {
			if (register.isValidateCases(code)) {
				return true;
			}
		}
		return false;
	}

	public void deleteRegister(int numberAuto) {
		int size = size();
		for (int i = 0; i < size-1; i++) {
			if (diagnosticList.get(i).isValidateCases(numberAuto)) {
				this.diagnosticList.remove(i);
			}
		}
	}

	public Object[] getSearchFilter(String object, int index){
		return Utilities.getSearchDeps(object,index,diagnosticList);
	}

	public int sizeForSearch(Object object){
		int size = size(),count = 0;
		for (int i = 0; i < size(); i++) {
			count += ((int)object == diagnosticList.get(i).getPatient().getAge()) ? 1:0;
		}
		return count;
	}

	public ArrayList<Object[]> getMatrixSearchFilter(String object){
		String auxString = object;
		ArrayList<Object[]> auxObjects = new ArrayList<>();
		int size = size();
		for (int i = 0; i < size; i++) {
			if (diagnosticList.get(i).isValidateDepartments(diagnosticList.get(i).getPatient().getDepar())){
				if (getSearchFilter(auxString,i) != null){
					auxObjects.add(getSearchFilter(auxString,i));
				}
			}
		}
		return auxObjects;
	}

	public int[] countTotalCases(Departments department){
		int size = size();
		int[] count = new int[3];
		for (int i = 0;i < size; i++) {
			boolean validDepartment = diagnosticList.get(i).isValidateDepartments(department);
			count[0] += (validDepartment) ? 1:0;
			count[1] += (validDepartment&& diagnosticList.get(i).getDateOfRecovered() != null) ? 1:0;
			count[2] += (validDepartment && diagnosticList.get(i).getDateOfDeath() != null) ? 1:0;
		}
		return count;
	}
	
	public int[] countTotal() {
		int[] count = new int[3];
		Departments deps[] = Departments.values();
		int size = deps.length;
		for (int i = 0; i < size; i++) {
			count[0] += countTotalCases(deps[i])[0];
			count[1] += countTotalCases(deps[i])[1];
			count[2] += countTotalCases(deps[i])[2];
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
	
	public int calCases(Departments departement) {
		int value = 0;
		value = countTotalCases(departement)[0];
		return(value);
	}
	
	public int[] getPercentagesCases() {
		Departments[] departments = Departments.values();
		int[] values = new int[departments.length];
		for (int i = 0; i < departments.length; i++) {
			int numberCases = calCases(departments[i]);
			values[i] = numberCases;
		}
		return values;
	}
	
	public int[] filterPercentages(int[] values) {
		int size = values.length;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if(values[i] > values[j]) {
					int aux = values[j];
					values[j] = values[i];
					values[i] = aux;
				}
			}
		}
		return values;
	}
	
	public int[] getLimitDatas(int[] values,int limit) {
		int[] result = new int[limit];
		int size = size();
		for (int i = 0; i < limit; i++) {
			result[i] = (values[i]*100/size);
		}
		return result;
	}
	
	public String[] ordenateArray(int[] values) {
		Departments[] departments = Departments.values();
		String[] results = new String[departments.length];
		int size = size();
		for (int i = 0; i < values.length; i++) {
			results[i] = searchDepartment(values[i], departments).getKeys()+(values[i]*100/size)+"%";
		}
		return results;
	}
	
	public Departments searchDepartment(int value, Departments[] deps) {
		int size = deps.length;
		for (int i = 0; i < size; i++) {
			if(calCases(deps[i]) == value) {
				return deps[i];
			}
		}
		return null;
	}
}
