package com.greenapex.employees;


public class Emp
{
	private Integer EmployeeNumber;
	private String LastName;
	private String FirstName;
	private String extension;
	private String email;
	private Integer officeCode;
	private Integer reportsTo;
	private String jobTitle;

	public Integer getEmployeeNumber() {
		return EmployeeNumber;
	}

	public void setEmployeeNumber(Integer employeeNumber) {
		EmployeeNumber = employeeNumber;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getOfficeCode() {
		return officeCode;
	}

	public void setOfficeCode(Integer officeCode) {
		this.officeCode = officeCode;
	}

	public Integer getReportsTo() {
		return reportsTo;
	}

	public void setReportsTo(Integer reportsTo) {
		this.reportsTo = reportsTo;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	
	

	@Override
	public String toString() {
		return "Emp [EmployeeNumber=" + EmployeeNumber + ", LastName=" + LastName + ", FirstName=" + FirstName
				+ ", extension=" + extension + ", email=" + email + ", officeCode=" + officeCode + ", reportsTo="
				+ reportsTo + ", jobTitle=" + jobTitle +"]"; }
	
}
