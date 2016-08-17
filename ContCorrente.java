package Agencias;

import Clientes.PessoaF;
import Clientes.PessoaJ;

public class ContCorrente extends Conta{
public ContCorrente(PessoaJ j) {
		super(j);
		// TODO Auto-generated constructor stub
	}
public ContCorrente(PessoaF f) {
	super(f);
	// TODO Auto-generated constructor stub
}
double limite;
public void setL(double limite){
	if (ativa==true) this.limite=limite;
	 else System.out.println("A conta não esta ativa");
}
public double getL(){
	 if (ativa==true)return limite;
	 else System.out.println("A conta não esta ativa");
	 return 0;
}
}
