package com.leo.fly.python.params;

import com.leo.fly.db.image.entity.Image;
import lombok.Data;

import java.util.List;

@Data
public class PythonImageParams {
    private List<Image> images;
    private Boolean white;
    private Boolean miniLogo;
    private Boolean centerLogo;
    private Boolean large;
    private Boolean middle;
    private Boolean mini;
}
