/*
 Isaac Yeow Ming 23049679
 Foo Jia Seng 23055155
 hello test
 */
import javax.swing.*;

public class CW2{
    public static void main(String[] args){
        while (true) {

        String currency;
        currency = JOptionPane.showInputDialog(null, "Please Insert Your Currency");
        
        double choose; 
        choose = Double.parseDouble(JOptionPane.showInputDialog(null, "Please Insert Your Exchange Amount"));
        
        double currencyPrice=0;

        if("SGD".equalsIgnoreCase(currency)){
            currencyPrice= choose *3.5098;
        }
        else if("USD".equalsIgnoreCase(currency)){
            currencyPrice= choose *4.7156;
        }
        else if("EUR".equalsIgnoreCase(currency)){
            currencyPrice= choose *5.1366;
        }
        else if("JPY".equalsIgnoreCase(currency)){
            currencyPrice= choose *0.0319;
        }

        double adminFee=0;
        if(currencyPrice <=2000.00){   
            adminFee = currencyPrice * 0.0025;
        } 
        else if(currencyPrice<=5000.00){
            adminFee = currencyPrice * 0.005;
        }
        else if(currencyPrice<=10000.00){
            adminFee = currencyPrice * 0.0075;
        }
        else if(currencyPrice>10000.00){
            adminFee = currencyPrice * 0.01;
        }

        double afterAdminPrice;
        afterAdminPrice = currencyPrice - adminFee;
        
       
        
        JOptionPane.showMessageDialog(null, "Total Amount Exchanged is RM"+ afterAdminPrice);
        JOptionPane.showMessageDialog(null, "Admin Fee has been deduted\nYour Admin Fee is RM"+ adminFee);
    }

        
    }
}
