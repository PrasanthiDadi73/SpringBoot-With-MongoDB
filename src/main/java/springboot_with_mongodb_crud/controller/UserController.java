package springboot_with_mongodb_crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springboot_with_mongodb_crud.entity.User;
import springboot_with_mongodb_crud.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/getAllUsers")
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @PostMapping("/addUsers")
    public void insertUsers(@RequestBody User users){
        userRepository.save(users);
    }

    @DeleteMapping("/deleteUserById/{id}")
        public String deleteUser(@PathVariable int id){
           userRepository.deleteById(id);
           return "User deleted Successfully";
        }

    @PutMapping("/updateUserById/{id}")
    public User updateUser(@RequestBody User user, @PathVariable int id) {
        int userId = user.getId();
        if (userId != id) {
            System.out.println("No such id present");
        }
        else
          return userRepository.save(user);
        return user;
    }
}
