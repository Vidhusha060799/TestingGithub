package com.mph.model;

import java.io.Serializable;

public class Salary implements Serializable {
private int basic;
private int hra;
private int da;
private int gross;
private int pf;
private int net;

public Salary() {
	super();
	// TODO Auto-generated constructor stub
}

public Salary(int basic, int hra, int da, int gross, int pf, int net) {
	super();
	this.basic = basic;
	this.hra = hra;
	this.da = da;
	this.gross = gross;
	this.pf = pf;
	this.net = net;
}

public int getBasic() {
	return basic;
}
public void setBasic(int basic) {
	this.basic = basic;
}
public int getHra() {
	return hra;
}
public void setHra(int hra) {
	this.hra = hra;
}
public int getDa() {
	return da;
}
public void setDa(int da) {
	this.da = da;
}
public int getPf() {
	return pf;
}
public void setPf(int pf) {
	this.pf = pf;
}

public int getGross() {
	return gross;
}

public void setGross(int basic,int hra,int da) {
	this.gross =basic+hra+da;
}

public int getNet() {
	return net;
}
public void setNet(int gross,int pf) {
	this.net = gross-pf;
}
@Override
public String toString() {
	return "Salary [basic=" + basic + ", hra=" + hra + ", da=" + da + ", gross=" + gross + ", pf=" + pf + ", net=" + net
			+ "]";
}


}
