package com.example.bemyapp;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createNotificationChannel();
        setContentView(R.layout.activity_main);
        VolunteerDataBase volunteerDataBase = new VolunteerDataBase(this);
        Map<String, Boolean> availableFor = new HashMap<>();
        availableFor.put("callOrMessage", true);
        availableFor.put("Mission", true);
        Map<Date, Date> availableWhen = new HashMap<>();
        availableWhen.put(volunteerDataBase.toDate("Thu Jun 06 01:26:00 GMT 2019"), volunteerDataBase.toDate("Thu Jun 06 10:40:00 GMT 2019"));
        availableWhen.put(volunteerDataBase.toDate("Thu Jun 07 01:26:00 GMT 2019"), volunteerDataBase.toDate("Thu Jun 07 10:40:00 GMT 2019"));
        availableWhen.put(volunteerDataBase.toDate("Thu Jun 08 01:26:00 GMT 2019"), volunteerDataBase.toDate("Thu Jun 08 10:40:00 GMT 2019"));
        Info.getInstance().addVolunteer(new Volunteer("Israel Israeli", "0545558181", availableFor, "Tel Aviv", availableWhen));
        /*
        // narkis's check
        VolunteerDataBase volunteerDataBase = new VolunteerDataBase(this);
        Map<String, Boolean> availableFor = new HashMap<>();
        availableFor.put("callOrMessage", true);
        availableFor.put("Mission", true);
        Map<Date, Date> availableWhen = new HashMap<>();
        availableWhen.put(volunteerDataBase.toDate("Thu Jun 06 01:26:00 GMT 2019"), volunteerDataBase.toDate("Thu Jun 06 01:40:00 GMT 2019"));
        Info.getInstance().addVolunteer("Yael", "0544736473", availableFor, "Tel-Aviv", availableWhen);
        //volunteerDataBase.WriteToFile(this);
        //Info.getInstance().setVolunteersList(volunteerDataBase.loadFromFile(this));
        List<Volunteer> nlist = new SearchVolunteer().getVolunteersForFriend("Tel-Aviv");
        */
    }

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "approveNotification";
            String description = "approve notification";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("channel1", name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    public void beMyClick(View view)
    {
        Intent intent = new Intent(MainActivity.this, beMyChoose.class);
        startActivity(intent);
    }
    public void beForClick(View view)
    {
        Intent intent = new Intent(MainActivity.this, beFor.class);
        startActivity(intent);
    }
}
