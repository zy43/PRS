package com.ittime.linglingbo.modules.ums.dto;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

/**
 * @author: dzy
 * @date: 2022/12/18 22:34
 * @email: 3323939959@qq.com
 */
@Data
public class UmsFansHobbyVO implements Comparable<UmsFansHobbyVO> {

    private String fansHobby;

    private Double proportion;

    @Override
    public int compareTo(@NotNull UmsFansHobbyVO o) {
        return (int)(o.getProportion() - this.getProportion());
    }
}
