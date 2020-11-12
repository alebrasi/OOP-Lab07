package it.unibo.oop.lab.nesting2;

import java.util.ArrayList;
import java.util.List;

public class OneListAcceptable<T> implements Acceptable<T> {

    private final List<T> list;
    
    public OneListAcceptable(List<T> list) {
        this.list = new ArrayList<>(list);
    }
    
	@Override
	public Acceptor<T> acceptor() {
		return new Acceptor<T>() {

			private int index;
		    
	        @Override
	        public void accept(T newElement) throws ElementNotAcceptedException {
	            if(indexIsInRange() && list.get(index).equals(newElement)) {
	                index++;
	            }else {
	                throw new ElementNotAcceptedException(newElement);
	            }
	        }
	        
	        private boolean indexIsInRange() {
	            return index < list.size(); 
	        }

	        @Override
	        public void end() throws EndNotAcceptedException {
	            if(indexIsInRange()) {
	                throw new EndNotAcceptedException();
	            }
	        }
			
		};
	}
}
