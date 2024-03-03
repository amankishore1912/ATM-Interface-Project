import java.util.*;

class User {
    float Balance;
    String userID = "amankishore"; 
    int Pin = 2324;

    public void checkUserID(){
        System.out.print("Enter the UserID: ");
        try(Scanner sc = new Scanner(System.in)){
            String ID = sc.nextLine();
            if(ID.equals(userID)){
                checkPin();
            }
            else{
                System.out.println("Please enter a valid UserID!");
                checkUserID();
            }
        }
    }

    public void checkPin() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the Pin: ");
            int enteredPin = sc.nextInt();
            System.out.println();
            if (enteredPin == Pin) {
                menu();
            } else {
                System.out.println("Invalid Pin, Try Again!");
                checkPin();
            }
        }
    }

    public void menu() {
        System.out.println("Enter the required choice: ");
        System.out.println("1. Check Account Balance");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Deposit Money");
        System.out.println("4. EXIT");

        try (Scanner sc = new Scanner(System.in)) {
            int opt = sc.nextInt();

            switch (opt) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    withdrawMoney();
                    break;
                case 3:
                    depositMoney();
                    break;
                case 4:
                    exit();
                    break;
                default:
                    System.out.println("Enter a Valid Option");
                    System.out.println();
                    menu();
                    break;
            }
        }
    }

    public void checkBalance() {
        System.out.println("Your Balance Amount is: " + Balance);
        System.out.println();
        menu();
    }

    public void withdrawMoney(){
        System.out.println("Enter the Amount to be withdrawn: ");
        try(Scanner sc = new Scanner(System.in)){
            float amt = sc.nextFloat();

            if(amt > Balance){
                System.out.println("You have insufficient balance in your account");
                System.out.println();
                menu();
            }
            else{
                Balance = Balance-amt;
                System.out.println("Withdrawl Successfull");
                System.out.println("Available Balance: "+Balance);
                System.out.println();
                menu();
            }
        }
    }

    public void depositMoney(){
        System.out.println("Enter the amount to be deposited: ");
        try(Scanner sc = new Scanner(System.in)){
            float amount = sc.nextFloat();
            Balance = Balance+amount;
            System.out.println("Amount deposited Successfully!");
            System.out.println("Available Balance: "+Balance);
            System.out.println();
            menu();
        }
    }

    public void exit(){
        System.exit(0);
    }
}

public class ATM_Machine {
    public static void main(String[] args) {
        User obj = new User();
        obj.checkUserID();
    }
}