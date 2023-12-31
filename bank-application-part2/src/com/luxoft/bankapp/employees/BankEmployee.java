//package com.luxoft.bankapp.employees;
//
//import com.luxoft.bankapp.domain.Department;
//
//public class BankEmployee {
//
//	public String name;
//	public Department department;
//	public int salary;
//
//	public BankEmployee() {
//
//	}
//
//	public BankEmployee(String name, Department department, int salary) {
//		this.name = name;
//		this.department = department;
//		this.salary = salary;
//	}
//
//	public Department getDepartment() {
//		return department;
//	}
//
//}


//exercise 3

package com.luxoft.bankapp.employees;

import com.luxoft.bankapp.domain.Department;

public class BankEmployee {

	public String name;
	public Department department;
	public int salary;

	public BankEmployee() {
	}

	public BankEmployee(String name, Department department, int salary) {
		this.name = name;
		this.department = department;
		this.salary = salary;
	}

	public Department getDepartment() {
		return department;
	}

	public interface Specialist {
		boolean makeDecision(double amount, double creditRate, double clientSalary, boolean propertyGuarantee);
	}

	public static abstract class AbstractSpecialist implements Specialist {

		private static final double OTHER_COMISSION = 0.005;
		private static final double PROPERTY_GUARANTEE_COMISSION = 0.002;
		// next element in the chain of responsibility
		protected AbstractSpecialist nextSpecialist;

		public void setNextSpecialist(AbstractSpecialist nextSpecialist) {
			this.nextSpecialist = nextSpecialist;
		}

		public void printFinalDecision(boolean decision) {
			if (decision) {
				System.out.format("Final approval at the %s level%n", this.getClass().getSimpleName());
			} else {
				System.out.format("Rejected at the %s level%n", this.getClass().getSimpleName());
			}
		}

		public static double calculateAnalysisComission(double amount, boolean propertyGuarantee) {
			double comission;
			if (propertyGuarantee) {
				comission = amount * PROPERTY_GUARANTEE_COMISSION;
			} else {
				comission = amount * OTHER_COMISSION;
			}
			return comission;
		}

		abstract public boolean makeDecision(double amount, double creditRate, double clientSalary, boolean propertyGuarantee);
	}

	public static class FinancialSpecialist extends AbstractSpecialist {

		@Override
		public boolean makeDecision(double amount, double creditRate, double clientSalary, boolean propertyGuarantee) {
			boolean decision = false;
			if (creditRate <= clientSalary / 3) {
				decision = true;
			}

			if (null != this.nextSpecialist && decision) {
				System.out.format("Approved at the %s level, passing to the next specialist%n", this.getClass().getSimpleName());
				return this.nextSpecialist.makeDecision(amount, creditRate, clientSalary, propertyGuarantee);
			}

			printFinalDecision(decision);

			return decision;
		}
	}

	public static class HousingPropertySpecialist extends AbstractSpecialist {

		@Override
		public boolean makeDecision(double amount, double creditRate, double clientSalary, boolean propertyGuarantee) {
			if (null != this.nextSpecialist && propertyGuarantee) {
				System.out.format("Approved at the %s level, passing to the next specialist%n", this.getClass().getSimpleName());
				return this.nextSpecialist.makeDecision(amount, creditRate, clientSalary, propertyGuarantee);
			}

			printFinalDecision(propertyGuarantee);

			return propertyGuarantee;
		}
	}
}
