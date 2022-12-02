package io.github.zam0k.warmupspringboot.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
@AllArgsConstructor
public class ApiError {
    String path;
    Integer status;
    List<String> message;

    public ApiError(String path, Integer status, String message) {
        this.path = path;
        this.message = Collections.singletonList(message);
        this.status = status;
    }
}
