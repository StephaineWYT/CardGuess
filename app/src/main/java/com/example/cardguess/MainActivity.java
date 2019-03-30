package com.example.cardguess;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //声明控件
    TextView textView1;
    ImageView imageView1, imageView2, imageView3;
    Button button1;
    //牌的初始顺序
    int poker[] = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3};

    //主函数
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setCardListeners();
        setBtn();
    }

    //初始化相关控件
    public void init() {
        textView1 = findViewById(R.id.textView1);
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        button1 = findViewById(R.id.button1);
    }

    //设置点击牌的监听器
    public void setCardListeners() {
        //将三张牌放入数组
        imageView1.setImageResource(poker[0]);
        imageView2.setImageResource(poker[1]);
        imageView3.setImageResource(poker[2]);

        //设置点击第一张牌的情况
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //牌的图案翻转，替换掉背面
                reverseCardImage();

                //其他两张牌设置成透明
                imageView2.setImageAlpha(100);
                imageView3.setImageAlpha(100);

                //点中和未点中
                if (poker[0] == R.drawable.pic1) {
                    textView1.setText("BINGO!!!");
                } else
                    textView1.setText("better luck next time");
            }
        });

        //设置点击第二张牌的情况
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //牌的图案翻转，替换掉背面
                reverseCardImage();

                //其他两张牌设置成透明
                imageView1.setImageAlpha(100);
                imageView3.setImageAlpha(100);

                //点中和未点中
                if (poker[1] == R.drawable.pic1)
                    textView1.setText("BINGO!!!");
                else
                    textView1.setText("better luck next time");
            }
        });

        //设置点击第三张牌的情况
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //牌的图案翻转，替换掉背面
                reverseCardImage();

                //其他两张牌设置成透明
                imageView1.setImageAlpha(100);
                imageView2.setImageAlpha(100);

                //点中和未点中
                if (poker[2] == R.drawable.pic1)
                    textView1.setText("BINGO!!!");
                else
                    textView1.setText("better luck next time");
            }
        });

    }

    //设置按钮监听
    public void setBtn() {
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //未点击时
                textView1.setText("click to guess red A");

                //设置牌的背面图案
                imageView1.setImageResource(R.drawable.pic4);
                imageView2.setImageResource(R.drawable.pic4);
                imageView3.setImageResource(R.drawable.pic4);

                //设置初始透明度
                imageView1.setImageAlpha(255);
                imageView2.setImageAlpha(255);
                imageView3.setImageAlpha(255);

                //随机洗牌
                for (int i = 0; i < 3; i++) {
                    int tmp = poker[i];
                    int random = (int) (Math.random() * 2);
                    poker[i] = poker[random];
                    poker[random] = tmp;
                }

            }
        });
    }

    public void reverseCardImage() {
        //牌的图案翻转，替换掉背面,重新替换原有顺序
        imageView1.setImageResource(poker[0]);
        imageView2.setImageResource(poker[1]);
        imageView3.setImageResource(poker[2]);
    }
}
