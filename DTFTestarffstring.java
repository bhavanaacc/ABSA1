 
package Analysis.arff.string;

import SentimentProcess.Dbconn;
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class DTFTestarffstring {
    
    public static int countID=1;
    public static String GetUniqueset(String[] input){
        StringBuilder sb=new StringBuilder();
  String[] name = input;
  Set<String> myset  = new HashSet<String>();
  Collections.addAll(myset,name);
  System.out.println(myset);
   sb.append(myset+",");
  return sb.toString();
          
    }
     public static void main(String[] str)
    {
        
            File file = new File("F:/arff1/DTFTestarffstring.arff");
        FileWriter writer=null;
        
     try {
         Dbconn db=new Dbconn();
            Connection con = null;
            con = db.conn();
            Statement stat =con.createStatement();
            stat.executeQuery("select * from reviewtest");
             writer = new FileWriter(file);
            ResultSet rs = null;
            rs = stat.getResultSet();
            int pj=0;
            writer.write("@relation 'AspectRelation'");
             writer.write("\n");
           writer.write("@attribute 'id' numeric");
          writer.write("\n");
           String[] part = getstr().split(",");
           String uniqset= GetUniqueset(part);
           writer.write("@attribute 'term' string");
             writer.write("\n");
            writer.write("@attribute 'aspect' {ambiance,price,service,anecdotes/miscellaneous,food}");
             writer.write("\n");
             writer.write("@data");
             writer.write("\n");
           while (rs.next()) {
             
               String parts=rs.getString(5).toLowerCase();
               String p1=   parts.replace(",", " ");
               String ss="";  
               ss=countID+",'"+p1+"',"+rs.getString(6);
               countID++;
               writer.write(ss);
               writer.write("\n");
               System.out.println(ss);
           }
          
           
        writer.close();
        } catch (Exception ex) {
            
            System.out.println(ex);
            
        }
    }
      public static String getstr()
    {
        StringBuilder sb=new StringBuilder();
       // sb.append("{");
  try
        { 
            Dbconn db = new Dbconn();
            com.mysql.jdbc.Connection con = (com.mysql.jdbc.Connection) db.conn();
            Statement st = (com.mysql.jdbc.Statement) con.createStatement();
            Statement st1 = (com.mysql.jdbc.Statement) con.createStatement();
            ResultSet rs = (ResultSet) st.executeQuery("select * from reviewtest");
        while (rs.next()) {
             String depe= rs.getString(5).toLowerCase();
             
          if(depe.equalsIgnoreCase("na")){}
else {sb.append(depe);}
        }
       //  sb.append("}");
        }
         catch (Exception ex)
        {
            System.out.println(ex);
        }
       return sb.toString();
    }
}
