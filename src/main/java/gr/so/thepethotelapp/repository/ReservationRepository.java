package gr.so.thepethotelapp.repository;

import gr.so.thepethotelapp.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    // Custom query για να βρεις κρατήσεις ενός συγκεκριμένου χρήστη
    List<Reservation> findByUserId(Long userId);

    // Custom query για να βρεις κρατήσεις σε συγκεκριμένο δωμάτιο
    List<Reservation> findByRoomId(Long roomId);
}
