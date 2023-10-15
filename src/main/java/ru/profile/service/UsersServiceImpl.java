package ru.profile.service;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ru.profile.exception.UsersNotFoundException;
import ru.profile.model.Users;
import ru.profile.repository.UsersRepository;
@Primary
@Service
public class UsersServiceImpl implements UsersService {
    private final UsersRepository usersRepository;
    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }
    @Override
    public Users getProfile(int personId) {
        return usersRepository.getProfileById(personId)
                .orElseThrow(() -> new UsersNotFoundException(personId));
    }
    @Override
    public void createProfile(String firstName, String secondName, int age) {
        usersRepository.insertProfile(firstName, secondName, age);
    }
    @Override
    public void updateProfile(String firstName, String secondName, int age, int id) {
        var profile = usersRepository.getProfileById(id)
                .orElseThrow(() -> new UsersNotFoundException(id));
        usersRepository.updateProfile(firstName, secondName, age, profile.id());
    }
    @Override
    public void deleteProfile(int id) {
        var profile = usersRepository.getProfileById(id)
                .orElseThrow(() -> new UsersNotFoundException(id));
        usersRepository.deleteProfileById(profile.id());
    }
}
