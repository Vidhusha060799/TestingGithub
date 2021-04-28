package com.mph.controller;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.mph.dao.EmployeeDao;
import com.mph.model.Employee;
import com.mph.model.Salary;


import com.mph.dao.EmployeeDao;

public class EmployeeController implements EmployeeInterface {
	Employee emp;
	Salary sal;
	List emplist = new ArrayList();
	EmployeeDao empdao = new EmployeeDao();
	public List addEmployee()
	{
	emp=new Employee();
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the Eid");
	int eno= sc.nextInt();
	emp.setEid(eno);
	System.out.println("Enter the name");
	String enam= sc.next();
	emp.setEname(enam);
	
	/*sal=new Salary();
	System.out.println("Enter the basic");
	int basic=sc.nextInt();
    sal.setBasic(basic);
    System.out.println("Enter the hra");
	int hra=sc.nextInt();
	sal.setHra(hra);
	System.out.println("Enter the da");
	int da=sc.nextInt();
    sal.setDa(da);
    System.out.println("Enter the pf");
	int pf=sc.nextInt();
    sal.setPf(pf); 
    sal.setGross(basic,hra,da);
    sal.setNet(sal.getGross(), pf);
    emp.setSalary(sal);*/
   // emplist.add(emp);
    empdao.insertEmp(emp);
    System.out.println(emp.getEid() + " " + emp.getEname() +" "+ "Successfully added");
	return emplist;
	}
	@Deprecated
	public void viewEmployee(List elist)
	{
	/*Iterator i= elist.iterator();
	while(i.hasNext())
	{
		System.out.println(i.next());
	}
			
	}*/
		empdao.viewEmp();
	//elist.forEach(emplist->System.out.println(emplist));
	
}
	public void insertUsingProc()
	{
		Employee e = new Employee();
		Scanner  sc = new Scanner(System.in);
		System.out.println("Enter the Eid");
		int eno = sc.nextInt();
		e.setEid(eno);
		System.out.println("Enter the Ename ");
		String enam = sc.next();
		e.setEname(enam);
		
		empdao.insertUsingProcedure(e);
	}
	public void rsmd()
	{
		empdao.rsmd();
	}
	@Override
	public void type_forward_only_rs() {
		empdao.type_forward_only_rs();
		
	}

	public void type_scroll_insensitive_rs()
	{
		empdao.type_scroll_insensitive_rs();
	}
	public void type_scroll_sensitive_rs_insert()
	{
		empdao.type_scroll_sensitive_rs_insert();
	}
	public void type_scroll_sensitive_rs_update()
	{
		empdao.type_scroll_sensitive_rs_update();
	}
	public void batchUpdate()
	{
		empdao.batchUpdate();
	}
public void StartWithV(List elist)
	{
		List name= (List) emplist.stream().filter(emp1->((Employee) emp1).getEname().startsWith("V")).collect(Collectors.toList());
		System.out.println(name);
	}
 public void serialisation(List elist)
 {
	 FileOutputStream fos =null ;
		ObjectOutputStream oos =null;
		try {
			fos= new FileOutputStream("myfile.txt");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(emp);
			
			System.out.println("Data successfully Serialized...");
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		finally {
			try {
				fos.close();
				oos.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
 }}
 public void deserialisation(List elist)
 
 {Employee emp = null;
	
	try (FileInputStream fis = new FileInputStream("myfile.txt");
			ObjectInputStream ois = new ObjectInputStream(fis)) {
		emp =(Employee)ois.readObject();
		fis.close();
		ois.close();
	} catch (ClassNotFoundException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println(emp.getEid());
System.out.println(emp.getEname());
System.out.println(emp.getSalary());


}
}