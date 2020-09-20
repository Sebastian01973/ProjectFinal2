package views;

import java.awt.*;

public class Constant {

//    Urls

    public static final String NAME_FILE_CONFIG = "resources/config/config.init";
    public static final String ENGLISH_PATH = "resources/languages/languageUS.properties";
    public static final String SPANISH_PATH = "resources/languages/languageES.properties";

    //    Imagenes


    //text home
    public static final String TEXT_H_LABEL_CASOS = "Cases";
    public static final String TEXT_H_LABEL_RECOVERED = "Recovered";
    public static final String TEXT_H_LABEL_DECEASED = "Deceased";
    public static final String TEXT_H_LABEL_NAME1 = "Student_One";
    public static final String TEXT_H_LABEL_NAME2 = "Student_Two";
    
    //    Titulos Principales

    public static final String APP_TITLE = "Corona_Virus";

//    Titulos Secundarios

    //    Colores
    public static final String COLOR_BANNER = "#767676";

    public static final Color COLOR_BLUE_DARK = Color.decode("#1a3855");
    public static final Color COLOR_BLUE_LIGHT_G = Color.decode("#2b4372");
    public static final Color COLOR_WHITE = Color.decode("#fffefd") ;
    public static final Color C_MIDNIGHT_BLUE = Color.decode("#00235b") ;
    public static final Color COLOR_WHITE_SMOKE = Color.decode("#f4f4f4") ;
    public static final Color COLOR_DIMGRAY = Color.decode("#666666") ;
    public static final Color COLOR_BLACK = Color.decode("#000000") ;
    public static final Color COLOR_BLUE_COVID = Color.decode("#032841");
    public static final Color COLOR_HOME_FOOTER = Color.decode("#363435");
    public static final Color COLOR_BLUE_RIGHT = Color.decode("#044a98");
    public static final Color COLOR_PURPLE = Color.decode("#851FA5");
    
    //home
    
    public static final String T_INFORMATION = "Information";
    public static final String T_FIRST_INFORMATION = "Firts_Information";
    public static final String T_SECOND_INFORMATION = "Second_Information";
    public static final String T_THIRD_INFORMATION = "Third_Information";
    public static final String T_INFO_COVID = "Info_Covid";
    public static final String T_INFO_SYMPTOMS = "T_Info_Symptoms";
    public static final String T_INFO_PREVENT= "T_Info_Prevent";
    public static final Color COLOR_BLUE_DIALOG = Color.decode("#0D3A62");
    public static final Color COLOR_RED_LIGHT = Color.decode("#B90603");



//    Fuentes
    public static final Font FONT_ROCWELL = new Font("Rockwell",Font.PLAIN, 20);
    public static final Font FONT_NEW_ROMAN_25 = new Font("Times New Roman",Font.PLAIN, 25);
    public static final Font FONT_BONODI_15 = new Font("Bodoni MT", Font.PLAIN, 15);
    public static final Font FONT_ARIAL_ROUNDER_17 = new Font("Arial Rounded MT Bold", Font.PLAIN, 17);
    public static final Font FONT_ARIAL_ROUNDER_25 = new Font("Arial Rounded MT Bold", Font.PLAIN, 25);
    public static final Font FONT_ARIAL_ROUNDER_30 = new Font("Arial Rounded MT Bold", Font.PLAIN, 30);
    public static final Font FONT_ARIAL_ROUNDER_15 = new Font("Arial Rounded MT Bold", Font.PLAIN, 15);
    public static final Font FONT_HELVETICA_17 = new Font("Helvetica", Font.BOLD, 17);
    public static final Font FONT_HELVETICA_15 = new Font("Helvetica", Font.PLAIN, 15);
    public static final Font FONT_HELVETICA_13 = new Font("Helvetica",Font.PLAIN, 13);


//    Titulos del menu

//    Titulos de menus
    public static final String M_FILE = "File";
    public static final String M_REFRESH = "Refresh";
    public static final String M_PATIENT = "Patient";
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
    public static final String M_HOME = "Home";
    public static final String M_TABLE = "Table";

//Menu Estadisticas

    public static final String M_DEATH = "Death";
    public static final String M_RECOVERED = "Recovered";
    public static final String M_DIAGNOSTIC= "Diagnostic";
    public static final String M_DEPARTMENT= "Department";

    public static final String[] TABLE_DEPS= new String[]{M_DEPARTMENT,M_DIAGNOSTIC,M_RECOVERED,M_DEATH};

    public static final String M_STATISTICS = "Statistics";
    public static final String M_STA_REPORT_LOCATION = "Report_Location";

    public static final String M_STA_REPORT_DEATH = "Report_Death";
    public static final String M_STA_REPORT_RECOVERED = "Report_Recovered";
    public static final String M_STA_REPORT_DIAGNOSTIC= "Report_Diagnostic";

    public static final String M_STATE_HEALTH= "Report_State_Health";
    public static final String M_PERCENTAGE_LETHALITY= "Report_Percentage_Lethality";

    public static final String M_STA_TABLE_FOR_LOCATION = "Report_Table_Location";

    //Menu de paciente,Graficos y Acerca de....

    public static final String M_GRAP_BAR_REPORT = "Report_Graphics_Bar";
    public static final String M_GRAP_REPORT_LINE = "Report_Graphics_Line";
    public static final String M_GRAP_TORTE_REPORT = "Report_Graphics_Torte";

    public static final String M_LOCATION = "Location";
    public static final String M_CREATORS = "About_Creators";
    public static final String M_APPLICATION = "About_App";
    public static final String M_TITLTE_STATES = "Title_States";
    public static final String M_DIALOG_STATES = "Dialog_States";

    //Dialogos y labels

    public static final String L_NUMBER_CASES = "Number_Cases";
    public static final String L_NUMBER_DEATH = "Number_Death";
    public static final String L_RESUME_CASES = "Resume_Cases";
    public static final String L_NUMBER_DIAGNOSTIC = "Number_Diagnostic";
    public static final String L_DIALOG = "Dialog";


    public static final String L_GENDER = "Gender";
    public static final String L_AGE = "Age";
    public static final String L_ATTENTION = "Attention";
    public static final String L_LOCATION = "Location_City";
    public static final String L_HEALTH = "Health_Condition";
    public static final String L_DATE_DIAGNOSTIC = "Date_Diagnostic";
    public static final String L_DATE_RECOVERED = "Date_Recovered";
    public static final String L_DATE_DEATH = "Date_Death";
    public static final String L_CANCEL = "Cancel";
    public static final String L_CREATE = "Create";




    //    Titulos de la tabla
    public static final Object[] HEADERDS_TABLEMAIN = {"Number_Case",L_GENDER,L_AGE,L_ATTENTION,L_LOCATION,
            L_HEALTH,L_DATE_DIAGNOSTIC,L_DATE_RECOVERED,L_DATE_DEATH};

    public static final String IMG_ICON_APP = "/images/covidIcon.png";
    public static final String IMG_ARROW_DOWN = "/images/arrowDown.png";
    public static final String IMG_ARROW_RIGHT = "/images/arrowRight.png";
    public static final String IMG_DIALOG = "/images/dialog.png";
    public static final String IMG_ABOUT = "/images/about.jpg";
    public static final String IMG_ABOUT_US = "/images/aboutUs.png";
    public static final String IMG_ABOUT_APP = "/images/aboutApp.png";
    public static final String IMG_SPANISH = "/images/Spanish.png";
    public static final String IMG_ENGLISH = "/images/English.png";
    public static final String IMG_ADD_USER = "/images/addUser.png";
    public static final String IMG_USER = "/images/User.png";
    public static final String IMG_MODIFY_USER = "/images/modifyUser.png";
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
    public static final String IMG_HOME = "/images/Home.png";
    public static final String IMG_RANGE_AGE = "/images/rangeAge.png";
    public static final String IMG_AGE = "/images/age.png";
    public static final String IMG_LOC = "/images/loc.png";
    public static final String IMG_COl = "/images/col.png";
    public static final String IMG_TABLE = "/images/table.png";
    public static final String IMG_TABLE1 = "/images/table1.png";
    public static final String IMG_DEATH = "/images/death.jpg";
    public static final String IMG_GRAPHICS = "/images/graphics.png";
    public static final String IMG_LOCATION = "/images/location.png";
    public static final String IMG_SEARCH_USER = "/images/searchuser.png";
    public static final String IMG_DELETE_USER = "/images/deleteUser.png";
    public static final String IMG_STADITICS1 = "/images/staditics1.png";
    public static final String IMG_STADISTIC = "/images/sta.png";
    public static final String IMG_STADITICS2 = "/images/Statidist2.png";
    public static final String IMG_STADITICSTORTE = "/images/statiditsTorte.png";

    //Imagenes Covid
    public static final String IMG_COV_AMBULANCE = "/images/Covid/Ambulance.png";
    public static final String IMG_COV_CORONA = "/images/Covid/coronavirus.png";
    public static final String IMG_COV_ASYMPTOMATIC = "/images/Covid/asintomathic.png";
    public static final String IMG_COV_BOOK_HEALTH = "/images/Covid/BookHealth.png";
    public static final String IMG_COV_CALENDAR = "/images/Covid/CalendarCovid.png";
    public static final String IMG_COV_CALL_EMERGENCY = "/images/Covid/CallEmergency.png";
    public static final String IMG_COV_CHECK_TEMPERATURE = "/images/Covid/CallEmergency.png";
    public static final String IMG_COV_DEATH = "/images/Covid/DeathCovid.png";
    public static final String IMG_COV_DENSITY_HUMAN = "/images/Covid/DensityHuman.png";
    public static final String IMG_COV_HAND_WASH = "/images/Covid/HandWash.png";
    public static final String IMG_COV_HEALTHY = "/images/Covid/Healthy.png";
    public static final String IMG_COV_HOME = "/images/Covid/HomeCovid.png";
    public static final String IMG_COV_HOSPITAL = "/images/Covid/Hospital.png";
    public static final String IMG_COV_MASK_MEDICAL = "/images/Covid/MaskMedical.png";
    public static final String IMG_COV_MICRO_ORGANIS = "/images/Covid/microOrganis.png";
    public static final String IMG_COV_PATIENT = "/images/Covid/patient.png";
    public static final String IMG_COV_PROTECTION_WEAR = "/images/Covid/protectionWear.png";
    public static final String IMG_COV_RECOVERED = "/images/Covid/recovered.png";
    public static final String IMG_COV_SEARCH_VIRUS = "/images/Covid/SearchVirus.png";
    public static final String IMG_COV_SICK_TEMPERATURE = "/images/Covid/sickTemperature.png";
    public static final String IMG_COV_SICK_SNEEZE = "/images/Covid/sickSneeze.png";
    public static final String IMG_COV_STADISTICS = "/images/Covid/Staditics.png";
    public static final String IMG_COV_STOP_SHAKING = "/images/Covid/stopShaking.png";
    public static final String IMG_COV_UCI = "/images/Covid/Uci.png";
    public static final String IMG_COV_WORLD = "/images/Covid/World.png";
    // imagenes home
    public static final String IMG_H_RECOVERED = "/images/Home/recuperados.jpg";
    public static final String IMG_H_CASES = "/images/Home/casos.jpg";
    public static final String IMG_H_DECEASED = "/images/Home/fallecidos.jpg";
    public static final String IMG_H_BANNER = "/images/Home/banner.jpg";
    public static final String IMG_H_LABEL_CASES = "/images/Home/5952754 - coronavirus forbidden keep distance no contact.png";
    public static final String IMG_H_LABEL_RECOVERED = "/images/Home/recovered.png";
    public static final String IMG_H_LABEL_DECEASED = "/images/Home/deceased.png";
    public static final String IMG_H_LABEL_UPTC = "/images/Home/uptc.jpg";

    //Imagenes Departamentos


    public static final String IMG_BANDERA = "/images/states/BanderaColombia.jpg";
    public static final String IMG_AMAZONAS = "/images/states/Amazonas.jpg";
    public static final String IMG_ANTIOQUIA = "/images/states/Antioquia.jpg";
    public static final String IMG_ARAUCA = "/images/states/Arauca.jpg";
    public static final String IMG_ATLANTICO = "/images/states/Atlantico.jpg";
    public static final String IMG_BOGOTA = "/images/states/Bogota.jpg";
    public static final String IMG_BOLIVAR = "/images/states/Bolivar.jpg";
    public static final String IMG_BOYACA = "/images/states/Boyaca.jpg";
    public static final String IMG_CALDAS = "/images/states/Caldas.jpg";
    public static final String IMG_CAQUETA = "/images/states/Caqueta.jpg";
    public static final String IMG_CASANARE = "/images/states/Casanare.jpg";
    public static final String IMG_CAUCA = "/images/states/Cauca.jpg";
    public static final String IMG_CESAR = "/images/states/Cesar.jpg";
    public static final String IMG_CHOCO = "/images/states/Choco.jpg";
    public static final String IMG_CORDOBA = "/images/states/Cordoba.jpg";
    public static final String IMG_CUNDINAMARCA = "/images/states/Cundinamarca.jpg";
    public static final String IMG_GUIANIA = "/images/states/Guainia.jpg";
    public static final String IMG_GUAJIRA = "/images/states/Guajira.jpg";
    public static final String IMG_GUAVIARE = "/images/states/Guaviare.jpg";
    public static final String IMG_HUILA = "/images/states/Huila.jpg";
    public static final String IMG_MAGDALENA = "/images/states/Magdalena.jpg";
    public static final String IMG_META = "/images/states/Meta.jpg";
    public static final String IMG_NARIÑO = "/images/states/Nariño.jpg";
    public static final String IMG_NORTE_SANTANDER = "/images/states/NorteSantander.jpg";
    public static final String IMG_PUTUMAYO = "/images/states/Putumayo.jpg";
    public static final String IMG_QUINDIO = "/images/states/Quindio.jpg";
    public static final String IMG_RISARALDAS = "/images/states/Risaralda.jpg";
    public static final String IMG_SAN_ANDRES = "/images/states/SanAndres.jpg";
    public static final String IMG_SANTANDER = "/images/states/Santander.jpg";
    public static final String IMG_SUCRE = "/images/states/Sucre.jpg";
    public static final String IMG_TOLIMA = "/images/states/Tolima.jpg";
    public static final String IMG_VALLE_CAUCA = "/images/states/ValleCauca.jpg";
    public static final String IMG_VAUPES = "/images/states/Vaupes.jpg";
    public static final String IMG_VICHADA = "/images/states/Vichada.jpg";


    public static final String[] IMGS_DEPART = new String[]{IMG_AMAZONAS,IMG_ANTIOQUIA,IMG_ARAUCA, IMG_SAN_ANDRES,IMG_ATLANTICO,
            IMG_BOGOTA, IMG_BOLIVAR, IMG_BOYACA, IMG_CALDAS, IMG_CAQUETA,IMG_CASANARE,
            IMG_CAUCA, IMG_CESAR, IMG_CHOCO, IMG_CUNDINAMARCA,IMG_CORDOBA , IMG_GUIANIA, IMG_GUAVIARE,IMG_HUILA,IMG_GUAJIRA,
            IMG_MAGDALENA, IMG_META, IMG_NARIÑO, IMG_NORTE_SANTANDER,
            IMG_PUTUMAYO, IMG_QUINDIO, IMG_RISARALDAS, IMG_SANTANDER, IMG_SUCRE,
            IMG_TOLIMA, IMG_VALLE_CAUCA,IMG_VAUPES, IMG_VICHADA};

    public static final String[] KEYS_DEPARTMENTS = new String[]{
            "Amaz","Anti","Arau","Arch","AtlA","Bogo","BolA","Boya","Cald","Caqu","Casa",
            "Cauc", "Cesa","Choc", "Cund","CArd","Guai","Guav","Huil","La G","Magd","Meta",
            "Nari", "Nort","Putu","Quin","Risa","Sant","Sucr", "Toli","Vall","Vaup","Vich",
    };
    
    public static final String[] LABELS_PIE = new String[] {"1-12 Bebes","13-30 Joven","31-60 Adulto",
			"60 en ancianos"};
}
