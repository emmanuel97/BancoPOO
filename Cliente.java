
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
}

