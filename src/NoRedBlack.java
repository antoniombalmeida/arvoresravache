import java.awt.*;

enum Cor {
    RED, BLACK
}

public class NoRedBlack {
    int valor;
    NoRedBlack esquerda, direita, pai;
    Cor cor;

    public NoRedBlack(int valor) {
        this.valor = valor;
        this.cor = Cor.RED;
        this.esquerda = null;
        this.direita = null;
        this.pai = null;
    }
}
