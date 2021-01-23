package org.eclipse.viatra.coding;

public class Node {
    Object id;

    public Node(Object id) {
        this.id = id;
    }

    public Node() {

    }

    @Override
    public String toString(){
        return id.toString();
    }
    
    @Override
    public int hashCode() {
    	return id != null? id.hashCode() : super.hashCode();
    }

}
