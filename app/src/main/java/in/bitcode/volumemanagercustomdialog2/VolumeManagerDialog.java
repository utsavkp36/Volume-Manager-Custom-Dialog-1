package in.bitcode.volumemanagercustomdialog2;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class VolumeManagerDialog extends Dialog {
    private Button btnSet;
    private SeekBar skBarMediaVolume,skBarCallVolume,skBarNotificationVolume;
    private TextView txtMediaSeekBarValue,txtCallSeekBarValue,txtNotificationSeekBarValue;
    public VolumeManagerDialog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.volume_manager_dialog);

        initViews();
        setUpListeners();
    }

    public interface OnVolumeChangedListener{
        void onVolumeChanged(String mediaVolume,String callVolume,String notificationVolume);
    }
    private OnVolumeChangedListener onVolumeChangedListener;

    public void setOnVolumeChangedListener(OnVolumeChangedListener onVolumeChangedListener) {
        this.onVolumeChangedListener = onVolumeChangedListener;
    }
    private void initViews(){
        btnSet=findViewById(R.id.btnSet);
        skBarMediaVolume=findViewById(R.id.skBarMediaVolume);
        skBarCallVolume=findViewById(R.id.skBarCallVolume);
        skBarNotificationVolume=findViewById(R.id.skBarNotificationVolume);

        txtMediaSeekBarValue=findViewById(R.id.txtMediaSeekBarValue);
        txtCallSeekBarValue=findViewById(R.id.txtCallSeekBarValue);
        txtNotificationSeekBarValue=findViewById(R.id.txtNotificationSeekBarValue);
    }

    private void setUpListeners(){
        skBarMediaVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int value, boolean b) {
                txtMediaSeekBarValue.setText(value+"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        skBarCallVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int value, boolean b) {
                txtCallSeekBarValue.setText(value+"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        skBarNotificationVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int value, boolean b) {
                txtNotificationSeekBarValue.setText(value+"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        btnSet.setOnClickListener(new BtnSetOnClickListener());
    }

    private class BtnSetOnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            onVolumeChangedListener.onVolumeChanged(
                    txtMediaSeekBarValue.getText().toString(),
                    txtCallSeekBarValue.getText().toString(),
                    txtNotificationSeekBarValue.getText().toString()
            );
            dismiss();
        }
    }
}
