package controllers;

import persistence.HandlerLanguage;
import views.Constant;
import views.JFWindowsMain;

import java.io.IOException;

import static javax.swing.JOptionPane.showMessageDialog;

public class ConfigLanguage {

    private JFWindowsMain jfWindowsMain;
    private HandlerLanguage config;

    public void setJfWindowsMain(JFWindowsMain jfWindowsMain) {
        this.jfWindowsMain = jfWindowsMain;
    }

    public void loadConfiguration() {
        if(config == null){
            config = new HandlerLanguage(Constant.NAME_FILE_CONFIG);
        }
        try{
            config.loadLanguage();
        }catch(IOException e){
            showMessageDialog(jfWindowsMain, e.getMessage());
        }
    }

    private void manageChangeLanguage(){
        jfWindowsMain.changeLanguage();
    }

    public void loadLanguage(){
        try {
            config.loadLanguage();
        } catch (IOException e) {
            showMessageDialog(jfWindowsMain, e.getMessage());
        }
    }

    public void saveConfig(){
        try {
            new HandlerLanguage(Constant.NAME_FILE_CONFIG).saveLanguage();
        } catch (IOException e) {
            showMessageDialog(jfWindowsMain, e.getMessage());
        }
    }

    public void changeToEnglish() throws IOException{
        HandlerLanguage.language = Constant.ENGLISH_PATH;
        saveConfig();
        loadLanguage();
    }

    public void changeToSpanish() throws IOException{
        HandlerLanguage.language = Constant.SPANISH_PATH;
        saveConfig();
        loadLanguage();
    }

    public void manageChangeLanguageUS(){
        try {
            changeToEnglish();
        } catch (IOException e1) {
            showMessageDialog(jfWindowsMain, e1.getMessage());
        }
        manageChangeLanguage();
    }

    public void manageChangeLanguageES(){
        try {
            changeToSpanish();
        } catch (IOException e1) {
            showMessageDialog(jfWindowsMain, e1.getMessage());
        }
        manageChangeLanguage();
    }
}
