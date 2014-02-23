package com.xgframe.platform.oss;

import com.aliyun.openservices.oss.OSSClient;
import com.aliyun.openservices.oss.model.OSSObject;
import com.aliyun.openservices.oss.model.ObjectMetadata;
import com.aliyun.openservices.oss.model.PutObjectResult;

import java.io.*;

/**
 * Created by Antony on 14-2-22.
 */
public class WxOSSClient {
    private String accessKeyId = "JDHrnKQb1Uezn7AM";
    private String accessKeySecret = "EsFoonehi8fUPimGTvSPh2f6GVYNYs";

    public void init() {
        String accessKeyId = "<key>";
        String accessKeySecret = "<secret>";

        OSSClient client = new OSSClient(accessKeyId, accessKeySecret);
    }

    public void createBucket(String bucketName) {

        String accessKeyId = "<key>";
        String accessKeySecret = "<secret>";

        OSSClient client = new OSSClient(accessKeyId, accessKeySecret);

        // 新建一个Bucket
        client.createBucket(bucketName);
    }

    public String putObject(String bucketName, String key, String filePath) throws FileNotFoundException, FileNotFoundException {

        // 初始化OSSClient
        OSSClient client = new OSSClient(accessKeyId, accessKeySecret);

        // 获取指定文件的输入流
        File file = new File(filePath);
        InputStream content = new FileInputStream(file);

        // 创建上传Object的Metadata
        ObjectMetadata meta = new ObjectMetadata();

        // 必须设置ContentLength
        meta.setContentLength(file.length());

        // 上传Object.
        PutObjectResult result = client.putObject(bucketName, key, content, meta);

        // 打印ETag
        System.out.println(result.getETag());
        return result.getETag();
    }

    public void getObject(String bucketName, String key) throws IOException {

        // 初始化OSSClient
        OSSClient client = new OSSClient(accessKeyId, accessKeySecret);

        // 获取Object，返回结果为OSSObject对象
        OSSObject object = client.getObject(bucketName, key);

        File file = new File("C:\\" + key);
        // 获取Object的输入流
        InputStream objectContent = object.getObjectContent();
        try {
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = objectContent.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            objectContent.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 处理Object
        System.out.println(objectContent);

        // 关闭流
        objectContent.close();
    }
}
