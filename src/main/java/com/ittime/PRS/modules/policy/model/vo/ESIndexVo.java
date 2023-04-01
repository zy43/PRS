package com.ittime.PRS.modules.policy.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.elasticsearch.cluster.metadata.AliasMetaData;
import org.elasticsearch.cluster.metadata.MappingMetaData;
import org.elasticsearch.common.settings.Settings;

import java.util.List;
import java.util.Map;

/**
 * @author zhl129
 * @date 2023/3/29 11:04
 * @email 1293384775@qq.com
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ESIndexVo {

    @ApiModelProperty("aliases")
    private Map<String, List<AliasMetaData>> aliases;

    @ApiModelProperty("mappings")
    private Map<String, MappingMetaData> mappings;

    @ApiModelProperty("settings")
    private Map<String, Settings> settings;

}
