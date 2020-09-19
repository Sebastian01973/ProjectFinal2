package TextPackage.models;

import controllers.Controller;
import models.Diagnostic;
import models.ManagePatients;
import persistence.FileManagerJson;

import java.util.ArrayList;

public class TestContarCasos {
    public static void main(String[] args) {
        String LOCAL_HOST_PACHO = "http://localhost/Json/SurtidoMix.json";
        ManagePatients managePatients = new ManagePatients();
        FileManagerJson file = new FileManagerJson();
//        ArrayList<Object[]>  file.readWebService(LOCAL_HOST_PACHO);

    }
}
