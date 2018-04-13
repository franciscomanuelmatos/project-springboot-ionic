package com.franciscomanuelmatos.udemysb.domain.enums;

public enum ClientType {
	PHYSICALPERSON(1, "Physical Person"),
	JURIDICALPERSON(2, "Juridical Person");
	
	private Integer code;
	private String description;
	
	private ClientType(Integer code, String description) {
		this.code = code;
		this.description = description;
	}

	public int getCode() {
		return code;
	}
	
	public String getDescription() {
		return description;
	}
	
	public static ClientType toEnum(Integer code) throws IllegalArgumentException {
		if(code == null)
			return null;
		
		for(ClientType c : ClientType.values()) {
			if(code.equals(c.code))
				return c;
		}
		
		throw new IllegalArgumentException("Invalid id: " + code);
	}
}
