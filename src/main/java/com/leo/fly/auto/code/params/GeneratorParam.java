package com.leo.fly.auto.code.params;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class GeneratorParam {
    @NotBlank
    private String tablePrefix;
    @NotBlank
    private String tableName;
    @NotBlank
    private String packageName;
    @NotBlank
    private String outDir;
    @NotNull
    private Boolean open;
    @NotNull
    private Boolean lombokModel;
}
