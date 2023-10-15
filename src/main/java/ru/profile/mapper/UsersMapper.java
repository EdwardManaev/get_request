package ru.profile.mapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.profile.model.Users;

import java.sql.ResultSet;
import java.sql.SQLException;
@Component
public class UsersMapper implements RowMapper<Users> {
    @Override
    public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Users(
                rs.getInt("id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getInt("age")
        );
    }
}