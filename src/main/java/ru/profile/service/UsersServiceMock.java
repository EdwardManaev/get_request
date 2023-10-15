package ru.profile.service;
import org.springframework.stereotype.Service;
import ru.profile.exception.UsersNotFoundException;
import ru.profile.model.Users;
 @Service
public class UsersServiceMock implements UsersService {
   @Override
    public Users getProfile(int personId) {
        // имитируем обращение к БД
        if (personId == 123) {
            return new Users(
                    personId,
                    "Станислав",
                    "Васильев",
                    17
            );
        } else {
            throw new UsersNotFoundException(personId);
        }
    }
    @Override
    public void createProfile(String firstName, String secondName, int age) {
    }
    @Override
    public void updateProfile(String firstName, String secondName, int age, int id) {
    }
    @Override
    public void deleteProfile(int id) {
    }
}