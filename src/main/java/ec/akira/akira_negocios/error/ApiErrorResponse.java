package ec.akira.akira_negocios.error;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiErrorResponse {

    private String endpoint;
    private String message;
    private LocalDateTime timestamp;
    private int statusCode;

    public ApiErrorResponse(String endpoint, String message, int statusCode) {
        this.endpoint = endpoint;
        this.message = message;
        this.timestamp = LocalDateTime.now();
        this.statusCode = statusCode;
    }
}
