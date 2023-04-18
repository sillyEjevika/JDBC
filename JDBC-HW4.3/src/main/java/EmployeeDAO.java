public interface EmployeeDAO {

    Employee saveEmployee(Employee employee);
    int employeeFromId(int id);
    int allEmployee();
    Employee updateEmployee(Employee employee, int id);

    int deleteEmployee(int id);

}
