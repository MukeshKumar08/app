package com.gg.gg.CommonActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class smsBroadcastReceiver extends BroadcastReceiver {



    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getAction().equals("android.Provider.Telephony.SMS_RECEIVED")){
                Bundle bundle = intent.getExtras();
                SmsMessage[] message;
                String Sms_From;
                if (bundle!=null){
                    try{
                        Object[] pdus = (Object[])bundle.get("pdus");
                        message = new SmsMessage[pdus.length];
                        for (int i=0;i<message.length;i++){
                            message[i] = SmsMessage.createFromPdu((byte[])pdus[i]);
                            Sms_From = message[i].getOriginatingAddress();
                            String SmsBody = message[i].getMessageBody();

                            Toast.makeText(context, "From:" + Sms_From + ", Body:"+SmsBody, Toast.LENGTH_SHORT).show();
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
        }

    }
}
