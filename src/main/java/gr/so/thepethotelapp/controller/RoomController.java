package gr.so.thepethotelapp.controller;

import gr.so.thepethotelapp.model.Room;
import gr.so.thepethotelapp.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    // Endpoint για να επιστρέφει όλα τα δωμάτια
    @GetMapping
    public List<Room> getAllRooms() {
        return roomService.findAll();
    }

    // Endpoint για να επιστρέφει συγκεκριμένο δωμάτιο με βάση το ID
    @GetMapping("/{id}")
    public Room getRoomById(@PathVariable Long id) {
        return roomService.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found with ID: " + id));
    }

    @PostMapping("/{id}/reserve")
    public ResponseEntity<String> reserveRoom(@PathVariable Long id) {
        roomService.reserveRoom(id);
        return ResponseEntity.ok("Room reserved successfully");
    }

}
