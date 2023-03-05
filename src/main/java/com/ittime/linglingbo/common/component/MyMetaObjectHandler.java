package com.ittime.linglingbo.common.component;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 自动填充创建时间、修改时间
 *
 * @author dujianghui
 */
@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    public static final String CREATE_TIME = "createTime";
    public static final String MODIFIED_TIME = "modifiedTime";

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ....");
        if (metaObject.hasSetter(CREATE_TIME)) {
            this.strictInsertFill(metaObject, CREATE_TIME, LocalDateTime::now, LocalDateTime.class);
        }

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ....");
        if (metaObject.hasSetter(MODIFIED_TIME)) {
            this.strictUpdateFill(metaObject, MODIFIED_TIME, LocalDateTime::now, LocalDateTime.class);
        }
    }
}
