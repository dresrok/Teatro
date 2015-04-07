/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teatro;

import estructural.Teatro;
import vista.InterfazLogin;
import vista.InterfazPrincipal;

/**
 *
 * @author Paleox
 */
public class App {
  
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*Teatro teatro = new Teatro();
        InterfazPrincipal interfazPrincipal = new InterfazPrincipal(teatro);
        interfazPrincipal.setVisible(true);*/
        Teatro teatro = new Teatro();
        InterfazLogin interfazLogin = new InterfazLogin(teatro);
        interfazLogin.setVisible(true);
    }
    
}
