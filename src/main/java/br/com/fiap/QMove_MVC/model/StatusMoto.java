package br.com.fiap.QMove_MVC.model;

public enum StatusMoto {
    DISPONIVEL("Disponível"),
    EM_USO("Em Uso"),
    MANUTENCAO("Manutenção"),
    INATIVA("Inativa");

    private final String descricao;

    StatusMoto(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
