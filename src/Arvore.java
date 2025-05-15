public class Arvore {
    public No raiz;
    public No filho;

    public Arvore(No raiz, No filho) {
        this.raiz = raiz;
        this.filho = null;
    }

    public No getRaiz() {
        return raiz;
    }

    public void setRaiz(No raiz) {
        this.raiz = raiz;
    }

    public No getFilho() {
        return filho;
    }

    public void setFilho(No filho) {
        this.filho = filho;
    }
}
