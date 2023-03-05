package com.ittime.linglingbo.common.component;

import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import org.springframework.stereotype.Component;

/**
 * @author: Gentleman
 * @date: 2022/2/9 10:42
 * @email: 1226734993@qq.com
 */
@Component
public class CustomerIdGenerator implements IdentifierGenerator {
    @Override
    public Long nextId(Object entity) {
        // 填充自己的Id生成器，
        return IdGenerator.generateId();
    }
}
