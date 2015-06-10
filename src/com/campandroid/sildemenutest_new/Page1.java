package com.campandroid.sildemenutest_new;


import com.campandroid.sildemenutest_new.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Page1 extends Fragment {
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
	
		View rootView = null;
		rootView = inflater.inflate(R.layout.fragment_main_two, container, false);
		
		MakeWebView(rootView, "http://vintageappmaker.tumblr.com");
		return rootView;
	
	}
	
	// 웹뷰화면을 만든다.
	void MakeWebView(View v, String sUrl) {

		WebView webview = (WebView) v.findViewById(R.id.webView1);
		webview.setWebViewClient(new WebClient());
		WebSettings set = webview.getSettings();
		set.setJavaScriptEnabled(true);
		set.setBuiltInZoomControls(true);
		webview.loadUrl(sUrl);

	}
	
	class WebClient extends WebViewClient {
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

}
