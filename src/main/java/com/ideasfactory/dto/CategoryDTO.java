package com.ideasfactory.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CategoryDTO {

    @EqualsAndHashCode.Include
    private Integer idCategory;

    @NotNull
    @Size(max = 70)
    private String name;
}
