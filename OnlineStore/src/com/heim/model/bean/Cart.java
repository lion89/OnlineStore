package com.heim.model.bean;

import java.util.ArrayList;

public class Cart {
	
	private ArrayList<String> name = new ArrayList<String>();
	private ArrayList<Integer> number = new ArrayList<Integer>();
	
	public void addNameNumber(String na,int nu){
		if(name.isEmpty()){
			this.name.add(na);
			this.number.add(nu);
		}else {
//			for(int i=0;i<name.size();i++){
//				if(name.get(i).equals(na)){
//					number.set(i, number.get(i)+nu);
//					break;
//				}
//				if(i==name.size()-1){
//					this.name.add(na);
//					this.number.add(nu);
//				}
//			}
			int i=-1;
			do {
				i++;
				if(i==name.size()){
					this.name.add(na);
					this.number.add(nu);
					break;
				}
				if(name.get(i).equals(na)){
					number.set(i, number.get(i)+nu);
					break;
				}
				
			} while (i<name.size());
		}
			
			
		System.out.println(name.size());
		
	}
	
	public String getName(int index){
		return this.name.get(index);
	}
	
	public int getNumber(int index){
		return this.number.get(index);
	}
	
	public int getSize(){
		return name.size();
	}
	
	

}
