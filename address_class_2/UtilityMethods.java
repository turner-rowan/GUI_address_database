package address_class_2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * A class of methods for use in the Database Class to manage GUI components
 * @author Rowan
 *
 */
public class UtilityMethods {
	
	/**
	 * Constructs a 7 parameter JButton
	 * @param text The text displayed on the button
	 * @param x The x coordinate of the button
	 * @param y The y coordinate of the button
	 * @param w The width of the button
	 * @param h	The height of the button
	 * @param theListener The listener to trigger the button action
	 * @param theCP The content pane containing the button
	 * @return the JButton that this method constructs
	 */
	public static JButton makeButton(String text, int x, int y, int w, int h,
			ActionListener theListener, Container theCP){
		JButton buttonToReturn = new JButton(text);
		buttonToReturn.setLocation(x, y);
		buttonToReturn.setSize(w, h);
		buttonToReturn.addActionListener(theListener);
		theCP.add(buttonToReturn);
		return buttonToReturn;
	}//makeButton
    
	/**
	 * Constructs a 9 parameter JButton
	 * @param text The text to be displayed on the JButton
	 * @param theX The x coordinate of the button
	 * @param theY The y coordinate of the button
	 * @param width The width of the button
	 * @param height The height of the button
	 * @param theFont The font of the button text
	 * @param enabledOrNot Boolean value that determines if the button is enabled upon initialization
	 * @param theListener The listener to trigger the button action
	 * @param theCP The content pane containing the button
	 * @return the JButton that this method constructs
	 */
    public static JButton makeButton(String text, int theX, int theY, int width, int height,
                                     Font theFont, boolean enabledOrNot, ActionListener theListener, Container theCP){
        JButton toReturn = new JButton(text);
        toReturn.setLocation(theX, theY);
        toReturn.setSize(width, height);
        toReturn.setFont(theFont);
        toReturn.setEnabled(enabledOrNot);
        toReturn.addActionListener(theListener);
        theCP.add(toReturn);
        return toReturn;
    }//9 parameter makeButton
    
	/**
	 * Constructs an 8 parameter JButton
	 * @param text The text to be displayed on the JButton
	 * @param theX The x coordinate of the button
	 * @param theY The y coordinate of the button
	 * @param width The width of the button
	 * @param height The height of the button
	 * @param theFont The font of the button text
	 * @param theListener The listener to trigger the button action
	 * @param theCP The content pane containing the button
	 * @return the JButton that this method constructs
	 */
    public static JButton makeButton(String text, int theX, int theY, int width, int height,
                                     Font theFont, ActionListener theListener, Container theCP){
        JButton toReturn = new JButton(text);
        toReturn.setLocation(theX, theY);
        toReturn.setSize(width, height);
        toReturn.setFont(theFont);
        toReturn.addActionListener(theListener);
        theCP.add(toReturn);
        return toReturn;
    }//8 parameter makeButton
    
    /**
     * Constructs a 6 parameter JLabel
     * @param text The text of the label
     * @param x The x coordinate of the label
     * @param y The y coordinate of the label
     * @param w The width of the label
     * @param h The height of the label
     * @param theCP The content pane containing the label
     * @return Returns the label this method constructs
     */
	public static JLabel makeLabel(String text, int x, int y, int w, int h, Container theCP){
		JLabel labelToReturn = new JLabel(text, JLabel.CENTER);
		labelToReturn.setLocation(x, y);
		labelToReturn.setSize(w, h);
		theCP.add(labelToReturn);
		return labelToReturn;
	}//makeLabel
	
	/**
	 * Resets label text to black
	 * @param theLabel The label to be reset
	 */
	public static void resetLabel(JLabel theLabel) {
		theLabel.setForeground(Color.BLACK);
	}//reset labels
	
	/**
	 * Resets text field to an empty string
	 * @param theTF The text field to be reset
	 */
	public static void resetTF(JTextField theTF) {
		theTF.setText("");
	}//reset text fields

	/**
	 * Constructs a 6 parameter JComboBox
	 * @param theEntries An array of Strings for the combo box to display
	 * @param theX The x coordinate of the box
	 * @param theY They y coordinate of the box
	 * @param theWidth The width of the box
	 * @param theHeight The height of the box
	 * @param theCP The content pane containing the box
	 * @return Returns the comboBox being constructed
	 */
	public static JComboBox makeComboBox(String[] theEntries, int theX, int theY, 
			int theWidth, int theHeight, Container theCP) {
		JComboBox toReturn = new JComboBox(theEntries);
		toReturn.setSize(theWidth, theHeight);
		toReturn.setLocation(theX,theY);
		theCP.add(toReturn);
		return toReturn;
	}//makeComboBox

	/**
	 * Constructs a vertical scroll pane for a text area
	 * @param theClient The text area for the scroll pane
	 * @param x The x coordinate of the scroll pane
	 * @param y The y coordinate of the scroll pane
	 * @param w The width of the scroll pane
	 * @param h The height of the scroll pane
	 * @param theCP The content pane containing the scroll pane
	 * @return Returns the scroll pane being constructed
	 */
	public static JScrollPane makeScrollPane(JTextArea theClient, int x, int y, int w, int h, Container theCP){
		JScrollPane scrollPaneToReturn = new JScrollPane(theClient,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneToReturn.setLocation(x, y);
		scrollPaneToReturn.setSize(w, h);
		theCP.add(scrollPaneToReturn);
		return scrollPaneToReturn;
	}//makeLabel
	
	/**
	 * Constructs a 6 parameter text field
	 * @param text Text to go in the text field
	 * @param x The x coordinate of the text field
	 * @param y The y coordinate of the text field
	 * @param w The width of the text field
	 * @param h The height of the text field
	 * @param theCP The content pane containing the text field
	 * @return Returns the JTextField being constructed
	 */
	public static JTextField makeTextField(String text, int x, int y, int w, int h, Container theCP){
		JTextField textFieldToReturn = new JTextField(text);
		textFieldToReturn.setLocation(x, y);
		textFieldToReturn.setSize(w, h);
		theCP.add(textFieldToReturn);
		return textFieldToReturn;
	}//makeTextField 
	
	/**
	 * Constructs an 8 parameter text field
	 * @param theText The text to go in the text field
	 * @param theX The x coordinate of the text field
	 * @param theY the y coordinate of the text field 
	 * @param theWidth The width of the text field
	 * @param theHeight The height of the text field
	 * @param thefont The font of the text in the text field
	 * @param editability Boolean value to enable or disable the editability of the text field.
	 * @param theCP The content pane holding the text field being constructed
	 * @return Returns the JTextField being constructed
	 */
    public static JTextField makeTextField(String theText,  int theX, int theY,int theWidth, int theHeight,
                                           Font thefont, boolean editability, Container theCP){
        JTextField textFieldToReturn = new JTextField(theText);
        textFieldToReturn.setSize(theWidth, theHeight);
        textFieldToReturn.setLocation(theX, theY);
        textFieldToReturn.setFont(thefont);
        textFieldToReturn.setEditable(editability);
        theCP.add(textFieldToReturn);
        return textFieldToReturn;
    }//makeTextField
    
	/**
	 * Constructs a 7 parameter JTextArea with a vertical scroll bar
	 * @param theText The text to go in the text area
	 * @param theX The x coordinate of the text area
	 * @param theY the y coordinate of the text area 
	 * @param theWidth The width of the text area
	 * @param theHeight The height of the text area
	 * @param editable Boolean value to enable or disable the editability of the text area.
	 * @param theCP The content pane holding the text area being constructed
	 * @return Returns the JTextArea being constructed
	 */
	public static JTextArea makeTextAreaWithScrollPane(String theText, int theX, int theY, 
			int theWidth, int theHeight, boolean editable, Container theCP){
		JTextArea toReturn = new JTextArea (theText);
		JScrollPane theSP = 
			new JScrollPane(toReturn,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		theSP.setLocation(theX,theY);
		theSP.setSize(theWidth,theHeight);
		toReturn.setEditable(editable);
		theCP.add(theSP); 
		return toReturn;
	}//makeTextAreaWithScrollPane
    
	/**
	 * Constructs a 7 parameter JTextArea
	 * @param theText The text to be in the text area
	 * @param x The x coordinate of the text area
	 * @param y The y coordinate of the text area
	 * @param w The width of the text area
	 * @param h The height of the text area
	 * @param editable Boolean value to enable or disable the editability of the text area.
	 * @param theCP The content pane holding the text area being constructed
	 * @return Returns the JTextArea being constructed
	 */
    public static JTextArea makeTextArea(String theText, int x, int y, int w, int h, boolean editable, Container theCP) {
    	JTextArea textAreaToReturn = new JTextArea(theText);
    	textAreaToReturn.setLocation(x, y);
		textAreaToReturn.setSize(w, h);
		textAreaToReturn.setEditable(editable);
		theCP.add(textAreaToReturn);
		return textAreaToReturn;
    }//makeTextArea
    
    /**
     * Method to exit the program upon closing the window
     * @param theWindow The window that exits the program upon closing
     */
	public static void closingCausesExit(JFrame theWindow) {
		theWindow.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}//windowClosing
		}); //end of definition of WindowAdapter and semicolon to end the line
	}//closingCausesExit

}//UtilityMethods
