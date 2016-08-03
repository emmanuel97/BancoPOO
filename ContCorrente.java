
public class ContCorrente extends Conta{
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
