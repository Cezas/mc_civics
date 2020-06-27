package me.civics.governments;

import java.util.HashMap;
import java.util.Map;


public class GovernmentCatalog {
	public static Map<String,Government> governments = new HashMap<String,Government>(){
		/**
		 * 
		 */
		private static final long serialVersionUID = -6105533073894581924L;

		{
			put("Autocracy", new Autocracy());
		}
	};
}
