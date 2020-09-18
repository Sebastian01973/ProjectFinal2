package models;

public enum HealthCondition {
    ASYMPTOMATIC("Asymptomatic"),
    MILD("Mild"),
    MODERATE("Moderate"),
    SEVERE("Severe"),
	N_A("N_A"),
    DECEASED("Decesed");
	
	private final String key;
	
	private HealthCondition(String key) {
		this.key = key;
	}

	public HealthCondition getHealthCondition() {
		return this;
	}

	public String getKey() {
		return key;
	}

	@Override
	public String toString() {
		return getKey();
	}
}
