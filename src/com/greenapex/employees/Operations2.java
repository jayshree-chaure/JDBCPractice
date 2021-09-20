package com.greenapex.employees;
import java.sql.*;
import java.util.*;

//import com.mysql.cj.util.StringUtils;

public class Operations2 {

	public static void main(String[] args) 
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels","root","root1234@");
			Scanner scanner = new Scanner(System.in);
			Operations2 c = new Operations2();
			int ch;
			
				System.out.println("Enter your choice \n");
				System.out.println("1.Add a Employee \n2.Delete a Employee"
						+  "\n3.View all Employees \n4.Update details of employee \n5.View specific Employee"
						+ "\n6.Exit");
				ch = scanner.nextInt();
			

			switch(ch)
			{
			case 1:
				c.addEmp(scanner, con);
				break;
			case 2:
				c.deleteEmp(scanner, con);
				break;
			case 3:
				c.viewAllEmp(con);
				break;
			case 4:
				c.updateEmpDetails(scanner, con);
				break;
			case 5:
				c.viewEmp(scanner, con);
				break;
			case 6: 
				 System.out.println("Exit"); 
				 System.exit(1);
			default: System.out.println("Please press 1 to 6"); 
			break;

			}
			con.close();
		}	
		catch(Exception e){
			System.out.println(e);
		}
	}

	private void viewEmp(Scanner scanner, Connection con) {

		System.out.println("Enter Employee number: ");
		int empNo = scanner.nextInt();
		try {
			PreparedStatement prp = con.prepareStatement("select * from employees where employeeNumber ="+empNo);
			ResultSet rs = prp.executeQuery();

			if(rs != null)
			{
				while(rs.next())
				{
					Emp emp = new Emp();
					emp.setEmployeeNumber(rs.getInt(1));
					emp.setLastName(rs.getString(2));
					emp.setFirstName(rs.getString(3));
					emp.setExtension(rs.getString(4));
					emp.setEmail(rs.getString(5));
					emp.setOfficeCode(rs.getInt(6));
					emp.setReportsTo(rs.getInt(7));
					emp.setJobTitle(rs.getString(8));
					System.out.println(emp);
				}
			}
			else
			{
				System.out.println("Employee not exist");
			}
		}
		catch (SQLException e1) 
		{
			e1.printStackTrace();
		}
	}




	private void updateEmpDetails(Scanner scanner, Connection con) 
	{
		System.out.println("Enter Employee number: ");
		int empNo = scanner.nextInt();
		System.out.println("Enter the fieldname to be updated: ");
		System.out.println("1. Employee LastName \n2. FirstName \n3. Extension \n4. Email  \n5. JobTitle");
		System.out.println("Please enter your choice : ");
		int ch = scanner.nextInt();
		System.out.println("Enter the value : ");
		String chAns = scanner.next();
		PreparedStatement prp;
		try {
			prp = con.prepareStatement("select * from Employees where employeeNumber = '"+empNo+"'");
			ResultSet rs = prp.executeQuery();
			if(rs != null && rs.next())
			{
				if(ch == 1)
				{
					prp = con.prepareStatement("update employees set lastName = '"+chAns+"' where employeeNumber = '"+empNo+"'");
					prp.executeUpdate();
					System.out.print("Success!");
				}
				else if(ch == 2)
				{
					prp = con.prepareStatement("update employees set firstName = '"+chAns+"' where employeeNumber = '"+empNo+"'");
					prp.executeUpdate();
					System.out.print("Success!");
				}
				else if(ch == 3)
				{
					prp = con.prepareStatement("update employees set extension = '"+chAns+"' where employeeNumber = '"+empNo+"'");
					prp.executeUpdate();
					System.out.print("Success!");
				}
				else if(ch == 4)
				{
					prp = con.prepareStatement("update employees set email= '"+chAns+"' where employeeNumber = '"+empNo+"'");
					prp.executeUpdate();
					System.out.print("Success!");
				}
				else if(ch == 5)
				{
					prp = con.prepareStatement("update employees set jobTitle = '"+chAns+"' where employeeNumber = '"+empNo+"'");
					prp.executeUpdate();
					System.out.print("Success!");
				}
			}
			else
			{
				System.out.println("Employee not exist");
			}	
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

	private void viewAllEmp(Connection con) 
	{
		ResultSet rs;
		try {
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery("select * from employees");
			while(rs.next())
			{

				System.out.println(rs.getInt(1)+"    "+rs.getString(2)+"   "
						+rs.getString(3)+"  "+rs.getString(4)+"   "+rs.getString(5)+"  "+rs.getString(6)+"   "
						+rs.getString(7)+"   "+rs.getString(8) );

			}
		}
		catch (SQLException e1) 
		{
			e1.printStackTrace();
		}
	}

	private void deleteEmp(Scanner scanner, Connection con) 
	{
		Emp c = new Emp();
		System.out.println("Enter the Employee number to delete : ");
		int empNo = scanner.nextInt();

		try {
			PreparedStatement prp = con.prepareStatement("select * from employees where employeeNumber ="+empNo);
			ResultSet rs = prp.executeQuery();

			if(rs != null)
			{
				prp = con.prepareStatement("delete from employees where employeeNumber = '"+empNo+"'");
				prp.executeUpdate();
				System.out.println("Employee successfully deleted");
			}
			else
			{
				System.out.println("Employee not exist");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void addEmp(Scanner scanner, Connection con) 
	{
		Emp c = new Emp();
		System.out.println("enter emp no");
		c.setEmployeeNumber(scanner.nextInt());
		System.out.println("Enter the First name of the employee: ");
		c.setFirstName(scanner.next());
		System.out.println("Enter the Last name of the employee: ");
		c.setLastName(scanner.next());
		System.out.println("Enter extension: ");
		c.setExtension(scanner.next());
		System.out.println("Enter email of employee: ");
		c.setEmail(scanner.next());
		c.setOfficeCode(1);
		c.setReportsTo(1002);
		System.out.println("Enter Job Title: ");
		c.setJobTitle(scanner.next());
		try {
			PreparedStatement prp = con.prepareStatement("insert into employees values(?,?,?,?,?,?,?,?)");
			prp.setInt(1,c.getEmployeeNumber());
			prp.setString(2,c. getLastName());
			prp.setString(3,c. getFirstName());
			prp.setString(4, c.getExtension());
			prp.setString(5,c. getEmail());		
			prp.setInt(6,c.getOfficeCode());
			prp.setLong(7, c.getReportsTo());
			prp.setString(8, c.getJobTitle());
			prp.executeUpdate();
			System.out.println("successfully added");

		} catch (SQLException e) 
		{
			System.err.println("SQLException Catched");
		}
	}
}
