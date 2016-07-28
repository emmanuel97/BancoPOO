	
public class PessoaJ extends Cliente{
String nomeFantasia,CNPJ;
	public void setCNPJ(String Cnpj){
	CNPJ=Cnpj;
	}
	public void setNomeF(String NF){
	nomeFantasia=NF;
	}
	public String dadosC(){
	return "Nome:"+nome+".\nTelefone:"+telefone+".\nemail:"+email+".\nNome de Fantasia:"+nomeFantasia+".\nCNPJ:"+CNPJ+".\n";
	}
}
