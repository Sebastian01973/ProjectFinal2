package models;

public enum HealthCondition {
    ASYMPTOMATIC("Asymptomatic"),
    MILD("Mild"),
    MODERATE("Moderate"),
    SEVERE("Severe"),
    DECEASED("Decesed"),
    IMPORTED("Imported");
	
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
		// TODO Auto-generated method stub
		return getKey();
	}
	
	
}
