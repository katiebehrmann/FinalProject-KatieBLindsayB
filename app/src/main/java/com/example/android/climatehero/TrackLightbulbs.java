package com.example.android.climatehero;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TrackLightbulbs extends AppCompatActivity {

    private static final int REQUEST_PICK_PHOTO = 111;
    private ImageView image;
    private int lightbulbScore;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference picRef = database.getReference("picture");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_lightbulbs);


//        picRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                String byteString = dataSnapshot.getValue(String.class);
//                if (TextUtils.isEmpty(byteString)) return;
//                image.setImageBitmap(ImageUtil.byteStringToBitmap(byteString)); // Read image from Firebase
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//            }
//        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_save_or_delete, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_save:
                Toast.makeText(this, "Light bulb efficiency saved", Toast.LENGTH_SHORT).show();
                Score s = new Score(lightbulbScore, "Lightbulb Efficiency", R.drawable.lightbulb);
                Intent data = new Intent();
                data.putExtra(Keys.SCORE, s);
                setResult(RESULT_OK, data);
                finish();
                return true;
            case R.id.menu_delete:
                Toast.makeText(this, "Light bulb efficiency deleted", Toast.LENGTH_SHORT).show();
                lightbulbScore = 0;

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void all(View view) {
        lightbulbScore = 2;
//        picRef.setValue(ImageUtil.bitmapToByteString(((BitmapDrawable) image.getDrawable()).getBitmap())); // Save image to Firebase
    }

    public void some(View view) {
        lightbulbScore = 1;
    }

    public void one(View view) {
        lightbulbScore = 0;
    }

    public void none(View view) {
        lightbulbScore = -1;
    }

    public void backHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void trackNext(View view) {
        Intent i = new Intent(this, TrackDiet.class);
        startActivity(i);
    }

//    public void selectImage(View view) {
//        Intent intent = new Intent();
//        intent.setType("image/*");
//        intent.setAction(Intent.ACTION_GET_CONTENT);
//        startActivityForResult(intent, REQUEST_PICK_PHOTO);
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (resultCode != RESULT_OK) return;
//
//        if (requestCode == REQUEST_PICK_PHOTO) {
//            Uri photoUrl = data.getData();
//            try {
//                decodeUri(photoUrl);
//            } catch (FileNotFoundException e) {
//                Toast.makeText(this, "Error decoding photo", Toast.LENGTH_SHORT).show();
//            }
//        }
//        super.onActivityResult(requestCode, resultCode, data);
//    }
//
//    // Compress and then display the image
//    private void decodeUri(Uri uri) throws FileNotFoundException {
//
//        // Get the dimensions of the bitmap
//        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
//
//        bmOptions.inJustDecodeBounds = true;
//        BitmapFactory.decodeStream(getContentResolver().openInputStream(uri), null, bmOptions);
//        int photoW = bmOptions.outWidth;
//        int photoH = bmOptions.outHeight;
//
//        // Determine how much to scale down the image so it's not bigger than 500 x 500 pixels
//        int scaleFactor = (int) Math.ceil(Math.min(photoW / 500, photoH / 500));
//
//        // Decode the image file into a Bitmap sized to fill the View
//        bmOptions.inJustDecodeBounds = false;
//        bmOptions.inSampleSize = scaleFactor;
//
//        // Create the compressed bitmap and load it to the imageView
//        Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(uri), null, bmOptions);
//        image.setImageBitmap(bitmap);
//    }
}
