//$Id$
package com.zoho.multikeymap;

import java.util.HashSet;
import java.util.Set;


public class MultiKeyMap< KEY, VALUE> {
	
	private MultiEntry<KEY,VALUE>[] table;
	
	
	@SuppressWarnings("unchecked")
	public MultiKeyMap() {
		table=new MultiEntry[16];
	}
	
	
	@SuppressWarnings("rawtypes")
	public static MultiKeyMap multiKeyMap(){
		return new MultiKeyMap<>();
	}


	public VALUE put(MultiKey<KEY> mk, VALUE value){
		
		MultiEntry<KEY,VALUE> entry= new MultiEntry<KEY, VALUE>(mk,value,null);
		int index=calculateHashCode(mk);
        if(table[index] == null){
            table[index] = entry;
        }
        else{
            MultiEntry<KEY, VALUE> previousNode = null;
            MultiEntry<KEY, VALUE> currentNode = table[index];
            while(currentNode != null){
            	if(currentNode.getKey().equals(mk)){
            		VALUE val=currentNode.getValue();
                    currentNode.setValue(value);
                    return val;
                }
                previousNode = currentNode;
                currentNode = currentNode.getNext();
            }
            if(currentNode == null)
                previousNode.setNext(entry);
        }
        return null;
	    
	 }
	
	 public VALUE put(KEY k1,KEY k2,KEY k3,KEY k4,KEY k5, VALUE value){
		 MultiKey<KEY> mk1=new MultiKey<KEY>(k1,k2,k3,k4,k5);
		 return this.put(mk1, value);
	 }
	 
	 public VALUE put(KEY k1,KEY k2,KEY k3,KEY k4, VALUE value){
		 MultiKey<KEY> mk1=new MultiKey<KEY>(k1,k2,k3,k4);
		 return this.put(mk1, value);
	 }
	 
	 public VALUE put(KEY k1,KEY k2,KEY k3, VALUE value){
		 MultiKey<KEY> mk1=new MultiKey<KEY>(k1,k2,k3);
		 return this.put(mk1, value);
	 }
	 
	 public VALUE put(KEY k1,KEY k2, VALUE value){
		 MultiKey<KEY> mk1=new MultiKey<KEY>(k1,k2);
		 return this.put(mk1, value);
	 }
	 
	 public void putAll(MultiKeyMap<KEY,VALUE> mkm) {
		 Set<MultiEntry<KEY,VALUE>> hash_Set = mkm.entrySet();
		 for(MultiEntry<KEY, VALUE> me:hash_Set) {
			 this.put(me.getKey(), me.getValue());
		 }
	 }
	 
	 
	 public VALUE get(MultiKey<KEY> mk){
	        VALUE value = null;
	        int index = calculateHashCode(mk);
	        MultiEntry<KEY, VALUE> entry = table[index];
	        while (entry != null){
	            if(entry.getKey().equals(mk)) {
	                value = entry.getValue();
	                break;
	            }
	            entry = entry.getNext();
	        }
	        return value;
	 }
	 
	 public VALUE get(KEY k1,KEY k2,KEY k3,KEY k4,KEY k5){
		 int index = calculateHashCode(k1,k2,k3,k4,k5);
	     MultiEntry<KEY, VALUE> entry = table[index];
	     while (entry != null){
	    	 if(this.isEqualKey(entry,k1,k2,k3,k4,k5)) {
	    		 return entry.getValue();
	    	 }
	    	 entry = entry.getNext();
	     }
		 return null;
	 }
	 
	 public VALUE get(KEY k1,KEY k2,KEY k3,KEY k4){
		 int index = calculateHashCode(k1,k2,k3,k4);
	     MultiEntry<KEY, VALUE> entry = table[index];
	     while (entry != null){
	    	 if(this.isEqualKey(entry,k1,k2,k3,k4)) {
	    		 return entry.getValue();
	    	 }
	    	 entry = entry.getNext();
	     }
		 return null;
	 }
	 
	 public VALUE get(KEY k1,KEY k2,KEY k3){
		 int index = calculateHashCode(k1,k2,k3);
	     MultiEntry<KEY, VALUE> entry = table[index];
	     while (entry != null){
	    	 if(this.isEqualKey(entry,k1,k2,k3)) {
	    		 return entry.getValue();
	    	 }
	    	 entry = entry.getNext();
	     }
	     
		 return null;
	 }
	 
	 public VALUE get(KEY k1,KEY k2){
		 int index = calculateHashCode(k1,k2);
	     MultiEntry<KEY, VALUE> entry = table[index];
	     while (entry != null){
	    	 if(this.isEqualKey(entry,k1,k2)) {
	    		 return entry.getValue();
	    	 }
	    	 entry = entry.getNext();
	     }
		 return null;
	 }
	 
	 public boolean containsKeys(KEY k1,KEY k2) {
		 int index = calculateHashCode(k1,k2);
	     MultiEntry<KEY, VALUE> entry = table[index];
	     while (entry != null){
	    	 KEY[] key=entry.getKey().getKeys();
	    	 if(key[0]==k1 && key[1]==k2) {
	    		 return true;
	    	 }
	    	 entry = entry.getNext();
	     }
		 return false;
		 
	 }
	 
	 public boolean containsKeys(KEY k1,KEY k2,KEY k3) {
		 int index = calculateHashCode(k1,k2,k3);
	     MultiEntry<KEY, VALUE> entry = table[index];
	     while (entry != null){
	    	 KEY[] key=entry.getKey().getKeys();
	    	 if(key[0]==k1 && key[1]==k2 && key[2]==k3) {
	    		 return true;
	    	 }
	    	 entry = entry.getNext();
	     }
		 return false;
		 
	 }
	 
	 public boolean containsKeys(KEY k1,KEY k2,KEY k3,KEY k4) {
		 int index = calculateHashCode(k1,k2,k3,k4);
	     MultiEntry<KEY, VALUE> entry = table[index];
	     while (entry != null){
	    	 KEY[] key=entry.getKey().getKeys();
	    	 if(key[0]==k1 && key[1]==k2 && key[2]==k3 && key[3]==k4) {
	    		 return true;
	    	 }
	    	 entry = entry.getNext();
	     }
		 return false;
		 
	 }
	 
	 public boolean containsKeys(KEY k1,KEY k2,KEY k3,KEY k4,KEY k5) {
		 int index = calculateHashCode(k1,k2,k3,k4,k5);
	     MultiEntry<KEY, VALUE> entry = table[index];
	     while (entry != null){
	    	 KEY[] key=entry.getKey().getKeys();
	    	 if(key[0]==k1 && key[1]==k2 && key[2]==k3 && key[3]==k4 && key[4]==k5) {
	    		 return true;
	    	 }
	    	 entry = entry.getNext();
	     }
		 return false;
		 
	 }
	 
	 public boolean containsKey(MultiKey<KEY> mk){
	        int index = calculateHashCode(mk);
	        MultiEntry<KEY, VALUE> entry = table[index];
	        while (entry != null){
	            if(entry.getKey().equals(mk)) {
	                return true;
	            }
	            entry = entry.getNext();
	        }
	        return false;
	 }

	 
	 public VALUE removeMultiKey(MultiKey<KEY> mk){
	        int index = calculateHashCode(mk);
	        MultiEntry<KEY, VALUE> previous = null;
	        MultiEntry<KEY, VALUE> current = table[index];
	        while (current != null){
	            if(current.getKey().equals(mk)){
	                if(previous == null){
	                	VALUE val=current.getValue();
	                    current = current.getNext();
	                    table[index] = current;
	                    return val;
	                }else {
	                	VALUE val=current.getValue();
	                    previous.setNext(current.getNext());
	                    return val;
	                }
	            }
	            previous = current;
	            current= current.getNext();
	        }
	        return null;
	    }
	 
	 public VALUE removeMultiKey(KEY k1,KEY k2){
		 int index = calculateHashCode(k1,k2);
	        MultiEntry<KEY, VALUE> previous = null;
	        MultiEntry<KEY, VALUE> current = table[index];
	        while (current != null){
	        	 if(this.isEqualKey(current,k1,k2)) {
	                if(previous == null){
	                	VALUE val=current.getValue();
	                    current = current.getNext();
	                    table[index] = current;
	                    return val;
	                }else {
	                	VALUE val=current.getValue();
	                    previous.setNext(current.getNext());
	                    return val;
	                }
	            }
	            previous = current;
	            current= current.getNext();
	        }
	        return null;
	 }
	 
	 public VALUE removeMultiKey(KEY k1,KEY k2,KEY k3){
		 int index = calculateHashCode(k1,k2,k3);
	        MultiEntry<KEY, VALUE> previous = null;
	        MultiEntry<KEY, VALUE> current = table[index];
	        while (current != null){
	        	 if(this.isEqualKey(current,k1,k2,k3)) {
	                if(previous == null){
	                	VALUE val=current.getValue();
	                    current = current.getNext();
	                    table[index] = current;
	                    return val;
	                }else {
	                	VALUE val=current.getValue();
	                    previous.setNext(current.getNext());
	                    return val;
	                }
	            }
	            previous = current;
	            current= current.getNext();
	        }
	        return null;
	 }
	 
	 public VALUE removeMultiKey(KEY k1,KEY k2,KEY k3,KEY k4){
		 int index = calculateHashCode(k1,k2,k3,k4);
	        MultiEntry<KEY, VALUE> previous = null;
	        MultiEntry<KEY, VALUE> current = table[index];
	        while (current != null){
	        	 if(this.isEqualKey(current,k1,k2,k3,k4)) {
	                if(previous == null){
	                	VALUE val=current.getValue();
	                    current = current.getNext();
	                    table[index] = current;
	                    return val;
	                }else {
	                	VALUE val=current.getValue();
	                    previous.setNext(current.getNext());
	                    return val;
	                }
	            }
	            previous = current;
	            current= current.getNext();
	        }
	        return null;
	 }
	 
	 public VALUE removeMultiKey(KEY k1,KEY k2,KEY k3,KEY k4,KEY k5){
		 int index = calculateHashCode(k1,k2,k3,k4,k5);
	        MultiEntry<KEY, VALUE> previous = null;
	        MultiEntry<KEY, VALUE> current = table[index];
	        while (current != null){
	        	 if(this.isEqualKey(current,k1,k2,k3,k4,k5)) {
	                if(previous == null){
	                	VALUE val=current.getValue();
	                    current = current.getNext();
	                    table[index] = current;
	                    return val;
	                }else {
	                	VALUE val=current.getValue();
	                    previous.setNext(current.getNext());
	                    return val;
	                }
	            }
	            previous = current;
	            current= current.getNext();
	        }
	        return null;
	 }
	 
	 public boolean removeAll(KEY k1) {
		 boolean bool=false;
		 for(int i = 0; i < 16; i++){
	           if(this.table[i] != null){
	                MultiEntry<KEY, VALUE> current = this.table[i];
	                while (current != null){
	                	KEY[] key=current.getKey().getKeys();
	                	if(key[0]==k1) {
		               		 this.removeMultiKey(current.getKey());
		               		 bool=true;
		               	}
	                    current = current.getNext();
	                }
	           }
	      }
		  return bool;
	 }
	 
	 public boolean removeAll(KEY k1,KEY k2) {
		 boolean bool=false;
		 for(int i = 0; i < 16; i++){
	           if(this.table[i] != null){
	                MultiEntry<KEY, VALUE> current = this.table[i];
	                while (current != null){
	                	KEY[] key=current.getKey().getKeys();
	                	if(key[0]==k1 && key[1]==k2) {
		               		 this.removeMultiKey(current.getKey());
		               		 bool=true;
		               	}
	                    current = current.getNext();
	                }
	           }
	      }
		  return bool;
	 }
	 
	 public boolean removeAll(KEY k1,KEY k2,KEY k3) {
		 boolean bool=false;
		 for(int i = 0; i < 16; i++){
	           if(this.table[i] != null){
	                MultiEntry<KEY, VALUE> current = this.table[i];
	                while (current != null){
	                	KEY[] key=current.getKey().getKeys();
	                	if(key[0]==k1 && key[1]==k2 && key[2]==k3) {
		               		 this.removeMultiKey(current.getKey());
		               		 bool=true;
		               	}
	                    current = current.getNext();
	                }
	           }
	      }
		  return bool;
	 }
	 
	 public boolean removeAll(KEY k1,KEY k2,KEY k3,KEY k4) {
		 boolean bool=false;
		 for(int i = 0; i < 16; i++){
	           if(this.table[i] != null){
	                MultiEntry<KEY, VALUE> current = this.table[i];
	                while (current != null){
	                	KEY[] key=current.getKey().getKeys();
	                	if(key[0]==k1 && key[1]==k2 && key[2]==k3 && key[3]==k4) {
		               		 this.removeMultiKey(current.getKey());
		               		 bool=true;
		               	}
	                    current = current.getNext();
	                }
	           }
	      }
		  return bool;
	 }
	 
	 public boolean isEqualKey(MultiEntry<KEY, VALUE> current,KEY k1,KEY k2) {
		 KEY[] key=current.getKey().getKeys();
    	 if(key[0]==k1 && key[1]==k2) {
    		 return true;
    	 }
		 return false;
	 }
	 
	 public boolean isEqualKey(MultiEntry<KEY, VALUE> current,KEY k1,KEY k2,KEY k3) {
		 KEY[] key=current.getKey().getKeys();
    	 if(key[0]==k1 && key[1]==k2 && key[2]==k3) {
    		 return true;
    	 }
		 return false;
	 }
	 
	 public boolean isEqualKey(MultiEntry<KEY, VALUE> current,KEY k1,KEY k2,KEY k3,KEY k4) {
		 KEY[] key=current.getKey().getKeys();
    	 if(key[0]==k1 && key[1]==k2 && key[2]==k3 && key[3]==k4) {
    		 return true;
    	 }
		 return false;
	 }
	 
	 public boolean isEqualKey(MultiEntry<KEY, VALUE> current,KEY k1,KEY k2,KEY k3,KEY k4,KEY k5) {
		 KEY[] key=current.getKey().getKeys();
    	 if(key[0]==k1 && key[1]==k2 && key[2]==k3 && key[3]==k4 && key[4]==k5) {
    		 return true;
    	 }
		 return false;
	 }
	 
	  public Set<MultiEntry<KEY,VALUE>> entrySet() {
		  Set<MultiEntry<KEY,VALUE>> hash_Set = new HashSet<>();
		  for(int i = 0; i < 16; i++){
	           if(this.table[i] != null){
	                MultiEntry<KEY, VALUE> currentNode = this.table[i];
	                while (currentNode != null){
	                    hash_Set.add(currentNode);
	                    currentNode = currentNode.getNext();
	                }
	           }
	      }
		  return hash_Set;
		
	  }
	 
	  public Set<MultiKey<KEY>> keySet() {
			Set<MultiKey<KEY>> hash_Set = new HashSet<>();
			for(int i = 0; i < 16; i++){
	            if(table[i] != null){
	                MultiEntry<KEY, VALUE> currentNode = table[i];
	                while (currentNode != null){
	                    hash_Set.add(currentNode.getKey());
	                    currentNode = currentNode.getNext();
	                }
	            }
	        }
			return hash_Set;
		}
	
	 public String display() {
		 String str="{";
			int f=0;
			for(int i = 0; i < 16; i++){
	            if(table[i] != null){
	                MultiEntry<KEY, VALUE> currentNode = table[i];
	                while (currentNode != null){
	                	if(f==0) {
	                		str+=currentNode.getKey()+"="+currentNode.getValue();
	                		f=1;
	                	}
	                	else {
	                		str+=", "+currentNode.getKey()+"="+currentNode.getValue();
	                	}
	                    currentNode = currentNode.getNext();
	                }
	            }
	        }
			str+="}";
			return str;
	 }
	 
	 public boolean isEmpty() {
			for(int i = 0; i < 16; i++){
	            if(table[i] != null){
	            	return false;
	            }
			}
			return true;
		}
		
	 public void clear() {
			for(int i = 0; i < 16; i++){
				if(table[i] != null)
					table[i] = null;
			}
		}
		
		
	public MultiKeyMap<MultiKey<KEY>,VALUE> clone() {
		return new MultiKeyMap<>();
	}
	
	public void checkKey(final MultiKey<KEY> mk) {
		if(mk==null) {
			throw new NullPointerException("Key must not be null");
		}
	}

	 
	 private int calculateHashCode(final MultiKey<KEY> mk) {
		 int total = 0;
         for (final KEY key : mk.getKeys()) {
            if (key != null) {
                 total ^= key.hashCode();
            }
         }
         //System.out.println(total%16);
         return total%16;
	 }
	 
	 private int calculateHashCode(KEY k1,KEY k2) {
		 int total = 0;
         if (k1 != null) {
               total ^= k1.hashCode();
         }
         if (k2 != null) {
             total ^= k2.hashCode();
         }
         //System.out.println(total%16);
         return total%16;
	 }
	 
	 private int calculateHashCode(KEY k1,KEY k2,KEY k3) {
		 int total = 0;
         if (k1 != null) {
               total ^= k1.hashCode();
         }
         if (k2 != null) {
             total ^= k2.hashCode();
         }
         if (k3 != null) {
             total ^= k3.hashCode();
         }
         //System.out.println(total%16);
         return total%16;
	 }
	 
	 private int calculateHashCode(KEY k1,KEY k2,KEY k3,KEY k4) {
		 int total = 0;
         if (k1 != null) {
               total ^= k1.hashCode();
         }
         if (k2 != null) {
             total ^= k2.hashCode();
         }
         if (k3 != null) {
             total ^= k3.hashCode();
         }
         if (k4 != null) {
             total ^= k4.hashCode();
         }
         //System.out.println(total%16);
         return total%16;
	 }
	 
	 private int calculateHashCode(KEY k1,KEY k2,KEY k3,KEY k4,KEY k5) {
		 int total = 0;
         if (k1 != null) {
               total ^= k1.hashCode();
         }
         if (k2 != null) {
             total ^= k2.hashCode();
         }
         if (k3 != null) {
             total ^= k3.hashCode();
         }
         if (k4 != null) {
             total ^= k4.hashCode();
         }
         if (k5 != null) {
             total ^= k5.hashCode();
         }
         //System.out.println(total%16);
         return total%16;
	 }
	 
}
