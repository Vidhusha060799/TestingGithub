package com.mph.controller;

import java.util.List;

import com.mph.model.Employee;

public interface EmployeeInterface {
	public List addEmployee();
	public void viewEmployee(List elist);
	//public void EmployeeNameStarts();
	public void insertUsingProc();
	public void rsmd();
	public void type_forward_only_rs();
	public void type_scroll_insensitive_rs();
	public void type_scroll_sensitive_rs_insert();
	public void type_scroll_sensitive_rs_update();
	public void batchUpdate();
	public void StartWithV(List elist);
	public void serialisation(List elist);
	public void deserialisation(List elist);

}
