package DTO;

import java.sql.Timestamp;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
public class UsuarioDTO {
    private String usuario_nome;
    private String usuario_username;
    private String usuario_senha;
    private String nome_permissao;
    private String usuario_adm;

}