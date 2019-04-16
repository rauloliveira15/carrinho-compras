package com.company.prjCompra;

public class Produto {

    private int codProd;
    private String descricao;
    private double preco;
    private Fornecedor fornecedor;

    public void imprimirEtiqueta(){
        System.out.println("codProd = " + codProd);
        System.out.println("descricao = " + descricao);
        System.out.println("preco = " + preco);
        System.out.println("fornecedor = " + fornecedor.getNome());
    }

    public int getCodProd() {
        return codProd;
    }

    public void setCodProd(int codProd) {
        this.codProd = codProd;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
}
