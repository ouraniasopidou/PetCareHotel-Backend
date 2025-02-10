package gr.so.thepethotelapp.controller;

import gr.so.thepethotelapp.model.Pet;
import gr.so.thepethotelapp.service.PetService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pets")
@Tag(name = "Pets", description = "Operations related to pets")
public class PetController {

    private final PetService petService;

    @Autowired
    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping
    @Operation(summary = "Get all pets", description = "Retrieve all pets from the database")
    public List<Pet> getAllPets() {
        return petService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get pet by ID", description = "Retrieve a single pet by its unique ID")
    public Optional<Pet> getPetById(@PathVariable Long id) {
        return petService.findById(id);
    }

    @GetMapping("/user/{userId}")
    @Operation(summary = "Get pets by user ID", description = "Retrieve pets owned by a specific user")
    public List<Pet> getPetsByUserId(@PathVariable Long userId) {
        return petService.findByUserId(userId);
    }

    @PostMapping
    @Operation(summary = "Create a new pet", description = "Add a new pet to the database")
    public Pet createPet(@RequestBody Pet pet) {
        return petService.save(pet);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing pet", description = "Update the details of an existing pet by ID")
    public Pet updatePet(@PathVariable Long id, @RequestBody Pet updatedPet) {
        return petService.updatePet(id, updatedPet);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete pet by ID", description = "Remove a pet from the database by its ID")
    public void deletePet(@PathVariable Long id) {
        petService.deleteById(id);
    }
}
