package modal.bean;

public class Desmatamento implements Comparable<Desmatamento>{

    private int id;
    private String bioma;
    private int ano;
    private String estado;
    private int areaDesmatada;
    private String ultimaModificacao;
    private String usuario;

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
     * @return the bioma
     */
    public String getBioma() {
        return bioma;
    }

    /**
     * @param bioma the bioma to set
     */
    public void setBioma(String bioma) {
        this.bioma = bioma;
    }

    /**
     * @return the ano
     */
    public int getAno() {
        return ano;
    }

    /**
     * @param ano the ano to set
     */
    public void setAno(int ano) {
        this.ano = ano;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the areaDesmatada
     */
    public int getAreaDesmatada() {
        return areaDesmatada;
    }

    /**
     * @param areaDesmatada the area_desmatada to set
     */
    public void setAreaDesmatada(int areaDesmatada) {
        this.areaDesmatada = areaDesmatada;
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
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public int compareTo(Desmatamento o) {
        if(this.id > o.getId()){
            return -1;
        }else if(this.id < o.getId()){
            return 1;
        }
        return 0;
    }
    
    
}
