package com.qingjiao.qa.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;


@Slf4j
public class FileUtils {

  public static boolean upload(MultipartFile file, String path, String fileName) {

    String filePath = System.getProperty("user.dir");

    String url = filePath+path+"/"+fileName;

    File picture = new File(url);

    if(picture.getParentFile().exists()) {
      picture.getParentFile().mkdir();
    }

    try {
      file.transferTo(picture);
      log.info("picture upload succ :)");
      return true;
    } catch (Exception e) {
      log.error("picture upload failed :(");
      e.printStackTrace();
      return false;
    }

  }
}
