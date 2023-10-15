package ru.profile.model;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
public record UsersRequest(
        @NotNull
        String firstName,
        @NotNull
        String lastName,
        @NotNull
        @Min(1)
        int age
) {
}