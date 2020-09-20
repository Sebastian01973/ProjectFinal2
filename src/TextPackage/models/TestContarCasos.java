package TextPackage.models;

import controllers.Controller;
import models.*;
import persistence.FileManagerJson;
import utilities.Utilities;

import java.time.LocalDate;
import java.util.ArrayList;

public class TestContarCasos {
    public static void main(String[] args) {

        String LOCAL_HOST_PACHO = "http://localhost/Json/SurtidoMix.json";
        ManagePatients managePatients = new ManagePatients();
        FileManagerJson file = new FileManagerJson();
        ArrayList<Object[]> ob = file.readWebService(LOCAL_HOST_PACHO);
        Utilities.readDatasJson(ob,managePatients);

        Diagnostic dg = new Diagnostic(1,new Patient(Departments.BOYACA,Attention.DECEASED,34,Gender.FEMALE,HealthCondition.ASYMPTOMATIC),null,null,null);
        System.out.println(dg.isValidateDepartments("12"));

//        System.out.println("------------------");
//        Object[] auxObje = managePatients.getIndexSearchEnum("Sucre",2);
//        System.out.println(auxObje);
//        for (int i = 0; i < auxObje.length; i++) {
//            System.out.println("--"+auxObje[i]+"--");
//        }

        System.out.println("------------------");
        ArrayList<Object[]> ok = managePatients.getMatrixSearchFilter("Moderate");
        int size = managePatients.sizeForSearch((String.valueOf("Moderate")));
        for (int i = 0; i < size; i++) {
            System.out.println(ok.get(i)[0] + "-" + ok.get(i)[1]);
        }
        System.out.println("Numero:" + managePatients.sizeForSearch((int)12));
   }

}
