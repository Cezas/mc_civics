package me.civics.listeners;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SubscriberCatalog {
	//map format is "ListenerName, playersForThisListener"
	public static Map<String,List<String>> subscriberlist = new HashMap<String,List<String>>();
	
	public static void addSubscriberToListener(String listener, String subscriber) {
		if (subscriberlist.get(listener).contains(subscriber) == false) {
			subscriberlist.get(listener).add(subscriber);
		}
	}
	
	public static void removeSubscriberToListener(String listener, String subscriber) {
		if (subscriberlist.get(listener).contains(subscriber) == true) {
			subscriberlist.get(listener).remove(subscriber);
		}
	}
	
}
