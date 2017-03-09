package com.facom.algoprog2.prog2Trabalho.model;

public class Paciente implements Comparable{
	private String nome;
	private String cpf;
	private int grau;
	
	
	
	
	public Paciente(String nome, String cpf, int grau) {
		
		this.nome = nome;
		this.cpf = cpf;
		this.grau = grau;
	}
	
	public int getGrau() {
		return grau;
	}
	public void setGrau(int grau) {
		this.grau = grau;
	}
	public String getNome() {
		return nome;
	}
	public String getCpf() {
		return cpf;
	}
	public int compareTo(Object o){
		Paciente p = (Paciente) o;
		if(getGrau()>p.getGrau())
			return 1;
		else{
			if(getGrau()<p.getGrau())
				return -1;
			else
				return 0;
			
		}
	}
	
	
}
