package dto;

import domains.additional.Language;
import domains.additional.Role;

public record UserCreateDTO(String uuid, String username, String password, Language language, Role role) {
}
