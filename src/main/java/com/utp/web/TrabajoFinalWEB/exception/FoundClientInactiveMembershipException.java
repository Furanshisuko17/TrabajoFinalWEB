package com.utp.web.TrabajoFinalWEB.exception;

public class FoundClientInactiveMembershipException extends Exception {
	
	static final long serialVersionUID = -3387516993124229948L;
	
	public FoundClientInactiveMembershipException() {
        super();
    }

    public FoundClientInactiveMembershipException(String message) {
        super(message);
    }

}
