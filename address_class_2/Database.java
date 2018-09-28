package address_class_2;

//Rowan Turner
//April 19, 2018
//CS 64
//Assignment 12
//Ch 15 Ordered Linked Lists

import java.awt.*;
import javax.swing.*;
import java.io.*;

/**
 * Makes a GUI for the user to enter and view AddressInfos, with search, delete, save and load methods.
 * @author Rowan
 *
 */
public class Database extends JFrame {
	/**
	 * reference to the AddressInfo list that can be sorted by address
	 */
	private AddressInfoCollection myCollection;
	/**
	 * Holds error messages generated when an invalid button request is made
	 */
	private String errorMsg;
	/**
	 * used for search and delete methods - the addressInfo that is found
	 */
	private AddressInfo found;
	/**
	 * Holds strings that will be used as the first name in address info objects
	 */
	private String firstName;
	/**
	 * Holds strings that will be used as the middle name in address info objects
	 */
	private String middleName;
	/**
	 * Holds strings that will be used as the family name in address info objects
	 */
	private String familyName;
	/**
	 * Holds strings that will be used as the street in address info objects
	 */
	private String street;
	/**
	 * Holds strings that will be used as the secondary in address info objects
	 */
	private String secondary;
	/**
	 * Holds strings that will be used as the city in address info objects
	 */
	private String city;
	/**
	 * Holds strings that will be used as the zipcode name in address info objects
	 */
	private String zipCode;
	/**
	 * Holds strings that will be used as the state in address info objects
	 */
	private String state;
	/**
	 * Holds strings that are returned from the saveOrLoad text field
	 */
	private String fileName;
	/**
	 * Set true if a save action requires a confirm/cancel decision, false otherwise.
	 */
	private boolean processingSave;
	/**
	 * set true if a delete action requires a confirm/cancel decision, false otherwise
	 */
	private boolean processingDelete;

	// this only sort of works. Still figuring out typeface
	private Font buttonFont = new Font("Times New Roman", Font.BOLD, 12);
	
	/**
	 * the add button
	 */
	private JButton addB;
	/**
	 * alphabetical display button
	 */
	private JButton alphabeticalSortB;
	/**
	 * address display button
	 */
	private JButton addressSortB;// address sort and display button
	/**
	 * search button
	 */
	private JButton searchB; // search button
	/**
	 * delete button
	 */
	private JButton deleteB; // delete button
	/**
	 * confirm button
	 */
	private JButton confirmB; // confirm delete button
	/**
	 * cancel button
	 */
	private JButton cancelB; // cancel delete button
	/**
	 * save list button
	 */
	private JButton saveB; // save list button
	/**
	 * load list button
	 */
	private JButton loadB; // load list button

	/**
	 * label for the first name text field
	 */
	private JLabel firstL;
	/**
	 * label for the middle name text field
	 */
	private JLabel middleL;
	/**
	 * label for the family name text field
	 */
	private JLabel familyL;
	/**
	 * label for the street TF
	 */
	private JLabel streetL;
	/**
	 * label for secondary address TF
	 */
	private JLabel secondaryL;
	/**
	 * label for city TF
	 */
	private JLabel cityL;
	/**
	 * label for zipCode TF
	 */
	private JLabel zipCodeL;
	/**
	 * label for state Combo Box
	 */
	private JLabel stateL;
	/**
	 * label for saving and loading TF
	 */
	private JLabel saveOrLoadL;

	/**
	 * text field for first name entry
	 */
	private JTextField firstTF;
	/**
	 *  TF for middle name entry
	 */
	private JTextField middleTF;
	/**
	 * TF for family name entry
	 */
	private JTextField familyTF;
	/**
	 * TF for street entry
	 */
	private JTextField streetTF;
	/**
	 * TF for secondary address entry. Optional
	 */
	private JTextField secondaryTF;
	/**
	 * TF for city entry
	 */
	private JTextField cityTF;
	/**
	 * TF for zipcode entry
	 */
	private JTextField zipCodeTF;
	/**
	 * TF for saving and loading entry
	 */
	private JTextField saveOrLoadTF;
	
	/**
	 * combo box for selecting the state of the address
	 */
	private JComboBox stateCB;
	
	/**
	 * text area that displays AddressInfos and all button triggered messages
	 */
	private JTextArea resultsTA;

	/**
	 * reference to the content pane of the GUI
	 */
	private Container myCP;
	
	/**
	 * Zero parameter constructor for the GUI. Creates an AddressInfoCollection as well as a GUI
	 */
	public Database() {
		super("Address Database");
		setSize(900, 500);
		setLocation(100, 100);
		myCP = getContentPane();
		myCP.setLayout(null);
		myCP.setBackground(Color.GRAY);
		myCollection = new AddressInfoCollection();

		makeAllButtons();
		makeAllLabels();
		makeAllTextComponents();
		processingSave = false;
		processingDelete = false;

		setVisible(true);
		UtilityMethods.closingCausesExit(this);
	}// Database constructor

	// Button Actions

	/**
	 * Adds AddressInfos to the list. Requires mandatory fields, disallows duplicate names
	 */
	private void addAction() {
		resetAllLabels();
		errorMsg = "";
		firstName = getRequiredString(firstTF, "First Name", firstL);
		middleName = getRequiredString(middleTF, "Middle Name", middleL);
		familyName = getRequiredString(familyTF, "Family Name", familyL);
		street = getRequiredString(streetTF, "Street", streetL);
		secondary = secondaryTF.getText();
		city = getRequiredString(cityTF, "City", cityL);
		state = stateCB.getSelectedItem().toString();
		if (state.equals("")) {
			errorMsg += "State required.\n";
			stateL.setForeground(Color.RED);
		} // if
		zipCode = getRequiredString(zipCodeTF, "Zip Code", zipCodeL);
		AddressInfo toAdd = new AddressInfo(firstName, middleName, familyName, street, secondary, city, state, zipCode);
		if (errorMsg.equals("")) {
			if (myCollection.add(toAdd)) {
				resultsTA.append("\nAddress Info Added\n");
			} else {
				resultsTA
						.append("\nFailed to Add Address Info.\n" + toAdd.getName() + " is already in the database.\n");
			} // else
			resetAllTF();
		} else {
			resultsTA.setText(errorMsg);
		} // else
	}// actions for add button
	
	/**
	 * alphabeticalDisplay button action.
	 * Sets the text in resultsTA to a display of the list ordered by name.
	 */
	private void alphabeticalDisplay() {
		resetAllLabels();
		String returnedString = myCollection.toStringAlphabetical();
		if (returnedString.equals("")) {
			resultsTA.setText("Database is empty.\n");
		} else {
			resultsTA.setText(returnedString);
		} // else
	}// actions for alphabetical sort button
	
	/**
	 * addressDisplay button action. Sets the text in resultsTA to a display of the list ordered by address.
	 */
	private void addressDisplay() {
		resetAllLabels();
		String returnedString = myCollection.toStringByAddress();
		if (returnedString.equals("")) {
			resultsTA.setText("Database is empty.\n");
		} else {
			resultsTA.setText(returnedString);
		} // else
	}// actions for address sort button

	/**
	 * Search button action
	 * Searches for an AddressInfo in the list using a first, middle and last name provided by the user.
	 * Sets resultsTA to display either the AddressInfo if found or indicate it was not found.
	 */
	private void searchAction() {
		resetAllLabels();
		errorMsg = "";
		firstName = getRequiredString(firstTF, "First Name", firstL);
		middleName = getRequiredString(middleTF, "Middle Name", middleL);
		familyName = getRequiredString(familyTF, "Family Name", familyL);
		if (errorMsg.equals("")) {
			found = myCollection.search(new AddressInfo(firstName, middleName, familyName));
			if (found != null) {
				resultsTA.setText("Address found:\n" + found);
			} else {
				resultsTA.setText(familyName + ", " + firstName + " " + middleName + " not found.");
			} // else
			resetAllTF();
		} else {
			resultsTA.setText(errorMsg);
		} // else
	}// action for the search button

	/**
	 * Delete button action. Searches for an AddressInfo using a first, middle and last name provided by the user.
	 * If found, enables cancel and confirm buttons and sets resultsTA to ask the user for cancel/confirm input.
	 */
	private void deleteAction() {
		resetAllLabels();
		errorMsg = "";
		firstName = getRequiredString(firstTF, "First Name", firstL);
		middleName = getRequiredString(middleTF, "Middle Name", middleL);
		familyName = getRequiredString(familyTF, "Family Name", familyL);
		if (errorMsg.equals("")) {
			found = myCollection.search(new AddressInfo(firstName, middleName, familyName));
			if (found != null) {
				resultsTA.setText("Click cancel to cancel, or confirm to delete\n" + found);
				processingDelete = true;
				adjustButtons(false);
			} else {
				resultsTA.setText(familyName + ", " + firstName + " " + middleName + " not found.");
			} // else
			resetAllTF();
		} else {
			resultsTA.setText(errorMsg);
		} // else
	}// actions for delete button

	/**
	 * Action for confirm button. Deletes AddressInfo if processingDelete is set to true, saves list to file
	 * if processingSave is set to true. sets resultsTA to indicate action taken.
	 */
	private void confirmAction() {
		if (processingDelete) {
			if (myCollection.delete(found)) {
				resultsTA.setText("Delete of\n" + found + "successful.\n");
			} else {
				resultsTA.setText("Delete failed. Broken code. Panic!");
			} // else
			processingDelete = false;
		} // if
		if (processingSave) {
			String potentialError = myCollection.saveToFile(fileName);
			resultsTA.setText(fileName + " overwritten.\n" + potentialError);
			processingSave = false;
		} // if
		adjustButtons(true);
	}//confirmAction

	/**
	 * Action for cancel button. Cancels delete or save action. Sets resultsTA to indicate action cancelled.
	 */
	private void cancelAction() {
		if (processingDelete) {
			resultsTA.setText("Delete cancelled");
			processingDelete = false;
		} // if
		if (processingSave) {
			resultsTA.setText("Save request cancelled. " + fileName + " unchanged.");
			processingSave = false;
		} // if
		adjustButtons(true);
	}//cancelAction

	/**
	 * Action for save button. Checks if the file name provided does not already exist - saves if so.
	 * Indicates if file cannot be saved, or triggers confirm/cancel buttons if file already exists
	 */
	private void saveAction() {
		resetAllLabels();
		errorMsg = "";
		String message = "";
		fileName = getRequiredString(saveOrLoadTF, "File Name", saveOrLoadL);
		if (errorMsg.equals("")) {
			File theFile = new File(fileName);
			if (!theFile.exists()) {
				message = myCollection.saveToFile(fileName);
				resultsTA.setText("Database saved to: " + fileName + "\n" + message);
			} else if (theFile.isDirectory()) {
				resultsTA.setText("Error: " + fileName + " is a directory.\n");
			} else if (!theFile.canWrite()) {
				resultsTA.setText("Cannot write data to " + fileName + ".\n");
			} else {
				adjustButtons(false);
				processingSave = true;
				resultsTA.setText(fileName + " already exists.\nPress Confirm to overwrite file " + fileName
						+ " or press Cancel to cancel save request\n");
			} // else
			resetAllTF();
		} else {
			resultsTA.setText(errorMsg);
		} // else
	}// saveAction
	
	/**
	 * Action for load button. Attempts to load file from file name given.
	 * Sets resultsTA to if file cannot be loaded, otherwise displays data loaded from file
	 */
	private void loadAction() {
		resetAllLabels();
		errorMsg = "";
		fileName = getRequiredString(saveOrLoadTF, "File Name", saveOrLoadL);
		if (errorMsg.equals("")) {
			File theFile = new File(fileName);
			if (!theFile.exists()) {
				resultsTA.setText(fileName + " does not exist—cannot load data.");
			} else if (!theFile.canRead()) {
				resultsTA.setText("Cannot read from " + fileName);
			} else {
				String fromLoad = myCollection.loadFromFile(fileName);
				resultsTA.setText("Data loaded from " + fileName + "\n" + fromLoad + "\n");
			} // else
			resetAllTF();
		} else {
			resultsTA.setText(errorMsg);
		} // else
	}// loadAction
	
	/**
	 * Constructs all buttons for the GUI
	 */
	private void makeAllButtons() {
		// Constructing buttons The font is null until I figure out what fonts I can use
		addB = UtilityMethods.makeButton("Add", 30, 350, 80, 20, buttonFont, (e) -> addAction(), myCP);
		alphabeticalSortB = UtilityMethods.makeButton("Display list ordered by name", 200, 100, 200, 20, null,
				(e) -> alphabeticalDisplay(), myCP);
		addressSortB = UtilityMethods.makeButton("Display list ordered by address", 200, 130, 215, 20, null,
				(e) -> addressDisplay(), myCP);
		searchB = UtilityMethods.makeButton("Search", 200, 160, 80, 20, null, (e) -> searchAction(), myCP);
		deleteB = UtilityMethods.makeButton("Delete", 200, 190, 80, 20, null, (e) -> deleteAction(), myCP);
		confirmB = UtilityMethods.makeButton("Confirm", 200, 220, 80, 20, null, false, (e) -> confirmAction(), myCP);
		cancelB = UtilityMethods.makeButton("Cancel", 200, 250, 80, 20, null, false, (e) -> cancelAction(), myCP);
		saveB = UtilityMethods.makeButton("Save", 200, 280, 80, 20, null, (e) -> saveAction(), myCP);
		loadB = UtilityMethods.makeButton("Load", 200, 310, 80, 20, null, (e) -> loadAction(), myCP);
	}// makeAllButtons

	/**
	 * Constructs all labels for the GUI
	 */
	private void makeAllLabels() {
		// Constructing labels
		firstL = UtilityMethods.makeLabel("First Name", 30, 30, 100, 20, myCP);
		middleL = UtilityMethods.makeLabel("Middle Name", 140, 30, 100, 20, myCP);
		familyL = UtilityMethods.makeLabel("Family Name", 250, 30, 100, 20, myCP);
		streetL = UtilityMethods.makeLabel("Street", 30, 80, 100, 20, myCP);
		secondaryL = UtilityMethods.makeLabel("Second line", 30, 130, 100, 20, myCP);
		cityL = UtilityMethods.makeLabel("City", 30, 180, 100, 20, myCP);
		zipCodeL = UtilityMethods.makeLabel("Zip Code", 30, 230, 100, 20, myCP);
		stateL = UtilityMethods.makeLabel("State", 30, 280, 100, 20, myCP);
		saveOrLoadL = UtilityMethods.makeLabel("Enter filename to save or load list", 200, 340, 200, 20, myCP);
	}// makeAllLabels

	/**
	 * Constructs all text components for the GUI
	 */
	private void makeAllTextComponents() {
		// Constructing text fields
		firstTF = UtilityMethods.makeTextField("", 30, 50, 100, 20, myCP);
		middleTF = UtilityMethods.makeTextField("", 140, 50, 100, 20, myCP);
		familyTF = UtilityMethods.makeTextField("", 250, 50, 100, 20, myCP);
		streetTF = UtilityMethods.makeTextField("", 30, 100, 100, 20, myCP);
		secondaryTF = UtilityMethods.makeTextField("", 30, 150, 100, 20, myCP);
		cityTF = UtilityMethods.makeTextField("", 30, 200, 100, 20, myCP);
		zipCodeTF = UtilityMethods.makeTextField("", 30, 250, 100, 20, myCP);
		saveOrLoadTF = UtilityMethods.makeTextField("", 200, 360, 200, 20, myCP);

		// Combo-box
		stateCB = UtilityMethods.makeComboBox(Address.STATES, 30, 300, 50, 20, myCP);

		resultsTA = UtilityMethods.makeTextAreaWithScrollPane("", 420, 30, 400, 400, false, myCP);
		resultsTA.setBackground(Color.lightGray);
	}// makeAllTextComponents

	/**
	 * Resets all labels to black
	 */
	private void resetAllLabels() {
		UtilityMethods.resetLabel(firstL);
		UtilityMethods.resetLabel(middleL);
		UtilityMethods.resetLabel(familyL);
		UtilityMethods.resetLabel(streetL);
		UtilityMethods.resetLabel(cityL);
		UtilityMethods.resetLabel(zipCodeL);
		UtilityMethods.resetLabel(stateL);
		UtilityMethods.resetLabel(saveOrLoadL);
	}// resets label colors to black

	/**
	 * resets all text fields to empty strings
	 */
	private void resetAllTF() {
		UtilityMethods.resetTF(firstTF);
		UtilityMethods.resetTF(middleTF);
		UtilityMethods.resetTF(familyTF);
		UtilityMethods.resetTF(streetTF);
		UtilityMethods.resetTF(secondaryTF);
		UtilityMethods.resetTF(cityTF);
		UtilityMethods.resetTF(zipCodeTF);
		UtilityMethods.resetTF(saveOrLoadTF);
		stateCB.setSelectedIndex(0);
	}// resets text fields to empty strings

	/**
	 * Enables/disables button sets. 
	 * If true, main button set is enabled and cancel and confirm are disabled
	 * @param tOrF Indicates which button set is enabled
	 */
	private void adjustButtons(boolean tOrF) {
		addB.setEnabled(tOrF);
		alphabeticalSortB.setEnabled(tOrF);
		addressSortB.setEnabled(tOrF);
		searchB.setEnabled(tOrF);
		deleteB.setEnabled(tOrF);
		saveB.setEnabled(tOrF);
		loadB.setEnabled(tOrF);
		confirmB.setEnabled(!tOrF);
		cancelB.setEnabled(!tOrF);
	}// 

	
	/**
	 * checks and returns text from a text field needed for a button triggered action
	 * @param theTF the text field to get text from
	 * @param forErrorMsg the field name to send to the error message if field is empty
	 * @param theL the label for the field to set to red if the field is empty
	 * @return Returns the error message string to indicate if there is a missing field
	 */
	private String getRequiredString(JTextField theTF, String forErrorMsg, JLabel theL) {
		String toReturn = theTF.getText();
		if (toReturn.equals("")) {
			theL.setForeground(Color.RED);
			errorMsg += forErrorMsg + " required.\n";
		} // if
		return toReturn;
	}// getRequiredString

	/**
	 * Main method. Initializes a database
	 * @param args I have literally no idea what this is
	 */
	public static void main(String args[]) {
		Database myDataBase = new Database();
	}// main method

}// Database
