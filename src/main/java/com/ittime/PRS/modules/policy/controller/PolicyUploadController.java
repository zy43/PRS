package com.ittime.PRS.modules.policy.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.cache.MapCache;
import com.ittime.PRS.common.api.CommonResult;
import com.ittime.PRS.modules.policy.mapper.PolicyUploadDAO;
import com.ittime.PRS.modules.policy.model.excel.PolicyExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author zhl129
 * @date 2023/3/9 15:54
 * @email 1293384775@qq.com
 */
@RestController
@RequestMapping("/policy/upload")
public class PolicyUploadController {

    @Autowired
    private PolicyUploadDAO policyUploadDAO;

    /**
     * 文件上传
     * <p>1. 创建excel对应的实体对象 参照{@link PolicyExcel}
     * <p>2. 由于默认一行行的读取excel，所以需要创建excel一行一行的回调监听器，参照{@link UploadDataListener}
     * <p>3. 直接读即可
     */
    @PostMapping("/excel")
    @ResponseBody
    public CommonResult upload(@RequestParam(value = "file") MultipartFile file) throws IOException {

        try {
            EasyExcel.read(file.getInputStream(), PolicyExcel.class, new UploadDataListener(policyUploadDAO)).readCache(new MapCache()).headRowNumber(1).sheet().doRead();
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.failed("读取失败");
        }
        return CommonResult.success("读取成功");
    }
}
