package models;

import java.time.LocalDate;
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

	public int size(){
		return diagnosticList.size();
	}

	public ArrayList<Diagnostic> getDiagnosticList(){
		return diagnosticList;
	}


}
