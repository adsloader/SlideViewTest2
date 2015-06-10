package com.campandroid.sildemenutest_new;

import java.io.IOException;
import java.io.InputStream;

import android.content.Context;

// asset���� ������ �д´�.
public class PageReader {
    static public  String readPage(Context ctx, String sPageFile) throws IOException {
	    
    	InputStream is = ctx.getAssets().open(sPageFile);
		int size = is.available();
		byte[] buffer = new byte[size];
		is.read(buffer);
		is.close();
		
		// ���� ���ڵ��� � �������� �ݵ�� �˾ƾ� �մϴ�.
		// �������ϸ� ������ ���ڸ� ������ �� ���Դϴ�.
		String sText = new String(buffer, "euc-kr");
		
		return sText;
	}
}
