package am.itspace.hibernatesearchexample.controller;

import am.itspace.hibernatesearchexample.model.User;
import am.itspace.hibernatesearchexample.repository.UserRepository;
import am.itspace.hibernatesearchexample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsersController {

    private final UserService userService;
    private  final UserRepository userRepository;

    @Autowired
    public UsersController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping("/usersByName")
    public List<User> getUsersByName(@RequestParam(name = "name") String name){
        userRepository.findAll();

        return userService.searchUserByName(name);
    }

    @GetMapping("/usersBySurname")
    public List<User> getUsersBySurname(@RequestParam(name = "surname") String surname){
        return userService.searchUserBySurname(surname
        );
    }

    @GetMapping("/usersByCharacteristic")
    public List<User> getUsersByCharacteristic(@RequestParam(name = "characteristic") String characteristic){
        return userService.searchUserByCharacteristics(characteristic);
    }

    @GetMapping("/usersByAgeRange")
    public List<User> getUsersByAgeRange(@RequestParam(name = "fromAge") int fromAge,@RequestParam(name = "toAge") int toAge){
        return userService.searchUserByAge(fromAge,toAge);
    }
}
