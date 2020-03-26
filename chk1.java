package Analysis;

import SentimentProcess.Dbconn;
import static SentimentProcess.ProcessComments.val;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class chk1 {
   
    public static double AmbTP=0.0;
    public static double AmbFN=0.0;
    public static double AmbFP=0.0;
    public static double AmbTN=0.0;
    
     
    public static double FoodTP=0.0;
    public static double FoodFN=0.0;
    public static double FoodFP=0.0;
     public static double FoodTN=0.0;
     
      public static double MiscTP=0.0;
    public static double MiscFN=0.0;
    public static double MiscFP=0.0;
     public static double MiscTN=0.0;
     
      public static double PriceTP=0.0;
    public static double PriceFN=0.0;
    public static double PriceFP=0.0;
     public static double PriceTN=0.0;
     
      public static double ServiceTP=0.0;
    public static double ServiceFN=0.0;
    public static double ServiceFP=0.0;
     public static double ServiceTN=0.0;

    public static double TotalA=0;
     public static double TotalB=0;
      public static double TotalC=0;
 public static double TotalD=0;
     public static double TotalE=0;
       
      public static void main(String args[]) throws IOException
      {
        br();
      }
      
      
      
      public static void br() throws IOException{
      try
      {
          //val=4;
          Dbconn db =new Dbconn();
            Connection con=db.conn();
            Statement st = con.createStatement();
            st.executeQuery("select * from reviewtest");
            ResultSet rs = st.getResultSet();
             while (rs.next()) {
                String Acutal =rs.getString("aspect").replaceAll("\\s+", "");
                 String weightedaspect="";
                if(val==1)
                     weightedaspect =rs.getString("tfaspect").replaceAll("\\s+", "");
                    else if(val==2)
                          weightedaspect =rs.getString("tfcoaspect").replaceAll("\\s+", "");
                         else if(val==3)
                               weightedaspect =rs.getString("weightedAspect").replaceAll("\\s+", "");
                             else  if(val==4)
                                     weightedaspect =rs.getString("weightedcoaspect").replaceAll("\\s+", "");
                                else
                                     weightedaspect =rs.getString("dpaspect").replaceAll("\\s+", "");
                if(Acutal.equalsIgnoreCase("ambiance"))
                {
                    TotalA=TotalA+1;
                     if(weightedaspect.equalsIgnoreCase("ambiance")) 
                    {
                        AmbTP= AmbTP+1;
                    }
                    else if (weightedaspect.equalsIgnoreCase("food") || weightedaspect.equalsIgnoreCase("service") ||weightedaspect.equalsIgnoreCase("price") ||weightedaspect.equalsIgnoreCase("miscellaneous") || weightedaspect.equalsIgnoreCase("anecdotes/miscellaneous")) 
                    { 
                        AmbFN= AmbFN+1;
                    }
                  
                }
         
            //*****
                 if(Acutal.equalsIgnoreCase("food"))
                {
                     TotalB=TotalB+1;
                     if(weightedaspect.equalsIgnoreCase("food")) 
                    {
                        FoodTP= FoodTP+1;
                    }
                    else if (weightedaspect.equalsIgnoreCase("ambiance") || weightedaspect.equalsIgnoreCase("service") ||weightedaspect.equalsIgnoreCase("price") || weightedaspect.equalsIgnoreCase("anecdotes/miscellaneous")) 
                    { 
                        FoodFN= FoodFN+1;
                    }
                  
                }
              //*****
                 if(Acutal.equalsIgnoreCase("price"))
                {
                     TotalD=TotalD+1;
                     if(weightedaspect.equalsIgnoreCase("price")) 
                    {
                        PriceTP= PriceTP+1;
                    }
                    else if (weightedaspect.equalsIgnoreCase("ambiance") || weightedaspect.equalsIgnoreCase("service") ||weightedaspect.equalsIgnoreCase("food") ||weightedaspect.equalsIgnoreCase("miscellaneous") || weightedaspect.equalsIgnoreCase("anecdotes/miscellaneous")) 
                    { 
                        PriceFN= PriceFN+1;
                    }
                  
                }
                //*****
                 if(Acutal.equalsIgnoreCase("miscellaneous")|| Acutal.equalsIgnoreCase("anecdotes/miscellaneous") )
                {
                     TotalC=TotalC+1;
                     if(weightedaspect.equalsIgnoreCase("miscellaneous") || weightedaspect.equalsIgnoreCase("anecdotes/miscellaneous")) 
                    {
                        MiscTP= MiscTP+1;
                    }
                    else if (weightedaspect.equalsIgnoreCase("ambiance") || weightedaspect.equalsIgnoreCase("service") ||weightedaspect.equalsIgnoreCase("food") ||weightedaspect.equalsIgnoreCase("price")) 
                    { 
                        MiscFN= MiscFN+1;
                    }
                  
                }
                  //*****
                 if(Acutal.equalsIgnoreCase("service"))
                {
                     TotalE=TotalE+1;
                     if(weightedaspect.equalsIgnoreCase("service")) 
                    {
                        ServiceTP= ServiceTP+1;
                    }
                    else if (weightedaspect.equalsIgnoreCase("ambiance") || weightedaspect.equalsIgnoreCase("miscellaneous") ||weightedaspect.equalsIgnoreCase("food") ||weightedaspect.equalsIgnoreCase("price") || weightedaspect.equalsIgnoreCase("anecdotes/miscellaneous")) 
                    { 
                        ServiceFN= ServiceFN+1;
                    }
                  
                }
                   
                   
   //***********************************************************************
                 if(Acutal.equalsIgnoreCase("ambiance") || Acutal.equalsIgnoreCase("miscellaneous")|| Acutal.equalsIgnoreCase("food")|| Acutal.equalsIgnoreCase("service") || weightedaspect.equalsIgnoreCase("anecdotes/miscellaneous"))
                {
                     if(weightedaspect.equalsIgnoreCase("price")) 
                    {
                        PriceFP= PriceFP+1;
                    }
                     
                }
             //****
                  if(Acutal.equalsIgnoreCase("price") || Acutal.equalsIgnoreCase("miscellaneous") || weightedaspect.equalsIgnoreCase("anecdotes/miscellaneous") || Acutal.equalsIgnoreCase("food")|| Acutal.equalsIgnoreCase("service"))
                {
                     if(weightedaspect.equalsIgnoreCase("ambiance")) 
                    {
                        AmbFP= AmbFP+1;
                    }
                     
                }
                //****
                  if(Acutal.equalsIgnoreCase("price") || Acutal.equalsIgnoreCase("ambiance")|| Acutal.equalsIgnoreCase("food")|| Acutal.equalsIgnoreCase("service"))
                {
                     if(weightedaspect.equalsIgnoreCase("miscellaneous") || weightedaspect.equalsIgnoreCase("anecdotes/miscellaneous")) 
                    {
                        MiscFP= MiscFP+1;
                    }
                     
                }
               //****
                  if(Acutal.equalsIgnoreCase("price") || Acutal.equalsIgnoreCase("ambiance")|| Acutal.equalsIgnoreCase("food")|| Acutal.equalsIgnoreCase("miscellaneous") || weightedaspect.equalsIgnoreCase("anecdotes/miscellaneous"))
                {
                     if(weightedaspect.equalsIgnoreCase("service")) 
                    {
                        ServiceFP= ServiceFP+1;
                    }
                     
                }
              //****
                  if(Acutal.equalsIgnoreCase("price") || Acutal.equalsIgnoreCase("ambiance")|| Acutal.equalsIgnoreCase("service")|| Acutal.equalsIgnoreCase("miscellaneous") || weightedaspect.equalsIgnoreCase("anecdotes/miscellaneous"))
                {
                     if(weightedaspect.equalsIgnoreCase("food")) 
                    {
                        FoodFP= FoodFP+1;
                    }
                     
                }
                 
             //*********************************************************************** TN
                 if(Acutal.equalsIgnoreCase("ambiance") || Acutal.equalsIgnoreCase("miscellaneous")|| Acutal.equalsIgnoreCase("food")|| Acutal.equalsIgnoreCase("service") || weightedaspect.equalsIgnoreCase("anecdotes/miscellaneous"))
                {
                     if(!weightedaspect.equalsIgnoreCase("price")) 
                    {
                        PriceTN= PriceTN+1;
                    }
                     
                }
             //****
                  if(Acutal.equalsIgnoreCase("price") || weightedaspect.equalsIgnoreCase("anecdotes/miscellaneous") || Acutal.equalsIgnoreCase("miscellaneous")|| Acutal.equalsIgnoreCase("food")|| Acutal.equalsIgnoreCase("service"))
                {
                     if(!weightedaspect.equalsIgnoreCase("ambiance")) 
                    {
                        AmbTN= AmbTN+1;
                    }
                     
                }
                //****
                  if(Acutal.equalsIgnoreCase("price") || Acutal.equalsIgnoreCase("ambiance")|| Acutal.equalsIgnoreCase("food")|| Acutal.equalsIgnoreCase("service"))
                {
                     if(!weightedaspect.equalsIgnoreCase("miscellaneous") || weightedaspect.equalsIgnoreCase("anecdotes/miscellaneous")) 
                    {
                        MiscTN= MiscTN+1;
                    }
                     
                }
               //****
                  if(Acutal.equalsIgnoreCase("price") || Acutal.equalsIgnoreCase("ambiance")|| Acutal.equalsIgnoreCase("food")|| Acutal.equalsIgnoreCase("miscellaneous") || weightedaspect.equalsIgnoreCase("anecdotes/miscellaneous"))
                {
                     if(!weightedaspect.equalsIgnoreCase("service")) 
                    {
                        ServiceTN= ServiceTN+1;
                    }
                     
                }
              //****
                  if(Acutal.equalsIgnoreCase("price") || weightedaspect.equalsIgnoreCase("anecdotes/miscellaneous") || Acutal.equalsIgnoreCase("ambiance")|| Acutal.equalsIgnoreCase("service")|| Acutal.equalsIgnoreCase("miscellaneous"))
                {
                     if(!weightedaspect.equalsIgnoreCase("food")) 
                    {
                        FoodTN= FoodTN+1;
                    }
                     
                }
                 
           }
         
    } catch(Exception ex){ System.out.println(ex);}
         
      systemclass.Refresh(val);
          System.out.println("***************");
          System.out.println(AmbTP);  System.out.println(AmbFN); System.out.println(AmbTN); System.out.println(AmbFP);
          System.out.println("***************");
          System.out.println(FoodTP);  System.out.println(FoodFN); System.out.println(FoodTN); System.out.println(FoodFP);
           System.out.println("***************");
          System.out.println(ServiceTP);  System.out.println(ServiceFN); System.out.println(ServiceTN); System.out.println(ServiceFP);
           System.out.println("***************");
            System.out.println(MiscTP);  System.out.println(MiscFN); System.out.println(MiscTN); System.out.println(MiscFP);
           System.out.println("***************");
            System.out.println(PriceTP);  System.out.println(PriceFN); System.out.println(PriceTN); System.out.println(PriceFP);
           System.out.println("***************");
           }
    
}
