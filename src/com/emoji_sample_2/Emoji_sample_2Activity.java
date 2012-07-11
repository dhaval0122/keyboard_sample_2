package com.emoji_sample_2;

import java.util.HashMap;

import android.app.Activity;
import android.content.DialogInterface;

import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.inputmethodservice.KeyboardView.OnKeyboardActionListener;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;

public class Emoji_sample_2Activity extends Activity implements
		OnKeyboardActionListener, OnKeyListener  {
	
	private KeyboardView keyboardView;
	private Keyboard keyboard;
	EditText currentEditText = null;
	private HashMap<String, String> keyCodeMap;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		keyboardView = (KeyboardView) findViewById(R.id.keyboardView);
		keyboard = new Keyboard(this, R.xml.keyboard_qwerty);
		keyboardView.setKeyboard(keyboard);
		keyboardView.setEnabled(true);
		keyboardView.setPreviewEnabled(true);
		keyboardView.setOnKeyListener((android.view.View.OnKeyListener) this);
		keyboardView.setOnKeyboardActionListener(this);		

		currentEditText = (EditText) findViewById(R.id.editText1);
		currentEditText.setCursorVisible(false);
		currentEditText.setOnClickListener(new View.OnClickListener() {
		   
		   public void onClick(View v) {
			   toggleKeyboardVisibility(currentEditText);
		   }
		  });
	}

	private void toggleKeyboardVisibility(EditText ei) {
		
	       KeyboardView keyboardView = (KeyboardView) findViewById(R.id.keyboardView);
	       int visibility = keyboardView.getVisibility();
	       switch (visibility) {
	        case View.VISIBLE:
	         keyboardView.setVisibility(View.GONE);
	         break;
	        case View.GONE:
	        case View.INVISIBLE:
	         keyboardView.setVisibility(View.VISIBLE);
	         currentEditText = ei;
	         break;
	       }
	  }

	public boolean onKey(View v, int keyCode, KeyEvent event) {	
		return false;
	}
	
	public void onKey(int primaryCode, int[] keyCodes) {
	
		keyCodeMap = new HashMap<String, String>();
	       keyCodeMap.put("1", "1");
	       keyCodeMap.put("2", "2");
	       keyCodeMap.put("3", "3");
	       keyCodeMap.put("4", "4");
	       keyCodeMap.put("5", "5");
	       keyCodeMap.put("6", "6");
	       keyCodeMap.put("7", "7");
	       keyCodeMap.put("8", "8");
	       keyCodeMap.put("9", "9");
	       keyCodeMap.put("0", "0");
	       keyCodeMap.put("11", "q");
	       keyCodeMap.put("12", "w");
	       keyCodeMap.put("13", "e");
	       keyCodeMap.put("14", "r");
	       keyCodeMap.put("15", "t");
	       keyCodeMap.put("16", "y");
	       keyCodeMap.put("17", "u");
	       keyCodeMap.put("18", "i");
	       keyCodeMap.put("19", "o");
	       keyCodeMap.put("10", "p");
	       keyCodeMap.put("21", "a");
	       keyCodeMap.put("22", "s");
	       keyCodeMap.put("23", "d");
	       keyCodeMap.put("24", "f");
	       keyCodeMap.put("25", "g");
	       keyCodeMap.put("26", "h");
	       keyCodeMap.put("27", "j");
	       keyCodeMap.put("28", "k");
	       keyCodeMap.put("29", "l");
	       keyCodeMap.put("31", "z");
	       keyCodeMap.put("32", "x");
	       keyCodeMap.put("33", "c");
	       keyCodeMap.put("34", "v");
	       keyCodeMap.put("35", "b");
	       keyCodeMap.put("36", "n");
	       keyCodeMap.put("37", "m");
	       keyCodeMap.put("-3", "@");
	       keyCodeMap.put("-2", ".com");
	       keyCodeMap.put("-1", "-");
	       keyCodeMap.put("-4", ".");								
			String c = keyCodeMap.get(String.valueOf(primaryCode));	
			if(!(c == null)){
		        currentEditText.append(c);
		       }
		       else{
		        switch(primaryCode){
		        case -5:
		         if(currentEditText.getText().toString().length() > 0)
		          currentEditText.setText(currentEditText.getText().toString().substring
		        		  (0, currentEditText.getText().toString().length() - 1));
		        }
		    }
	}	
	public void onPress(int primaryCode) {  }
	public void onRelease(int primaryCode) { }
	public void onText(CharSequence text) { }
	public void swipeDown() {}
	public void swipeLeft() { }
	public void swipeRight() {}
	public void swipeUp() {	}
}