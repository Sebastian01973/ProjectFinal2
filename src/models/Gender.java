package models;

public enum Gender {
	MALE("M"),
	FEMALE("F");
	
	private final String gendercharacter;
	
	private Gender(String gender) {
		this.gendercharacter = gender;
	}
	
	public String getGender(){
		return this.gendercharacter;
	}

	@Override
	public String toString() {
		return getGender();
	}
}
