package TextPackage.models;

import controllers.Controller;
import models.*;
import persistence.FileManagerJson;
import utilities.Utilities;

import java.time.LocalDate;
import java.util.ArrayList;

public class TestContarCasos {
    public static void main(String[] args) {
//        Patient patient = new Patient(Departments.AMAZONAS, Attention.DECEASED,14,Gender.FEMALE,HealthCondition.DECEASED);
//        Diagnostic dg = new Diagnostic(2,patient, LocalDate.now(),null,null);
//        System.out.println(dg.isValidateDepartments(Departments.AMAZONAS));

        String LOCAL_HOST_PACHO = "http://localhost/Json/SurtidoMix.json";
        ManagePatients managePatients = new ManagePatients();
        FileManagerJson file = new FileManagerJson();
        ArrayList<Object[]> ob = file.readWebService(LOCAL_HOST_PACHO);
        Utilities.readDatasJson(ob,managePatients);
        int[] aux = managePatients.countTotalCases(Departments.AMAZONAS);
        for (int i = 0; i < aux.length; i++) {
            System.out.println(""+aux[i]);
        }
        System.out.println("------------------");
//        Object[] auxObje = managePatients.getDatasDepartament();
//        for (int i = 0; i < auxObje.length; i++) {
//            System.out.println("--"+auxObje[i]+"--");
//        }

        System.out.println("------------------");
        ArrayList<Object[]> ok = managePatients.getDatasDepartaments();
        for (int i = 0; i < ok.size(); i++) {
            System.out.println(ok.get(i)[0]+ "-" + ok.get(i)[1]);
        }
    }
}
