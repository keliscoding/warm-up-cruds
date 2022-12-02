package io.github.zam0k.warmupspringboot.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class CreatePostDTO {
    @NotBlank(message = "title cannot be empty")
    @Size(min=5, max=80, message="title must be between 5 and 80 characters")
    private String title;

    @NotBlank(message = "description cannot be empty")
    @Size(min = 5, max = 200, message = "climate must be between 5 and 200 characters")
    private String description;

    @NotNull(message = "profile cannot be empty")
    private Long profile;
}
