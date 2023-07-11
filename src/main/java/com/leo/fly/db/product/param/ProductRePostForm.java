package com.leo.fly.db.product.param;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class ProductRePostForm {
    private String type;

    private List<Long> id;
    @Min(0)
    @NotNull
    private Integer startPage;

    @Min(0)
    @NotNull
    private Integer endPage;

    private Integer size;
}
