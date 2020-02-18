package com.github.dwyane.dto;

import com.github.dwyane.entity.Menu;
import com.github.dwyane.entity.TreeEntity;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @ClassNanme: MenuDto
 * @Description: 树形菜单dto
 * @Author: xujinzhao
 * @Date: 2020/2/16 16:05
 */
@Data
public class MenuDto extends TreeEntity<MenuDto> {

    /**
     * 菜单名称
     */
    @NotBlank(message = "菜单名称不能为空")
    private String name;

    /**
     * 菜单权限标识
     */
    private String permission;

    /**
     * url
     */
    private String url;

    /**
     * 重定向url
     */
    private String redirect;

    /**
     * 图标
     */
    private String icon;

    /**
     * 类型
     */
    private Integer type;

    /**
     * 模块
     */
    private String component;

    /**
     * 路径
     */
    private String path;

    /**
     * 备注
     */
    private String remark;

    public MenuDto(Menu menu) {
        this.id = menu.getId();
        this.parentId = menu.getParentId();
        this.icon = menu.getIcon();
        this.name = menu.getName();
        this.url = menu.getUrl();
        this.type = menu.getType();
        this.sort = Integer.parseInt(menu.getSort());
        this.component = menu.getComponent();
        this.path = menu.getPath();
        this.redirect = menu.getRedirect();
        this.remark = menu.getRemark();
    }
}
