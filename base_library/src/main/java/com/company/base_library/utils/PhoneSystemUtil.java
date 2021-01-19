package com.company.base_library.utils;

import android.os.Build;
import android.os.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * 页面
 *
 * @author wuao
 * @date 2018.05.17
 * @note -
 * ---------------------------------------------------------------------------------------------------------------------
 * @modified -
 * @date -
 * @note -
 */
public class PhoneSystemUtil {
    /**
     * 是否是MIUI系统
     *
     * @return true -- 是 false -- 否
     */
    public static boolean isMIUI() {
        return MIUIUtils.isMIUI();
    }

    /**
     * 是否为Flyme系统
     *
     * @return true -- 是 false -- 否
     */
    public static boolean isFlyme() {
        return FlymeUtils.isFlyme();
    }

    /**
     * MIUI工具
     */
    public static class MIUIUtils {
        private static final String KEY_MIUI_VERSION_CODE = "ro.miui.ui.version.code";
        private static final String KEY_MIUI_VERSION_NAME = "ro.miui.ui.version.name";
        private static final String KEY_MIUI_INTERNAL_STORAGE = "ro.miui.internal.storage";

        /**
         * 是否是MIUI系统
         *
         * @return true -- 是  false -- 否
         */
        public static boolean isMIUI() {
            //1.通过硬件设备的制造商判断
            if (Build.MANUFACTURER.equals("Xiaomi")) {
                return true;
            }
            try {
                final BuildProperties prop = BuildProperties.newInstance();
                return prop.getProperty(KEY_MIUI_VERSION_CODE, null) != null
                        || prop.getProperty(KEY_MIUI_VERSION_NAME, null) != null
                        || prop.getProperty(KEY_MIUI_INTERNAL_STORAGE, null) != null;
            } catch (final IOException e) {
                return false;
            }
        }
    }

    /**
     * Flyme工具
     */
    public static class FlymeUtils {
        /**
         * 是否是Flyme系统
         *
         * @return true -- 是  false -- 否
         */
        public static boolean isFlyme() {
            //1.通过硬件设备的制造商判断
            if (Build.MANUFACTURER.equals("Meizu")) {
                return true;
            }
            try {
                //2.Invoke Build.hasSmartBar()，魅族5.1以下有效
                final Method method = Build.class.getMethod("hasSmartBar");
                return method != null;
            } catch (Exception ignored) {
            }
            //3.通过系统表示来判断
            return isMeizuFlymeOS();
        }

        /**
         * 判断魅族系统操作版本标识
         */
        private static boolean isMeizuFlymeOS() {
            return getSystemProperty().toLowerCase().contains("flyme");
        }

        /**
         * 获取系统操作版本标识
         */
        private static String getSystemProperty() {
            try {
                Class<?> clz = Class.forName("android.os.SystemProperties");
                Method get = clz.getMethod("get", String.class, String.class);
                return (String) get.invoke(clz, "ro.build.display.id", "");
            } catch (Exception ignored) {
            }
            return "";
        }
    }

    /**
     * 属性工具
     */
    public static class BuildProperties {
        private final Properties properties;

        private BuildProperties() throws IOException {
            properties = new Properties();
            properties.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
        }

        public static BuildProperties newInstance() throws IOException {
            return new BuildProperties();
        }

        public boolean containsKey(final Object key) {
            return properties.containsKey(key);
        }

        public boolean containsValue(final Object value) {
            return properties.containsValue(value);
        }

        public Set<Map.Entry<Object, Object>> entrySet() {
            return properties.entrySet();
        }

        public String getProperty(final String name) {
            return properties.getProperty(name);
        }

        public String getProperty(final String name, final String defaultValue) {
            return properties.getProperty(name, defaultValue);
        }

        public boolean isEmpty() {
            return properties.isEmpty();
        }

        public Enumeration<Object> keys() {
            return properties.keys();
        }

        public Set<Object> keySet() {
            return properties.keySet();
        }

        public int size() {
            return properties.size();
        }

        public Collection<Object> values() {
            return properties.values();
        }
    }

}
