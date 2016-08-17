package Agencias;
import Banco.Banco;
import Clientes.PessoaF;
import Clientes.PessoaJ;
public class Conta {
    int numero;
    boolean ativa;
    double saldo;
    PessoaF f;
    PessoaJ j;
    public Conta(PessoaF f){
    	this.f=f;
    }
    public Conta(PessoaJ j){
    	this.j=j;
    }
    
      public void setAll(int numero,boolean ativa,double saldo){
      this.ativa=ativa;
        this.numero=numero;
        this.saldo=saldo;
}  
      public void deposito(double valor){
    	if (ativa==true)  saldo+=valor;
    	else System.out.println("A conta não esta ativa");
      }
      public double Saldo(){
    	  if (ativa==true) return saldo;
    	  return 0;
      }
      public void verSaldo(){
    	  if (ativa==true) System.out.println("o seu saldo é R$"+this.Saldo());
    	  else System.out.println("A conta não esta ativa");
      }
      
      public void extração(double valor){
    	  if (ativa==true)  saldo-=valor;
      	else System.out.println("A conta não esta ativa");
      }
      public void cancelarConta(){
    	  if (ativa==true){saldo=0;
    	  ativa=false;}
    	  else System.out.println("A conta já estava inativa");
    	}
      public void ativarConta(){
    	  if (ativa==false) ativa=true;
    		else System.out.println("A conta já estava ativa");
    	}
      public void transferir(Banco x,int numA,int numConta,double valor){
      if(x.buscarA(numA)!=null){if(x.buscarA(numA).buscarContaC(numConta)!=null){
    	  x.buscarA(numA).buscarContaC(numConta).deposito(valor);
      saldo-=valor;}System.out.println("A conta não existe");}
      else System.out.println("A agencia não existe");
      }
      public void situação(){
    	  if (ativa==true)System.out.println("A conta esta ativa e o seu saldo é R$"+this.Saldo());
    	  else System.out.println("A conta não esta ativa");
      }
      public PessoaF obterPF(){
    	  return f;
      }
      public PessoaJ obterPJ(){
    	  return j;
      }
}

