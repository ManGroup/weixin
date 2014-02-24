package com.xgframe.platform.oss;

import com.aliyun.openservices.oss.OSSClient;
import com.aliyun.openservices.oss.model.OSSObject;
import com.aliyun.openservices.oss.model.ObjectMetadata;
import com.aliyun.openservices.oss.model.PutObjectResult;

import java.io.*;

/**
 * Created by Antony on 14-2-22.
 */
public interface WxOSSClient {


    //初始化
    public void init();
    //创建 Bucket
    public void createBucket(String bucketName);
    //上传文件
    public String putObject(String bucketName, String key, String filePath) throws FileNotFoundException, FileNotFoundException;
    //下载文件
    public void getObject(String bucketName, String key) throws IOException;
}
