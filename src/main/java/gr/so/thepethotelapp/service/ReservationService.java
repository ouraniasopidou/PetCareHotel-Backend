package gr.so.thepethotelapp.service;

import gr.so.thepethotelapp.model.Reservation;
import gr.so.thepethotelapp.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    // Μέθοδος για να πάρεις όλες τις κρατήσεις
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    // Μέθοδος για να βρεις κράτηση με βάση το ID
    public Optional<Reservation> findById(Long id) {
        return reservationRepository.findById(id);
    }

    // Μέθοδος για να βρεις κρατήσεις με βάση τον χρήστη
    public List<Reservation> findByUserId(Long userId) {
        return reservationRepository.findByUserId(userId);
    }

    // Μέθοδος για να βρεις κρατήσεις με βάση το δωμάτιο
    public List<Reservation> findByRoomId(Long roomId) {
        return reservationRepository.findByRoomId(roomId);
    }

    // Μέθοδος για να δημιουργήσεις μια νέα κράτηση
    public Reservation save(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    // Μέθοδος για να διαγράψεις κράτηση με βάση το ID
    public void deleteById(Long id) {
        reservationRepository.deleteById(id);
    }
}
