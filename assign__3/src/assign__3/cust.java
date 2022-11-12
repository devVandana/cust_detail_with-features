package assign__3;

public class cust {

	//Defining attributes of the customer
		private int customerId;
	    private String customerName;
	    private String customerPhone;
	    private String customerEmail;
	    private String customerPostalCode;
	    
	    //Default constructor
	    public cust() {
	    }
	    
	    //Parameterized constructor
	    public cust(int id, String name, String phone, String email, String postalCode) {
	        this.customerId = id;
	        this.customerName = name;
	        this.customerPhone = phone;
	        this.customerEmail = email;
	        this.customerPostalCode = postalCode;
	    }
	    
	    //getters and setters for each attribute
	    public String getCustomerPostalCode() {
	        return customerPostalCode;
	    }
	    
	    public void setCustomerPostalCode(String customerPostalCode) {
	        this.customerPostalCode = customerPostalCode;
	    }
	    
	    public String getCustomerEmail() {
	        return customerEmail;
	    }
	    
	    public void setCustomerEmail(String customerEmail) {
	        this.customerEmail = customerEmail;
	    }
	    
	    public String getCustomerPhone() {
	        return customerPhone;
	    }
	    
	    public void setCustomerPhone(String customerPhone) {
	        this.customerPhone = customerPhone;
	    }

	    public String getCustomerName() {
	        return customerName;
	    }
	    
	    public void setCustomerName(String customerName) {
	        this.customerName = customerName;
	    }
	    
	    public int getCustomerId() {
	        return customerId;
	    }
	    
	    public void setCustomerId(int customerId) {
	        this.customerId = customerId;
	    }
	    
	    //To string method to display the customers.
	    public String toString() {
	        return "Customer:" + "\n  " + "id=" + customerId + ", name=" + customerName + ", phone=" + customerPhone + ", email=" + customerEmail + ", postalCode=" + customerPostalCode;
	    }


}
