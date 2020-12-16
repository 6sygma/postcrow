package postcrow.app.webview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

public class SplashScreen extends Activity {

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        RotateAnimation anim = new RotateAnimation(0, 360, 50f, 50f);
        anim.setInterpolator(new LinearInterpolator());
        anim.setRepeatCount(Animation.INFINITE);
        anim.setDuration(1700);

        Animation rotate = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
        // Start animating the image
        final ImageView splash = (ImageView) findViewById(R.id.splash);
        splash.startAnimation(anim);
        //splash.startAnimation(rotate);

        // Later.. stop the animation
        splash.setAnimation(null);

		int SPLASH_TIME_OUT = 9000;
		new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(SplashScreen.this, MainActivity.class);
                //Intent i = new Intent(SplashScreen.this, SigninActivity.class);
                startActivity(i);

                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

}
