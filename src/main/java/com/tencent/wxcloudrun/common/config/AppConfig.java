package com.tencent.wxcloudrun.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 全局配置类
 * 
 * @author test
 */
@Component
@ConfigurationProperties(prefix = "app")
public class AppConfig
{
    /** 项目名称 */
    private static String name;

    /** 版本 */
    private static String version;

    /** 版权年份 */
    private static String copyrightYear;

    /** 上传路径 */
    private static String uploadPath;

    public static String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        AppConfig.name = name;
    }

    public static String getVersion()
    {
        return version;
    }

    public void setVersion(String version)
    {
        AppConfig.version = version;
    }

    public static String getCopyrightYear()
    {
        return copyrightYear;
    }

    public void setCopyrightYear(String copyrightYear)
    {
        AppConfig.copyrightYear = copyrightYear;
    }



    public static String getUploadPath()
    {
        return uploadPath;
    }

    public void setUploadPath(String uploadPath)
    {
        AppConfig.uploadPath = uploadPath;
    }


}
