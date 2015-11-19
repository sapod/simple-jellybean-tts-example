I recently posted this question on stack overflow:
I am trying to play around with the google tts api and no matter what I try, I can't get it to sound like it does in "Google Now"'s search results. Is this not available for use? does anybody know this? Thanks
and I got an answer:
It is possible to access the Google Now voice using the Android TTS APIs. You need to use "KEY\_FEATURE\_NETWORK\_SYNTHESIS" in the "params" parameter for the TextToSpeech.speak() call.

See

http://developer.android.com/reference/android/speech/tts/TextToSpeech.Engine.html#KEY_FEATURE_NETWORK_SYNTHESIS

and

http://developer.android.com/reference/android/speech/tts/TextToSpeech.html#speak(java.lang.String,int,java.util.HashMap)

-- Fergus Henderson

So I decided to put this out there as a sample for others who might want to play around with it.
this will be Jelly Bean only.
Original question @ http://stackoverflow.com/questions/11638628/android-jelly-bean-google-now-text-to-speech-engine-not-availble-for-developer