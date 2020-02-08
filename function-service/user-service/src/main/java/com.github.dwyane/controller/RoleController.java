package com.github.dwyane.controller;

import com.github.dwyane.constant.CommonConstant;
import com.github.dwyane.entity.Role;
import com.github.dwyane.enums.ResultEnum;
import com.github.dwyane.service.RoleService;
import com.github.dwyane.utils.PageUtil;
import com.github.dwyane.utils.ResultVoUtil;
import com.github.dwyane.vo.ResultVo;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @ClassNanme: RoleController
 * @Description: 角色controller
 * @Author: xujinzhao
 * @Date: 2020/2/7 23:52
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    /**
     * @description 根据id获取角色
     * @author xujinzhao
     * @date 2020/2/8 上午12:41
     */
    @GetMapping("/{id}")
    public ResultVo<Role> get(@PathVariable Long id) {
        return ResultVoUtil.success(roleService.findById(id));
    }

    /**
     * @description 分页获取角色列表
     * @author xujinzhao
     * @date 2020/2/8 上午12:41
     */
    @GetMapping("/listPage")
    public ResultVo<PageImpl<Role>> listPage(@RequestParam(value = CommonConstant.PAGE_NUM, required = false, defaultValue = CommonConstant.PAGE_NUM_DEFAULT) String pageNum,
                                             @RequestParam(value = CommonConstant.PAGE_SIZE, required = false, defaultValue = CommonConstant.PAGE_SIZE_DEFAULT) String pageSize,
                                             @RequestParam(value = CommonConstant.SORT, required = false, defaultValue = CommonConstant.PAGE_SORT_DEFAULT) String sort,
                                             @RequestParam(value = CommonConstant.ORDER, required = false, defaultValue = CommonConstant.PAGE_ORDER_DEFAULT) String order) {
        return ResultVoUtil.success(
                roleService.findPage(PageUtil.Pageable(pageNum, pageSize, sort, order)));
    }

    /**
     * @description 新增/修改角色
     * @author xujinzhao
     * @date 2020/2/8 上午1:12
     */
    @PostMapping
    public ResultVo save(@RequestBody @Valid Role role) {
        roleService.save(role);
        return ResultVoUtil.success();
    }

    /**
     * @description 根据id删除角色
     * @author xujinzhao
     * @date 2020/2/8 上午1:14
     */
    @DeleteMapping("/{id}")
    public ResultVo delete(@PathVariable Long id) {
        roleService.deleteById(id);
        return ResultVoUtil.success();
    }

    /**
     * @description 批量删除角色
     * @author xujinzhao
     * @date 2020/2/8 下午4:15
     */
    @DeleteMapping
    public ResultVo deleteList(@RequestBody Long[] ids) {
        if (ArrayUtils.isNotEmpty(ids)) {
            roleService.deleteList(ids);
            return ResultVoUtil.success();
        } else {
            return ResultVoUtil.error(ResultEnum.PARAM_ERROR);
        }
    }
}
