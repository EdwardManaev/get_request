package ru.profile.repository;
import ru.profile.model.Users;
import java.util.Optional;
public interface UsersRepository {
    Optional<Users> getProfileById(int id);
    void insertProfile(String firstName, String secondName, int age);
    void updateProfile(String firstName, String secondName, int age, int id);
    void deleteProfileById(int id);
}