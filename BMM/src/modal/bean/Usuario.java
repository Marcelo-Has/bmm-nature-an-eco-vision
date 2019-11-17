package modal.bean;

public class Usuario implements Comparable<Usuario>{
    
    private int id;
    private String nome;
    private String login;
    private String senha;
    private String ultimaModificacao;
    private String codT;
    private String nomeT;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the ultimaModificacao
     */
    public String getUltimaModificacao() {
        return ultimaModificacao;
    }

    /**
     * @param ultimaModificacao the ultimaModificacao to set
     */
    public void setUltimaModificacao(String ultimaModificacao) {
        this.ultimaModificacao = ultimaModificacao;
    }

    /**
     * @return the codT
     */
    public String getCodT() {
        return codT;
    }

    /**
     * @param codT the codT to set
     */
    public void setCodT(String codT) {
        this.codT = codT;
    }

    /**
     * @return the nomeT
     */
    public String getNomeT() {
        return nomeT;
    }

    /**
     * @param nomeT the nomeT to set
     */
    public void setNomeT(String nomeT) {
        this.nomeT = nomeT;
    }

    @Override
    public int compareTo(Usuario o) {
        if(this.id > o.getId()){
            return -1;
        }else if(this.id < o.getId()){
            return 1;
        }
        
        return 0;
    }
    
    
    
}
