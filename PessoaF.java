
public class PessoaF extends Cliente{
String CPF;
	public void setCPF(String Cpf){
	this.CPF=Cpf;
	}
	public String dadosC(){
		return "Nome:"+nome+".\nTelefone:"+telefone+".\nemail:"+email+".\nCPF:"+CPF+".\n";
		}
}
