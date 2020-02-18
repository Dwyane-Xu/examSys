package com.github.dwyane.controller;

import com.github.dwyane.constant.ApiMsg;
import com.github.dwyane.constant.CommonConstant;
import com.github.dwyane.entity.Role;
import com.github.dwyane.enums.ResultEnum;
import com.github.dwyane.service.RoleService;
import com.github.dwyane.utils.PageUtil;
import com.github.dwyane.utils.ResultVoUtil;
import com.github.dwyane.vo.ResponseBean;
import com.github.dwyane.vo.ResultVo;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    public ResponseBean<Role> findById(@PathVariable Long id) {
        return new ResponseBean<>(roleService.findById(id));
    }

    /**
     * @description 分页获取角色列表
     * @author xujinzhao
     * @date 2020/2/8 上午12:41
     */
    @GetMapping("/listPage")
    public ResponseBean<PageImpl<Role>> findPage(@RequestParam(value = CommonConstant.PAGE_NUM, required = false, defaultValue = CommonConstant.PAGE_NUM_DEFAULT) String pageNum,
                                             @RequestParam(value = CommonConstant.PAGE_SIZE, required = false, defaultValue = CommonConstant.PAGE_SIZE_DEFAULT) String pageSize,
                                             @RequestParam(value = CommonConstant.SORT, required = false, defaultValue = CommonConstant.PAGE_SORT_DEFAULT) String sort,
                                             @RequestParam(value = CommonConstant.ORDER, required = false, defaultValue = CommonConstant.PAGE_ORDER_DEFAULT) String order) {
        return new ResponseBean<>(roleService.findPage(PageUtil.Pageable(pageNum, pageSize, sort, order)));
    }

    /**
     * @description 新增/修改角色
     * @author xujinzhao
     * @date 2020/2/8 上午1:12
     */
    @PostMapping
    public ResponseBean<String> save(@RequestBody @Valid Role role) {
        try {
            roleService.save(role);
            return new ResponseBean<>();
        } catch (Exception e) {
            return new ResponseBean<>(e.getMessage(), ApiMsg.);
        }
    }

    /**
     * @description 根据id删除角色
     * @author xujinzhao
     * @date 2020/2/8 上午1:14
     */
    @DeleteMapping("/{id}")
    public ResponseBean<String> delete(@PathVariable Long id) {
        try {
            roleService.deleteById(id);
            return new ResponseBean<>();
        } catch (Exception e) {
            return new ResponseBean<>(e.getMessage());
        }
    }

    /**
     * @description 批量删除角色
     * @author xujinzhao
     * @date 2020/2/8 下午4:15
     */
    @DeleteMapping
    public ResponseBean<String> deleteList(@RequestBody Long[] ids) {
        try {
            if (ArrayUtils.isNotEmpty(ids)) {
                roleService.deleteList(ids);
                return new ResponseBean<>();
            } else {
                return new ResponseBean<>(, , )
            }
        } catch (Exception e) {

        }
    }

    @PutMapping("/{roleId}/{menuIds}")
    public ResponseBean<Boolean> updateMenuIdsByRoleId(@PathVariable Long roleId, @PathVariable String menuIds) {
        return null;
    }
}
