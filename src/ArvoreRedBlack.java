public class ArvoreRedBlack {
    public NoRedBlack raiz;
    public final NoRedBlack NIL;

    public ArvoreRedBlack() {
        NIL = new NoRedBlack(-1);
        NIL.cor = Cor.BLACK;
        NIL.esquerda = NIL.direita = NIL.pai = null;
        raiz = NIL;
    }
    private void rotacaoEsquerda(NoRedBlack x) {
        NoRedBlack y = y.esquerda;
        y.direita = x.esquerda;
        if (y.esquerda != NIL) {
            y.pai = x.pai;
        }
        y.pai = x.pai;
        if (x.pai == null) {
            raiz = y;
        } else if (x == x.pai.esquerda) {
            x.pai.esquerda = y;
        } else {
            x.pai.direita = y;
        }
        y.esquerda = x;
        x.pai = y;
    }

    private void rotacaoDireita(NoRedBlack y) {
        NoRedBlack x = y.esquerda;
        y.esquerda = x.direita;
        if (x.direita != null) {
            x.direita.pai = y;
        }
        x.pai = y.pai;
        if (y.pai == null) {
            raiz = x;
        } else if (y == y.pai.direita) {
            y.pai.direita = x;
        } else {
            y.pai.esquerda = x;
        }
        x.direita = y;
        y.pai = x;
    }

    public void inserir(int chave) {
        NoRedBlack no = new NoRedBlack(chave);
        no.esquerda = no.direita = no.pai = null;

        NoRedBlack y = null;
        NoRedBlack x = raiz;
        while (x != null) {
            y = x;
            if (no.valor < x.valor) {
                x = x.esquerda;
            }
            else x = x.direita;
        }
        no.pai = y;
        if (y == null) {
            raiz = no;
        }
        else if (no.valor < y.valor) {
            y.esquerda = no;
        }
        else {
            y.direita = no;
        }
        no.esquerda = NIL;
        no.direita = NIL;
        no.cor = Cor.RED;

        inserirFix(no);
    }

    private void inserirFix(NoRedBlack k) {
        while (k.pai != null && k.pai.cor == Cor.RED) {
            if (k.pai == k.pai.pai.esquerda) {
                NoRedBlack u = k.pai.pai.direita;
                if (u.cor == Cor.RED) {
                    k.pai.cor = Cor.BLACK;
                    u.cor = Cor.BLACK;
                    k.pai.pai.cor = Cor.RED;
                    k = k.pai.pai;
                } else {
                    if (k == k.pai.direita) {
                        k = k.pai;
                        rotacaoEsquerda(k);
                    }
                    k.pai.cor = Cor.BLACK;
                    k.pai.pai.cor = Cor.RED;
                    rotacaoDireita(k.pai.pai);
                }
            }
        }
    }
}
