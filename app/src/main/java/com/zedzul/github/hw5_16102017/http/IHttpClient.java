package com.zedzul.github.hw5_16102017.http;

interface IHttpClient {

    void request(String url, HttpClient.IResponseListener listener);
}
