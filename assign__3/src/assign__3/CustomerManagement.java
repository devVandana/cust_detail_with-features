package assign__3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CustomerManagement {
    
	//Declaring ArrayList and customer String
		ArrayList<cust> customersList;
		String customerString= "";
		
		//Creating object of current (this) ArrayList for the current customer
		 public CustomerManagement() {
		        this.customersList = new ArrayList<>();
		    }

		    public boolean addCustomerToList(cust cstmr) {
		    	//Parsing through the customer list to check for same ID
		        for (cust customer : customersList) {
		            if (cstmr.getCustomerId() == customer.getCustomerId()) {
		                JOptionPane.showMessageDialog(null, "Sorry!TRY AGAIN AS THIS ID ALREADY EXIST");
		                return false;
		            }
		        }
		        //Adding customer if no existing same ID found
		        customersList.add(cstmr);
		        return true;
		    }

		    public boolean findCustomerToList(int c) {

		        boolean found = false;
		        //Parsing through the list to find existing customer by matching ID
		        for (cust customer : customersList) {
		            if (customer.getCustomerId() == c) {
		                found = true;
		                //Displaying the customer object details in message box if found
		                JOptionPane.showMessageDialog(null, customer.toString());
		                return true;
		            }

		        }
		        //If not found, indicated using variable found send message box with the required message
		        if (!found) {
		            JOptionPane.showMessageDialog(null, "Customer ID " + c + " does not exist");
		        }
		        return false;
		    }

		    public void modifyCustomerToList(int c, String name, String phone, String email, String postalCode) {
		    	//Using the find logic to search for customer 
		        boolean found = false;
		        cust customer;
		        for (int i = 0; i < customersList.size(); i++) {
		            customer = customersList.get(i);
		            if (customer.getCustomerId() == c) {
		                found = true;
		                //update values using setters 
		                customer.setCustomerName(name);
		                customer.setCustomerPhone(phone);
		                customer.setCustomerEmail(email);
		                customer.setCustomerPostalCode(postalCode);
		                //updating customer list
		                customersList.set(i, customer);
		                JOptionPane.showMessageDialog(null, "Updated");

		            }
		        }
		        //Displaying Message if not found
		        if (!found) {
		            JOptionPane.showMessageDialog(null, "Customer ID " + c + " does not exist");
		        }
		    }

		    public void deleteCustomer(int c) {
		    	//Using Found logic to find the customer using ID
		        boolean found = false;
		        cust customer;
		        for (int i = 0; i < customersList.size(); i++) {
		            customer = customersList.get(i);
		            if (customer.getCustomerId() == c) {
		            	//Removing customer if found
		                customersList.remove(customer);
		                JOptionPane.showMessageDialog(null, "INFORMATION DELETED");

		            }
		        }
		        //Message if not found
		        if (!found) {
		            JOptionPane.showMessageDialog(null, "Customer ID " + c + " does not exist");
		        }
		    }

		    public String DisplayCustomers() {
		    	//Clearing customer string of any previous record
		    	customerString = "";
		        for (cust customer : customersList) {
		            //JOptionPane.showMessageDialog(null, customer.toString() + "\n");
		        	//Adding customer object details from customerList to customer string
		            customerString +=  customer.toString() + "\n";
		        }
		        //returning the string to display in text area
		       return customerString;
		    }

		    public void writeToTextFile() {
		        try {
		        	//Creating file Writer object and giving source
		            FileWriter myWriter = new FileWriter("src/CDetails.txt");
		            
		            //Parsing through customer list and adding all the atrributes to the file for each object
		            for (cust customer : customersList) {
		                myWriter.write("\n"+customer.getCustomerId() + "," + customer.getCustomerName() + "," + customer.getCustomerPhone() + "," + customer.getCustomerEmail() + "," + customer.getCustomerPostalCode());
		            }
		            //Closing file
		            myWriter.close();
		            JOptionPane.showMessageDialog(null, "SUCCESS!! AS INFORMATION HAS BEEN WRITTEN IN FILE");

		        } catch (IOException e) {
		            System.out.println("An error occurred.");
		            e.printStackTrace();
		        }
		    }


}
