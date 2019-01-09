package kr.co.company.androidstudio00;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class MultiTouchView extends View {
    private static final int SIZE = 60;
    final int MAX_POINTS = 10;
    float[] x = new float[MAX_POINTS];      //변수 x를 배열로 선언
    float[] y = new float[MAX_POINTS];      //변수 y를 배열로 선언
    boolean[] touching = new boolean[MAX_POINTS]; //변수 touching을 배열로 선언
    private Paint mPaint;  //paint를 사용한다.

    public MultiTouchView(Context context, AttributeSet attrs){
        super(context, attrs);
        initView();
    }
    private void initView(){
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.BLUE);                    //색 선언
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);    //스타일 선언
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int index = event.getActionIndex(); //변수 index 선언
        int id = event.getPointerId(index);  //변수 id 선언
        int action = event.getActionMasked(); //변수 action 선언
        //스위치문을 사용
        switch (action) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_POINTER_DOWN:       //만약 눌러지면
                x[id] = (int) event.getX(index);
                y[id] = (int) event.getY(index);        //x와 y의 배열을 바꿔준다.
                touching[id] = true;
                break;                            //touching을 true로 반환하고 break
            case MotionEvent.ACTION_MOVE:     //만약 누른 상태에서 움직이면
                break;                                      //break
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_POINTER_UP:
            case MotionEvent.ACTION_CANCEL:         //만약 손을 떼거나 액션이 취소되면
                touching[id] = false;
                break;                                //touching을 false로 반환하고 break
        }
        invalidate();
        return true;
    }
    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);    //캔버스로 그리기

        for(int i=0; i <MAX_POINTS;i++){
            if(touching[i]){
                canvas.drawCircle(x[i], y[i], SIZE, mPaint);      //x,y좌표에 동그라미 그리기
            }
        }
    }
}
