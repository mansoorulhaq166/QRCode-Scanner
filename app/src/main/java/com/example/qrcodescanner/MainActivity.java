package com.example.qrcodescanner;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
<<<<<<< HEAD
import android.view.View;
=======
>>>>>>> c595867 (Gradle Plugin Updated)
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.journeyapps.barcodescanner.BarcodeEncoder;
import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

public class MainActivity extends AppCompatActivity {
    Button scanBtn;
    TextView messageText, messageFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scanBtn = findViewById(R.id.scanbtn);
        messageFormat = findViewById(R.id.scantxt);
        messageText = findViewById(R.id.message_content);
        try {
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.encodeBitmap("content", BarcodeFormat.QR_CODE, 400, 400);
            ImageView imageView = findViewById(R.id.imageView);
            imageView.setImageBitmap(bitmap);
        } catch (Exception exception) {
            Toast.makeText(this, "Not Generated", Toast.LENGTH_SHORT).show();
        }

<<<<<<< HEAD
        scanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ScanOptions options = new ScanOptions();
                options.setPrompt("Scan a barcode or QR Code")
                        .setOrientationLocked(true);
                options.setCameraId(0);
                options.setBeepEnabled(true)
                        .setBarcodeImageEnabled(true);
                barcodeLauncher.launch(options);
            }
        });
    }

    private final ActivityResultLauncher<ScanOptions> barcodeLauncher = registerForActivityResult(new ScanContract(),
            result ->
            {
                if (result.getContents() == null) {
                    Toast.makeText(getApplicationContext(), "Scan Cancelled", Toast.LENGTH_LONG).show();
                } else {
                    messageFormat.setText(result.getFormatName());
                    messageText.setText(result.getContents());
                }
            });
=======
        scanBtn.setOnClickListener(v -> {
            ScanOptions options = new ScanOptions();
            options.setPrompt("Scan a barcode or QR Code").setOrientationLocked(true);
            options.setCameraId(0);
            options.setBeepEnabled(true).setBarcodeImageEnabled(true);
            barcodeLauncher.launch(options);
        });
    }

    private final ActivityResultLauncher<ScanOptions> barcodeLauncher = registerForActivityResult(new ScanContract(), result -> {
        if (result.getContents() == null) {
            Toast.makeText(getApplicationContext(), "Scan Cancelled", Toast.LENGTH_LONG).show();
        } else {
            messageFormat.setText(result.getFormatName());
            messageText.setText(result.getContents());
        }
    });
>>>>>>> c595867 (Gradle Plugin Updated)
}