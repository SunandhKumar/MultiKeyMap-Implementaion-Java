//$Id$
package com.zoho.multikeymap;


public class MultiMainControl {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String args[]) {
		
		MultiKeyMap multimap=new MultiKeyMap();
		MultiKeyMap demo=new MultiKeyMap();
		MultiKey mk=new MultiKey(1,2);
		MultiKey<Integer> mk1=new MultiKey<Integer>(1,2,3);
		MultiKey mk2=new MultiKey("One","Two","Three","Four");
		MultiKeyMap mkm=MultiKeyMap.multiKeyMap();
		
		
		System.out.println(multimap.isEmpty());
		multimap.put("A","B","C",19);
		multimap.put(mk1,"Second");
		multimap.put(mk2,1);
		multimap.put(1,2,3,4,"FIVE");
		demo.put(mk,"First");
		demo.put("A","B","F","G","H","alpha");
		mkm.putAll(multimap);
		
		System.out.println(mkm.display());
		System.out.println(multimap.isEmpty());
		System.out.println(multimap.display());
		System.out.println("DEMO: "+demo.display());
		
		System.out.println(multimap.get(mk));
		System.out.println(multimap.get(mk1));
		System.out.println(multimap.get(mk2));
		System.out.println(multimap.get("A","B","C"));
		System.out.println(multimap.get(1,2,3,4));
		
		System.out.println(multimap.containsKey(mk));
		System.out.println(multimap.containsKeys(1, 2, 3));
		System.out.println(multimap.containsKeys(1, 8, 3));
		
		System.out.println(multimap.entrySet());
		multimap.removeMultiKey(mk1);
		//multimap.removeMultiKey(1,2);
		//multimap.removeMultiKey("A","B","F","G","H");
		multimap.removeAll(1,2);
		System.out.println(multimap.entrySet());
		System.out.println(multimap.keySet());
		
		multimap.putAll(demo);
		System.out.println(multimap.entrySet());
		
		multimap.clear();
		System.out.println(multimap.entrySet());
		
	}
	
}
