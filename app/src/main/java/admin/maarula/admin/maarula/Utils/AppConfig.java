package admin.maarula.admin.maarula.Utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;

import java.util.Calendar;

import admin.maarula.admin.maarula.Activity.TestDetailsActivity;
import admin.maarula.admin.maarula.R;


public class AppConfig {

    public static Animation topAnimation, bottomAnimation, middleAnimation;

    public static void initAnimation(Activity activity) {
        topAnimation = AnimationUtils.loadAnimation(activity, R.anim.top);
        bottomAnimation = AnimationUtils.loadAnimation(activity, R.anim.bottom);
        middleAnimation = AnimationUtils.loadAnimation(activity, R.anim.middle);
    }

    public static void jumpTo(Activity thisActivity, Class jumpClass, String anim) {
        Intent intent = new Intent(thisActivity, jumpClass);
        thisActivity.startActivity(intent);
        switch (anim) {
            case "fade":
                thisActivity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;
            case "slide":
                thisActivity.overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                break;
        }
    }

    public static void setStatusBarColor(Activity activity, int color) {
        activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        activity.getWindow().setStatusBarColor(ContextCompat.getColor(activity, color));
        activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }

    public static void setSystemBarTransparent(Activity act) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = act.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }

    public static void showwCustomToast(Activity activity, String message1, String message2) {
        final Toast toast = new Toast(activity);
        toast.setDuration(Toast.LENGTH_LONG);
        View custom_view = activity.getLayoutInflater().inflate(R.layout.custom_toast, null);
        TextView text = custom_view.findViewById(R.id.message2);
        TextView text2 = custom_view.findViewById(R.id.message);
        text.setText(message1);
        text2.setText(message2);
        toast.setView(custom_view);
        toast.show();
    }

    public static void showConfirmDialog(Context context, String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(R.string.ConfirmationString);
        builder.setPositiveButton("Start Test", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                AppConfig.jumpTo((Activity) context, TestDetailsActivity.class, "fade");
            }
        });
        builder.setNegativeButton("Not Now", null);
        builder.show();
    }

    public static String getGreetings() {
        Calendar c = Calendar.getInstance();
        int timeOfDay = c.get(Calendar.HOUR_OF_DAY);

        if (timeOfDay >= 0 && timeOfDay < 12) {
            return "Good Morning";
        } else if (timeOfDay >= 12 && timeOfDay < 16) {
            return "Good Afternoon";
        } else if (timeOfDay >= 16 && timeOfDay < 21) {
            return "Good Evening";
        } else if (timeOfDay >= 21 && timeOfDay < 24) {
            return "Good Night";
        }
        return "";
    }

    public static void nestedScrollTo(final NestedScrollView nested, final View targetView) {
        nested.post(new Runnable() {
            @Override
            public void run() {
                nested.scrollTo(500, targetView.getBottom());
            }
        });
    }


}
