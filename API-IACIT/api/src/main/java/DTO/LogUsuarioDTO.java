package DTO;

import lombok.Data;

@Data
public class LogUsuarioDTO {
        
    private String logCodUsuario;

    private String logUsuarioNome;
    
    private String logUsuarioUsername;

    private String logUsuarioSenha;

    private String logCodPermissao;

    private String  logUsuarioAlterou; 

    private String logUsuarioDatahoraAlterecao;

    private String  logUsuarioOperacao; 

}
