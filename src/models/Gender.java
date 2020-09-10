package models;

public enum Gender {
	MALE('M'),FEMALE('F');
	
	private final char gendercharacter;
	
	private Gender(char gender) {
		this.gendercharacter = gender;
	}
	
	public char getGender() {
		return this.gendercharacter;
	}
}
