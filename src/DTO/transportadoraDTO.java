package DTO;

public class transportadoraDTO {
    private int codEmpresa, numFunc;
    private String nome, servico;
    private float valorMercado;

    public int getCodEmpresa() {
        return codEmpresa;
    }
    public void setCodEmpresa(int codEmpresa) {
        this.codEmpresa = codEmpresa;
    }
    public int getNumFunc() {
        return numFunc;
    }
    public void setNumFunc(int numFunc) {
        this.numFunc = numFunc;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getServico() {
        return servico;
    }
    public void setServico(String servico) {
        this.servico = servico;
    }
    public float getValorMercado() {
        return valorMercado;
    }
    public void setValorMercado(float valorMercado) {
        this.valorMercado = valorMercado;
    }
}
