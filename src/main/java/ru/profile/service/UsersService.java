package ru.profile.service;
import ru.profile.model.Users;
public interface UsersService {
    Users getProfile(int personId);
    void createProfile(String firstName, String secondName, int age);
    void updateProfile(String firstName, String secondName, int age, int id);

    void deleteProfile(int id);
}