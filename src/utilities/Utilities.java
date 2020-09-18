package utilities;

import models.*;
import persistence.HandlerLanguage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
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
            case 0: return Attention.RECOVERED;
            case 1: return Attention.HOUSE;
            case 2: return Attention.DECEASED;
            case 3: return  Attention.HOSPITAL;
            case 4: return  Attention.ICU_HOSPITAL;
            default: return null;
        }
    }

    public static Gender getGender(int index){
        switch (index){
            case 0: return Gender.MALE;
            case 1: return Gender.FEMALE;
            default: return null;
        }
    }

    public static HealthCondition getHealthCondition(int index){
        switch (index){
            case 0: return HealthCondition.ASYMPTOMATIC;
            case 1: return HealthCondition.MILD;
            case 2: return HealthCondition.MODERATE;
            case 3: return HealthCondition.SEVERE;
            case 4: return HealthCondition.DECEASED;
            default: return null;
        }
    }

    public static LocalDate parseDateToLocalDate(Date date) {
        if (date == null){
            return LocalDate.of(1900,01,01);
        }else{
            return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        }
    }



//    public static LocalDate parseDateToLocalDate(Object date) {
//        if (date == null){
//            return null;
//        }else{
//            return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//        }
//    }

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
  
}
