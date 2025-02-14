package ec.akira.akira_negocios.auditable;

import org.springframework.data.domain.AuditorAware;
import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        // Aquí puedes obtener el usuario autenticado desde SecurityContextHolder u otro
        // mecanismo
        return Optional.of("admin"); // Reemplazar por el usuario actual del sistema
    }
}