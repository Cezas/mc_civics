package me.civics.policies;

import java.util.HashMap;
import java.util.Map;


public class PolicyCatalog {
	public static Map<String,PolicyCard> policies = new HashMap<String,PolicyCard>(){
		/**
		 * 
		 */
		private static final long serialVersionUID = 6564426429514659036L;
		{
		put("HorseLords",new HorseLords());
		}
	};
}
