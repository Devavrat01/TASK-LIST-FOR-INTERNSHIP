import java.sql.*;

public class EmployeeDaoImpl implements EmployeeDaoIntrf {
    Connection con;

    @Override
    public void createEmployee(Employee emp) {
        try {
            con = DBConnection.CreateDBConnection();
            String query = "INSERT INTO Employee1 VALUES(?,?,?,?)";
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1, emp.getId());
            pstm.setString(2, emp.getName());
            pstm.setDouble(3, emp.getSalary());
            pstm.setInt(4, emp.getAge());
            int cnt = pstm.executeUpdate();
            if (cnt != 0) {
                System.out.println("Employee Inserted Successfully!!!");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public void showAllEmployee() {
        String query = "SELECT * FROM Employee1";
        System.out.println("Employee Details:");
        System.out.println("---------------------------------------------");
        System.out.format("%s\t%s\t%s\t%s\n", "ID", "Name", "Salary", "Age");
        System.out.println("---------------------------------------------");

        try {
            con = DBConnection.CreateDBConnection();
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {
                System.out.format("%d\t%s\t%f\t%d\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getDouble(3),
                        result.getInt(4));
                System.out.println("---------------------------------------------");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showEmployeeBasedOnID(int id) {
        try {
            String query = "SELECT * FROM Employee1 WHERE id = ?";
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1, id);
            ResultSet result = pstm.executeQuery();
            while (result.next()) {
                System.out.format("%d\t%s\t%f\t%d\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getDouble(3),
                        result.getInt(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateEmployee(int id, String name) {
        String query = "UPDATE Employee1 SET name=? WHERE id=?";
        try {
            con = DBConnection.CreateDBConnection();
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1, name);
            pstm.setInt(2, id);
            int cnt = pstm.executeUpdate();
            if (cnt != 0) {
                System.out.println("Employee Details Updated Successfully");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
           e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployee(int id) {
        String query = "DELETE FROM Employee1 WHERE id=?";
        try {
            con = DBConnection.CreateDBConnection();
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1, id);
            int cnt = pstm.executeUpdate();
            if (cnt != 0) {
                System.out.println("Employee Deleted Successfully with ID " + id);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
