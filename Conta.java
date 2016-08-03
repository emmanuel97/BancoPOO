
public class Conta {
    int numero;
    boolean ativa;
    double saldo;
    
    
    
      public void setAll(int numero,boolean ativa,double saldo){
      this.ativa=ativa;
        this.numero=numero;
        this.saldo=saldo;
}  
      public void deposito(double valor){
    	if (ativa==true)  saldo+=valor;
    	else System.out.println("A conta não esta ativa");
      }
      public double verSaldo(){
    	  if (ativa==true) return saldo;
    	  return 0;
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
      x.buscarA(numA).buscarContaC(numConta).deposito(valor);
      }
      public void situação(){
    	  if (ativa==true)System.out.println("A conta esta ativa e o seu saldo é R$"+this.verSaldo());
    	  else System.out.println("A conta não esta ativa");
      }
}

