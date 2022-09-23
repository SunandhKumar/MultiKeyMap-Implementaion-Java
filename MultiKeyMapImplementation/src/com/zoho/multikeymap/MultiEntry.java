//$Id$
package com.zoho.multikeymap;

public class MultiEntry<KEY,VALUE>{
	private MultiKey<KEY> key;
    private VALUE value;
    private MultiEntry<KEY,VALUE> next;
    
    public MultiEntry(MultiKey<KEY> key, VALUE value, MultiEntry<KEY,VALUE> next){
        this.key = key;
        this.value = value;
        this.next = next;
    }

	public MultiKey<KEY> getKey() {
		return key;
	}

	public void setKey(MultiKey<KEY> key) {
		this.key = key;
	}

	public VALUE getValue() {
		return value;
	}

	public void setValue(VALUE value) {
		this.value = value;
	}

	public MultiEntry<KEY,VALUE> getNext() {
		return next;
	}

	public void setNext(MultiEntry<KEY,VALUE> next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return key + "=" + value;
	}
    

    
    
}
