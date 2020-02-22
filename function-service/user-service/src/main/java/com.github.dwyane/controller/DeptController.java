package com.github.dwyane.controller;

import com.github.dwyane.entity.Dept;
import com.github.dwyane.service.DeptService;
import com.github.dwyane.vo.ResponseBean;
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
    public ResponseBean<Dept> findById(@PathVariable Long id) {
//        return ResultVoUtil.success(deptService.findById(id));
        return null;
    }

    /**
     * @description 获取树形部门集合
     * @author xujinzhao
     * @date 2020/2/6 下午11:49
     */
    @GetMapping("/list")
    public ResponseBean<Dept> findTreeList() {
//        return ResultVoUtil.success(deptService.findTreeList());
        return null;
    }

    /**
     * @description 新增/更新部门
     * @author xujinzhao
     * @date 2020/2/7 上午1:57
     */
    @PostMapping
    public ResponseBean save(@RequestBody @Valid Dept dept) {
//        deptService.save(dept);
//        return ResultVoUtil.success();
        return null;
    }

    /**
     * @description 删除部门
     * @author xujinzhao
     * @date 2020/2/7 下午5:39
     */
    @DeleteMapping("/{id}")
    public ResponseBean delete(@PathVariable Long id) {
//        deptService.deleteById(id);
//        return ResultVoUtil.success();
        return null;
    }
}
