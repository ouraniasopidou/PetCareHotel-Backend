package gr.so.thepethotelapp.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users") // Σύνδεση με τον πίνακα "users" στη βάση
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Αυτόματη αύξηση του ID
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String phoneNumber;
}