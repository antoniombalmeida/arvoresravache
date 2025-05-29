import java.util.LinkedList;
import java.util.Queue;

public class Arvore {
    public No raiz;

    public Arvore(No raiz) {
        this.raiz = raiz;
    }



    public int contarNosArvore(No raiz) {
        if(raiz == null) {
            return 0;
        }
        return 1 + contarNosArvore(raiz.getNoEsquerdo()) + contarNosArvore(raiz.getNoDireito());
    }

    public int contarNosArvoreSemRec(No raiz) {
        if (raiz == null) {
            return 0;
        }
        LinkedList<No> nosArvore = new LinkedList<>();
        nosArvore.add(raiz);
        while(!nosArvore.isEmpty()) {
            No n = nosArvore.removeFirst();
            if (raiz.getNoEsquerdo() != null) {
                raiz = raiz.getNoEsquerdo();
                nosArvore.add(raiz);

            }
        }
        while (raiz.getNoEsquerdo() != null) {
            
                raiz = raiz.getNoEsquerdo();
            nosArvore.add(raiz);
        }

        return nosArvore.size();
    }
    public int contarNosFolhaRecursivo(No raiz) {
        if (raiz == null) {
            return 0;
        }

        if (raiz.getNoEsquerdo() == null && raiz.getNoDireito() == null)
            return 1;
        else
            return contarNosFolhaRecursivo(raiz.getNoEsquerdo()) + contarNosFolhaRecursivo (raiz.getNoDireito());
    }
    public int contarNosFolha(No raiz) {
        if (raiz == null) return 0;

        Queue<No> fila = new LinkedList<>();
        fila.add(raiz);
        int contador = 0;
        while(!fila.isEmpty()) {
            No atual = fila.poll();
            if(atual.getNoEsquerdo() == null && atual.getNoDireito() == null) {
                contador++;
            }
            if (atual.noEsquerdo != null) fila.add(atual.noEsquerdo);
            if (atual.noDireito != null) fila.add(atual.noDireito);
        }
        return contador;
    }

    public void percorrerPreOrdem(No raiz) {
        if (raiz != null) {
            System.out.println(raiz.conteudo);
            percorrerPreOrdem(raiz.getNoEsquerdo());
            percorrerPreOrdem(raiz.getNoDireito());
        }
    }
    public void percorrerPreOrdemSemRec(No raiz) {
        if (raiz != null) {

        }
    }
    public void percorrerEmOrdem(No raiz) {
        if (raiz != null) {
            percorrerEmOrdem(raiz.getNoEsquerdo());
            System.out.println(raiz.conteudo);
            percorrerEmOrdem(raiz.getNoDireito());
        }
    }
    public void percorrerPosOrdem(No raiz) {
        if(raiz != null) {
            percorrerPosOrdem(raiz.getNoEsquerdo());
            percorrerPosOrdem(raiz.getNoDireito());
            System.out.println(raiz.conteudo);
        }
    }
    public void percorrerEmNivel(No raiz) {
        if(raiz == null) {
            return;
        }
        Queue<No> fila = new LinkedList<>();
        fila.add(raiz);

        while (!fila.isEmpty()) {
            No nivel = fila.poll();
            System.out.println(nivel.conteudo);
            if(nivel.getNoEsquerdo() != null) {
                fila.add(nivel.getNoEsquerdo());
            }
            if(nivel.getNoDireito() != null) {
                fila.add(nivel.getNoDireito());
            }
        }
    }


    public No getRaiz() {
        return raiz;
    }

    public void setRaiz(No raiz) {
        this.raiz = raiz;
    }

}