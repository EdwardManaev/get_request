package ru.profile.exception;
public class UsersNotFoundException extends RuntimeException {
    private final int personId;
    public UsersNotFoundException(int personId) {
        this.personId = personId;
    }
    @Override
    public String getMessage() {
        return "Profile with id = " + personId + " not found";
    }
}
