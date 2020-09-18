package utilities;

import persistence.HandlerLanguage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
    
    public static HealthCondition getHealthConsdition(String data) {
    	switch (data) {
		case "Asintomático": return HealthCondition.ASYMPTOMATIC;
		case "Fallecido": return HealthCondition.DECEASED;
		case "Leve": return HealthCondition.MILD;
		default:
			break;
		}
    	return null;
    }
}
