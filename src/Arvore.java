public class Arvore {
    public No raiz;

    public Arvore(No raiz) {
        this.raiz = raiz;
    }

    public int contarNosArvore() {
        No aux = raiz;
        if (aux == null) {
            return 0;
        }
        int contador = 0;
        while (aux != null) {
            if (aux.getNoDireito() != null) {
                aux = aux.getNoDireito();
                contador++;
            }
        }
        return contador;
    }

    public void percorrerPreOrdem() {
        No aux = raiz;
        while (aux != null && raiz != null) {
            System.out.println(aux);
            if (aux.getNoEsquerdo() != null) {
                aux = aux.getNoEsquerdo();
            }
            else if (aux.getNoDireito().getNoDireito() != null) {
                aux = aux.getNoDireito().getNoDireito();
            }

        }

        if (aux != )
    }



    public No getRaiz() {
        return raiz;
    }

    public void setRaiz(No raiz) {
        this.raiz = raiz;
    }

}
