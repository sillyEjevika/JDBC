import java.sql.*;

public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public Employee saveEmployee(Employee employee) {
        try (PreparedStatement statement = Application.getConnection().prepareStatement(
                "INSERT INTO employee (first_name, last_name, gender, age, city_id) " +
                        "VALUES ((?), (?), (?), (?), (?))")) {
            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getLastName());
            statement.setString(3, employee.getGender());
            statement.setInt(4, employee.getAge());
            statement.setInt(5, employee.getCityId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public int employeeFromId(int id) {
        try (PreparedStatement statement = Application.getConnection().prepareStatement(
                " SELECT * FROM employee WHERE id = (?)")) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String firtsName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                String gender = resultSet.getString(4);
                int age = resultSet.getInt(5);
                int cityId = resultSet.getInt(6);
                System.out.printf("%s. %s %s, %s, %d, %d \n", id, firtsName, lastName, gender, age, cityId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int allEmployee() {
        try (PreparedStatement statement = Application.getConnection().prepareStatement(
                "SELECT * FROM employee")) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String firtsName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                String gender = resultSet.getString(4);
                int age = resultSet.getInt(5);
                int cityId = resultSet.getInt(6);
                System.out.printf("%s %s, %s, %d, %d \n", firtsName, lastName, gender, age, cityId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public Employee updateEmployee(Employee employee, int id) {
        try (PreparedStatement statement = Application.getConnection().prepareStatement(
                "UPDATE employee SET first_name = (?), last_name = (?)," +
                        " gender = (?), age = (?), city_id = (?)" +
                        "WHERE id = (?)")) {
                 statement.setString(1, employee.getFirstName());
                 statement.setString(2, employee.getLastName());
                 statement.setString(3, employee.getGender());
                 statement.setInt(4, employee.getAge());
                 statement.setInt(5, employee.getCityId());
                 statement.setInt(6, id);
                 statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public int deleteEmployee(int id) {
        try (PreparedStatement statement = Application.getConnection().prepareStatement(
                "DELETE FROM employee WHERE id = (?)")){
        statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

}