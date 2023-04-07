package in.bitcode.volumemanagercustomdialog2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btnManageVolume;
    private TextView txtMediaVolume,txtCallVolume,txtNotificationVolume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        btnManageVolume.setOnClickListener(new BtnManageVolumeOnClickListener());
    }

    private void initViews(){
        btnManageVolume=findViewById(R.id.btnManageVolume);
        txtMediaVolume=findViewById(R.id.txtMediaVolume);
        txtCallVolume=findViewById(R.id.txtCallVolume);
        txtNotificationVolume=findViewById(R.id.txtNotificationVolume);
    }

    private class BtnManageVolumeOnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            VolumeManagerDialog volumeManagerDialog=new VolumeManagerDialog(MainActivity.this);

            volumeManagerDialog.setOnVolumeChangedListener(
                    new VolumeManagerDialog.OnVolumeChangedListener() {
                        @Override
                        public void onVolumeChanged
                                (String mediaVolume, String callVolume, String notificationVolume) {
                            txtMediaVolume.setText(mediaVolume);
                            txtCallVolume.setText(callVolume);
                            txtNotificationVolume.setText(notificationVolume);
                        }
                    }
            );
            volumeManagerDialog.show();
        }
    }

}