package com.ruoyi.common.utils;

import com.ruoyi.system.service.SystemUserRealmService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.RealmSecurityManager;

/**
 * 用户授权信息
 *
 * @author ruoyi
 */
public class AuthorizationUtils {
    /**
     * 清理所有用户授权信息缓存
     */
    public static void clearAllCachedAuthorizationInfo() {
        getUserRealm().clearAllCachedAuthorizationInfo();
    }

    /**
     * 获取自定义Realm
     */
    public static SystemUserRealmService getUserRealm() {
        RealmSecurityManager rsm = (RealmSecurityManager) SecurityUtils.getSecurityManager();
        return (SystemUserRealmService) rsm.getRealms().iterator().next();
    }
}
