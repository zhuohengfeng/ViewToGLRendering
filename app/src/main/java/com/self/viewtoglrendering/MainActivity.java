package com.self.viewtoglrendering;

import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.self.viewtoglrendering.cuberenerer.CubeGLRenderer;


public class MainActivity extends AppCompatActivity {

    private GLSurfaceView mGLSurfaceView;
    private GLRenderable mGLLinearLayout;
    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViews();
    }

    private void initViews() {
        setContentView(R.layout.activity_main);

        ViewToGLRenderer viewToGlRenderer = new CubeGLRenderer(this);

        mGLSurfaceView = (GLSurfaceView) findViewById(R.id.gl_surface_view);
        mGLLinearLayout = (GLRenderable) findViewById(R.id.gl_layout);
        mWebView = (WebView) findViewById(R.id.web_view);

        mGLSurfaceView.setEGLContextClientVersion(2);
        mGLSurfaceView.setRenderer(viewToGlRenderer);

        mGLLinearLayout.setViewToGLRenderer(viewToGlRenderer);

        mWebView.setWebViewClient(new WebViewClient());
        mWebView.setWebChromeClient(new WebChromeClient());
        mWebView.loadUrl("https://www.baidu.com/");
    }


}
