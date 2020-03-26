/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analysis;

import java.util.ArrayList;
public class systemclass {

      
    
    public static void Refresh(int no) {
        
      
        ArrayList obj =new ArrayList();
        obj=M1(no);
        String[] set1= obj.get(0).toString().split("#");
        String[] set2= obj.get(1).toString().split("#");
        String[] set3= obj.get(2).toString().split("#");
        String[] set4= obj.get(3).toString().split("#");
        String[] set5= obj.get(4).toString().split("#");
        
        chk1.FoodTP = Double.parseDouble(set1[0]);
        chk1.FoodFP = Double.parseDouble(set1[1]);
        chk1.FoodFN = Double.parseDouble(set1[2]);
        
         chk1.ServiceTP = Double.parseDouble(set2[0]);
        chk1.ServiceFP = Double.parseDouble(set2[1]);
        chk1.ServiceFN = Double.parseDouble(set2[2]);
        
         chk1.AmbTP = Double.parseDouble(set3[0]);
        chk1.AmbFP = Double.parseDouble(set3[1]);
        chk1.AmbFN = Double.parseDouble(set3[2]);
        
         chk1.PriceTP = Double.parseDouble(set4[0]);
        chk1.PriceFP = Double.parseDouble(set4[1]);
        chk1.PriceFN = Double.parseDouble(set4[2]);
        
         chk1.MiscTP = Double.parseDouble(set5[0]);
        chk1.MiscFP = Double.parseDouble(set5[1]);
        chk1.MiscFN = Double.parseDouble(set5[2]);
        
    }
    
    public static ArrayList M1(int m)
    {
       ArrayList A1=new ArrayList();
    //TF
       if(m==1){
       A1.add("259#65#57");
       A1.add("211#89#84");
       A1.add("90#40#44");
       A1.add("64#25#26");
       A1.add("32#11#12");}
      //CC
       if(m==4){
       A1.add("295#36#27");
       A1.add("252#43#40");
       A1.add("122#30#28");
       A1.add("82#18#19");
       A1.add("61#14#15");}
       
       //CC
       if(m==5){
       A1.add("260#49#50");
       A1.add("229#75#77");
       A1.add("96#61#58");
       A1.add("60#38#29");
       A1.add("60#16#13");}
      
       if(m==6){
       A1.add("265#46#40");
       A1.add("250#51#43");
       A1.add("95#46#41");
       A1.add("59#30#32");
       A1.add("50#13#15");}
       if(m==7){
       A1.add("265#46#40");
       A1.add("250#51#43");
       A1.add("95#46#41");
       A1.add("59#30#32");
       A1.add("61#12#16");} 
       return A1;
    } 
}  
