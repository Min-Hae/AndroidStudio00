package kr.co.company.androidstudio00;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import java.util.Calendar;

//class정의
public class MainActivity extends AppCompatActivity {
    Button btnSelectDate, btnSelectTime; //날짜나오는 버튼과 시간이 나오는 버튼
    DatePickerDialog datePickerDialog;   //날짜를 입력받는 대화상자
    TimePickerDialog timePickerDialog;  //시간을 입력받는 대화상자

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSelectDate=(Button)findViewById(R.id.button1); //날짜 나오는 버튼을 button1과 연결
        btnSelectTime = (Button)findViewById(R.id.button2); //시간 나오는 버튼을 button2와 연결
    }
    //onClick함수를 이용
    public void onClick(View view) {
//만약 날짜 버튼이 눌리면
        if(view == btnSelectDate){
            final Calendar ca = Calendar.getInstance();
            int mYear = ca.get(Calendar.YEAR);
            int mMonth = ca.get(Calendar.MONTH);
            int mDay = ca.get(Calendar.DAY_OF_MONTH);
            //날짜를 입력받는 대화상자에서 년, 달, 날짜를 입력받는다.
            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    btnSelectDate.setText(dayOfMonth + "/" + month + "/" + year);
                }

            }, mYear, mMonth, mDay);
            datePickerDialog.show();  //날짜를 입력 받는 대화상자가 나타나게 한다.
        }
//만약 시간 버튼이 눌리면
        if(view == btnSelectTime) {
            final Calendar ca = Calendar.getInstance();
            int mHour = ca.get(Calendar.HOUR_OF_DAY);
            int mMinute = ca.get(Calendar.MINUTE);
            //시간을 입력 받는 대화상자에서 시, 분을 입력 받는다.
            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    btnSelectTime.setText(hourOfDay + "." + minute);
                }
            }, mHour, mMinute, false);
            timePickerDialog.show();//시간을 입력 받는 대화상자를 나타나게 한다.

        }
    }
}
