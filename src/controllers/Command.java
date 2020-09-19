package controllers;

import models.Attention;

public enum Command {

    AMAZONAS, ANTIOQUIA, ARAUCA, SAN_ANDRES, ATLANTICO, BOGOTA, BOLIVAR,
    BOYACA, CALDAS, CAQUETA, CASANARE, CAUCA, CESAR, CHOCO, CUNDINAMARCA, CORDOBA, GUAINIA,
    GUAVIARE, HUILA, GUAJIRA, MAGDALENA, META, NARINO, NORTE_SANTANDER, PUTUMAYO,
    QUINDIO, RISARALDA, SANTANDER, SUCRE, TOLIMA, VALLE_CAUCA, VAUPES, VICHADA,
    C_CREATE_NEW_PATIENT,C_CANCEL_NEW_PATIENT,
    C_ACTIVE_CASES_ADD,C_RECOVERED_CASES_ADD,C_DEATH_CASES_ADD,
    C_TABLE_LOCATION,

    C_ES_LANGUAGE,C_US_LANGUAGE,EXIT_APP,LOAD_FILE,SAVE_FILE,

    ADD_PATIENT,SEARCH_PATIENT,MODIFY_PATIENT,DELETE_PATIENT, REFRESH_DATA,

    C_MENU_HOME,C_MENU_TABLE,C_MENU_STATISTIC, C_MENU_LOCATION,

    C_ACTIVE_CASES,C_DEATH_CASES,C_RECOVERED_CASES,C_CASES_LOCATION,
    C_REPORT_LETHAL,C_REPORT_HEALTH,
    C_GRAPHICS_LINE,C_GRAPHICS_BAR,C_GRAPHICS_TORTE;
}
