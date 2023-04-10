package com.ittime.PRS.modules.collection.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ittime.PRS.common.api.CommonPage;
import com.ittime.PRS.common.api.CommonResult;
import com.ittime.PRS.modules.collection.model.Collection;
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

    @ApiOperation("添加收藏")
    @PostMapping
    public CommonResult<String> add(Principal principal,@RequestBody Collection collection){
        String name = principal.getName();
        UmsAdmin user = umsAdminService.getAdminByUsername(name);
        boolean success = collectionService.addCollection(user.getId(),collection);
        if (success) {
            return CommonResult.success("添加成功");
        } else {
            return CommonResult.failed("已存在，添加失败");
        }
    }

    @ApiOperation("删除收藏")
    @DeleteMapping("/{id}")
    public CommonResult<String> delete(@PathVariable Long id){
        boolean success = collectionService.deleteCollection(id);
        if (success) {
            return CommonResult.success("删除成功");
        } else {
            return CommonResult.failed("删除失败");
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
        return CommonResult.success(CommonPage.restPage(result));

    }

}

