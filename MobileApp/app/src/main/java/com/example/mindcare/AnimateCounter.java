package com.example.mindcare;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.animation.Interpolator;
import android.widget.TextView;


public class AnimateCounter {
    private TextView mView;
    private long mDuration;
    private float mStartValue;
    private float mEndValue;
    private int mPrecision;
    private Interpolator mInterpolator;
    private ValueAnimator mValueAnimator;
    private AnimateCounterListener mListener;

    public void execute() {
        mValueAnimator = ValueAnimator.ofFloat(mStartValue, mEndValue);
        mValueAnimator.setDuration(mDuration);
        mValueAnimator.setInterpolator(mInterpolator);
        mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Float current = Float.valueOf(animation.getAnimatedValue().toString());
                mView.setText(String.format("%." + mPrecision + "f", current));
            }
        });
        mValueAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                if(mListener != null) {
                    mListener.onAnimateCounterEnd();
                }
            }
        });
        mValueAnimator.start();
    }

    public static class Builder {
        private long mDuration = 2000;
        private float mStartValue = 0;
        private float mEndValue = 10;
        private int mPrecision = 0;
        private Interpolator mInterpolator = null;
        private TextView mView;

        public Builder(TextView view) {
            if(view == null) {
                throw new IllegalArgumentException("view cannot be null");
            }
            mView = view;
        }
        public Builder setCount(final int start, final int end, final int precision) {
            mStartValue = start;
            mEndValue = end;
            mPrecision = precision;
            return this;
        }

        public Builder setDuration(long duration) {
            mDuration = duration;
            return this;
        }
        public Builder setInterpolator(Interpolator inter) {
            mInterpolator = inter;
            return this;
        }
        public AnimateCounter build() {
            return new AnimateCounter(this);
        }

    }

    private AnimateCounter(Builder builder) {
        mView = builder.mView;
        mDuration = builder.mDuration;
        mStartValue = builder.mStartValue;
        mEndValue = builder.mEndValue;
        mPrecision = builder.mPrecision;
        mInterpolator = builder.mInterpolator;
    }
    public void stop() {
        if(mValueAnimator.isRunning())
            mValueAnimator.cancel();
    }
    public void setAnimateCounterListener(AnimateCounterListener listener) {
        mListener = listener;
    }

    public interface AnimateCounterListener {
        void onAnimateCounterEnd();
    }
}
