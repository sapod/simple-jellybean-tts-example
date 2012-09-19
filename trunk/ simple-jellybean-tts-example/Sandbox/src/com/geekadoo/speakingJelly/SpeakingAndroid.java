package com.geekadoo.speakingJelly;

import java.util.HashMap;
import java.util.Locale;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.view.View;
import android.widget.EditText;

public class SpeakingAndroid extends Activity implements OnInitListener {

	// TTS object
	private TextToSpeech myTTS;
	// status check code
	private int MY_DATA_CHECK_CODE = 0;

	// create the Activity
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// check for TTS data
		Intent checkTTSIntent = new Intent();
		checkTTSIntent.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
		startActivityForResult(checkTTSIntent, MY_DATA_CHECK_CODE);
	}

	public void speakClicked(View v) {
		speak(false);
	}

	public void speakJbClicked(View v) {
		speak(true);
	}

	private void speak(boolean b) {
		// get the text entered
		EditText enteredText = (EditText) findViewById(R.id.enter);
		String words = enteredText.getText().toString();
		speakWords(words, b);
	}

	private void speakWords(String speech, boolean b) {
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put(TextToSpeech.Engine.KEY_FEATURE_NETWORK_SYNTHESIS, "true");
		myTTS.speak(speech, TextToSpeech.QUEUE_FLUSH, b ? hashMap : null);
	}

	// act on result of TTS data check
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		if (requestCode == MY_DATA_CHECK_CODE) {
			// if (resultCode == TextToSpeech.Engine.CHECK_VOICE_DATA_PASS) {
			// the user has the necessary data - create the TTS
			myTTS = new TextToSpeech(this, this);
			// }
			// else {
			// //no data - install it now
			// Intent installTTSIntent = new Intent();
			// installTTSIntent.setAction(TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
			// startActivity(installTTSIntent);
			// }
		}
	}

	// setup TTS
	public void onInit(int initStatus) {
		// check for successful instantiation
		// if (initStatus == TextToSpeech.SUCCESS) {
		// if(myTTS.isLanguageAvailable(Locale.US)==TextToSpeech.LANG_AVAILABLE)
		myTTS.setLanguage(Locale.US);
		// }
		// else if (initStatus == TextToSpeech.ERROR) {
		// Toast.makeText(this, "Sorry! Text To Speech failed...",
		// Toast.LENGTH_LONG).show();
		// }
	}
}
