package com.zedzul.github.hw5_16102017.backend;

import com.example.ConfigGson;
import com.google.gson.Gson;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConfigServlet extends HttpServlet {

    private static final int DEFAULT_APP_VERSION = 1;
    private static final boolean DEFAULT_FORCE_UPDATE = false;

    @Override
    public void doPost(final HttpServletRequest pRequest, final HttpServletResponse pResponse)
            throws IOException {
        String pExceptionMessage = "";
        if (pRequest.getParameter("client_app") == null) {
            final String pReqVersion = pRequest.getParameter("version");
            final String pReqForceUpdate = pRequest.getParameter("force_update");

            try {
                ConfigConstants.setCurrentAppVersion(Integer.valueOf(pReqVersion));
                ConfigConstants.setForceUpdate(Boolean.valueOf(pReqForceUpdate));
            } catch (final Exception pE) {
                ConfigConstants.setCurrentAppVersion(DEFAULT_APP_VERSION);
                ConfigConstants.setForceUpdate(DEFAULT_FORCE_UPDATE);
                pExceptionMessage = pE.getMessage();
            }
        }

        pResponse.setContentType("application/json");
        final ConfigGson result = new ConfigGson(ConfigConstants.getCurrentAppVersion(), ConfigConstants.isForceUpdate(), pExceptionMessage);
        new Gson().toJson(result, pResponse.getWriter());

    }

}
