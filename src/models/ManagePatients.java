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
		return new Diagnostic(size()+1,new Patient(location,attention,age,gender,healthCondition),dates[0],dates[1],dates[2]);
	}

	public void addDiagnostic(Diagnostic diagnostic) {
		diagnosticList.add(diagnostic);
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

	public Object[] getDatasDepartament(int index){
		Departments[] dep = Departments.values();
			return new Object[]{
					dep[index].getDepartment(),
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
		Departments[] departments = Departments.values();
		int size = values.length;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if(values[i] > values[j]) {
					int aux = values[j];
					values[j] = values[i];
					values[i] = aux;
					System.out.println("i: "+values[i] + "j: "+values[j]);
				}
			}
		}
		return values;
	}
	
	public int[] ordenateArray() {
		return null;
	}
	
//	public int[] filterValues(int[] datas) {
//		int[] result = new int[10];
//		for (int i = 0; i < result.length; i++) {
//			int value = travelArray(datas, 0);
//			result[i] = value;
//			datas = resizeArray(datas, value);
//		}
//		return result;
//	}

//	public Object[][] filterValues2(Object[][] datas) {
//		Object[][] result = new Object[10][2];
//		String[] names = new String[datas.length];
//		Object[][] numbers = getValues(datas);
//		for (int i = 0; i < result.length; i++) {
//			Object[][] value = travelArray(datas, 0);
//			result[i][1] = value;
//			int number = (int) value[0][1];
//			numbers = resizeArray(numbers, number);
//		}
//		return result;
//	}
//	
////	public String[] getFilterPercentages(){
////		Object[][] datas = getPercentagesCases();
////		int[] percentages = filterValues(datas);
////		String[] departments = new String[percentages.length];
////		int count = 0;
////		for (int i = 0; i < datas.length; i++) {
////			int value = (int) datas[i][1];
////			if(value == percentages[count]) {
////				departments[i] = (String) datas[i][0];	
////				count++;
////			}
////		}
////		return departments;
////	}
//	
//	public Object[][] getValues(Object[][] datas) {
//		Object[][] values = new Object[datas.length][2];
//		for (int i = 0; i < datas.length; i++) {
//			values[i][1] = datas[i][1];
//			values[i][0] = datas[i][0];
//		}
//		return values;
//	}
//	
//	public String getDepNames(int value,Object[] array) {
//		String deps = "";
//		for (int i = 0; i < array.length; i++) {
//			
//		}
//		return deps;
//	}
//	
//	public Object[][] travelArray(Object[][] datas,int value) {
//		String department = "";
//		Object[][] matrix = new Object[1][2];
//		for (int j = 0; j < datas.length; j++) {
//			int num = (int) datas[j][1];
//			if(value < num) {
//				department = (String) datas[j][0];
//				value = (int) datas[j][1];
//				matrix[0][1] = value;
//				matrix[0][0] = department;
//			}
//		}
//		return matrix;
//	}
//	
//	public Object[][] resizeArray(Object[][] numbers,int value) {
//		Object[][] result = new Object[numbers.length][2];
//		boolean find = false;
//		for (int i = 0; i < result.length; i++) {
//			int number = (int) numbers[i][1];
//			if(!find && value == number) {
//				find = true;
//				result[i][1] = 0;
//				result[i][0] = numbers[i][0];
//				continue;
//			}
//			result[i][1] = numbers[i][1];
//			result[i][0] = numbers[i][0];
//		}
//		return result;
//	}
}
