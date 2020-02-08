package com.github.dwyane.controller;

import com.github.dwyane.vo.ResultVo;
import com.github.dwyane.entity.Dept;
import com.github.dwyane.service.DeptService;
import com.github.dwyane.utils.ResultVoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @ClassNanme: DeptController
 * @Description: 部门controller
 * @Author: xujinzhao
 * @Date: 2020/2/6 17:39
 */
@RestController
@RequestMapping("/dept")
public class DeptController {

    private final DeptService deptService;

    @Autowired
    public DeptController(DeptService deptService) {
        this.deptService = deptService;
    }

    /**
     * @description 根据id获取部门
     * @author xujinzhao
     * @date 2020/2/7 上午1:40
     */
    @GetMapping("/{id}")
    public ResultVo<Dept> get(@PathVariable Long id) {
        return ResultVoUtil.success(deptService.findById(id));
    }

    /**
     * @description 获取树形部门集合
     * @author xujinzhao
     * @date 2020/2/6 下午11:49
     */
    @GetMapping("/list")
    public ResultVo<Dept> list() {
        return ResultVoUtil.success(deptService.findList());
    }

    /**
     * @description 新增/更新部门
     * @author xujinzhao
     * @date 2020/2/7 上午1:57
     */
    @PostMapping
    public ResultVo save(@RequestBody @Valid Dept dept) {
        deptService.save(dept);
        return ResultVoUtil.success();
    }

    /**
     * @description 删除部门
     * @author xujinzhao
     * @date 2020/2/7 下午5:39
     */
    @DeleteMapping("/{id}")
    public ResultVo delete(@PathVariable Long id) {
        deptService.deleteById(id);
        return ResultVoUtil.success();
    }
}
