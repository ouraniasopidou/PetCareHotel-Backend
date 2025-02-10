package gr.so.thepethotelapp.repository;

import gr.so.thepethotelapp.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    Room findByRoomNumber(int roomNumber);
}
