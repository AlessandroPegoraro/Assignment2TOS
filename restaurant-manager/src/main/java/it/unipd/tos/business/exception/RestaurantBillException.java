////////////////////////////////////////////////////////////////////
// Alessandro Pegoraro 1143562
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business.exception;

public class RestaurantBillException extends Exception {
	private String message;
	
	public RestaurantBillException(String error) {
		message=error;
	}
	
	public String getMessage() {
		return message;
	}
	
}
