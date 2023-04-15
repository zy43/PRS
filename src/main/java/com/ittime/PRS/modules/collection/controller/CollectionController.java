package com.ittime.PRS.modules.collection.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ittime.PRS.common.api.CommonPage;
import com.ittime.PRS.common.api.CommonResult;
import com.ittime.PRS.modules.collection.model.Collection;
import com.ittime.PRS.modules.collection.model.param.CollectParam;
import com.ittime.PRS.modules.collection.model.vo.CollectionVo;
import com.ittime.PRS.modules.collection.service.CollectionService;
import com.ittime.PRS.modules.ums.model.UmsAdmin;
import com.ittime.PRS.modules.ums.service.UmsAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Zhl
 * @since 2023-04-04
 */
@RestController
@Api(tags = "CollectionController")
@Tag(name = "CollectionController", description = "政策收藏")
@RequestMapping("/collection")
public class CollectionController {



    @Autowired
    private UmsAdminService umsAdminService;

    @Autowired
    private CollectionService collectionService;

    @ApiOperation("添加/删除收藏")
    @PostMapping
    public CommonResult<String> addOrDelete(Principal principal,@RequestBody CollectParam collectParam){
        String name = principal.getName();
        UmsAdmin user = umsAdminService.getAdminByUsername(name);
        // 未收藏
        if (collectParam.getFlag() == 0) {
            collectionService.addCollection(user.getId(),collectParam.getPolicyId());
            return CommonResult.success("添加成功");
        } else {
            collectionService.deleteCollection(user.getId(),collectParam.getPolicyId());
            return CommonResult.success("删除成功");
        }
    }



    @ApiOperation("用户收藏列表")
    @GetMapping("/list")
    public CommonResult<CommonPage<CollectionVo>> list(Principal principal,
                                                       @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                       @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){
        String name = principal.getName();
        UmsAdmin user = umsAdminService.getAdminByUsername(name);
        IPage<CollectionVo> result = collectionService.pageList(user.getId(),pageSize,pageNum);

        if(result == null) return CommonResult.success(null);
        return CommonResult.success(CommonPage.restPage(result));

    }

}

