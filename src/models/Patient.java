package models;

public class Patient {

	private Departments dep;
	private Attention atention;
	private int age;
	private Gender gender;
	private HealthCondition healthCondition;

	public Patient(Departments location, Attention states, int age, Gender gender, HealthCondition healthCondition) {
		this.atention = states;
		this.age = age;
		this.gender = gender;
		this.healthCondition = healthCondition;
		this.dep = location;
	}

	public Attention getStates() {
		return atention;
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
	
	public Departments getLocation() {
		return this.dep;
	}
	public String getDepar(){
		return this.dep.getKeys();
	}
}
