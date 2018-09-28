package address_class_2;
import java.util.*;
import java.io.*;
/**
 * A class that holds Names and Addresses. Has basic constructors, access and modifier methods and various compare/before/after methods.
 * @author Rowan
 *
 */
public class AddressInfo implements Serializable, Comparable<AddressInfo>{

	/**
	 * reference to Name of Contact
	 */
	private Name myName;
	/**
	 * reference to the address of contact
	 */
	private Address myAddress;
	
	/**
	 * Reference to a comparator for AddressInfos
	 */
	public static final Comparator<AddressInfo> ADDRESS_COMPARATOR = new AddressComparator();
	
	/**
	 * AddressComparator Class
	 * @author Rowan
	 */
	private static class AddressComparator implements  Comparator<AddressInfo>{
		/**
		 * Compares AddressInfos by Address and Name
		 * @param aI1 The first AddressInfo to be compared
		 * @param aI2 The second AdressInfo to be compares
		 * @return returns a negative int if the first comes before the second, 0 if equal, positive if after
		 */
		public int compare(AddressInfo aI1, AddressInfo aI2) {
			int resultOfComparingAddresses = aI1.myAddress.compareTo(aI2.myAddress);
			if(resultOfComparingAddresses != 0){
				return resultOfComparingAddresses;
			}//if addresses are not the same
			return aI1.myName.compareTo(aI2.myName);		
		}//compare
	}//AddressComparator

	/**
	 * 8 parameter constructor. Creates a Name and Address for the AddressInfo
	 * @param theFirst The first name
	 * @param theMiddle The middle name
	 * @param theLast The family name
	 * @param theStreetAddress1 The street address
	 * @param theStreetAddress2 The secondary street address
	 * @param theCity The city of the address
	 * @param theState The state of the address
	 * @param theZipCode The zipcode of the address
	 */
	public AddressInfo(String theFirst, String theMiddle, String theLast, 
			String theStreetAddress1, String theStreetAddress2, 
			String theCity, String theState, String theZipCode){
		myName = new Name(theFirst, theMiddle, theLast);
		myAddress = new Address(theStreetAddress1, theStreetAddress2,
				theCity, theState, theZipCode);	
	}//8 parameter constructor
	
	/**
	 * 7 parameter constructor. Creates a Name and Address for the AddressInfo. 
	 * @param theFirst The first name
	 * @param theMiddle The middle name
	 * @param theLast The family name
	 * @param theStreetAddress1 The street address
	 * @param theCity The city of the address
	 * @param theState The state of the address
	 * @param theZipCode The zipcode of the address
	 */
	public AddressInfo(String theFirst, String theMiddle, String theLast, 
			String theStreetAddress1, String theCity, 
			String theState, String theZipCode){
		myName = new Name(theFirst, theMiddle, theLast);
		myAddress = new Address(theStreetAddress1, theCity, 
				theState, theZipCode);
	}//7 parameter constructor

	/**
	 * 3 parameter constructor. Creates a Name with passed names and an Address of empty strings
	 * @param theFirst The first name
	 * @param theMiddle The middle name
	 * @param theLast The faimly name
	 */
	public AddressInfo(String theFirst, String theMiddle, String theLast){
		myName = new Name(theFirst, theMiddle, theLast);
		myAddress = new Address();
	}//3 parameter constructor

	/**
	 * Returns the Name of the AddressInfo that called it
	 * @return Returns myName
	 */
	public Name getName(){
		return myName;
	}//getName

	/**
	 * Returns the Address of the AddressInfo that called it
	 * @return Returns myAddress
	 */
	public Address getAddress(){
		return myAddress;
	}//getAddress
	
	/**
	 * Sets the Name of the AddressInfo that called it
	 * @param theName The Name being assigned
	 */
	public void setName(Name theName){
		myName = theName;
	}//setName
	
	/**
	 * Sets the name of the AddressInfo that called it
	 * @param theFirst The first name being assigned
	 * @param theMiddle The middle name being assigned
	 * @param theFamily The family name being assigned
	 */
	public void setName(String theFirst, String theMiddle, String theFamily) {
		myName.setFirst(theFirst);
		myName.setMiddle(theMiddle);
		myName.setFamily(theFamily);		
	}//setName

	/**
	 * Sets the address of the AddressInfo that called it
	 * @param theAddress The address being assigned
	 */
	public void setAddress(Address theAddress){
		myAddress = theAddress;
	}//setAddress
	
	/**
	 * Sets the address of the AddressInfo that called it
	 * @param theStreet The street of the Address
	 * @param theSecondLine The secondary street of the address
	 * @param theCity The city of the address
	 * @param theState The state of the address
	 * @param theZipCode The zipcode of the address
	 */
	public void setAddress(String theStreet, String theSecondLine, 
			String theCity, String theState, String theZipCode) {
		myAddress.setStreet(theStreet);
		myAddress.setSecondLine(theSecondLine);
		myAddress.setCity(theCity);
		myAddress.setState(theState);
		myAddress.setZipCode(theZipCode);
	}//setAddress 5 parameter
	
	/**
	 * Sets the address of the AddressInfo that called it
	 * @param theStreet The street of the Address
	 * @param theCity The city of the address
	 * @param theState The state of the address
	 * @param theZipCode The zipcode of the address
	 */
	public void setAddress(String theStreet, String theCity, String theState,
			String theZipCode) {
		myAddress.setStreet(theStreet);
		myAddress.setCity(theCity);
		myAddress.setState(theState);
		myAddress.setZipCode(theZipCode);
	}//setAddress 4 parameter

	/**
	 * toString for AddressInfos. Concatenates the Name toString with the Address toString
	 * @return Returns a string representation of the AddressInfo
	 */
	public String toString(){
		return myName.toString() + "\n" + myAddress.toString() ;
	}//toString

	/**
	 * Equals method for AddressInfo. Only checks Name portion of AddressInfo objects
	 * @param theOther The object being compared to the invoking AddressInfo
	 * @return Returns true if the Names in each AddressInfo are equal
	 */
	public boolean equals(Object theOther){
		AddressInfo theAddressInfo = (AddressInfo)theOther;
		return myName.equals(theAddressInfo.myName);
	}//equals

	/**
	 * Compares the Names of AddressInfo objects
	 * @param theAddressInfo The AddressInfo being compared to the invoking AddressInfo
	 * @return Returns a negative int if the invoking object is less than the parameter, 0 if equal, positive if it is greater than
	 */
	public int compareTo(AddressInfo theAddressInfo){
		return myName.compareTo(theAddressInfo.myName);
	}//compareTo

	/**
	 * Checks if the invoking AddressInfo comes before the passed AddressInfo based on Name
	 * @param theAddressInfo The AddressInfo being compared to by the invoking AddressInfo
	 * @return Returns true if the Name of the invoking AddressInfo comes before the Name of the passed AddressInfo
	 */
	public boolean beforeAlpha(AddressInfo theAddressInfo){
		 return compareTo(theAddressInfo)<0;
	}//before
	
	/**
	 * Checks if the invoking AddressInfo comes before the passed AddressInfo, checking both Address first and then Name
	 * @param theAddressInfo The AddressInfo being compared to by the invoking AddressInfo
	 * @return Returns true if the invoking AddressInfo comes before the passed AddressInfo
	 */
	public boolean beforeAddress(AddressInfo theAddressInfo){
		return myAddress.before(theAddressInfo.myAddress) || 
				myAddress.equals(theAddressInfo.myAddress)
				&& myName.before(theAddressInfo.myName);
	}//beforeAddress
	
}//AddressInfo
