////package com.luxoft.bankapp.domain;
////
////import java.io.Serializable;
////
////import com.luxoft.bankapp.exceptions.NotEnoughFundsException;
////import com.luxoft.bankapp.utils.Params;
////
////public abstract class AbstractAccount implements Account, Serializable {
////
////	private static final long serialVersionUID = -2272551373694344386L;
////
////	public static final int SAVING_ACCOUNT_TYPE = 1;
////	public static final int CHECKING_ACCOUNT_TYPE = 2;
////
////	private int id;
////	private int type;
////
////	public double balance;
////
////	public AbstractAccount(int id, double amount) {
////		this.id = id;
////		this.balance = amount;
////	}
////
////	public int getType() {
////		return type;
////	}
////
////	public void setType(int type) {
////		this.type = type;
////	}
////
////	@Override
////	public void deposit(final double amount) {
////		if (amount < 0) {
////			throw new IllegalArgumentException("Cannot deposit a negative amount");
////		}
////		this.balance += amount;
////	}
////
////	@Override
////	public void withdraw(final double amount) throws NotEnoughFundsException {
////		if (amount < 0) {
////			throw new IllegalArgumentException("Cannot withdraw a negative amount");
////		}
////
////		if (amount > maximumAmountToWithdraw()) {
////			throw new NotEnoughFundsException(id, balance, amount, "Requested amount exceeds the maximum amount to withdraw");
////		}
////
////		this.balance -= amount;
////	}
////
////	public double maximumAmountToWithdraw(){
////		switch (type) {
////		   case SAVING_ACCOUNT_TYPE:
////			   return balance;
////		   case CHECKING_ACCOUNT_TYPE:
////			   CheckingAccount checkingAccount = (CheckingAccount)this;
////			  return checkingAccount.balance + checkingAccount.overdraft;
////		}
////
////        return 0;
////    }
////
////	@Override
////	public int getId() {
////		return id;
////	}
////
////	@Override
////	public double getBalance() {
////		return balance;
////	}
////
////	@Override
////    public long decimalValue(){
////        return Math.round(balance);
////    }
////
////	@Override
////	public int hashCode() {
////		final int prime = 31;
////		int result = 1;
////		result = prime * result + id;
////		return result;
////	}
////
////	@Override
////	public boolean equals(Object obj) {
////		if (this == obj)
////			return true;
////		if (obj == null)
////			return false;
////		if (getClass() != obj.getClass())
////			return false;
////		AbstractAccount other = (AbstractAccount) obj;
////		if (id != other.id)
////			return false;
////		return true;
////	}
////
////	public static Account parse(Params params) {
////
////        switch (params.get("accountType")){
////            case "s": return SavingAccount.parse(params);
////            case "c": return CheckingAccount.parse(params);
////        }
////
////        return null;
////    }
////
////}
//
////exercise 2.1
//package com.luxoft.bankapp.domain;
//
//import java.io.Serializable;
//
//import com.luxoft.bankapp.exceptions.NotEnoughFundsException;
//import com.luxoft.bankapp.utils.Params;
//
//public abstract class AbstractAccount implements Account, Cloneable {
//
//	private static final long serialVersionUID = -2272551373694344386L;
//
//	public static final int SAVING_ACCOUNT_TYPE = 1;
//	public static final int CHECKING_ACCOUNT_TYPE = 2;
//
//	private int id;
//	private int type;
//
//	public double balance;
//
//	public AbstractAccount(int id, double amount) {
//		this.id = id;
//		this.balance = amount;
//	}
//
//	public int getType() {
//		return type;
//	}
//
//	public void setType(int type) {
//		this.type = type;
//	}
//
//	@Override
//	public void deposit(final double amount) {
//		if (amount < 0) {
//			throw new IllegalArgumentException("Cannot deposit a negative amount");
//		}
//		this.balance += amount;
//	}
//
//	@Override
//	public void withdraw(final double amount) throws NotEnoughFundsException {
//		if (amount < 0) {
//			throw new IllegalArgumentException("Cannot withdraw a negative amount");
//		}
//
//		if (amount > maximumAmountToWithdraw()) {
//			throw new NotEnoughFundsException(id, balance, amount, "Requested amount exceeds the maximum amount to withdraw");
//		}
//
//		this.balance -= amount;
//	}
//
//	public double maximumAmountToWithdraw(){
//		switch (type) {
//			case SAVING_ACCOUNT_TYPE:
//				return balance;
//			case CHECKING_ACCOUNT_TYPE:
//				CheckingAccount checkingAccount = (CheckingAccount)this;
//				return checkingAccount.balance + checkingAccount.overdraft;
//		}
//
//		return 0;
//	}
//
//	@Override
//	public int getId() {
//		return id;
//	}
//
//	@Override
//	public double getBalance() {
//		return balance;
//	}
//
//	@Override
//	public long decimalValue(){
//		return Math.round(balance);
//	}
//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + id;
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		AbstractAccount other = (AbstractAccount) obj;
//		if (id != other.id)
//			return false;
//		return true;
//	}
//
//	public static Account parse(Params params) {
//
//		switch (params.get("accountType")){
//			case "s": return SavingAccount.parse(params);
//			case "c": return CheckingAccount.parse(params);
//		}
//
//		return null;
//	}
//
//	@Override
//	public Object clone() throws CloneNotSupportedException {
//		try {
//			// Perform a shallow copy using super.clone
//			AbstractAccount clonedAccount = (AbstractAccount) super.clone();
//			return clonedAccount;
//		} catch (CloneNotSupportedException e) {
//			// Propagate the exception as a RuntimeException
//			throw new RuntimeException("Clone not supported", e);
//		}
//	}
//
//}

//exercise 3

package com.luxoft.bankapp.domain;

import com.luxoft.bankapp.exceptions.NotEnoughFundsException;
import com.luxoft.bankapp.utils.Params;

import java.io.Serializable;

public abstract class AbstractAccount implements Account, Cloneable {

    private static final long serialVersionUID = -2272551373694344386L;

    public static final int SAVING_ACCOUNT_TYPE = 1;
    public static final int CHECKING_ACCOUNT_TYPE = 2;

    private int id;
    private int type;

    public double balance;

    public AbstractAccount(int id, double amount) {
        this.id = id;
        this.balance = amount;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public void deposit(final double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Cannot deposit a negative amount");
        }
        this.balance += amount;
    }

    @Override
    public void withdraw(final double amount) throws NotEnoughFundsException {
        if (amount < 0) {
            throw new IllegalArgumentException("Cannot withdraw a negative amount");
        }

        if (amount > maximumAmountToWithdraw()) {
            throw new NotEnoughFundsException(id, balance, amount, "Requested amount exceeds the maximum amount to withdraw");
        }

        this.balance -= amount;
    }

    public double maximumAmountToWithdraw() {
        switch (type) {
            case SAVING_ACCOUNT_TYPE:
                return balance;
            case CHECKING_ACCOUNT_TYPE:
                CheckingAccount checkingAccount = (CheckingAccount) this;
                return checkingAccount.balance + checkingAccount.overdraft;
        }

        return 0;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public long decimalValue() {
        return Math.round(balance);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AbstractAccount other = (AbstractAccount) obj;
        if (id != other.id)
            return false;
        return true;
    }

    public static Account parse(Params params) {
        switch (params.get("accountType")) {
            case "s":
                return SavingAccount.parse(params);
            case "c":
                return CheckingAccount.parse(params);
        }

        return null;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        try {
            // Perform a shallow copy using super.clone
            AbstractAccount clonedAccount = (AbstractAccount) super.clone();
            return clonedAccount;
        } catch (CloneNotSupportedException e) {
            // Propagate the exception as a RuntimeException
            throw new RuntimeException("Clone not supported", e);
        }
    }

    public static class SavingAccount extends AbstractAccount {

        private static final long serialVersionUID = 9200460687227050240L;
        private Currency currency;

        public SavingAccount(int id, double amount) {
            super(id, amount);
            this.setType(AbstractAccount.SAVING_ACCOUNT_TYPE);
        }

        public SavingAccount(int id, double amount, Currency currency) {
            super(id, amount);
            this.currency = currency;
            this.setType(AbstractAccount.SAVING_ACCOUNT_TYPE);
        }

        public Currency getCurrency() {
            return currency;
        }

        @Override
        public String toString() {
            return String.format("Saving account %d, balance: %.2f", getId(), balance);
        }

        public static Account parse(Params params) {
            String id = params.get("id");
            String balance = params.get("balance");
            String currency = params.get("currency");

            return new SavingAccount(
                    Integer.parseInt(id),
                    Double.parseDouble(balance),
                    new Currency(currency));
        }
    }

    public static class CheckingAccount extends AbstractAccount {

        private static final long serialVersionUID = 7922392307762434334L;
        public double overdraft;
        private Currency currency;

        public CheckingAccount(int id, double amount, double overdraft) {
            super(id, amount);
            if (overdraft < 0) {
                throw new IllegalArgumentException("Cannot create an account with a starting negative overdraft");
            }
            this.overdraft = overdraft;
            this.setType(AbstractAccount.CHECKING_ACCOUNT_TYPE);
        }

        public CheckingAccount(int id, double amount, double overdraft, Currency currency) {
            super(id, amount);
            if (overdraft < 0) {
                throw new IllegalArgumentException("Cannot create an account with a starting negative overdraft");
            }
            this.overdraft = overdraft;
            this.currency = currency;
            this.setType(AbstractAccount.CHECKING_ACCOUNT_TYPE);
        }

        public double getOverdraft() {
            return overdraft;
        }

        public Currency getCurrency() {
            return currency;
        }

        @Override
        public String toString() {
            return String.format("Checking account %d, balance: %.2f, overdraft: %.2f", getId(), balance, overdraft);
        }

        public static Account parse(Params params) {
            String id = params.get("id");
            String balance = params.get("balance");
            String overdraft = params.get("overdraft");
            String currency = params.get("currency");

            return new CheckingAccount(
                    Integer.parseInt(id),
                    Double.parseDouble(balance),
                    Double.parseDouble(overdraft),
                    new Currency(currency));
        }
    }
}
