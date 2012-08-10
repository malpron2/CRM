package model;

public class Currency {
	private String currencyName;
	private String currencySymbol;
	private double currencyLocalValue;
	
	public Currency(String p_currencyName, String p_currencySymbol, double p_currencyLocalValue) {
		this.currencyName = p_currencyName;
		this.currencySymbol = p_currencySymbol;
		this.currencyLocalValue = p_currencyLocalValue;
	}

	public String getCurrencyName() {
		return currencyName;
	}
	
	public void setCurrencyName(String p_currencyName) {
		this.currencyName = p_currencyName;
	}
	
	public String getCurrencySymbol() {
		return currencySymbol;
	}
	
	public void setCurrencySymbol(String p_currencySymbol) {
		this.currencySymbol = currencySymbol;
	}
	
	public double getCurrencyLocalValue() {
		return currencyLocalValue;
	}
	
	public void setCurrencyLocalValue(double p_currencyLocalValue) {
		this.currencyLocalValue = currencyLocalValue;
	}
}
