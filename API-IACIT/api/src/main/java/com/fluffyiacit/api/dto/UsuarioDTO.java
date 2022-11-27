package com.fluffyiacit.api.dto;

import lombok.Data;

@Data
public class UsuarioDTO {
    private String usuario_nome;
    private String usuario_username;
    private String usuario_senha;
    private String nome_permissao;
    private String usuario_adm;
    private String usuario_alterou;

}
