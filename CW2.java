/*
 Isaac Yeow Ming 23049679
 Foo Jia Seng 23055155
 hello test
 */
import javax.swing.*;

public class CW2{
    public static void main(String[] args){
        String currency;
        currency = JOptionPane.showInputDialog(null, "Please Insert Your Currency \n(SGD/USD/JPY/EUR)");
        double excRate = 0;
        String symbol= "$";

        

        double choose; 
        choose = Double.parseDouble(JOptionPane.showInputDialog(null, "Please Insert Your Exchange Amount (MYR)"));
        
        double adminFee=0;
        if(choose <=2000.00){
            
            adminFee = choose * 0.0025;
        } 
        else if(choose<=5000.00){
            adminFee = choose * 0.005;
        }
        else if(choose<=10000.00){
            adminFee = choose * 0.0075;
        }
        else if(choose>10000.00){
            adminFee = choose * 0.01;
        }

        double total=0;

        if("SGD".equalsIgnoreCase(currency)){
            symbol= "$";
            total= choose *0.28;
        }
        else if("USD".equalsIgnoreCase(currency)){
            total= choose *0.21;
            symbol= "$";
        }
        else if("EUR".equalsIgnoreCase(currency)){
            total= choose *0.20;
            symbol= "€";
        }
        else if("JPY".equalsIgnoreCase(currency)){
            total= choose *31.23;
            symbol= "¥";
        }
       
        JOptionPane.showMessageDialog(null, "Total Amount Exchanged is"+ symbol + total);
        JOptionPane.showMessageDialog(null, "Your Admin Fee is RM"+ adminFee);
        
        
    }
}
