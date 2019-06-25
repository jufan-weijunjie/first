package com.wei.first.bean.enums;

/**
 * FileName：UserRoleEnum
 *
 * @author 魏俊杰
 * @date 16:59 2019/6/25
 */
public enum UserRoleEnum {
    ADMIN("admin","管理员"),
    TOURIST_USER("touristUser","游客用户"),
    ORIGINAL_USER("originalUser","普通用户"),
    VIP_LV1("vip","会员等级1"),
    VIP_LV2("vip","会员等级2"),
    VIP_LV3("vip","会员等级3"),
    VIP_LV4("vip","会员等级4"),
    VIP_LV5("vip","会员等级5"),
    VIP_LV6("vip","会员等级6"),
    VIP_LV7("vip","会员等级7"),
    VIP_LV8("vip","会员等级8"),
    VIP_GOLD("vip","会员");

    private String roleName;

    private String note;

    UserRoleEnum(String roleName, String note) {
        this.roleName = roleName;
        this.note = note;
    }

    UserRoleEnum() {
    }
}
