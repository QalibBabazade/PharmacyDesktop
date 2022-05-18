/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.babazade.pharmacy.main;

import az.babazade.pharmacy.dao.DbHelper;
import java.sql.Connection;

/**
 *
 * @author qalib.babazade
 */
public class MainMethod {
    
    public static void main(String[] args) {
        try( Connection c = DbHelper.getConnection()){
           
            if(c != null){
                System.out.println("Ugurla qosulma");
            }else{
                System.out.println("Qosulma yoxdu");
            }
            
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
    }
    
}
