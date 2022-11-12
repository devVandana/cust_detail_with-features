package assign__3;

import java.awt.BorderLayout;

import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.Font;

import javax.swing.*;

public class custgui extends javax.swing.JFrame {
	CustomerManagement customerManagementObject;
	String customerString;
	Boolean res = true;
	Boolean cres = true;
		
		public custgui() {
	        initComponents();
	        customerManagementObject = new CustomerManagement();
	    }
	   
		//creating method
	    private void initComponents() {

		// createing frame panel label butten text filed and text area	
	    	// setting in layout 
			    JFrame frame01 = new JFrame ("Customer");
			  //setting frame size
			    frame01.setSize(500,400);
			    
			    
			    JPanel one = new JPanel();  
		        JPanel two = new JPanel();
		        JPanel three = new JPanel();
		        JPanel four = new JPanel();
		        JPanel five = new JPanel();
		        one.setLayout (new GridLayout(5,2));
		        two.setLayout(new GridLayout(5,2));
		        
			    
			    JTextField ID = new JTextField(20);
		        JTextField Phone = new JTextField(20);
		        JTextField Email = new JTextField();
		        JTextField Name = new JTextField();
		        JTextField PostalCode = new JTextField();
		        JLabel CustomerID = new JLabel("Customer ID ");
		        JLabel CustomerName = new JLabel("Customer Name");
		        JLabel CustomerPostalCode = new JLabel("Customer Postal Code ");
		        JLabel CustomerPhone = new JLabel("Customer Phone");
		        JLabel CustomerEmail = new JLabel("Customer Email");
		        JButton Add = new JButton("Add");
		        JButton Find = new JButton("Find");
		        JButton Modify = new JButton("Modify");
		        JButton Display = new JButton("Display");
		        JButton Delete = new JButton("Delete");
		        JTextArea Area = new JTextArea(20,40);
		        
		        //setting font
		        CustomerID.setFont(new Font("Tahoma", Font.BOLD, 14));
		        CustomerName.setFont(new Font("Tahoma", Font.BOLD, 14));
		        CustomerPostalCode.setFont(new Font("Tahoma", Font.BOLD, 14));
		        CustomerPhone.setFont(new Font("Tahoma", Font.BOLD, 14));
		        CustomerEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		       
		        //adding elements to panel 
		        one.add(CustomerID);
		        two.add(ID);
		        one.add(CustomerName);
		        two.add(Name);
		        one.add(CustomerPostalCode);
		        two.add(PostalCode);
		        one.add(CustomerPhone);
		        two.add(Phone);
		        one.add(CustomerEmail);
		        two.add(Email);
		        four.add(Add);
		        four.add(Find);
		        four.add(Modify);
		        four.add(Display);
		        four.add(Delete);
		        five.add(Area);
		        
		        //adding panel to frame 
		        three.add(one);
		        three.add(two);
		        frame01.add(three, BorderLayout.NORTH);
		        frame01.add(four, BorderLayout.SOUTH);
		        frame01.add(five, BorderLayout.CENTER );
		       
		        Area.setEditable(true);
			    frame01.setVisible(true);
			    frame01.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   
			//Adding action listeners for each buttons using the anonymous block method.
			ActionListener b1 = new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					//Clearing the textArea and check is the fields are filled
					Area.setText("");
					res=true;
					cres=true;
					 if (ID.getText().isEmpty() || Name.getText().isEmpty() || Phone.getText().isEmpty() || Email.getText().isEmpty() || PostalCode.getText().isEmpty()) {
				         //Giving error if not all fields are filled.  Returning if not 
						 JOptionPane.showMessageDialog(null, "Please fill all input fields");
				            return;
				        }
				        int id = 0;
				        try {
				        	//parsing to int to check the input format is integer
				            id = Integer.parseInt(ID.getText());
				        } catch (NumberFormatException numberFormatException) {
				        	//throwing exception message for improper value
				            JOptionPane.showMessageDialog(null, numberFormatException.getMessage() + " ID input should be a number");
				            cres=false;
				        }
				        //fetching values from each field
				        String name = Name.getText();
				        String phone = Phone.getText();
				        String email = Email.getText();
				        String postalCode = PostalCode.getText();
				        
				        if(cres) {
				        //Creating new customer object with the values
					    cust cus = new cust(id, name, phone, email, postalCode);
				        
				        //check is the given id already exist
				        res = customerManagementObject.addCustomerToList(cus);
				        //if it doesnt exist giving success message and writing to file.
				        if(res) {
				        JOptionPane.showMessageDialog(null, "New Customer Added.");
				        customerManagementObject.writeToTextFile();
				        }
				        }
				        //Clearing each field.
				        ID.setText("");
				        Name.setText("");
				        Phone.setText("");
				        Email.setText("");
				        PostalCode.setText("");
				}
			};
			//adding action listener to the button
			Add.addActionListener(b1);
			
			ActionListener b2 = new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					//Clearing text are and checking if ID is empty
					Area.setText("");
					if (ID.getText().isEmpty()) {
			            JOptionPane.showMessageDialog(null, "Please fill Id input field");
			            return;
			        }
			        int id = 0;
			        //check for valid input format
			        try {
			            id = Integer.parseInt(ID.getText());
			        } catch (NumberFormatException numberFormatException) {
			            JOptionPane.showMessageDialog(null, numberFormatException.getMessage() + " ID input should be a number");

			        }
			        //finding the customer
			        customerManagementObject.findCustomerToList(id);
			        //clearing the fields.
			        ID.setText("");
			        Name.setText("");
			        Phone.setText("");
			        Email.setText("");
			        PostalCode.setText("");
				}
			};
			Find.addActionListener(b2);
			
			ActionListener b3 = new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					//Clearing text area and check if the fields are empty
					Area.setText("");
					 if (ID.getText().isEmpty() || Name.getText().isEmpty() || Phone.getText().isEmpty() || Email.getText().isEmpty() || PostalCode.getText().isEmpty()) {
				            JOptionPane.showMessageDialog(null, "Please fill all input fields");
				            return;
				        }
				        int id = 0;
				        try {
				            id = Integer.parseInt(ID.getText());
				        } catch (NumberFormatException numberFormatException) {
				            JOptionPane.showMessageDialog(null, numberFormatException.getMessage() + " ID input should be a number");

				        }
				        //Getting the values of each field
				        String name = Name.getText();
				        String phone = Phone.getText();
				        String email = Email.getText();
				        String postalCode = PostalCode.getText();
				        //modifying the customer object and list with the new values
				        customerManagementObject.modifyCustomerToList(id, name, phone, email, postalCode);
				       //Writing it to the file
				        customerManagementObject.writeToTextFile();
				        ID.setText("");
				        Name.setText("");
				        Phone.setText("");
				        Email.setText("");
				        PostalCode.setText("");
				}
			};
			Modify.addActionListener(b3);
			
			ActionListener b4 = new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					//clearing text area
					Area.setText("");
					//getting the string of all customer objects and their attributes 
					customerString = customerManagementObject.DisplayCustomers();
					//Display using the customer String on the Text Area
					Area.setText(customerString);
				}
			};
			Display.addActionListener(b4);
			
			ActionListener b5 = new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					//Checking if ID field is empty
					 if (ID.getText().isEmpty()) {
				            JOptionPane.showMessageDialog(null, "Please fill Id input field");
				            return;
				        }
				        int id = 0;
				        //Checing for input format
				        try {
				            id = Integer.parseInt(ID.getText());
				        } catch (NumberFormatException numberFormatException) {
				            JOptionPane.showMessageDialog(null, numberFormatException.getMessage() + " ID input should be a number");

				        }
				             //Deleteing the cutsomer using the given ID
				            customerManagementObject.deleteCustomer(id);
				        	ID.setText("");
				            Name.setText("");
				            Phone.setText("");
				            Email.setText("");
				            PostalCode.setText("");
				}
			};
			Delete.addActionListener(b5);  
		
	   }        
	               	
	public static void main(String args[]) {
		//creating gui object
	    new custgui();

	}
	}





