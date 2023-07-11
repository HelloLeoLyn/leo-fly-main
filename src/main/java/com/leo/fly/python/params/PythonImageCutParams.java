package com.leo.fly.python.params;

import lombok.Data;

@Data
public class PythonImageCutParams {
    private Long productId;
    private Long imageId;
    private String saveType;
    private String url;
    private String path;
    private String imageName;
    private String moduleType;
    private boolean fillWhiteBG;
    private boolean leftLogo;
    private boolean bgWater;
    private String generateType;
    private boolean size1000;
    private boolean size300;
    private boolean size50;
    private String optionType;
    private String fileType;
    private String inputPath;
    private String outPath;
}
