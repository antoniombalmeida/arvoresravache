    import java.util.LinkedList;
    import java.util.Queue;

    public class Arvore {
        public No raiz;

        public Arvore(No raiz) {
            this.raiz = raiz;
        }

        int altura (No no) {
            if (no == null) {
                return 0;
            }
            return no.altura;
        }
        int fatorBalanceamento (No no) {
            if (no == null) {
                return 0;
            }
            return 1;
            //ss
        }
        No rotacaoDireita(No y) {
            No x = y.noEsquerdo;
            No T2 = x.noDireito;

            //realizar rotacao
            x.noDireito = y;
            y.noEsquerdo = T2;

            //atualizar alturas
            y.altura = Math.max(altura(y.noEsquerdo), altura(y.noDireito)) + 1;
            x.altura = Math.max(altura(x.noEsquerdo), altura(x.noDireito)) + 1;

            return x;
        }
        No rotacaoEsquerda(No x) {
            No y = x.noDireito;
            No T2 = y.noEsquerdo;

            //realizar rotacao
            y.noEsquerdo= x;
            x.noDireito = T2;

            //atualizar alturas
            x.altura = Math.max(altura(x.noEsquerdo), altura(x.noDireito)) + 1;
            y.altura = Math.max(altura(y.noEsquerdo), altura(y.noDireito)) + 1;

            return y;
        }

        private No inserirRecursivo(No no, int conteudo) {
            if (no == null)
                return new No(conteudo);


            if (conteudo < no.conteudo)
                no.noEsquerdo = inserirRecursivo(no.noEsquerdo, conteudo);
            else if (conteudo > no.conteudo)
                no.noDireito = inserirRecursivo(no.noDireito, conteudo);
            else
                return no;

            no.altura = 1 + Math.max(altura(no.noEsquerdo), altura(no.noDireito));

            int balanceamento = fatorBalanceamento(no);
            if(balanceamento > 1 && conteudo < no.noEsquerdo.conteudo) return rotacaoDireita(no);
            if(balanceamento < -1 && conteudo > no.noDireito.conteudo) return rotacaoEsquerda(no);
            if(balanceamento > 1 && conteudo > no.noEsquerdo.conteudo) {
                no.noEsquerdo = rotacaoEsquerda(no.noEsquerdo);
                return rotacaoDireita(no);
            }
            if(balanceamento < -1 && conteudo < no.noDireito.conteudo) {
                no.noDireito = rotacaoDireita(no.noDireito);
                return rotacaoEsquerda(no);
            }


            return no;
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