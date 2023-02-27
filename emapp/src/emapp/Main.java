package emapp;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		String name;
		int id;
		EmployeeDaoInterface detail = new EmployeeDaoImp();
		System.out.println("Welcome to Employee management applications");
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("1 -Add Employee\n" + "2 -Show All Employee\n" + "3 -Show Employee based on id \n"
					+ "4 -Update the employee\n" + "5 -Delete the Emplyee\n");
			System.out.println("Enter the choice :");
			int ch = sc.nextInt();
			switch (ch) {
			case 1:
				Employee emp = new Employee();
				System.out.println("Enter Id :");
				id = sc.nextInt();
				System.out.println("Enter your Age :");
				int age = sc.nextInt();
				System.out.println("Enter your Name :");
				name = sc.next();
				System.out.println("Enter your salary :");
				Double salary = sc.nextDouble();

				emp.setId(id);
				emp.setAge(age);
				emp.setName(name);
				emp.setSalary(age);
				detail.createEmployee(emp);
				break;
			case 2:
				detail.ShowAllEmployee();
				break;
			case 3:
				System.out.println("Enter the ID");
				int empid = sc.nextInt();
				detail.showEmployeeBasedOnID(empid);
				break;
			case 4:
				System.out.println("Enter the Id to update the name");
				int empid1 = sc.nextInt();
				System.out.println("Enter the new name");
				name = sc.next();
				detail.UpdateEmployee(empid1, name);
				break;
			case 5 :
				System.out.println("Enter the Id to delete");
				id = sc.nextInt();
				detail.deleteEmployee(id);
				break;

			case 6:
				System.out.println("Thank you for using our application !");
				System.exit(0);
			default:
				System.out.println("Enter the valid value");

			}
		} while (true);
	}

}
