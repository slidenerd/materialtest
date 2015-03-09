package materialtest.vivz.slidenerd.anim;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

/**
 * Created by Windows on 04-03-2015.
 */
public class AnimationUtils {
    public static void scaleXY(RecyclerView.ViewHolder holder) {
        holder.itemView.setScaleX(0);
        holder.itemView.setScaleY(0);

        PropertyValuesHolder propx = PropertyValuesHolder.ofFloat("scaleX", 1);
        PropertyValuesHolder propy = PropertyValuesHolder.ofFloat("scaleY", 1);

        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(holder.itemView, propx, propy);


        animator.setDuration(800);
        animator.start();
    }

    public static void scaleX(RecyclerView.ViewHolder holder) {
        holder.itemView.setScaleX(0);

        PropertyValuesHolder propx = PropertyValuesHolder.ofFloat("scaleX", 1);

        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(holder.itemView, propx);


        animator.setDuration(800);
        animator.start();
    }

    public static void scaleY(RecyclerView.ViewHolder holder) {
        holder.itemView.setScaleY(0);

        PropertyValuesHolder propy = PropertyValuesHolder.ofFloat("scaleY", 1);

        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(holder.itemView, propy);

        animator.setDuration(800);
        animator.start();
    }

    public static void animate(RecyclerView.ViewHolder holder, boolean goesDown) {

        YoYo.with(Techniques.RubberBand)
                .duration(1000)
                .playOn(holder.itemView);
//        AnimatorSet animatorSet = new AnimatorSet();
//        ObjectAnimator animatorScaleX = ObjectAnimator.ofFloat(holder.itemView, "scaleX" ,0.5F, 0.8F, 1.0F);
//        ObjectAnimator animatorScaleY = ObjectAnimator.ofFloat(holder.itemView, "scaleY", 0.5F, 0.8F, 1.0F);
//        ObjectAnimator animatorTranslateY = ObjectAnimator.ofFloat(holder.itemView, "translationY", goesDown == true ? 300 : -300, 0);
//        ObjectAnimator animatorTranslateX = ObjectAnimator.ofFloat(holder.itemView, "translationX", -50, 50, -30, 30, -20, 20, -5, 5, 0);
//        animatorSet.playTogether(animatorTranslateX, animatorTranslateY, animatorScaleX, animatorScaleY);
//        animatorSet.setInterpolator(new AnticipateInterpolator());
//        animatorSet.setDuration(1000);
//        animatorSet.start();

    }

    public static void animateToolbar(View containerToolbar) {


    }

//        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(holder.itemView, "translationY", (positive == true ? 200.0F : -200.F), 0F);
//        objectAnimator.setInterpolator(new DecelerateInterpolator());
//        objectAnimator.setDuration(1000);
//        objectAnimator.start();
//        YoYo.with(Techniques.StandUp).duration(800).playOn(holder.itemView);
//        AnimatorSet animatorSet = new AnimatorSet();
//        Animator scaleVertical = ObjectAnimator.ofFloat(holder.itemView,"scaleY",1.0F,0.8F,1.2F,1.4F,1.6F,1.4F,1.2F,0.8F,1.0F).setDuration(2000);
//        Animator rotateY = ObjectAnimator.ofFloat(holder.itemView,"rotationY",0,5,10,15,20,25,30,25,20,15,10,5,0).setDuration(2000);
//        //ObjectAnimator.ofFloat(holder.itemView,"scaleY",1.0F,0.8F,1.2F,1.4F,1.6F,1.4F,1.2F,0.8F,1.0F).setDuration(2000)
//        //ObjectAnimator.ofFloat(holder.itemView,"rotationY",0,5,10,15,20,25,30,25,20,15,10,5,0).setDuration(2000);
//
//        animatorSet.playTogether(rotateY, scaleVertical);
//        animatorSet.start();


//        containerToolbar.setRotationX(-90);
//        containerToolbar.setAlpha(0.2F);
//        containerToolbar.setPivotX(0.0F);
//        containerToolbar.setPivotY(0.0F);
//
//        Animator alpha = ObjectAnimator.ofFloat(containerToolbar, "alpha", 0.2F, 0.4F, 0.6F, 0.8F, 1.0F).setDuration(4000);
//        Animator rotationX = ObjectAnimator.ofFloat(containerToolbar, "rotationX", -90, 60, -45, 45, -10, 30, 0, 20, 0, 5, 0).setDuration(8000);
//        AnimatorSet animatorSet = new AnimatorSet();
//        animatorSet.setInterpolator(new DecelerateInterpolator());
//        animatorSet.playTogether(alpha, rotationX);
//        animatorSet.start();
}
