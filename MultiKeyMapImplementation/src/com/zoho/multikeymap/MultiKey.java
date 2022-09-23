//$Id$
package com.zoho.multikeymap;

import java.util.Arrays;

public class MultiKey<KEY> {
	

		private transient int hashCode;
	    private final KEY[] keys;


	    @SuppressWarnings("unchecked")
		public MultiKey(final KEY key1, final KEY key2) {
	    	this((KEY[]) new Object[] { key1, key2 });
	    }
	    

		@SuppressWarnings("unchecked")
		public MultiKey(final KEY key1, final KEY key2,final KEY key3) {
			this((KEY[]) new Object[] { key1, key2 ,key3});
	    }
	    

		@SuppressWarnings("unchecked")
		public MultiKey(final KEY key1, final KEY key2,final KEY key3,final KEY key4) {
			this((KEY[]) new Object[] { key1, key2 ,key3 ,key4});
	    }
	    

		@SuppressWarnings("unchecked")
		public MultiKey(final KEY key1, final KEY key2,final KEY key3,final KEY key4,final KEY key5) {
			this((KEY[]) new Object[] { key1, key2 ,key3, key4, key5});
	    }
		
		public MultiKey(final KEY[] keys) {
			super();
			this.keys=keys;
			calculateHashCode(keys);
		}
	    
	    
	    private void calculateHashCode(final KEY[] keys) {
	    	int total = 0;
            for (final KEY key : keys) {
                if (key != null) {
                    total ^= key.hashCode();
                }
            }
            this.hashCode = total%16;    
	     }

		
		public KEY[] getKeys() {
			return keys;
		}


		public int getHashCode() {
			return hashCode;
		}


		public void setHashCode(int hashCode) {
			this.hashCode = hashCode;
		}


		@Override
		public String toString() {
			return Arrays.toString(keys);
		}

		
		
		
	    
}
