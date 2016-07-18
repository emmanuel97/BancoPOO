    
public class PessoaJ extends Cliente{
    
   String CNPJ,nomeFant;
   public void setCNPJ(String cnpj){
       CNPJ=cnpj;
   }
    public void setNF(String fant){
        nomeFant=fant;
    }
     public String getCNPJ(){
       return CNPJ;
   }
    public String getNF(){
        return nomeFant;
    }
}
