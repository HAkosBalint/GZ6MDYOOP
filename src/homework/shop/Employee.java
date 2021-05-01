package homework.shop;

import homework.tax.Taxable;

public class Employee implements Taxable {
	private String name;
	private int salary;
	private int tax;
	
	public Employee(String name, int salary) {
		this.name = name;
		this.salary = salary;
		this.tax = 15;
	}

	public String getName() {
		return name;
	}

	public int getSalary() {
		return salary;
	}
	
	@Override
	public void setTax(double tax) {
		this.tax = 15;
	}
	
	@Override
	public double getTax() {
		return salary * ((double)tax/ 100);
	}
	
	@Override
	public double getTaxedValue() {
		return salary - getTax();
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + ", tax=" + tax + "]";
	}	
}
