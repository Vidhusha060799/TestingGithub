package com.mph.view;

import java.util.List;
import java.util.Scanner;

import com.mph.controller.EmployeeController;
import com.mph.controller.EmployeeInterface;

public class MainClass {	
	
	public static void main(String[] args) {
    EmployeeInterface ec=new EmployeeController();
	Scanner sc=new Scanner(System.in);
	List elist=null;
    String input=null;
    System.out.println("Enter your Username");
    String un=sc.next();
    System.out.println("Enter your Password");
    String pw=sc.next();
    if(un.equals(pw)) 
    {
    //BiPredicate<String String>pred=(un,pw)->un.equals(pw);
    //if(pred.test(un,pw)){
    do
    {System.out.println("Please wait Loading");
    try
    {
    	Thread.sleep(3000);
    }
    catch(InterruptedException ie)
    {
    	ie.printStackTrace();
    }
    System.out.println("Enter your Choice");
    System.out.println("1.Add Employee");
    System.out.println("2.View Employee");
    System.out.println("3. Employee Name starts with v");
    System.out.println("4. Serialisation");
    System.out.println("5. Deserialisation");
    System.out.println("6.Procedure insert");
    System.out.println("7.Get ResultSet MetaData Info");
    System.out.println("8.RS forward only");
    System.out.println("9.RS Scroll insensitive");
    System.out.println("10.RS Scroll sensitive insert");
    System.out.println("11.RS Scroll sensitive update");
    System.out.println("12.Batch update");
    int choice=sc.nextInt();
    switch (choice)
    {
    case 1:
    {
    	elist = ec.addEmployee();
        break;
    }
    case 2:
    {
    	ec.viewEmployee(elist);
    	break;
    }
    case 3:
    {
    	ec.StartWithV(elist);
    	break;
    }
    case 4:
    {
    	ec.serialisation(elist);
    	break;
    	
    }
    case 5:
    {
    	ec.deserialisation(elist);
    	break;
    }
    case 6:
    {
    	ec.insertUsingProc();
    	break;
    }
    case 7:
    {
    	ec.rsmd();
    	break;
    }
    case 8:
    {
    	ec.type_forward_only_rs();
    }
    case 9:
    {
    	ec.type_scroll_insensitive_rs();
    }
    case 10:
    {
    	ec.type_scroll_sensitive_rs_insert();
    	}
    case 11:
    {
    	ec.type_scroll_sensitive_rs_update();
    	
    }
    case 12:
    {
    	ec.batchUpdate();
    }
    }
   
    System.out.println("Do you want to continue?If yes press Y or y");
    input = sc.next();
	} while(input.equals("Y")||input.equals("y"));
    System.out.println("System exited.....Thankyou for using the system");
    System.exit(0);
    }
else

	{System.out.println("User not found Exception");}

}
}
