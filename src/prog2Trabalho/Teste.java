package prog2Trabalho;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.facom.algoprog2.prog2Trabalho.model.Paciente;

public class Teste {

	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new FileReader("entrada.txt"));
		String linha = br.readLine();
		int size = 0;
		
		while(linha!=null)
			size++;
		ListaDePrioridadePaciente lista = new ListaDePrioridadePaciente();
		while(linha!=null){
			String[] vals = linha.split("[ \t]");
			
			String acao = vals[0];
			String cpf = vals[1];
			String nome = vals[2]+" "+vals[3];
			int grau = Integer.parseInt(vals[4]);
			
			Paciente p = new Paciente(nome, cpf, grau);
			
			lista.insere(p);
			
			
			
			
		}
		lista.exibir();
		

	}

}
	