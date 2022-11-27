package com.fluffyiacit.api.dto;

import lombok.Data;

@Data
public class LoginResponseDTO {
	String permissao;
	String passwordMatch;
}
