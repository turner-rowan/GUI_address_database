package address_class_2;
//Rowan Turner
//February 1, 2018
//CS 64
//Assignment 2
//Ch 11 Searching and Sorting

/**
 * A class for house addresses to be part of AddressInfo objects
 * @author Rowan
 *
 */
public class Address implements Comparable<Address>, java.io.Serializable {
	/**
	 * String holding the street portion of an address
	 */
	private String myStreet;
	/**
	 * String holding the secondary street portion of an address
	 */
	private String mySecondLine;
	/**
	 * String holding the city portion of an address
	 */
	private String myCity;
	/**
	 * String holding the state portion of an address
	 */
	private String myState;
	/**
	 * String holding the zipcode portion of an address
	 */
	private String myZipCode;
	
	/**
	 * Array of state abbreviation strings, used by the state combo box in Database
	 */
	public static final String[] STATES = { "", "Al", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID",
			"IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ",
			"NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV",
			"WI", "WY" };
	
	/**
	 * 5 parameter Address constructor
	 * @param theStreet The street address
	 * @param theSecondLine Secondary street line
	 * @param theCity The city of the address
	 * @param theState The state of the address
	 * @param theZipCode The zipcode of the address
	 */
	public Address(String theStreet, String theSecondLine, String theCity, String theState, String theZipCode) {
		myStreet = theStreet;
		mySecondLine = theSecondLine;
		myCity = theCity;
		myState = theState;
		myZipCode = theZipCode;
	}//5 parameter constructor
	
	/**
	 * 4 parameter Address constructor. Sets the secondary line to an empty string
	 * @param theStreet The street address
	 * @param theCity The city of the address
	 * @param theState The state of the address
	 * @param theZipCode The zipcode of the address
	 */
	public Address(String theStreet, String theCity, String theState, String theZipCode) {
		myStreet = theStreet;
		mySecondLine = "";
		myCity = theCity;
		myState = theState;
		myZipCode = theZipCode;
	}//4 parameter constructor

	/**
	 * Zero parameter Address constructor. Sets each instance variable to an empty string
	 */
	public Address() {
		myStreet = "";
		mySecondLine = "";
		myCity = "";
		myState = "";
		myZipCode = "";
	}//0 parameter constructor
	
	/**
	 * Returns the street address of the Address that called it
	 * @return returns myStreet
	 */
	public String getStreet() {
		return myStreet;
	}//getStreet
	
	/**
	 * Returns the secondary address of the Address that called it
	 * @return returns mySecondLine
	 */
	public String getSecondLine() {
		return mySecondLine;
	}//getSecondLine
	
	/**
	 * Returns the city portion of the Address that called it
	 * @return returns myCity
	 */
	public String getCity() {
		return myCity;
	}//getCity
	
	/**
	 * Returns the state portion of the Address that called it
	 * @return returns myState
	 */
	public String getState() {
		return myState;
	}//getState
	
	/**
	 * Returns the zipcode portion of the Address that called it
	 * @return returns myZipCode
	 */
	public String getZipCode() {
		return myZipCode;
	}//getZipCode
	
	/**
	 * Sets the street address of the Address that called it
	 * @param theStreet The street being assigned 
	 */
	public void setStreet(String theStreet) {
		myStreet = theStreet;
	}//setStreet
	
	/**
	 * Sets the secondary street address of the Address that called it
	 * @param theSecondLine The secondary street being assigned 
	 */
	public void setSecondLine(String theSecondLine) {
		mySecondLine = theSecondLine;
	}//setSecondLine
	
	/**
	 * Sets the city portion of the Address that called it
	 * @param theCity The city being assigned 
	 */
	public void setCity(String theCity) {
		myCity = theCity;
	}//setCity
	
	/**
	 * Sets the state portion of the Address that called it
	 * @param theState The state being assigned 
	 */
	public void setState(String theState) {
		myState = theState;
	}//setState
	
	/**
	 * Sets the zipcode portion of the Address that called it
	 * @param theZipCode The zipcode being assigned 
	 */
	public void setZipCode(String theZipCode) {
		myZipCode = theZipCode;
	}//setZipCode
	
	/**
	 * Determines if the passed Address is equal to the invoking Address. Checks all Address variables
	 * @param theOther Passed object being compared to the invoking Address. Typecast to Address.
	 * @return True if equal, false if not
	 */
	public boolean equals(Object theOther) {
		Address theAddress = (Address)theOther;
		return myStreet.equals(theAddress.myStreet) 
				&& mySecondLine.equals(theAddress.mySecondLine)
				&& myCity.equals(theAddress.myCity)
				&& myState.equals(theAddress.myState)
				&& myZipCode.equals(theAddress.myZipCode);
	}// equals
	
	/**
	 * Determines whether the invoking Address is greater than, less than or equal to the passed Address
	 * @param theAddress The address to compare to
	 * @return Returns a negative int if the invoker is less than the passed Address, 0 if they are equal, positive if the invoker is greater than the passed Address
	 */
	public int compareTo(Address theAddress) {
		int compareState = myState.compareTo(theAddress.myState); 
		if (compareState != 0) {
			return compareState;
		}// States were different
		int compareCity = myCity.compareTo(theAddress.myCity); 
		if (compareCity != 0) {
			return compareCity;
		}// Cities were different
		int compareZipCode = myZipCode.compareTo(theAddress.myZipCode); 
		if (compareZipCode != 0) {
			return compareZipCode;
		}// ZipCodes were different  
		int compareStreet = myStreet.compareTo(theAddress.myStreet); 
		if (compareStreet != 0) {
			return compareStreet;
		}// Streets were different 
		return mySecondLine.compareTo(theAddress.mySecondLine);
	}// compareTo
	
	/**
	 * Uses compareTo to determine if the invoking Address comes before the passed Address
	 * @param theAddress The Address being compared to the invoking Address
	 * @return Returns true if the invoking Address comes before the passed Address. False otherwise.
	 */
	public boolean before(Address theAddress) {
		return (compareTo(theAddress) < 0);
	}//before
	
	/**
	 * toString method for Address. 
	 * @return Returns a String representing the Address
	 */
	public String toString() {
		return (myStreet.equals("") ? "" : myStreet + "\n") + (mySecondLine.equals("") ? "" : mySecondLine + "\n") + 
				(myCity.equals("") ? "" : myCity + ", ") + (myState.equals("") ? "" : myState + " ") + 
				(myZipCode.equals("") ? "" : myZipCode + "\n");
	}//toString
	
	
}//Address
