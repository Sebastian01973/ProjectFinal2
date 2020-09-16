package models;

public enum Departments {
    AMAZONAS("Amazonas"),
    ANTIOQUIA("Antioquia"),
    ARAUCA("Arauca"),
    SAN_ANDRES("San Andres"),
    ATLANTICO("Atlantico"),
    BOGOTA("Bogota D.C"),
    BOLIVAR("Bolivar"),
    BOYACA("Boyaca"),
    CALDAS("Caldas"),
    CAQUETA("Caqueta"),
    CASANARE("Casanare"),
    CAUCA("Cauca"),
    CESAR("Cesar"),
    CHOCO("Choco"),
    CUNDINAMARCA("Cundinamarca"),
    CORDOBA("Cordoba"),
    GUAINIA("Guainia"),
    GUAVIARE("Guaviare"),
    HUILA("Huila"),
    GUAJIRA("Guajira"),
    MAGDALENA("Magdalena"),
    META("Meta"),
    NARINO("Nariño"),
    NORTE_SANTANDER("Norte de Santander"),
    PUTUMAYO("Putumayo"),
    QUINDIO("Quindio"),
    RISARALDA("Risaralda"),
    SANTANDER("Santander"),
    SUCRE("Sucre"),
    TOLIMA("Tolima"),
    VALLE_CAUCA("Valle del Cauca"),
    VAUPES("Vaupes"),
    VICHADA("Vichada");

    private final String name;

    private Departments(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName();
    }
}
