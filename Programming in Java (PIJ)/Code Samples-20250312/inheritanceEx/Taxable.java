public interface Taxable {
	public final  static double defaultPercent = 33;
	double calculateTax(double annualIncome);
	double calculateDeductions(double investedAmount);

}
