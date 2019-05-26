package dao;

import pojo.City;

public interface CityDao {
    public boolean addCity(City city);

    public City getCityById(int id);

    public boolean updateCity(City city);

    public boolean deleteCityById(int id);

}
