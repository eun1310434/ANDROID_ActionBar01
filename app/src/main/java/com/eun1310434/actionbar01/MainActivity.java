/*=====================================================================
06.03.2018
eun1310434@naver.com
https://blog.naver.com/eun1310434
참고) Do it android app programming
=====================================================================*/

package com.eun1310434.actionbar01;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    ActionBar actionBar;
    //ActionBar는 value의 styles에 따라 달라짐  " <style name="AppTheme" parent="Theme.AppCompat.Light.DarkActionBar"> "
    //이것이 AndroidManifest에 적용됨.android:theme="@style/AppTheme">
    //만약 ActionBar를 없애려면 "Theme.AppCompat.Light.NoActionBar"로 설정하면 됨.


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);

        actionBar = this.getSupportActionBar();// 액션바 객체를 참조


        actionBar.setTitle("Main Title");
        actionBar.setSubtitle("Sub Title");
    }


    // 액션바의 아이콘을 바꿈
    public void onButton1Clicked(View v) {

        if(actionBar.getDisplayOptions() == (ActionBar.DISPLAY_SHOW_HOME | ActionBar.DISPLAY_USE_LOGO)){
            actionBar.setTitle("Main Title");
            actionBar.setSubtitle("Sub Title");
            actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME|ActionBar.DISPLAY_SHOW_TITLE);//Title 보여주기
        }else{
            actionBar.setLogo(R.drawable.home);
            actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME|ActionBar.DISPLAY_USE_LOGO);//Logo 보여주기
        }


    }


    // 액션바 보이기 안보이기 설정
    public void onButton2Clicked(View v) {
        if(actionBar.isShowing()){
            actionBar.hide();//엑션바 감추기
        }else{
            actionBar.show();//액션바 보여주기
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //옵션메뉴 설정
        getMenuInflater().inflate(R.menu.menu_item, menu); //menu inflation
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //옵션메뉴 선택
        switch(item.getItemId()) {
            case R.id.menu_refresh:
                textView.setText("Refresh Menu Choice : ");
                break;
            case R.id.menu_search:
                textView.setText("Search Menu Choice : ");
                break;
            case R.id.menu_settings:
                textView.setText("Search Settings Choice : ");
                break;
            default:
                break;
        }
        textView.append(Integer.toString(item.getOrder()));// item.getOrder() -> XML의 "android:orderInCategory"를 말함
        return super.onOptionsItemSelected(item);
    }

}
