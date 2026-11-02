package gui;

import businessLogic.BLFacade;
import businessLogic.BLFactory;
import dataAccess.Emaitza;

public class adapterMain {
	public static void main(String[] args) {
		boolean isLocal = true;
		BLFacade blFacade = new BLFactory().getBusinessLogicFactory(isLocal);

		Emaitza s = blFacade.isLogged("Aitor Fernandez", "aurrera"); 
		if (s != null) {
			
		    SellerTable st = new SellerTable(s.getSeller());
		    st.setVisible(true);
		}
	}
}
