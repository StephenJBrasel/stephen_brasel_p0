package com.revature.revabank.models;

import java.util.Arrays;

public enum Role {
	ADMIN("Admin"){},
	MANAGER("Manager"){},
	CLERK("Clerk"){},
	PATRON("User"){},
	LOCKED("Locked"){}
	;

	private String type;

	Role(String type){
		this.type = type;
	}


	public static Role getByName(String name){
//
//		for (Role role : Role.values()) {
//			if(role.roleName.equals(name)){
//				return role;
//			}
//		}
//
//		return LOCKED;

		return Arrays.stream(Role.values())
				.filter(role -> role.type.equals(name))
				.findFirst()
				.orElse(LOCKED);
	}

	public static int getOrdinal(Role role){
		for (int i = 0; i < Role.values().length; i++) {
			if(Role.values()[i] == role) return i+1;
		}
		return getOrdinal(Role.LOCKED);
	}

	@Override public String toString(){
		return type;
	}

}
