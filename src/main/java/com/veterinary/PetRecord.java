package com.veterinary;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/* Клас-сутність для MongoDB.
   Поля відповідають колонкам у вашому CSV файлі.
*/
@Document(collection = "veterinary-records") // Перевірте назву колекції в Compass!
public class PetRecord {

    @Id
    private String id;

    // 10 полів з вашого CSV
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

    // Конструктор з 10 параметрами
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
