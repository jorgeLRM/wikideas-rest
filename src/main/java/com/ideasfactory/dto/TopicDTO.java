package com.ideasfactory.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class TopicDTO {

    @EqualsAndHashCode.Include
    private Integer idTopic;

    @NotNull
    @Size(max = 70)
    private String title;

    @NotNull
    private String content;

    @NotNull
    private CategoryDTO category;
}
