package com.leo.fly.ailibaba.photo;


import com.leo.fly.db.image.entity.Image;

import java.util.List;

public interface PhotoService {

    PhotoBankAlbumResult album(PhotoBankAlbumParams params);

    PhotoBankPhotoResult photo(PhotoBankParams param);

    List<Image> sendImagesToAlibaba(List<Image>images, Long albumID);
}

