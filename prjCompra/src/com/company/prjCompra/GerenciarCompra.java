package com.company.prjCompra;

import java.util.Scanner;

public class GerenciarCompra {

    public Fornecedor fornecedores[] = new Fornecedor[20];
    public Produto produtos[] = new Produto[20];

    Cesta cesta = new Cesta();

    public static void main(String[] args) {
	// write your code here
        GerenciarCompra gc = new GerenciarCompra();
        Scanner sc = new Scanner(System.in);
        int op = 0;
        do{
            System.out.println("1 -- Cadastrar Fornecedor");
            System.out.println("2 -- Cadastrar Produto");
            System.out.println("3 -- Abrir Carrinho");
            System.out.println("4 -- Fechar Carrinho");
            System.out.println("9 -- Sair");
            System.out.println("Digite sua opção: ");
            op = Integer.parseInt(sc.nextLine());
            switch (op){
                case 1:
                    gc.cadastrarFornecedor();
                    break;
                case 2:
                    gc.cadastrarProduto();
                    break;
                case 3:
                    gc.abrirCarrinho();
                    break;
                case 4:
                    gc.fecharCarrinho();
                    break;
                case 9:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }while(op!=9);
    }

    private void fecharCarrinho(){
        System.out.println("Seu carrinho");
        cesta.exibeLista();
        System.out.println("Total da compra: R$" + cesta.calcularTotal());
    }

    private void abrirCarrinho(){
        System.out.println("Produtos cadastrados");
        for (Produto p: produtos) {
            if(p!=null){
                p.imprimirEtiqueta();
            }
        }
        Scanner sc = new Scanner(System.in);
        int codigo;
        System.out.println("Digite o codigo do produto a ser adicionado no carrinho: ");
        codigo = Integer.parseInt(sc.nextLine());
        for (Produto p: produtos) {
            if(p!=null) {
                if (p.getCodProd()==codigo) {
                    cesta.adicionarItem(p);
                    System.out.println(p.getDescricao() + " Adicionado com sucesso!");
                    return;
                }
            }
        }
        System.out.println("Produto não encontrado!");
    }

    private void cadastrarProduto(){
        Scanner sc = new Scanner(System.in);
        int tam;
        System.out.println("Quantos produtos deseja cadastrar?: ");
        tam = Integer.parseInt(sc.nextLine());
        if(tam <= 20) {
            for (int i = 0; i < tam; i++) {
                produtos[i] = new Produto();
                System.out.println("Digite o código do produto: ");
                produtos[i].setCodProd(Integer.parseInt(sc.nextLine()));
                System.out.println("Digite a descrição do produto: ");
                produtos[i].setDescricao(sc.nextLine());
                System.out.println("Digite o preço do produto: ");
                produtos[i].setPreco(Double.parseDouble(sc.nextLine()));
                int codigo;
                System.out.println("Informe o codigo do fornecedor: ");
                codigo = Integer.parseInt(sc.nextLine());
                for (Fornecedor f: fornecedores) {
                    if(f!=null){
                        if(f.getIdForn()==codigo){
                            produtos[i].setFornecedor(f);
                        }
                    }
                }
                System.out.println("Produto cadastrado com sucesso!");
            }
        }
    }

    private void cadastrarFornecedor(){
        Scanner sc = new Scanner(System.in);
        int tam;
        System.out.println("Quantos fornecedores deseja cadastrar?: ");
        tam = Integer.parseInt(sc.nextLine());
        if(tam <= 20){
            for (int i = 0; i < tam; i++) {
                fornecedores[i] = new Fornecedor();
                System.out.println("Digite o ID do fornecedor: ");
                fornecedores[i].setIdForn(Integer.parseInt(sc.nextLine()));
                System.out.println("Digite o nome do fornecedor: ");
                fornecedores[i].setNome(sc.nextLine());
                System.out.println("Digite o contato: ");
                fornecedores[i].setContato(sc.nextLine());
                System.out.println("Digite o telefone: ");
                fornecedores[i].setFone(sc.nextLine());
                System.out.println("Digite o email: ");
                fornecedores[i].setEmail(sc.nextLine());
                System.out.println("Fornecedor cadastrado com sucesso!");
            }
        }
    }
}
