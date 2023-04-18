import java.sql.*;

public class Application {
    public static void main(String[] args) {
        stringEmployeeId(2);
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        Employee employee = new Employee("Vadim", "Sokolov", "male", 25, 3);
        System.out.println(employeeDAO.saveEmployee(employee));
        employeeDAO.employeeFromId(4);
        employeeDAO.allEmployee();
        employeeDAO.updateEmployee( employee, 10);
        employeeDAO.deleteEmployee(11);
    }
    private static String stringEmployeeId(int id) {
        String sql = "SELECT employee.first_name, employee.last_name, employee.gender, city.city_name" +
                " FROM employee" +
                " INNER JOIN city" +
                " ON employee.city_id = city.city_id" +
                " WHERE id = " + id;


        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                String firstName = resultSet.getString(1);
                String lastName = resultSet.getString(2);
                String gender = resultSet.getString(3);
                String cityName = resultSet.getString(4);
                System.out.printf("%s %s, %s, %s \n", firstName, lastName, gender, cityName);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    static Connection getConnection() {
        String url = "jdbc:postgresql://localhost:5432/skypro";
        String login = "postgres";
        String password = "123456qQ";
        try {
            return DriverManager.getConnection(url, login, password);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    }