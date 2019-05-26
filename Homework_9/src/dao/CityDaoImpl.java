package dao;

import connectionManager.ConnectionManager;
import connectionManager.ConnectionManagerJdbcImpl;
import pojo.City;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CityDaoImpl implements CityDao {
    private static ConnectionManager connectionManager = ConnectionManagerJdbcImpl.getInstance();

    @Override
    public boolean addCity(City city) {
        Connection connection = connectionManager.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO cities VALUES (DEFAULT, ?, ?)");
        ) {
            statement.setString(1, city.getName());
            statement.setInt(2, city.getCitizens());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public City getCityById(int id) {
        Connection connection = connectionManager.getConnection();
        City city = null;
        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT * from cities WHERE id = ?");
        ) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    city = new City(resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getInt("citizens"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return city;
    }

    @Override
    public boolean updateCity(City city) {
        if (city.getId() != 0) {
            Connection connection = connectionManager.getConnection();
            try (PreparedStatement statement = connection.prepareStatement(
                    "UPDATE cities SET name=?, citizens=?");
            ) {
                statement.setString(1, city.getName());
                statement.setInt(2, city.getCitizens());
                statement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteCityById(int id) {
        Connection connection = connectionManager.getConnection();
        City city = null;
        try (PreparedStatement statement = connection.prepareStatement(
                "DELETE FROM cities WHERE id=?");
        ) {
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
