package emapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeDaoImp implements EmployeeDaoInterface {

	private PreparedStatement pstmt;

	@Override
	public void createEmployee(Employee emp) {
		try {
			Connection con = DBConnection.createDBConnection();
			String query = "insert into employee values(?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, emp.getId());
			pstmt.setInt(2, emp.getAge());
			pstmt.setString(3, emp.getName());
			pstmt.setDouble(4, emp.getSalary());
			int cnt = pstmt.executeUpdate();
			if (cnt != 0) {
				System.out.println("Employement added successfully");
			}

		} catch (SQLException e) {

			e.printStackTrace();
			System.out.println("Exception in insertion");
		}

	}

	public void ShowAllEmployee() {
		try {
			Connection con = DBConnection.createDBConnection();
			String query = "select * from employee";

			System.out.println("Employee details :");
			System.out.println("-----------------------------");
			System.out.format("%s\t%s\t%s\t%s\n", "Id", "Age", "Name", "Salary");
			System.out.println("-----------------------------");
			Statement stmt = con.createStatement();
			ResultSet result = stmt.executeQuery(query);
			while (result.next()) {
				System.out.format("%d\t%d\t%s\t%f\n", result.getInt(1), result.getInt(2), result.getString(3),
						result.getDouble(4));

				System.out.println();

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void showEmployeeBasedOnID(int id) {
		try {
			Connection con = DBConnection.createDBConnection();
			String query = "select * from employee where Id =" + id;

			System.out.println("Employee details :");
			System.out.println("-----------------------------");
			System.out.format("%s\t%s\t%s\t%s\n", "Id", "Age", "Name", "Salary");
			System.out.println("-----------------------------");
			Statement stmt = con.createStatement();
			ResultSet result = stmt.executeQuery(query);
			while (result.next()) {
				System.out.format("%d\t%d\t%s\t%f\n", result.getInt(1), result.getInt(2), result.getString(3),
						result.getDouble(4));

				System.out.println();

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void UpdateEmployee(int id, String name) {
		try {
			Connection con = DBConnection.createDBConnection();
			String query = "update employee set Name = ? where Id =?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setInt(2, id);
			int cnt = pstmt.executeUpdate();
			if (cnt != 0) {
				System.out.println("Employement details updated successfully");
			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

	}

	public void deleteEmployee(int id) {
		try {
			Connection con = DBConnection.createDBConnection();
			String query = "DELETE FROM employee WHERE Id=?";
			PreparedStatement pstmt = con.prepareStatement(query);

			pstmt.setInt(1, id);
			int cnt = pstmt.executeUpdate();
			if (cnt != 0) {
				System.out.println("Employee detail deleted successfully");
			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

	}

}
