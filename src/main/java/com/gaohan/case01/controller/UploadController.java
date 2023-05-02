package com.gaohan.case01.controller;

import com.gaohan.case01.pojo.Result;
import com.gaohan.case01.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {

    @Autowired
    private AliOSSUtils aliOSSUtils;

    /**
     * 本地存储
     * @param name
     * @param image
     * @return
     * @throws Exception
     */
    @PostMapping("/upload")
    public Result upload(String name, MultipartFile image) throws Exception {
        log.info("文件上传：{}, {}", name, image);

        // 获取原始文件名
        String originalFilename = image.getOriginalFilename();

        // 构造唯一的文件名 - uuid（通用唯一识别码）
        int index = originalFilename.lastIndexOf(".");
        String extname = originalFilename.substring(index);
        String newFileName = UUID.randomUUID().toString() + extname;
        log.info("文件名：{}", newFileName);

        // 将文件存储在服务器的磁盘目录中 /Users/zihan/work/java/java-case01-file/
        image.transferTo(new File("/Users/zihan/work/java/java-case01-file/" + newFileName));

        return Result.success();
    }


    /**
     * 阿里云oss对象存储
     * @param image
     * @return
     */
    @PostMapping("/upload/oss")
    public Result upload(MultipartFile image) throws IOException {
        log.info("文件上传, 文件名：{}", image.getOriginalFilename());

        // 调用阿里云OSS工具类
        String url = aliOSSUtils.upload(image);
        log.info("文件上传完成，文件访问url：{}", url);

        return Result.success(url);
    }

}
