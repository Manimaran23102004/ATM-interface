import java.io.*;
class atm{
    int p=1234;    //sample password
    String check;
    boolean a=true;
    double currentAmount=5000;
    double dAmount=0;
    double bal=0;
    String rec;

    void Receipt(){
        System.out.println("Receipt Print !! Take it...");
    }

    void checkBalance()throws Throwable{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            int Password;
                System.out.println("Enter password : ");
                Password=Integer.parseInt(in.readLine());
                bal = currentAmount + dAmount;

                if(Password == p){
                    System.out.println("Your Balance Is : "+bal);
                    
                    System.out.println("You want to print Receipt (Yes) or (No)");
                    rec=in.readLine().toLowerCase();
                        if(rec.equals("yes")){
                            Receipt();
                        }
                        else{
                            System.out.println("Thank you!!");
                        }
                }
                else{
                    System.out.println("Password Incorrect");
                }
    }
    void Deposite(double damount)throws Throwable{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            currentAmount+=damount;
            System.out.println("Deposited Successfully");
            
            System.out.println("You want to print Receipt (Yes) or (No)");
            rec=in.readLine().toLowerCase();
                
            if(rec.equals("yes")){
                Receipt();
            }
            else{
                System.out.println("Thank you!!");
            }  
    
    }
    void WithDraw(double amount)throws Throwable{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            if((amount<currentAmount) && (currentAmount>=1000)){
                currentAmount-=amount;
                System.out.println("Your have been WithDraw : "+amount);
                
                System.out.println("You want to print Receipt (Yes) or (No)");
                rec=in.readLine().toLowerCase();
                    if(rec.equals("yes")){
                        Receipt();
                    }
                    else{
                        System.out.println("Thank you!!");
                    }  
            }   
            else{
                System.out.println("You have lesser amount of the account balance...");
            }
    } 
   
}
public class atmMachine{
    public static void main(String arg[])throws Throwable{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        atm a=new atm();
        int choice;
        boolean continueLoop=true;
        while(continueLoop){
            System.out.println("1.Check Balance");
            System.out.println("2.Deposite Amount");
            System.out.println("3.WithDraw Amount");
            System.out.println("4.Exit");
            choice=Integer.parseInt(in.readLine());
                switch (choice){
                    case 1:
                        a.checkBalance();
                        break;           
                    case 2:
                        double depAmount;
                        System.out.println("Enter amount");
                        depAmount=Double.parseDouble(in.readLine());
                        a.Deposite(depAmount);  
                            
                        break;
                    case 3:
                        double amount;
                        System.out.println("Enter amount");
                        amount=Double.parseDouble(in.readLine());
                        a.WithDraw(amount);
                        
                        break;
                    case 4:
                        System.out.println("Thanks for using ATM!!");
                        continueLoop=false;
                        break;
                    default:
                        System.out.println("Enter correct choice");
                        break;
                    }
        }
    }
}