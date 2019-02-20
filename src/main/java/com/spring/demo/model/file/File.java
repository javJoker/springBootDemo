package com.spring.demo.model.file;

import com.spring.demo.model.common.BaseModel;

import java.io.Serializable;

public class File extends BaseModel implements Serializable {
    /**
     * ID
     */
    private String id;

    /**
     * 文件名
     */
    private String name;

    /**
     * 文件路径
     */
    private String url;

    /**
     * 文件大小
     */
    private Integer size;

    /**
     * 文件后缀
     */
    private String suffix;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix == null ? null : suffix.trim();
    }

}