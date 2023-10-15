package ru.profile.repository;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.profile.mapper.UsersMapper;
import ru.profile.model.Users;
import java.util.Optional;
@Repository
public class UsersRepositoryImpl implements UsersRepository {
    private static final String SQL_GET_PROFILE_BY_ID =
            "select id, first_name, last_name, age from profile where id = :id";
    private static final String SQL_INSERT_PROFILE =
            "insert into profile (first_name, last_name, age) values (:firstName, :lastName, :age)";
    private static final String SQL_UPDATE_PROFILE =
            "update profile set first_name = :firstName, last_name = :lastName, age = :age where id = :id";
    private static final String SQL_DELETE_PROFILE = "delete from profile where id = :id";
    private final UsersMapper usersMapper;
    private final NamedParameterJdbcTemplate jdbcTemplate;
    public UsersRepositoryImpl(
            UsersMapper usersMapper,
            NamedParameterJdbcTemplate jdbcTemplate
    ) {
        this.usersMapper = usersMapper;
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public Optional<Users> getProfileById(int id) {
        var params = new MapSqlParameterSource();
        params.addValue("id", id);
        return jdbcTemplate.query(
                        SQL_GET_PROFILE_BY_ID,
                        params,
                        usersMapper
                ).stream()
                .findFirst();
    }
    @Override
    public void insertProfile(String firstName, String lastName, int age) {
        var params = new MapSqlParameterSource();
        params.addValue("firstName", firstName);
        params.addValue("lastName", lastName);
        params.addValue("age", age);
        jdbcTemplate.update(SQL_INSERT_PROFILE, params);
    }

    @Override
    public void updateProfile(String firstName, String lastName, int age, int id) {
        var params = new MapSqlParameterSource();
        params.addValue("firstName", firstName);
        params.addValue("lastName", lastName);
        params.addValue("age", age);
        params.addValue("id", id);
        jdbcTemplate.update(SQL_UPDATE_PROFILE, params);
    }
    @Override
    public void deleteProfileById(int id) {
        var params = new MapSqlParameterSource();
        params.addValue("id", id);
        jdbcTemplate.update(SQL_DELETE_PROFILE, params);
    }
}