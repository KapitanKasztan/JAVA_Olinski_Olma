package JAVA_Olinski_Olma.controller;

import JAVA_Olinski_Olma.model.Users;
import JAVA_Olinski_Olma.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Users", description = "Operacje na u?ytkownikach")
@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Operation(summary = "Retrieve all users")
    @GetMapping("/all")
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @Operation(summary = "Create a new user")
    @PostMapping("/create")
    public Users createUser(@RequestBody Users user) {
        return userRepository.save(user);
    }
}