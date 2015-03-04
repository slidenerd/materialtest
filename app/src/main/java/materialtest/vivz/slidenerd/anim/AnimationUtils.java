package materialtest.vivz.slidenerd.anim;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.support.v7.widget.RecyclerView;

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
}
