package models;

public enum Atention {
	RECOVERED("Recovered"),HOUSE("House"),DECEASED("Deceased"),
	HOSPITAL("Hospital"),ICU_HOSPITAL("Icu_Hospital");
	
	private final String key;

	private Atention(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}

	@Override
	public String toString() {
		return getKey();
	}
	
	
}
