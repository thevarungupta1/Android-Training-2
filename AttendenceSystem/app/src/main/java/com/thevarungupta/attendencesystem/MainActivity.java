package com.thevarungupta.attendencesystem;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button generateQRButton, scanQRCodeButton;
    ImageView imageView;
    TextView barcodeResultText;

    int otp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.image_view_barcode);
        barcodeResultText = findViewById(R.id.text_barcode_result);

        generateQRButton = findViewById(R.id.button_barcode_generate);
        scanQRCodeButton = findViewById(R.id.button_barcode_scan);

        generateQRButton.setOnClickListener(this);
        scanQRCodeButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_barcode_scan:
                scanQRCode();
                break;
            case R.id.button_barcode_generate:
                generateQRCode();
                break;
        }
    }

    public void generateQRCode() {
        String otp = generateOtp();
        MultiFormatWriter writer = new MultiFormatWriter();
        try {
            BitMatrix bitMatrix = writer.encode(otp, BarcodeFormat.QR_CODE, 800, 800);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
            imageView.setImageBitmap(bitmap);
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }

    private void scanQRCode() {
        Intent intent = new Intent(this, ScanBarcodeActivity.class);
        startActivityForResult(intent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {
            if (resultCode == CommonStatusCodes.SUCCESS) {
                if (data != null) {
                    Barcode barcode = data.getParcelableExtra("barcode");
                    barcodeResultText.setText(barcode.displayValue);
                } else {
                    barcodeResultText.setText("No Barcode Result");
                }
            }
        }
    }


    private String generateOtp() {
        Random random = new Random();
        otp = random.nextInt(9000) + 1000;
        return String.valueOf(otp);
    }


}
