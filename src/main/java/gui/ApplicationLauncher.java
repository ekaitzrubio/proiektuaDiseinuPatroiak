package gui;

import java.awt.Color;
import java.util.Locale;
import javax.swing.UIManager;

import configuration.ConfigXML;
import businessLogic.BLFacade;
import businessLogic.BLFactory;

public class ApplicationLauncher {  
    
    public static void main(String[] args) {

        ConfigXML c = ConfigXML.getInstance();      
        Locale.setDefault(new Locale(c.getLocale()));
        
        MainGUI a = new MainGUI("");
        a.setVisible(true);

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            
            boolean isLocal = c.isBusinessLogicLocal();
            
            BLFacade appFacadeInterface = new BLFactory().getBusinessLogicFactory(isLocal);
            
            MainGUI.setBussinessLogic(appFacadeInterface);
            
        } catch (Exception e) {
            a.jLabelSelectOption.setText("Error: " + e.toString());
            a.jLabelSelectOption.setForeground(Color.RED);    
            
            System.out.println("Error in ApplicationLauncher: " + e.toString());
        }
    }
}