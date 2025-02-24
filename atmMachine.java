import java.io.*;
class atm{
        int p=1234;
        String check;
        boolean a=true;
        double currentAmount=5000;
        double dAmount=0;
        double bal=0;
    void checkBalance()throws Throwable{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int Password;
            System.out.println("enter password : ");
            Password=Integer.parseInt(in.readLine());
            bal = currentAmount + dAmount;

        if(Password == p){
            System.out.println("Your Balance Is : "+bal);
        }
        else{
            System.out.println("Password Incorrect");
        }
    }
 void Deposite(double damount)throws Throwable{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    this.dAmount=damount;
    currentAmount+=dAmount;
    System.out.println("Deposited Successfully");
    System.out.println("you want to chect balance");
    check=in.readLine().toLowerCase();
    if(check!="yes"){
        checkBalance();
    }
    else{
        System.out.println("Thank you!!..");
    }
}
void WithDraw(double amount)throws Throwable{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    if((amount<currentAmount) && (currentAmount>1000)){
        currentAmount-=amount;
        System.out.println("Your have been WithDraw : "+amount);
    }
    else{
        System.out.println("the minimum balance must be 1000");
    }
    System.out.println("you want to chect balance");
    check=in.readLine().toLowerCase();
    if(check!="yes"){
        checkBalance();
    }
    else{
        System.out.println("Thank you!!..");
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
                String check;
                System.out.println("Enter amount");
                depAmount=Double.parseDouble(in.readLine());
                a.Deposite(depAmount);           
                break;
            case 3:
                double amount;
                System.out.println("Enter amount");
                amount=Double.parseDouble(in.readLine());
                a.WithDraw(amount);
                System.out.println("you want to chect balance");
                check=in.readLine().toLowerCase();
                if(check=="yes"){
                    a.checkBalance();                    
                }
                else{
                    System.out.println("Thank you!!..");
                    continueLoop=false;    
                }
                break;
            case 4:
                continueLoop=false;
                break;
            default:
                System.out.println("enter correct choice");
                break;
        }
    }
    }
}