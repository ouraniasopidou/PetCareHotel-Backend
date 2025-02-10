package gr.so.thepethotelapp.service;

import gr.so.thepethotelapp.model.Room;
import gr.so.thepethotelapp.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    public Optional<Room> findById(Long id) {
        return roomRepository.findById(id);
    }

    public Room findByRoomNumber(int roomNumber) {
        return roomRepository.findByRoomNumber(roomNumber);
    }

    public Room save(Room room) {
        return roomRepository.save(room);
    }

    public Room updateRoom(Long id, Room updatedRoom) {
        Optional<Room> existingRoom = roomRepository.findById(id);
        if (existingRoom.isPresent()) {
            Room room = existingRoom.get();
            room.setRoomNumber(updatedRoom.getRoomNumber());
            room.setAvailable(updatedRoom.isAvailable());
            room.setAnimalType(updatedRoom.getAnimalType());
            room.setPricePerDay(updatedRoom.getPricePerDay());
            room.setCreatedAt(updatedRoom.getCreatedAt());
            return roomRepository.save(room);
        } else {
            throw new RuntimeException("Room not found with ID: " + id);
        }
    }

    public void deleteById(Long id) {
        roomRepository.deleteById(id);
    }

    public void reserveRoom(Long id) {
        Room room = roomRepository.findById(id).orElseThrow(() -> new RuntimeException("Room not found"));
        if (room.isAvailable()) {
            room.setAvailable(false);
            roomRepository.save(room);
        } else {
            throw new RuntimeException("Room is already reserved");
        }
    }

}
