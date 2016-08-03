
public class Cliente {
String nome,telefone,email;
 
 public void setAll(String nome,String telefone,String email){
     this.nome=nome;
       this.telefone=telefone;
       this.email=email;
}
 public String dadosC(){
	 return "Nome:"+nome+".\nTelefone:"+telefone+".\nemail:"+email+".\n";
 }
 
 public void buscarContaC(Agencia x,int numConta){
	 if(x.buscarContaC(numConta)!= null)x.buscarContaC(numConta);
	 
 }
 public void buscarContaP(Agencia x,int numConta){
	 if(x.buscarContaP(numConta)!= null)x.buscarContaP(numConta);
 }
}

