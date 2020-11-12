package DTO;

public class caminhoneiroDTO extends pessoaDTO {
    private int numCNH, codEmpresa;
    private String tipoCNH;

    public int getNumCNH() {
        return numCNH;
    }
    public void setNumCNH(int numCNH) {
        this.numCNH = numCNH;
    }
    public String getTipoCNH() {
        return tipoCNH;
    }
    public void setTipoCNH(String tipoCNH) {
        this.tipoCNH = tipoCNH;
    }
    public int getCodEmpresa() {
        return codEmpresa;
    }
    public void setCodEmpresa(int codEmpresa) {
        this.codEmpresa = codEmpresa;
    }
}
