public class No {

    public Integer conteudo;
    public No noEsquerdo;
    public No noDireito;

    public No(Integer conteudo, No noEsquerdo, No noDireito) {
        this.conteudo = conteudo;
        this.noEsquerdo = noEsquerdo;
        this.noDireito = noDireito;
    }

    public Integer getConteudo() {
        return conteudo;
    }

    public void setConteudo(Integer conteudo) {
        this.conteudo = conteudo;
    }

    public No getNoEsquerdo() {
        return noEsquerdo;
    }

    public void setNoEsquerdo(No noEsquerdo) {
        this.noEsquerdo = noEsquerdo;
    }

    public No getNoDireito() {
        return noDireito;
    }

    public void setNoDireito(No noDireito) {
        this.noDireito = noDireito;
    }
}
