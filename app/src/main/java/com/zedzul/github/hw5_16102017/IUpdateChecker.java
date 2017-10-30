package com.zedzul.github.hw5_16102017;

interface IUpdateChecker {

    Boolean isForceUpdate();

    Integer getCurrentVersion();

    String getError();
}
