package in.capgerni.calculate;

public abstract class Account {
	double intersetRate;
	double amount;
	abstract double calculateInterest(double intersetRate,double amount);

}
