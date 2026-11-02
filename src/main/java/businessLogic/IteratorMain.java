package businessLogic;

import domain.Sale;

public class IteratorMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean isLocal = true;
		BLFacade blFacade = new BLFactory().getBusinessLogicFactory(isLocal);

		ExtendedIterator<Sale> it = blFacade.getSalesIterator(""); 
		Sale s;

		System.out.println("FROM LAST TO FIRST");
		it.goLast();
		while (it.hasPrevious()) {
		    s = it.previous();
		    System.out.println(s);
		}

		System.out.println("\nFROM FIRST TO LAST");
		it.goFirst();
		while (it.hasNext()) {
		    s = it.next();
		    System.out.println(s);
		}

	}

}
