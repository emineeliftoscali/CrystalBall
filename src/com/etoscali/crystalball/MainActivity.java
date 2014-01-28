package com.etoscali.crystalball;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.etoscali.crystalball.ShakeDetector.OnShakeListener;

public class MainActivity extends Activity {
	public static final String TAG = MainActivity.class.getSimpleName();
	private CrystalBall mCrystalBall = new CrystalBall();
	private TextView mAnswerLabel;
	private ImageView mCrystalballImage;
	private SensorManager mSensorManager;
	private Sensor mAccelerometer;
	private ShakeDetector mShakeDetector;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Declaring our button and textview for predictor
		mAnswerLabel = (TextView) findViewById(R.id.textView1);
		mCrystalballImage = (ImageView)findViewById (R.id.imageView1);
		mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
		mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		mShakeDetector = new ShakeDetector(new OnShakeListener() {
			
			@Override
			public void onShake() {
				handleNewAnswer();
				
			}
		});
		
	
		 //Toast.makeText(this, "Yay our activity was created!", Toast.LENGTH_LONG).show();
		//Log.d(TAG, "Error was here MainActivity()");
	}
	
	@Override
	public void onResume() {
		super.onResume();
		mSensorManager.registerListener(mShakeDetector, mAccelerometer, SensorManager.SENSOR_DELAY_UI);
		
	}
	@Override
	public void onPause() {
		super.onPause();
		mSensorManager.unregisterListener(mShakeDetector);
	}
	
	private void animateCrystalBall(){
		
		mCrystalballImage.setImageResource(R.drawable.ball_animation);
		AnimationDrawable ballAnimation = (AnimationDrawable) mCrystalballImage.getDrawable();
		
		if (ballAnimation.isRunning()){
			ballAnimation.stop();
		}
		ballAnimation.start();
		
	}
	
	private void animateAnswer(){
		AlphaAnimation fadeInAnimation = new AlphaAnimation(0, 1);
		fadeInAnimation.setDuration(1500);
		fadeInAnimation.setFillAfter(true);
		mAnswerLabel.setAnimation(fadeInAnimation);
		
		
	}
	
	private void playSound(){
		MediaPlayer player = MediaPlayer.create(this, R.raw.crystal_ball);
		player.start();
		player.setOnCompletionListener(new OnCompletionListener() {
			
			
			@Override
			public void onCompletion(MediaPlayer mp) {
				mp.release();
				
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void handleNewAnswer() {
		String answer = mCrystalBall.getAnAnswer();
		mCrystalBall.mAnswers[0] = "Bana öyle bakma";
		mAnswerLabel.setText(answer);
		animateCrystalBall();
		animateAnswer();
		playSound();
	}

}
