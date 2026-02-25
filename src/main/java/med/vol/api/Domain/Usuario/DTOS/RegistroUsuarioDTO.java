package med.vol.api.Domain.Usuario.DTOS;

import med.vol.api.Domain.Usuario.RoleUsuarios;

public record RegistroUsuarioDTO(String login, String senha, RoleUsuarios role) {
}
