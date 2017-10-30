package com.zedzul.github.hw5_16102017.backend;

final class ConfigConstants {

    static void setCurrentAppVersion(final Integer pCurrentAppVersion) {
        CURRENT_APP_VERSION = pCurrentAppVersion;
    }

    static void setForceUpdate(final Boolean pFORCE_UPDATE) {
        FORCE_UPDATE = pFORCE_UPDATE;
    }

    static Integer getCurrentAppVersion() {
        return CURRENT_APP_VERSION;
    }

    static Boolean isForceUpdate() {
        return FORCE_UPDATE;
    }

    private static Integer CURRENT_APP_VERSION = 1;
    private static Boolean FORCE_UPDATE = false;
}
