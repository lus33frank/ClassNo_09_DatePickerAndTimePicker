package tw.com.frankchang.houli.classno_09_datepickerandtimepicker;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView tvShowDate, tvShowTime;
    Calendar calendar_Today;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findviewer();
    }

    private void findviewer(){
        tvShowDate = (TextView) findViewById(R.id.textView);
        tvShowTime = (TextView) findViewById(R.id.textView2);
    }

    public void dateOnClick(View v){
        int now_year, now_month, now_day;

        calendar_Today = Calendar.getInstance();
        now_year = calendar_Today.get(Calendar.YEAR);
        now_month = calendar_Today.get(Calendar.MONTH);
        now_day = calendar_Today.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog date_DPDialog = new DatePickerDialog(this, DateSetListener,
                                                                now_year, now_month, now_day);
        date_DPDialog.show();
    }

    DatePickerDialog.OnDateSetListener DateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            String strDateTime;

            strDateTime = getResources().getString(R.string.Date) + year + "/" + (month + 1);
            strDateTime += "/" + dayOfMonth;
            tvShowDate.setText(strDateTime);
        }
    };

    public void timeOnClick(View v){
        int now_hour, now_minute;

        calendar_Today = Calendar.getInstance();
        now_hour = calendar_Today.get(Calendar.HOUR_OF_DAY);
        now_minute = calendar_Today.get(Calendar.MINUTE);

        TimePickerDialog time_TPDialog = new TimePickerDialog(this, TimeSetListener,
                                                                now_hour, now_minute, true);
        time_TPDialog.show();
    }

    TimePickerDialog.OnTimeSetListener TimeSetListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            tvShowTime.setText(getResources().getString(R.string.Time) + hourOfDay + "：" + minute);
        }
    };
}
