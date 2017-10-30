package com.zedzul.github.hw5_16102017;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;

import java.util.List;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MainActivityTest {

    private static final String UPDATE_DONE = "update done";
    private static final String FAKE_VERSION = "12345";
    private static final String FAKE_VERSION_2 = "54321";
    private static final String FAKE_VERSION_3 = "1";

    @Captor
    ArgumentCaptor<String> argumentCaptor;

    @Before
    public void someInit() {
        argumentCaptor = ArgumentCaptor.forClass(String.class);
    }

    @Test
    public void doReturnExample() {
        final MainActivity pMockMain = mock(MainActivity.class);
        doReturn(UPDATE_DONE).when(pMockMain).checkUpdate();

        Assert.assertEquals(UPDATE_DONE, pMockMain.checkUpdate());
        verify(pMockMain).checkUpdate();
    }

    @Test
    public void captorExample() {
        final UpdateChecker pMockUpdateChecker = mock(UpdateChecker.class);
        doReturn(FAKE_VERSION_2).when(pMockUpdateChecker).fakeCurentVersion(FAKE_VERSION);

        Assert.assertEquals(FAKE_VERSION_2, pMockUpdateChecker.fakeCurentVersion(FAKE_VERSION));

        verify(pMockUpdateChecker).fakeCurentVersion(argumentCaptor.capture());

        final List<String> pStringArgs = argumentCaptor.getAllValues();
        Assert.assertEquals(FAKE_VERSION_2, pMockUpdateChecker.fakeCurentVersion(pStringArgs.get(0)));

    }
}