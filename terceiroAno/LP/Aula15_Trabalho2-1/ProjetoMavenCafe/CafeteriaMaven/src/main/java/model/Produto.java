package model;

import java.time.LocalDate;
import java.time.Period;

public class Produto {
    private String nome;
    private String descricao;
    private double preco;
    private String[] ingredientes;
    private double taxaEntrega;
    private LocalDate validade;

    public Produto(String nome, String descricao, double preco, String[] ingredientes,
                   double taxaEntrega, LocalDate validade) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.ingredientes = ingredientes;
        this.taxaEntrega = taxaEntrega;
        this.validade = validade;
    }

    public String verificarValidade() {
        LocalDate dataAtual = LocalDate.now();
        Period verificacao = Period.between(dataAtual, validade);
        if (verificacao.getYears() >= 0 && verificacao.getMonths() >= 0 && verificacao.getDays() > 0) {
            return "Dentro da validade";
        } else if (verificacao.getYears() == 0 && verificacao.getMonths() == 0 && verificacao.getDays() == 0) {
            return "Vai vencer hoje";
        } else {
            return "Fora da validade";
        }
    }

    public double calcularPreco() {
        if (taxaEntrega == 0) {
            return preco;
        } else {
            return preco * (1 + taxaEntrega / 100); // CORRIGIDO
        }
    }

    public String[] rotularProduto() {
        String[] rotulos = new String[ingredientes.length];
        for (int i = 0; i < ingredientes.length; i++) {
            switch (ingredientes[i]) {
                case "Amendoim": // CORRIGIDO (era "Amendoin")
                    rotulos[i] = "Alérgicos a Amendoim";
                    break;
                case "Derivados de Leite":
                    rotulos[i] = "Intolerantes à Lactose";
                    break;
                case "Glúten":
                    rotulos[i] = "Celíacos";
                    break;
                case "Áçucar":
                    rotulos[i] = "Diabéticos";
                    break;
                case "Gordura Saturada":
                    rotulos[i] = "Colesterol Alto";
                    break;
                default:
                    rotulos[i] = "Nenhum Problema";
                    break;
            }
        }
        return rotulos;
    }

    // Getters e Setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String[] getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String[] ingredientes) {
        this.ingredientes = ingredientes;
    }

    public double getTaxaEntrega() {
        return taxaEntrega;
    }

    public void setTaxaEntrega(double taxaEntrega) {
        this.taxaEntrega = taxaEntrega;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }
}
