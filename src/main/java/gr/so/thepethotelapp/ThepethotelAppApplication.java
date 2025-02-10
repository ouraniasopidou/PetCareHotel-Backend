package gr.so.thepethotelapp;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ThepethotelAppApplication {

    public static void main(String[] args) {
        // Φόρτωση μεταβλητών από το .env
        Dotenv dotenv = Dotenv.load();
        System.setProperty("DB_USER", dotenv.get("DB_USER"));
        System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));

        // Εκκίνηση της εφαρμογής Spring Boot
        SpringApplication.run(ThepethotelAppApplication.class, args);
    }
}
