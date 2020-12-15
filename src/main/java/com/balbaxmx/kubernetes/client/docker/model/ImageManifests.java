package com.balbaxmx.kubernetes.client.docker.model;

import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: zhangyh
 * @ClassName: ImageManifests
 * @Date: 2020/9/7 15:29
 * @Operation:
 * @Description: 镜像信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageManifests {

    private Integer schemaVersion;

    private String name;

    private String tag;

    private String architecture;

    private List<FsLayer> fsLayers;

    private List<JsonObject> history;



}
