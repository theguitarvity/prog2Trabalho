
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;



public class Teste {

	public static void main(String[] args) throws Exception {
		

		BufferedReader br = null;
		PrintStream ps = null;
		try {
			br = new BufferedReader(new FileReader("/home/victor/java/prog2/prog2Trabalho/src/entrada.txt"));
			ps = new PrintStream("/home/victor/java/prog2/prog2Trabalho/src/saida.txt");
			String linha = br.readLine();
			ListaDePrioridadePaciente lista = new ListaDePrioridadePaciente();

			while (linha != null) {
				String[] vals = linha.split("[ \t]");

				String acao = vals[0];
				if (acao.equals("ENTRADA")) {
					String cpf = vals[1];
					String nome = "";
					for (int i = 2; i < vals.length - 1; i++)
						nome += " " + vals[i];

					int risco = Integer.parseInt(vals[vals.length - 1]);
					Paciente p = new Paciente(nome, cpf, risco);
					lista.insere(p);
					ps.println(linha);
				} else if (acao.equals("ATENDIMENTO")) {
					Paciente aux = lista.remove();
					ps.println("ATENDIMENTO " + aux.getCpf() + " " + aux.getNome() + " " + aux.getGrau());

				} else if (acao.equals("RECLASS")) {
					String cpf = vals[1];
					int novoRisco = Integer.parseInt(vals[vals.length - 1]);
					Paciente aux = lista.reclassifica(cpf, novoRisco);
					ps.println("RECLASS " + aux.getCpf() + " " + aux.getNome() + " " + aux.getGrau());

				}

				linha = br.readLine();
			}
			// br.close();
			ps.println("NÃO FORAM ATENDIDOS:");
			if (lista.exibir().length > 0) {
				for (int i = 0; i < lista.exibir().length && lista.exibir()[i] != null; i++)
					ps.println(lista.exibir()[i]);
			}

			br.close();

			lista.exibir();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// Tratamento da exceção de entrada/saída.
			e.printStackTrace();
		}catch(NullPointerException e ){
			System.out.println("A lista está vazia");
		}finally {
			// Código sempre executado, com ou sem exceção.
			try {
				if (br != null)
					// Fecha o arquivo.
					br.close();
			} catch (IOException e) {
				// O fechamento do arquivo ainda pode cusar uma exceção.
				e.printStackTrace();
			}
		}
	}

}
