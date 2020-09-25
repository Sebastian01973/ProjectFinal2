package utilities;

import models.*;
import persistence.HandlerLanguage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import models.HealthCondition;

public class Utilities {

    public static Properties generateProperties(String pathFile ) throws IOException {
        Properties properties = new Properties();
        InputStream input = new FileInputStream(pathFile);
        properties.load( input );
        return properties;
    }

    public static void saveProperties( Properties properties, String pathFile ) throws IOException{
        FileOutputStream output = new FileOutputStream(pathFile);
        properties.store(output, null);
        output.close();
    }

    public static Object[] getKeys(Object[] keys) {
        String[] auxConstants = new String[keys.length];
        for (int i = 0; i < keys.length; i++) {
            auxConstants[i] = getKey(String.valueOf(keys[i]));
        }
        return auxConstants;
    }

    public static String getKey(String key) {
        return HandlerLanguage.languageProperties.getProperty(key);
    }

    public static Attention getAttention(int index){
        switch (index){
            case 1: return Attention.RECOVERED;
            case 2: return Attention.HOUSE;
            case 3: return Attention.DECEASED;
            case 4: return  Attention.HOSPITAL;
            case 5: return  Attention.ICU_HOSPITAL;
            case 6: return Attention.N_A;
            default: return null;
        }
    }

    public static Gender getGender(int index){
        switch (index){
            case 1: return Gender.MALE;
            case 2: return Gender.FEMALE;
            default: return null;
        }
    }

    public static HealthCondition getHealthCondition(int index){
        switch (index){
            case 1: return HealthCondition.ASYMPTOMATIC;
            case 2: return HealthCondition.MILD;
            case 3: return HealthCondition.MODERATE;
            case 4: return HealthCondition.SEVERE;
            case 5: return HealthCondition.N_A;
            case 6: return HealthCondition.DECEASED;
            default: return null;
        }
    }

    public static LocalDate parseDateToLocalDate(Date date) {
        if (date == null){
            return null;
        }else{
            return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        }
    }

    public static boolean isValidateDatasOfAdd(Date diagnostic,Date recovered,Date death){
        if (diagnostic == null || (recovered != null && death != null)){
            return true;
        }else {
            return false;
        }
    }

    public static void readDatasJson(ArrayList<Object[]> arrayObjects, ManagePatients managePatients){
        int size = arrayObjects.size();
        for (int i = 0; i < size; i++) {
            Object[] objects = arrayObjects.get(i);
            Diagnostic auxDiagnostic = null;
            for (int j = 0; j < objects.length; j++) {
                auxDiagnostic = new Diagnostic(i+1,
                new Patient(
                		UtilitiesViews.getDepartament(UtilitiesViews.getDatasDepartaments(String.valueOf(objects[0]))),
                		UtilitiesViews.getAttention(String.valueOf(objects[1])),
                		Integer.parseInt(String.valueOf(objects[2])),
                		UtilitiesViews.getGender(String.valueOf(objects[3])),
                		UtilitiesViews.getHealthCondition(String.valueOf(objects[4]))),
                        UtilitiesViews.toParseLocalDate(objects[5]),
                        UtilitiesViews.toParseLocalDate(objects[6]),
                        UtilitiesViews.toParseLocalDate(objects[7])
               );
            }
            managePatients.addDiagnostic(auxDiagnostic);
        }
    }

    public static boolean isValidateDatasSearch(int data,int data2,int data3,int data4){
       if (data != 0 && (data2 == 0 && data3 == 0 && data4 == 0)){
           return true;
       }else{
           return false;
       }
    }

    public static Departments getDepartaments(String key){
        Departments[] ok = Departments.values();
        for (int i = 0; i < ok.length; i++) {
            if (key.equals(ok[i].getKeys())){
                return ok[i];
            }
        }
        return null;
    }

    public static String dateToString(LocalDate date) {
        if (date != null){
            return (date.getDayOfMonth() + "/" + date.getMonthValue() + "/" + date.getYear());
        }else{
            return null;
        }
    }

    public static String dateToStringByte(LocalDate date) {
        if (date != null){
            return (date.getDayOfMonth() + "/" + date.getMonthValue() + "/" + date.getYear());
        }else{
            return "";
        }
    }
    
    

    public static Object[] getSearchDeps(String ob, int index, ArrayList<Diagnostic> patients){
    	if(patients.get(index).isValidateAttention(ob)) {
    		return patients.get(index).toObjectVector();
    	}
    	if(patients.get(index).isValidateGender(ob)) {
    		return patients.get(index).toObjectVector();
    	}
        if (patients.get(index).isValidateDepartments(ob)){
            return  patients.get(index).toObjectVector();
        }
        if (patients.get(index).isValidateHealth(ob)){
            return patients.get(index).toObjectVector();
        }else if (ob.equals(String.valueOf(patients.get(index).getPatient().getAge()))){
            return patients.get(index).toObjectVector();
        }
        return null;
    }

    public static String getKeyLanguage(String key){
        if (key != null) {
            switch (key) {
                case "N/A.":
                    return HealthCondition.N_A.getKey();
                case "Asymptomatic.":
                case "Asintomatico.":
                    return HealthCondition.ASYMPTOMATIC.getKey();
                case "Leve.":
                case "Mild.":
                    return HealthCondition.MILD.getKey();
                case "Moderate.":
                case "Moderado.":
                    return HealthCondition.MODERATE.getKey();
                case "Grave.":
                case "Severe.":
                    return HealthCondition.SEVERE.getKey();
                case "Decesed.":
                case "Fallecido.":
                    return HealthCondition.DECEASED.getKey();
                case "Recuperado.":
                case "Recovered.":
                    return Attention.RECOVERED.getKey();
                case "In House.":
                case "En casa.":
                    return Attention.HOUSE.getKey();
                case "En Hospital.":
                case "In Hospital.":
                    return Attention.HOSPITAL.getKey();
                case "Care UCI.":
                case "Cuidados UCI.":
                    return Attention.ICU_HOSPITAL.getKey();
                default:
                    return key;
            }
        }else{
            return null;
        }
    }
  
}
