import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by Владимир on 12.01.2017.
 */


public class CustomSeekBar extends LinearLayout {

    Context context;
    boolean Interval_enable = false;
    public CustomSeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        seekBar = new SeekBar(context);
    }
    String[] list = null;

    private SeekBar seekBar;
    Activity getActivity() {
        return (Activity) context;
    }

    public void setInterval(String[] list)
    {

        this.list = list;
        Interval_enable = true;

    }


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if(changed && getChildCount()==0)
        {
            removeAllViews();
            if(Interval_enable)
            {
                Create_SeekBar_with_interval();
            }
            else
            {
                Create_SeekBar_standart();
            }
        }
    }

    void Create_SeekBar_with_interval()
    {
        setOrientation(VERTICAL);
        setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        float count = list.length;
        final LinearLayout linearLayout = new LinearLayout(context);
        seekBar.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        seekBar.setMax((int) (count - 1));
        TextView tt = new TextView(context);
        tt.setText(list[0]);
        tt.measure(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED);
        int f_padding = tt.getMeasuredWidth()/2;
        tt.setText(list[list.length - 1]);
        tt.measure(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED);
        int s_padding = tt.getMeasuredWidth()/2;
        seekBar.setPadding(f_padding,0,s_padding,0);

        float last_sum = 0;
        float main_width = getMeasuredWidth()-getPaddingLeft()-getPaddingRight()-seekBar.getPaddingLeft()-seekBar.getPaddingRight();
        float interval = main_width/(count - 1);
        linearLayout.setOrientation(HORIZONTAL);
        for (float i = 0; i < count; i++) {
            TextView tv = new TextView(context);
            tv.setText(list[(int) i]);
            tv.measure(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED);
            int width = tv.getMeasuredWidth();
            float add = width/2 ;
            float x = (interval)*i - last_sum-add+seekBar.getPaddingLeft();
            linearLayout.addView(tv);
            tv.setX(x);
            last_sum+=width;
        }
        addView(linearLayout);
        addView(seekBar);
    }
    void Create_SeekBar_standart()
    {
        addView(seekBar);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);


        final int height = getMeasuredHeight();
        final int width = getMeasuredWidth();
        setMeasuredDimension(width,height);
    }
    public int getProgress() {
        return getSeekBar().getProgress();
    }

    public void setProgress(int progress) {
        getSeekBar().setProgress(progress);
    }
    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        getSeekBar().setOnSeekBarChangeListener(onSeekBarChangeListener);
    }
    private SeekBar getSeekBar() {
        return seekBar;
    }
}
