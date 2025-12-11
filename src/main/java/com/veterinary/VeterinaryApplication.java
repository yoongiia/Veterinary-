package com.veterinary;

import com.opencsv.CSVReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class VeterinaryApplication implements CommandLineRunner {

    @Autowired
    private PetRecordRepository petRecordRepository;

    public static void main(String[] args) {
        SpringApplication.run(VeterinaryApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- ВЕТЕРИНАРНА КЛІНІКА ---");
            System.out.println("1. Завантажити дані з CSV файлу");
            System.out.println("2. Переглянути всі записи");
            System.out.println("3. Видалити всі записи");
            System.out.println("4. Вихід");
            System.out.print("Ваш вибір: ");

            String choice = scanner.next();

            switch (choice) {
                case "1":
                    addRecordsFromCsv();
                    break;
                case "2":
                    viewAllRecords();
                    break;
                case "3":
                    dropAllRecords();
                    break;
                case "4":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Невідома команда.");
            }
        }
    }

    private void addRecordsFromCsv() {
        // Файл має називатися точно як тут (перевірте папку resources!)
        try (CSVReader reader = new CSVReader(new InputStreamReader(
                getClass().getClassLoader().getResourceAsStream("veterinary_data.csv")))) {
            
            List<String[]> rows = reader.readAll();
            
            if (rows.isEmpty()) {
                System.out.println("CSV файл порожній.");
                return;
            }

            rows.remove(0); // Видаляємо перший рядок (заголовки)

            List<PetRecord> records = new ArrayList<>();
            for (String[] row : rows) {
                // Створюємо об'єкт, передаючи 10 значень з CSV
                PetRecord record = new PetRecord(
                        row[0], // animalOwner
                        row[1], // animalAndSpecies
                        row[2], // veterinarian
                        row[3], // dateOfAdmission
                        row[4], // receptionHours
                        row[5], // diagnosisAndTreatment
                        row[6], // addressOwner
                        row[7], // vaccination
                        row[8], // veterinaryExperience
                        row[9]  // contacts
                );
                records.add(record);
            }
            
            petRecordRepository.saveAll(records);
            System.out.println("Успішно додано " + records.size() + " записів до бази MongoDB.");
            
        } catch (Exception e) {
            System.out.println("Помилка при читанні CSV файлу: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void viewAllRecords() {
        List<PetRecord> records = petRecordRepository.findAll();
        if (records.isEmpty()) {
            System.out.println("База даних порожня.");
        } else {
            records.forEach(System.out::println);
        }
    }

    private void dropAllRecords() {
        petRecordRepository.deleteAll();
        System.out.println("Всі записи видалено.");
    }
}