package gr.so.thepethotelapp.controller;

import gr.so.thepethotelapp.model.Reservation;
import gr.so.thepethotelapp.service.ReservationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservations")
@Tag(name = "Reservations", description = "Operations related to Reservations")
public class ReservationController {

    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    @Operation(summary = "Get all reservations", description = "Retrieve all reservations from the database")
    public List<Reservation> getAllReservations() {
        return reservationService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get reservation by ID", description = "Retrieve a single reservation by its unique ID")
    public Optional<Reservation> getReservationById(@PathVariable Long id) {
        return reservationService.findById(id);
    }

    @GetMapping("/user/{userId}")
    @Operation(summary = "Get reservations by User ID", description = "Retrieve all reservations for a specific user")
    public List<Reservation> getReservationsByUserId(@PathVariable Long userId) {
        return reservationService.findByUserId(userId);
    }

    @GetMapping("/room/{roomId}")
    @Operation(summary = "Get reservations by Room ID", description = "Retrieve all reservations for a specific room")
    public List<Reservation> getReservationsByRoomId(@PathVariable Long roomId) {
        return reservationService.findByRoomId(roomId);
    }

    @PostMapping
    @Operation(summary = "Create a new reservation", description = "Add a new reservation to the database")
    public Reservation createReservation(@RequestBody Reservation reservation) {
        return reservationService.save(reservation);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a reservation", description = "Remove a reservation from the database by its ID")
    public void deleteReservation(@PathVariable Long id) {
        reservationService.deleteById(id);
    }
}
