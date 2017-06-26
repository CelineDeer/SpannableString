package com.hxl.alarmdemo;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView hypeLinkText;
    private TextView foreginColorText;
    private TextView backColorText;
    private TextView differentTextSize;
    private TextView strikeText;
    private TextView underlineText;
    private TextView superText;
    private TextView subScriptText;
    private TextView containsImageText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();

        initData();

    }
    private void initView(){
        setContentView(R.layout.activity_main);
        hypeLinkText = (TextView) findViewById(R.id.text);
        foreginColorText = (TextView) findViewById(R.id.text_foregin_color);
        backColorText = (TextView) findViewById(R.id.text_backgroud_color);
        differentTextSize = (TextView) findViewById(R.id.text_different_size);
        strikeText = (TextView) findViewById(R.id.text_strike_line);
        underlineText = (TextView) findViewById(R.id.text_under_line);
        superText = (TextView) findViewById(R.id.text_super_script);
        subScriptText = (TextView) findViewById(R.id.text_sub_script);
        containsImageText = (TextView) findViewById(R.id.text_contains_image);
    }

    private void initData(){
        //设置文字超链接
        setTextHypeLink2();

        //设置文字前景色 ForegroundColorSpan
        setTextForginColor();

        //设置文字背景色 BackgroundColorSpan
        setTextBackColor();

        //textview显示不同大小的字体
        setTextDifferentSize();

        //设置文字的删除线
        setTextStrikeLine();

        //设置文字的下划线
        setTextUnderline();

        //设置文字的下标
        setTextSuperScript();

        //设置文字的上标
        setTextSubScript();

        //设置文字里面包含表情
        setTextContainsImage();

    }



    private void setTextHypeLink(){
        String html = "<a href='http://www.baidu.com'>百度一下</a> 我就知道";
        CharSequence charSequence = Html.fromHtml(html);
        SpannableStringBuilder builder = new SpannableStringBuilder(charSequence);
        URLSpan[] urlSpans = builder.getSpans(0, charSequence.length(),
                URLSpan.class);
        for (URLSpan span : urlSpans) {
            int start = builder.getSpanStart(span);
            int end = builder.getSpanEnd(span);
            int flag = builder.getSpanFlags(span);
            final String link = span.getURL();
            builder.setSpan(new ClickableSpan() {
                @Override
                public void onClick(View widget) {
                    // 捕获&lt;a>标签点击事件，及对应超链接link
                }
            }, start, end, flag);
            builder.removeSpan(span);
        }
        hypeLinkText.setLinksClickable(true);
        hypeLinkText.setMovementMethod(LinkMovementMethod.getInstance());
        hypeLinkText.setText(charSequence);
    }

    private void setTextForginColor(){
        SpannableString spannableString = new SpannableString("这是文字的前景色");
        ForegroundColorSpan span = new ForegroundColorSpan(Color.parseColor("#0099ee"));
        spannableString.setSpan(span,5,8, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        foreginColorText.setText(spannableString);
    }

    private void setTextBackColor(){
        SpannableString spannableString1 = new SpannableString("设置文字的背景色");
        BackgroundColorSpan span1 = new BackgroundColorSpan(Color.parseColor("#ac00ff30"));
        spannableString1.setSpan(span1,5,8,Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        backColorText.setText(spannableString1);
    }

    private void setTextDifferentSize(){
        SpannableString spannableString2 = new SpannableString("我们是葫芦娃葫芦娃");
        RelativeSizeSpan relativeSizeSpan1 = new RelativeSizeSpan(1.2f);
        RelativeSizeSpan relativeSizeSpan2 = new RelativeSizeSpan(1.4f);
        RelativeSizeSpan relativeSizeSpan3 = new RelativeSizeSpan(1.6f);
        RelativeSizeSpan relativeSizeSpan4 = new RelativeSizeSpan(1.8f);
        RelativeSizeSpan relativeSizeSpan5 = new RelativeSizeSpan(1.6f);
        RelativeSizeSpan relativeSizeSpan6 = new RelativeSizeSpan(1.4f);
        RelativeSizeSpan relativeSizeSpan7 = new RelativeSizeSpan(1.2f);
        RelativeSizeSpan relativeSizeSpan8 = new RelativeSizeSpan(1.2f);

        spannableString2.setSpan(relativeSizeSpan1,1,2,Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        spannableString2.setSpan(relativeSizeSpan2,2,3,Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        spannableString2.setSpan(relativeSizeSpan3,3,4,Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        spannableString2.setSpan(relativeSizeSpan4,4,5,Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        spannableString2.setSpan(relativeSizeSpan5,5,6,Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        spannableString2.setSpan(relativeSizeSpan6,6,7,Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        spannableString2.setSpan(relativeSizeSpan7,7,8,Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        spannableString2.setSpan(relativeSizeSpan8,8,9,Spanned.SPAN_INCLUSIVE_EXCLUSIVE);

        differentTextSize.setText(spannableString2);
    }

    private void setTextStrikeLine() {
        SpannableString strikeSpannableString = new SpannableString("我是删除线");
        StrikethroughSpan StrikeSpan = new StrikethroughSpan();
        strikeSpannableString.setSpan(StrikeSpan,2,5,Spanned.SPAN_INCLUSIVE_EXCLUSIVE);

        strikeText.setText(strikeSpannableString);
    }

    private void setTextUnderline() {
        SpannableString underlineString = new SpannableString("我是下划线下划线");
        UnderlineSpan underlineSpan = new UnderlineSpan();
        underlineString.setSpan(underlineSpan,2,8,Spanned.SPAN_INCLUSIVE_INCLUSIVE);

        underlineText.setText(underlineString);
    }

    private void setTextSuperScript() {
        SpannableString superString = new SpannableString("这个是上标");
        SuperscriptSpan span = new SuperscriptSpan();
        RelativeSizeSpan sizeSpan = new RelativeSizeSpan(0.6f);
        superString.setSpan(span,3,5, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        superString.setSpan(sizeSpan,3,5,Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        superText.setText(superString);
    }

    private void setTextSubScript() {
        SpannableString spannablestring = new SpannableString("这个是下标");
        SubscriptSpan subSpan = new SubscriptSpan();
        spannablestring.setSpan(subSpan,3,5,Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        RelativeSizeSpan sizeSpan = new RelativeSizeSpan(0.6f);
        spannablestring.setSpan(sizeSpan,3,5,Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        subScriptText.setText(spannablestring);
    }

    private void setTextContainsImage() {
        SpannableString imageString = new SpannableString("这个文字里面包含表情(表情)");
        Drawable image = getResources().getDrawable(R.mipmap.smiley_0);
        image.setBounds(0,0,50,50);
        ImageSpan imageSpan = new ImageSpan(image);
        imageString.setSpan(imageSpan,8,10,Spanned.SPAN_INCLUSIVE_INCLUSIVE);

        containsImageText.setText(imageString);
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
    }


    private void setTextHypeLink2(){
        SpannableString spannableString = new SpannableString("为文字设置超链接");
        URLSpan urlSpan = new URLSpan("http://www.jianshu.com/u/b216fb12a05d");
        spannableString.setSpan(urlSpan, 5, spannableString.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        hypeLinkText.setMovementMethod(LinkMovementMethod.getInstance());
        hypeLinkText.setHighlightColor(Color.parseColor("#36969696"));
        hypeLinkText.setText(spannableString);
    }


}
