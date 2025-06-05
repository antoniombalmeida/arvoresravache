public class No {

    public Integer conteudo;
    public No noEsquerdo;
    public No noDireito;
    public int altura;

    public No(Integer conteudo, No noEsquerdo, No noDireito, int fatorBalanceamento, int altura) {
        this.conteudo = conteudo;
        this.noEsquerdo = noEsquerdo;
        this.noDireito = noDireito;
        this.altura = 1;
    }

    // Construtor adicional para permitir new No(conteudo)
    public No(Integer conteudo) {
        this.conteudo = conteudo;
        this.noEsquerdo = null;
        this.noDireito = null;
        this.altura = 1;
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
