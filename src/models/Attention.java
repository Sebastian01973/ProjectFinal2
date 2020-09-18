package models;

public enum Attention {
	RECOVERED("Recovered"),
	HOUSE("House"),
	DECEASED("Deceased"),
	HOSPITAL("Hospital"),
	ICU_HOSPITAL("Icu_Hospital"),
	N_A("N_A");
	
	private final String key;

	private Attention(String key) {
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
