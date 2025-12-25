package sms;

import java.time.LocalDate;

public class Person {
    private String name;
    private Gender gender;
    private String nationalId;
    private String birthDate;

    Person(String name, String gender, String nationalId, String birthDate) {
        this.name = name;
        this.gender = toGender(gender);
        this.nationalId = nationalId;
        this.birthDate = birthDate;
    }

    private Gender toGender(String gender) {
        if(gender.equalsIgnoreCase("Male")){
            return  Gender.MALE;
        } else {
            return Gender.FEMALE;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = toGender(gender);
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}
