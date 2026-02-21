package med.vol.api.Domain.Usuario;

public enum RoleUsuarios {
    ADMIN("admin"),
    USER("user");

    private String role;

    RoleUsuarios(String role) {
        this.role = role;
    }
    public String getRole() {
        return role;
    }
}
