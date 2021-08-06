/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.parking25;

import com.mycompany.parking25.views.View;
import java.util.logging.Level;
import java.util.logging.Logger;

public class main {
    public static void main(String[] args){
        
        try {
        View view = new View();
        view.show();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error");
        }
    }
}
