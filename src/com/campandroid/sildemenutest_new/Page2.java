package com.campandroid.sildemenutest_new;

import java.io.IOException;

import com.campandroid.sildemenutest_new.R;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Page2 extends Fragment {
	
	public static final String ARG_SECTION_NUMBER = "section_number";
	
	ImageView imgShare;
	ImageView imgBanner;
	
	int nSelection = 0;

	// 원본 URL의 정보를 배열로 가지고 있다.
	String URL_LIST[] = {
			"https://mirror.enha.kr/wiki/%EA%B3%A0%EC%96%91%EC%9D%B4",
			"https://mirror.enha.kr/wiki/%EA%B3%A0%EC%96%91%EC%9D%B4",
			"https://mirror.enha.kr/wiki/%EC%B1%85",
			"https://mirror.enha.kr/wiki/%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C",
			"https://mirror.enha.kr/wiki/%EA%B3%BC%EC%9D%BC",
			"http://blog.naver.com/adsloader" };

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
	
		View rootView = null;
		rootView = inflater.inflate(R.layout.fragment_main, container, false);
		
		Bundle args = getArguments();
		nSelection  = args.getInt(ARG_SECTION_NUMBER);
		
		MakeEbookView(rootView, nSelection);
		
		MakeEbookView(rootView, nSelection);
		return rootView;
	
	}
	
	// ebbok view를 만든다.
	void MakeEbookView(View v, int nIndx) {
		TextView txtTitle = (TextView) v.findViewById(R.id.section_label);
		txtTitle.setText(" " + nSelection + " page");
		TextView txtContent = (TextView) v.findViewById(R.id.txtContent);

		// 페이지에 맞는 문자열을 가져온다.
		String sContent = getPageText(getActivity().getApplicationContext(),
				nSelection);

		txtContent.setText(sContent);

		imgShare = (ImageView) v.findViewById(R.id.imgShare);
		imgShare.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String sMessage = ">" + nSelection + "의 원본 주소입니다.";
				Context ctx = getActivity().getApplicationContext();
				Toast.makeText(ctx, sMessage, Toast.LENGTH_LONG).show();

				// 선택된 페이지의 URL로 이동한다.
				BrowsedUrl(URL_LIST[nSelection]);

			}
		});

		imgBanner = (ImageView) v.findViewById(R.id.imgBanner);

		// 2페이지이면 그림없음
		if (nIndx == 5) {
			imgBanner.setVisibility(View.GONE);
		} else {
			int[] RES_ID = { R.drawable.cat, R.drawable.cat, R.drawable.books,
					R.drawable.androboy, R.drawable.fruit, R.drawable.books };
			imgBanner.setImageResource(RES_ID[nSelection]);
		}
	}
	
	// 페이지에 맞는 문자열을 가져온다.
	String getPageText(Context ctx, int nIndex) {
		String[] PAGES = { "p1.txt", "p1.txt", "p2.txt", "p3.txt", "p4.txt",
				"p5.txt" };
		String sContent = "";
		try {
			sContent = PageReader.readPage(getActivity()
					.getApplicationContext(), PAGES[nIndex]);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return sContent;
	}
	
	// URL로 이동한다.
	void BrowsedUrl(String sUrl){
		Intent i = new Intent(Intent.ACTION_VIEW); 
		Uri u = Uri.parse(sUrl);
		i.setData(u);

		startActivity(i);
	}

}
