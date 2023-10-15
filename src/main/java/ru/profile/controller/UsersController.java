package ru.profile.controller;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.profile.model.Users;
import ru.profile.model.UsersRequest;
import ru.profile.service.UsersService;
import javax.validation.Valid;
@RestController
@RequestMapping(value = "/users")
public class UsersController {
    private final UsersService usersService;
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }
    @GetMapping(value = "/{personId:\\d+}")
    public Users getProfile(@PathVariable int personId) {
        return usersService.getProfile(personId);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProfile(@Valid @RequestBody UsersRequest request) {
        usersService.createProfile(
                request.firstName(),
                request.lastName(),
                request.age()
        );
    }
    @PutMapping(value = "/{personId:\\d+}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateProfile(
            @Valid @RequestBody UsersRequest request,
            @PathVariable int personId
    ) {
        usersService.updateProfile(
                request.firstName(),
                request.lastName(),
                request.age(),
                personId
        );
    }
    @DeleteMapping(value = "/{personId:\\d+}")
    public void deleteProfile(@PathVariable int personId) {
        usersService.deleteProfile(personId);
    }
}