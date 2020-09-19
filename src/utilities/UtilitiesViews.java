package utilities;

import models.Attention;
import models.Departments;
import models.Gender;
import models.HealthCondition;
import views.Constant;
import views.models.JModelLabel;

import javax.swing.*;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics2D;
import java.text.Collator;
import java.text.DecimalFormat;
import java.text.Normalizer;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;

public class UtilitiesViews {
	
	public static int[] parseDatas(int[] data) {
		int[] value = new int[data.length];
		for (int i = 0; i < value.length; i++) {
			value[i] = data[i]/10;
		}
		return value;
	}

    public static String toFloatFormatPercentage(float value) {
        DecimalFormat df = (DecimalFormat) NumberFormat.getInstance();
        df.applyPattern( "% ####,##" );
        String strValue = df.format(value);
        return strValue;
    }

    public static String toFormatterDate(LocalDate date) {
        if (date != null){
            String formatDate = "dd-MM-yyyy";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatDate);
        return date.format(formatter);
        }else{
            return "";
        }
    }

//  //2020-06-19T00:00:00.000
  public static LocalDate toParseLocalDate(Object date){
	  if(date != null) {
		  	String subDate = date.toString();
		  	String formatDate = "dd-MM-yyyy";
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatDate);
			LocalDate dateResult = LocalDate.parse((CharSequence) subDate.substring(0, 10));
			dateResult.format(formatter);
			return dateResult;  
	  }
	  return null;
  }
  
  public static String trimDate(LocalDate date) {
	  if(date != null) {
		  String data = date.toString();
		  String dateTrim = data.replace('-', '/');
		  return dateTrim;
	  }
	  return null;
  }
  
  public static String dateToString(Object date) {
	  LocalDate auxDate = toParseLocalDate(date);
	  return trimDate(auxDate);
  }
    
    //Utilities GRAPHICS
    
    public static void drawAxis(int x1,int y1,int x2,int y2,Graphics2D graphics2D) {
    	graphics2D.drawLine(x1, y1, x2, y2);
    }
    
    public static int getSeparationAxis(char Axis, float value,Container container) {
    	if(Axis == 'x') {
    		return (int) (container.getWidth()*value);
    	}
    	return (int) (container.getHeight()*value);
    }
    
    public static void drawXDivisions(Graphics2D g2D,int length,String[] labels,Container c) {
    	int x = getSeparationAxis('x',0.15f,c);
		int y1 = getSeparationAxis('y',0.79f,c);
		int y2 = getSeparationAxis('y',0.81f,c);
		int increase = length/labels.length;
		for (int i = 0; i < labels.length; i++) {
			g2D.setColor(Color.red);
			g2D.drawLine(x+(i*increase), y1, x+(i*increase), y2);
			g2D.setColor(Color.black);
			g2D.drawString(labels[i], x+(i*increase)-2, y2+11);
		}
    }
    
    public static void drawYDivisions(Graphics2D g2D,int length,String[] labels,Container container) {
		int x1= getSeparationAxis('x',0.08f,container);
		int x2=	getSeparationAxis('x',0.1f,container);
		int sizeDivision = length/labels.length;
		for (int i = 0; i < labels.length
				; i++) {
			double value = i*100.0/100;
			g2D.setColor(Color.red);
			g2D.drawLine(x1, (int)(length-value*sizeDivision), x2, (int)(length-value*sizeDivision));
			g2D.setColor(Color.black);
			g2D.drawString(labels[i], x1-30, (int)(length-value*sizeDivision));
		}
	}

	public static JLabel spaceLabel(Color bg, Color fg){
    	JLabel space = new JModelLabel("<html>s<p>s<p><html>",bg,fg);
    	return  space;
	}

	//Utilities Json

	public static String toCutHealthCondition(String data){
    	if (data.charAt(0) == 'A'){
    		return "Asintomatico";
		}else{
    		return data;
		}
	}

	public static Gender getGender(String data){
		switch (data){
			case "M": return Gender.MALE;
			case "F": return Gender.FEMALE;
			default: return null;
		}
	}

	public static HealthCondition getHealthCondition(String data) {
		switch (data) {
			case "Asintomatico": return HealthCondition.ASYMPTOMATIC;
			case "Fallecido": return HealthCondition.DECEASED;
			case "Leve": return HealthCondition.MILD;
			case "Moderado": return HealthCondition.MODERATE;
			case "Grave": return HealthCondition.SEVERE;
			case "N/A": return HealthCondition.N_A;
			default: return null;
		}
	}

	public static Attention getAttention(String data){
		switch (data){
			case "Recuperado": return Attention.RECOVERED;
			case "Casa": return Attention.HOUSE;
			case "Fallecido": return Attention.DECEASED;
			case "Hospital": return  Attention.HOSPITAL;
			case "Hospital UCI": return  Attention.ICU_HOSPITAL;
			case "N/A": return Attention.N_A;
			default: return null;
		}
	}

	public static boolean isValidate(String depar,String regex,int start,int end){
		if (depar.length() >= end ){
			if (depar.substring(start,end).equals(regex)){
				return true;
			}
		}
		return false;
	}

	public static String getDatasDepartaments(String depart){
		String[] departments = Constant.KEYS_DEPARTMENTS;
		int size = departments.length;
		String cad1 = Normalizer.normalize(depart, Normalizer.Form.NFD);
		String cad2 = cad1.replaceAll("[^\\p{ASCII}]", "");
		for (int i = 0; i < size; i++) {
			if (isValidate(cad2,"Carta",0,5)){
				return departments[6];
			}else if(isValidate(cad2,"Barra",0,5)){
				return departments[4];
			}else if(isValidate(cad2,"Marta",6,11)){
				return departments[20];
			}else if(isValidate(cad2,"Buena",0,5)){
				return  departments[30];
			}
			if (isValidate(cad2,departments[i],0,4)){
				return departments[i];
			}
		}
		return "Mal";
    }

    public static Departments getDepartament(String data){
    	String[] constant = Constant.KEYS_DEPARTMENTS;
    	Departments[] departments = Departments.values();
    	int size = constant.length;
		for (int i = 0; i < size; i++) {
			if (constant[i].equals(data)){
				return departments[i];
			}
		}
		return null;
	}
}
