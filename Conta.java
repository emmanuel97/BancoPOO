
public class Conta {
    String numero;
    boolean ativa;
    double saldo;
    
    
    
      public void setAll(String numero,boolean ativa,double saldo){
      this.ativa=ativa;
        this.numero=numero;
        this.saldo=saldo;
}  
      public void deposito(double valor){
    	  saldo=valor;
      }
      public double verSaldo(){
    	  return saldo;
      }
      
      public void extração(double valor){
    	  saldo-=valor;
      }
}
