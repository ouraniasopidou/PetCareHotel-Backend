package gr.so.thepethotelapp.service;

import gr.so.thepethotelapp.model.Pet;
import gr.so.thepethotelapp.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    private final PetRepository petRepository;

    @Autowired
    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public List<Pet> findAll() {
        return petRepository.findAll();
    }

    public Optional<Pet> findById(Long id) {
        return petRepository.findById(id);
    }

    public List<Pet> findByUserId(Long userId) {
        return petRepository.findByUserId(userId);
    }

    public Pet save(Pet pet) {
        return petRepository.save(pet);
    }

    public Pet updatePet(Long id, Pet updatedPet) {
        Optional<Pet> existingPet = petRepository.findById(id);
        if (existingPet.isPresent()) {
            Pet pet = existingPet.get();
            pet.setName(updatedPet.getName());
            pet.setType(updatedPet.getType());
            pet.setBreed(updatedPet.getBreed());
            pet.setAge(updatedPet.getAge());
            pet.setOwnerName(updatedPet.getOwnerName());
            pet.setUserId(updatedPet.getUserId());
            return petRepository.save(pet);
        } else {
            throw new RuntimeException("Pet not found with ID: " + id);
        }
    }

    public void deleteById(Long id) {
        petRepository.deleteById(id);
    }
}
