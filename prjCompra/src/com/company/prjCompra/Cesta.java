package com.company.prjCompra;

public class Cesta {

    private Produto itens[] = new Produto[20];
    private int indice = 0;
    private double total;

    public void adicionarItem(Produto produto){
        if(indice < 20) {
            this.itens[indice] = produto;
            indice++;
            this.total+=produto.getPreco();
        }
    }

    public void exibeLista(){
        for (Produto p: itens) {
            if(p!=null){
                p.imprimirEtiqueta();
            }
        }
    }

    public double calcularTotal(){
        return total;
    }

}
