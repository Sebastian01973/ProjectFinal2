package views;

import java.awt.*;

public class Constant {

//    Urls

    public static final String NAME_FILE_CONFIG = "resources/config/config.init";
    public static final String ENGLISH_PATH = "resources/languages/languageUS.properties";
    public static final String SPANISH_PATH = "resources/languages/languageES.properties";

    //    Imagenes

    public static final String IMG_ICON_APP = "/images/covidIcon.png";
    public static final String IMG_SPANISH = "/images/Spanish.png";
    public static final String IMG_ENGLISH = "/images/English.png";
    public static final String IMG_ADD_USER = "/images/addUser.png";
    public static final String IMG_FILE = "/images/file.png";
    public static final String IMG_EXIT = "/images/exit.png";
    public static final String IMG_EXIT_APP = "/images/exitApp.png";
    public static final String IMG_REFRESH = "/images/refresh.png";
    public static final String IMG_WRITE = "/images/write.png";
    public static final String IMG_CODE = "/images/Code.png";
    public static final String IMG_SAVE = "/images/save.png";
    public static final String IMG_DOCUMENT = "/images/document.png";
    public static final String IMG_WORLD = "/images/world.png";
    public static final String IMG_BANNER = "/images/bannerCovid.jpg";



    //    Titulos Principales

    public static final String APP_TITLE = "Corona_Virus";

//    Titulos Secundarios

    //    Colores

    public static final Color COLOR_WHITE = Color.decode("#FFFFFF") ;
    public static final Color COLOR_BLACK = Color.decode("#000000") ;
    public static final Color COLOR_BLUE_LIGHT = Color.decode("#52D9E9") ;
    public static final Color COLOR_GREEN_SOFT = Color.decode("#25B50F") ;
    public static final Color COLOR_RED_TINTE = Color.decode("#C14343");
    public static final Color COLOR_GRAY_LIGHT = Color.decode("#CDD7DD");


//    Fuentes
    public static final Font FONT_ROCWELL = new Font("Rockwell",Font.PLAIN, 20);
    public static final Font FONT_NEW_ROMAN_13 = new Font("Times New Roman",Font.PLAIN, 13);
    public static final Font FONT_NEW_ROMAN_25 = new Font("Times New Roman",Font.PLAIN, 25);
    public static final Font FONT_COMPONENTS_DIALOG_COST = new Font("Bodoni MT", Font.PLAIN, 15);
    public static final Font FONT_ARIAL_ROUNDER_17 = new Font("Arial Rounded MT Bold", Font.PLAIN, 17);
    public static final Font FONT_ARIAL_ROUNDER_15 = new Font("Arial Rounded MT Bold", Font.PLAIN, 15);
    public static final Font FONT_HELVETICA_17 = new Font("Helvetica", Font.PLAIN, 17);
    public static final Font FONT_HELVETICA_15 = new Font("Helvetica", Font.PLAIN, 15);


//    Titulos del menu

//    Titulos de menus
    public static final String M_FILE = "File";
    public static final String M_ADD_DIAGNOSTIC = "Add_Diagnostic";
    public static final String M_SEARCH_DIAGNOSTIC = "Search_Diagnostic";
    public static final String M_MODIFY_DIAGNOSTIC = "Modify_Diagnostic";
    public static final String M_DELETE_DIAGNOSTIC = "Delete_Diagnostic";
    public static final String M_LANGUAGE = "Language";
    public static final String M_LANGUAGE_ES = "Spanish";
    public static final String M_LANGUAGE_US = "English";
    public static final String M_SAVE = "Save";
    public static final String M_LOAD = "Load";
    public static final String M_EXIT = "Exit";




//    Titulos de la tabla
    public static final Object[] HEADERDS_TABLEMAIN = {"Number_Case","Gender","Age","Attention", "Location_City",
        "Health_Condition","Date_Diagnostic","Date_Recovered","Date_Death"};
}
