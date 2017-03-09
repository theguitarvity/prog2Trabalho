package prog2Trabalho;

import com.facom.algoprog2.prog2Trabalho.model.Paciente;

public class ListaDePrioridadePaciente {
	private Paciente[] pacientes;
	private int n;
	
	public ListaDePrioridadePaciente(int max){
		this.pacientes = new Paciente[max];
		this.n = 0;
	}
	public ListaDePrioridadePaciente(){
		this(10);
	}
	
	private int pai(int i){
		if(i==0)
			return 0;
		else
			return (i-1)/2;
	}
	private int esquerdo(int i){
		return 2*(i+1)-1;
	}
	private int direito(int i){
		return 2*(i+1);
	}
	public void desce(int i){
		int esq, dir, iMaior = i;
		esq = esquerdo(i);
		dir = direito(i);
		if(pacientes[esq].compareTo(pacientes[iMaior])==1)
			iMaior = esq;
		if(pacientes[dir].compareTo(pacientes[iMaior])==1)
			iMaior = dir;
		if(iMaior!=1){
			troca(i, iMaior);
			desce(iMaior);
		}
		
	}
	private void sobe(int i){
		int p = pai(i);
		while(pacientes[i].compareTo(pacientes[pai(i)])==1){
			
			troca(i, pai(i));
			i = p;
			p = pai(p);
		}
	}
	public void insere(Paciente p){
		pacientes[n] = p;
		n++;
		sobe(n-1);
	}
	public Paciente remove(){
		Paciente p = pacientes[0];
		pacientes[0] = pacientes[n-1];
		n--;
		if(n>0)
			desce(0);
		return p;
	}
	private void troca(int i, int j){		
		Paciente aux = pacientes[i];
		pacientes[i] = pacientes[j];
		pacientes[j] = aux;
	}
}
