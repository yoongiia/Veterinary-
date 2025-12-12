package com.veterinary;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "veterinary-records") 
public class PetRecord {

    @Id
    private String id;

    private String animalOwner;
    private String animalAndSpecies;
    private String veterinarian;
    private String dateOfAdmission;
    private String receptionHours;
    private String diagnosisAndTreatment;
    private String addressOwner;
    private String vaccination;
    private String veterinaryExperience;
    private String contacts;

    public PetRecord() {
    }

    public PetRecord(String animalOwner, String animalAndSpecies, String veterinarian, 
                     String dateOfAdmission, String receptionHours, String diagnosisAndTreatment, 
                     String addressOwner, String vaccination, String veterinaryExperience, String contacts) {
        this.animalOwner = animalOwner;
        this.animalAndSpecies = animalAndSpecies;
        this.veterinarian = veterinarian;
        this.dateOfAdmission = dateOfAdmission;
        this.receptionHours = receptionHours;
        this.diagnosisAndTreatment = diagnosisAndTreatment;
        this.addressOwner = addressOwner;
        this.vaccination = vaccination;
        this.veterinaryExperience = veterinaryExperience;
        this.contacts = contacts;
    }

    @Override
    public String toString() {
    return "Запис візиту {\n" + 
           "id=\"" + id + "\"\n" +
           "Власник=\"" + animalOwner + "\"\n" +
           "Тварина=\"" + animalAndSpecies + "\"\n" +
           "Лікар=\"" + veterinarian + "\"\n" +
           "Дата=\"" + dateOfAdmission + "\"\n" +
           "Час=\"" + receptionHours + "\"\n" +
           "Діагноз=\"" + diagnosisAndTreatment + "\"\n" +
           "Адреса=\"" + addressOwner + "\"\n" +
           "Вакцинація=\"" + vaccination + "\"\n" +
           "Стаж лікаря=\"" + veterinaryExperience + "\"\n" +
           "Контакти=\"" + contacts + "\"\n" +
           "}"; 
}
    }
