package com.facom.algoprog2.prog2Trabalho.model;

public class Paciente {
	private String nome;
	private String cpf;
	private int grau;
	
	
	
	
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
	
	
	public static void main(String[] args) {
		Paciente p = new Paciente();
		p.setGrau(10);
		
	}
}
