package models;

public class Patient {

	private Departments location;
	private Attention atention;
	private int age;
	private Gender gender;
	private HealthCondition healthCondition;

	public Patient(Departments location, Attention states, int age, Gender gender, HealthCondition healthCondition) {
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

	public int getAge() {
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
	
	public Departments getLocation() {
		return this.location;
	}
}
