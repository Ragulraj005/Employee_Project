package emapp;

public interface EmployeeDaoInterface {
	
	//create Employee
	public void createEmployee(Employee emp) ;
	//show all employee
	public void ShowAllEmployee();
	//show employee based on id
	public void showEmployeeBasedOnID(int id);
	//update employee
	public void UpdateEmployee(int id,String name) ;
	//delete employee
	public void deleteEmployee(int id);
}
