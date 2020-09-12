package models;

public class Patient {

	private String location;
	private Attention atention;
	private byte age;
	private Gender gender;
	private HealthCondition healthCondition;

	public Patient(String location, Attention states, byte age, Gender gender, HealthCondition healthCondition) {
		this.atention = states;
		this.age = age;
		this.gender = gender;
		this.healthCondition = healthCondition;
		this.location = location;
	}

	public Attention getStates() {
		return atention;
	}

	public void setStates(Attention states) {
		this.atention = states;
	}

	public byte getAge() {
		return age;
	}

	public Gender getGender() {
		return gender;
	}

	public HealthCondition getHealthCondition() {
		return healthCondition;
	}

	public void setHealthCondition(HealthCondition healthCondition) {
		this.healthCondition = healthCondition;
	}
	
	public String getLocation() {
		return this.location;
	}
}
