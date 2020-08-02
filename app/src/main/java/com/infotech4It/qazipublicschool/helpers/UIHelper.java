package com.infotech4It.qazipublicschool.helpers;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.location.Address;
import android.media.ExifInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Patterns;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.LayoutAnimationController;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.infotech4It.qazipublicschool.BuildConfig;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.X509TrustManager;

import constants.Constants;


public class UIHelper {

    public String getAuthKey() {
        byte[] data = new byte[0];
        try {
            data = (Constants.ApiUserName + ":" + Constants.ApiPassword).getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "Basic " + Base64.encodeToString(data, Base64.NO_WRAP);
    }

    public static void getRouteFromCurrent(Context context, String latitude, String longitude) {
        Uri navigationIntentUri = Uri.parse("google.navigation:q=" + latitude + "," + longitude);//creating intent with latlng
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, navigationIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        context.startActivity(mapIntent);
    }

    public static void trustEveryone() {
        try {
            HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });
            SSLContext context = SSLContext.getInstance("TLS");
            context.init(null, new X509TrustManager[]{new X509TrustManager() {
                public void checkClientTrusted(X509Certificate[] chain,
                                               String authType) {
                }

                public void checkServerTrusted(X509Certificate[] chain,
                                               String authType) {
                }

                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }
            }}, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(
                    context.getSocketFactory());
        } catch (Exception e) { // should never happen
            e.printStackTrace();
        }
    }

    /*public boolean isUserLogin() {
        String isLogin = PreferenceHelper.getInstance().getString(Constants.isLogin, "");
        if (isLogin.equalsIgnoreCase(Constants.yes)) {
            return true;
        } else {
            return false;
        }

    }*/

    public String getCurrentDate() {
        String date = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(new Date());
        return date;
    }

    public String getYear(Date myDate) {
        String date = new SimpleDateFormat("yyyy", Locale.ENGLISH).format(myDate);
        return date;
    }

    public void addFragmentWithData(Context context, int id, Fragment fragment, String className) {
        Bundle bundle = new Bundle();
        bundle.putString(Constants.CLASS_NAME, className);
        FragmentTransaction fragmentTransaction = ((AppCompatActivity) context).getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(id, fragment);
        fragment.setArguments(bundle);
        fragmentTransaction.commit();
        fragmentTransaction.addToBackStack(null);
    }

    public void replaceFragmentWithData(Context context, int id, Fragment fragment, String className) {
        Bundle bundle = new Bundle();
        bundle.putString(Constants.CLASS_NAME, className);
        FragmentTransaction fragmentTransaction = ((AppCompatActivity) context).getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(id, fragment);
        fragment.setArguments(bundle);
        fragmentTransaction.commit();
    }

    public void addFragment(Context context, int id, Fragment fragment) {

        FragmentTransaction fragmentTransaction = ((AppCompatActivity) context).getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(id, fragment);
        fragmentTransaction.commit();
        fragmentTransaction.addToBackStack(null);
    }

    public void replaceFragment(Context context, int id, Fragment fragment) {

        FragmentTransaction fragmentTransaction = ((AppCompatActivity) context).getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(id, fragment);
        fragmentTransaction.commit();
    }

    public Date ConvertDateInToYYMMDD(String getDate) {
        Date convertedDate = null;
        try {
            String date = getDate;
            convertedDate = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss", Locale.ENGLISH).parse(date);
        } catch (Exception e) {

        }

        return convertedDate;

    }

    public Date ConvertDateInToDDMMYY(String getDate) {
        Date convertedDate = null;
        try {
            String date = getDate;
            convertedDate = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(date);
        } catch (Exception e) {

        }

        return convertedDate;

    }

    /*public void showLongToastInCenter(Context ctx, int messageId) {
        Toast toast = Toast.makeText(ctx, messageId, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }*/

    public String getFormattedDate(Date mDate) {
        SimpleDateFormat daysFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        return daysFormat.format(mDate);
    }

    public String getFormattedStringFromString(int day, int month, int year) {
        String dateString = year + "-" + month + "-" + day;
        Date mDate = new Date(dateString);
        SimpleDateFormat daysFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        return daysFormat.format(mDate);
    }

    public int getWidthInPixel(Context context, float dp) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        float px = dp * (metrics.densityDpi / 160f);
        return (int) px;
    }

   /* public void showAlertDialog(Context ctx, String message) {
        //message = Strings.nullToEmpty( message );
        new AlertDialog.Builder(ctx)
                .setMessage(message)
                .setPositiveButton(ctx.getResources().getString(R.string.ok_btn),null)
                .show();
    }*/

    public void showLongToastInCenter(Context ctx, String message) {
        //message = Strings.nullToEmpty( message );
        Toast toast = Toast.makeText(ctx, message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    public void showToast(Context ctx, String message) {
        //message = Strings.nullToEmpty( message );
        Toast toast = Toast.makeText(ctx, message, Toast.LENGTH_LONG);
        toast.show();
    }

    public void hideSoftKeyboard(Context context, EditText editText) {

        InputMethodManager imm = (InputMethodManager) context
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);

    }

    /*public void Alert(final Context context, String msg) {
        AlertDialog alertDialog = new AlertDialog.Builder(
                context).create();

        // Setting Dialog Title
        alertDialog.setTitle(context.getResources().getString(R.string.app_name_launcher));

        // Setting Dialog Message
        alertDialog.setMessage(msg);

        // Setting OK Button
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        // Showing Alert Message
        alertDialog.show();
    }

    public void errorAlert(final Context context, String msg) {
        AlertDialog alertDialog = new AlertDialog.Builder(
                context).create();

        // Setting Dialog Title
        alertDialog.setTitle(context.getResources().getString(R.string.txt_alert));

        // Setting Dialog Message
        alertDialog.setMessage(msg);

        // Setting OK Button
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        // Showing Alert Message
        alertDialog.show();
    }
*/
    public void callAlert(final Activity context, final String msg) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);


        // Setting Dialog Message
        alertDialog.setMessage(msg);

        // Setting OK Button
        alertDialog.setPositiveButton("Call", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                call(context, msg);

            }
        });

        alertDialog.setNegativeButton("Cancel", null);
        alertDialog.create();

        // Showing Alert Message
        alertDialog.show();
    }

    public String getImagesUrl() {
        return "http://servicedesk.pk/woo_rides/";

    }

    public void showSoftKeyboard(Context context, EditText editText) {

        InputMethodManager imm = (InputMethodManager) context
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInputFromWindow(editText.getWindowToken(), InputMethodManager.SHOW_IMPLICIT, 0);

    }

    public void hideSoftKeyboard(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context
                .getSystemService(Context.INPUT_METHOD_SERVICE);

        if (view != null)
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

    }

    public Rect locateView(View v) {
        int[] loc_int = new int[2];
        if (v == null)
            return null;
        try {
            v.getLocationOnScreen(loc_int);
        } catch (NullPointerException npe) {
            // Happens when the view doesn't exist on screen anymore.
            return null;
        }
        Rect location = new Rect();
        location.left = loc_int[0];
        location.top = loc_int[1];
        location.right = location.left + v.getWidth();
        location.bottom = location.top + v.getHeight();
        return location;
    }

    public void textMarquee(TextView txtView) {
        // Use this to marquee Textview inside listview

        txtView.setEllipsize(TruncateAt.END);
        // Enable to Start Scroll

        // txtView.setMarqueeRepeatLimit(-1);
        // txtView.setHorizontallyScrolling(true);
        // txtView.setSelected(true);
    }

    public void animateRise(final ViewGroup mLayout) {

        AnimationSet set = new AnimationSet(true);

        Animation animation = new AlphaAnimation(0.0f, 1.0f);
        animation.setDuration(250);
        set.addAnimation(animation);

        animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                0.0f, Animation.RELATIVE_TO_SELF, -1.0f);
        animation.setDuration(500);
        set.addAnimation(animation);

        animation.setAnimationListener(new AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mLayout.setVisibility(View.INVISIBLE);
            }
        });

        mLayout.startAnimation(set);

    }

    public void animateFall(ViewGroup mLayout) {

        AnimationSet set = new AnimationSet(true);

        Animation animation = new AlphaAnimation(0.0f, 1.0f);
        animation.setDuration(250);
        set.addAnimation(animation);

        animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                -1.0f, Animation.RELATIVE_TO_SELF, 0.0f);
        animation.setDuration(500);
        set.addAnimation(animation);

        mLayout.startAnimation(set);

    }

    public void animateLayoutSlideDown(ViewGroup mLayout) {

        AnimationSet set = new AnimationSet(true);

        Animation animation = new AlphaAnimation(0.0f, 1.0f);
        animation.setDuration(250);
        set.addAnimation(animation);

        animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                -1.0f, Animation.RELATIVE_TO_SELF, 0.0f);
        animation.setDuration(150);
        set.addAnimation(animation);

        LayoutAnimationController controller = new LayoutAnimationController(
                set, 0.25f);
        mLayout.setLayoutAnimation(controller);

    }

    public void animateLayoutSlideToRight(ViewGroup mLayout) {

        AnimationSet set = new AnimationSet(true);

        Animation animation = new AlphaAnimation(0.0f, 1.0f);
        animation.setDuration(750);
        set.addAnimation(animation);

        animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF,
                0.0f, Animation.RELATIVE_TO_SELF, 0.0f);

        animation.setDuration(750);
        set.addAnimation(animation);

        LayoutAnimationController controller = new LayoutAnimationController(
                set, 0.25f);
        mLayout.setLayoutAnimation(controller);

    }

    public void animateLayoutSlideFromRight(ViewGroup mLayout) {

        AnimationSet set = new AnimationSet(true);

        Animation animation = new AlphaAnimation(0.0f, 1.0f);
        animation.setDuration(750);
        set.addAnimation(animation);

        animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 1.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                0.0f, Animation.RELATIVE_TO_SELF, 0.0f);

        animation.setDuration(750);
        set.addAnimation(animation);

        LayoutAnimationController controller = new LayoutAnimationController(
                set, 0.25f);
        mLayout.setLayoutAnimation(controller);

    }

    public void animateLayoutSlideToLeft(ViewGroup mLayout) {

        AnimationSet set = new AnimationSet(true);

        Animation animation = new AlphaAnimation(0.0f, 1.0f);
        animation.setDuration(750);
        set.addAnimation(animation);

        animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, -1.0f, Animation.RELATIVE_TO_SELF,
                0.0f, Animation.RELATIVE_TO_SELF, 0.0f);

        animation.setDuration(750);
        set.addAnimation(animation);

        LayoutAnimationController controller = new LayoutAnimationController(
                set, 0.25f);
        mLayout.setLayoutAnimation(controller);

    }

    public void animateFromRight(ViewGroup mLayout) {

        AnimationSet set = new AnimationSet(true);

        Animation animation = new AlphaAnimation(0.0f, 1.0f);
        animation.setDuration(250);
        set.addAnimation(animation);

        animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 1.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                0.0f, Animation.RELATIVE_TO_SELF, 0.0f);
        animation.setDuration(500);
        set.addAnimation(animation);

        mLayout.startAnimation(set);

    }

    public void animateToRight(ViewGroup mLayout) {

        AnimationSet set = new AnimationSet(true);

        Animation animation = new AlphaAnimation(0.0f, 1.0f);
        animation.setDuration(250);
        set.addAnimation(animation);

        animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF,
                0.0f, Animation.RELATIVE_TO_SELF, 0.0f);
        animation.setDuration(500);
        set.addAnimation(animation);

        mLayout.startAnimation(set);

    }

    public Bitmap getThumbnail(Context context, Uri uri, int size) throws IOException {
        int rotate = checkImageForRotation(uri.getPath());
        InputStream input = context.getContentResolver().openInputStream(uri);

        BitmapFactory.Options onlyBoundsOptions = new BitmapFactory.Options();
        onlyBoundsOptions.inJustDecodeBounds = true;
        onlyBoundsOptions.inDither = true;//optional
        onlyBoundsOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;//optional
        BitmapFactory.decodeStream(input, null, onlyBoundsOptions);
        input.close();
        if ((onlyBoundsOptions.outWidth == -1) || (onlyBoundsOptions.outHeight == -1))
            return null;

        int originalSize = (onlyBoundsOptions.outHeight > onlyBoundsOptions.outWidth) ? onlyBoundsOptions.outHeight : onlyBoundsOptions.outWidth;

        double ratio = (originalSize > size) ? (originalSize / size) : 1.0;

        BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
        bitmapOptions.inSampleSize = getPowerOfTwoForSampleRatio(ratio);
        bitmapOptions.inDither = true;//optional
        bitmapOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;//optional
        input = context.getContentResolver().openInputStream(uri);
        Bitmap bitmap = BitmapFactory.decodeStream(input, null, bitmapOptions);
        Matrix matrix = new Matrix();
        matrix.postRotate(rotate);
        Bitmap rotatedBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        input.close();
        return rotatedBitmap;
    }

    public int checkImageForRotation(String imagePath) {
        ExifInterface ei;
        int rotate = 0;
        try {
            ei = new ExifInterface(imagePath);
            int orientation = ei.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);

            switch (orientation) {
                case ExifInterface.ORIENTATION_ROTATE_90:
                    rotate = 90;
                    break;

                case ExifInterface.ORIENTATION_ROTATE_180:
                    rotate = 180;
                    break;

                case ExifInterface.ORIENTATION_ROTATE_270:
                    rotate = 270;
                    break;

                case ExifInterface.ORIENTATION_NORMAL:
                    rotate = 0;
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rotate;
    }

    private int getPowerOfTwoForSampleRatio(double ratio) {
        int k = Integer.highestOneBit((int) Math.floor(ratio));
        if (k == 0) return 1;
        else {
            return k;
        }
    }

    public Drawable convertUriToDrawable(Context context, Uri imageUri) {
        try {
            InputStream inputStream = context.getContentResolver().openInputStream(imageUri);
            return Drawable.createFromStream(inputStream, imageUri.toString());
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    public File saveImage(Bitmap _bitmap, String fileName, Context context) {
        File file = new File(fileName);
        ValidateFolderExist(file.getParent());
        FileOutputStream outStream = null;
        try {
            file.createNewFile();
            outStream = new FileOutputStream(file);
            _bitmap.compress(Bitmap.CompressFormat.PNG, 90, outStream);
            outStream.flush();
            outStream.close();
            //addImageToGallery(file.getAbsolutePath(), context);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    public void ValidateFolderExist(String folderPath) {
        File dir = new File(folderPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }

    public String loadJSONFromAsset(Context context) {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = null;
        try {
            InputStreamReader reader = new InputStreamReader(context
                    .getAssets().open("jsondata.json"));
            br = new BufferedReader(reader);
            String temp;
            while ((temp = br.readLine()) != null) {
                sb.append(temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close(); // stop reading
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    public void smsShare(final Activity context, String phNumber, String messageBody) {
        String sendTo = "";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            sendTo = "smsto: " + phNumber;
        } else {
            sendTo = "sms:" + phNumber;
        }

        Intent sendIntent = new Intent(Intent.ACTION_VIEW);
        sendIntent.setData(Uri.parse(sendTo));
        sendIntent.putExtra("sms_body", messageBody);

        try {
            context.startActivity(sendIntent);
        } catch (Exception e) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {

                @Override
                public void run() {
                    Toast.makeText(context, "SMS service is not available", Toast.LENGTH_LONG).show();
                }
            });
        }

    }

    public void sendEmail(String[] to, String[] cc, String body, Activity ctx, String subject) {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO,
                Uri.parse("mailto:"));

        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, body);
        if (to != null)
            emailIntent.putExtra(Intent.EXTRA_EMAIL, to);
        ctx.startActivity(Intent.createChooser(emailIntent, "Send phone via..."));
    }

    public boolean isEmptyOrNull(String string) {
        if (string == null)
            return true;

        return (string.trim().length() <= 0);
    }

    public String captilize(String name) {
        char[] chars = name.toLowerCase().toCharArray();
        boolean found = false;
        for (int i = 0; i < chars.length; i++) {
            if (!found && Character.isLetter(chars[i])) {
                chars[i] = Character.toUpperCase(chars[i]);
                found = true;
            } else if (Character.isWhitespace(chars[i]) || chars[i] == '.' || chars[i] == ' ') { // You can add other chars here
                found = false;
            }
        }

        return String.valueOf(chars);
    }

    public String captilizeAfterDot(String name) {
        char[] chars = name.toLowerCase().toCharArray();
        boolean found = false;
        for (int i = 0; i < chars.length; i++) {
            if (!found && Character.isLetter(chars[i])) {
                chars[i] = Character.toUpperCase(chars[i]);
                found = true;
            } else if (Character.isWhitespace(chars[i]) || chars[i] == '.' || chars[i] == ' ') { // You can add other chars here
                found = false;
            }
        }

        return String.valueOf(chars);
    }

    public String capitalizeScentance(String name) {
      /*  final StringBuilder result = new StringBuilder(name.length());
        String[] words = name.split("\\s");
        for(int i=0,l=words.length;i<l;++i) {
            if (i > 0) result.append(" ");
            result.append(Character.toUpperCase(words[i].charAt(0)))
                    .append(words[i].substring(1));
        }
        StringBuilder sb = new StringBuilder(name);
        sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        sb.setCharAt(name.indexOf(" ") + 1, Character.toUpperCase(sb.charAt(name.indexOf(" ") + 1)));
        sb.setCharAt(name.indexOf(".") + 1, Character.toUpperCase(sb.charAt(name.indexOf(".") + 1)));*/
        char[] chars = name.toLowerCase().toCharArray();
        boolean found = false;
        for (int i = 0; i < chars.length; i++) {
            if (!found && Character.isLetter(chars[i])) {
                chars[i] = Character.toUpperCase(chars[i]);
                found = true;
            } else if (Character.isWhitespace(chars[i]) || chars[i] == '.' || chars[i] == ' ') { // You can add other chars here
                found = false;
            }
        }

        return String.valueOf(chars);
    }

    public String getFormattedAddress(Address address) {
        String addressName = "";
               /* for (int i = 0; i < address.getMaxAddressLineIndex(); i++) {
                    addressName += address.getAddressLine(i) + " ";
                }*/
        String location = "";
        String city = address.getLocality();
        //String distric = addresses.get(0).getAdminArea();
        String country = "";
        if (address.getAdminArea() != null && address.getAdminArea().length() >= 2) {
            String[] arr = address.getAdminArea().split(" ");
            if (arr != null) {
                if (arr.length > 1) {
                    country = String.valueOf(arr[0].charAt(0)) + arr[1].charAt(0);
                    country = country.toUpperCase();
                } else {
                    country = address.getAdminArea().substring(0, 2);
                    country = country.toUpperCase();
                }
            } else {
                country = country.toUpperCase();
            }

        } else
            country = address.getAdminArea();

        String postalCode = address.getPostalCode();
        //  sb.insert(location.indexOf("CA") + 2, ", ");

        //location.replaceAll(" ",", ");
                /*if(address!=null){
                    location += address;
				}*/

        if (city != null && city.length() > 0) {
            location += city;
        }
        if (country != null && country.length() > 0) {
            if (city != null && city.length() > 0)
                location += ", " + country;
            else
                location += country;
        }
        if (postalCode != null && postalCode.length() > 0) {
            if (country != null && country.length() > 0)
                location += ", " + postalCode;
            else
                location += postalCode;
        }
        if (location.length() == 0)
            location = "N/A";
        return location;

    }

    public boolean isNotNull(String str) {
        return str != null && str.length() > 0;

    }

    public double faircalculation(float mils) {
        double price;
        // float meters=GMSGeometryLength(routePath);
        //float mils= Float.parseFloat(DistanceCalculator.getDistanceBetweenLocation(startLocation,endLocation));

        if (mils >= 3.00) {
            price = 35.00;
        } else if (mils >= 0.34 && mils <= 0.66) {
            price = 7.50;
        } else if (mils >= 0.67 && mils <= 0.99) {
            price = 15.00;
        } else if (mils >= 1.00 && mils <= 1.99) {
            price = 20.00;
        } else if (mils >= 2.00 && mils <= 2.99) {
            price = 30.00;
        } else {
            price = 5.00;
        }
        return price;

    }

    public void call(Activity activity, String number) {

        Uri call = Uri.parse("tel:" + number);
        Intent surf = new Intent(Intent.ACTION_DIAL, call);
        activity.startActivity(surf);
    }


//    public void openActivityAndSendPosition(Activity activity, Class<?> calledActivity, int position) {
//        Intent myIntent = new Intent(activity, calledActivity);
//        myIntent.putExtra(Constants.CLASS_NAME, position);
//        activity.startActivity(myIntent);
//    }

//    public void openJobDetailActivity(Activity activity, Class<?> calledActivity, int orderServiceId, int position) {
//        Intent myIntent = new Intent(activity, calledActivity);
//        myIntent.putExtra(Constants.ORDER_SERVICE_ID, orderServiceId);
//        myIntent.putExtra(Constants.CLASS_NAME, position);
//        activity.startActivity(myIntent);
//    }
//
//    public void openActivityAndSendValue(Activity activity, Class<?> calledActivity, String value) {
//        Intent myIntent = new Intent(activity, calledActivity);
//        myIntent.putExtra(Constants.ValueKey, value);
//        activity.startActivity(myIntent);
//    }
//
//    public void openActivityAndSendMobileNo(Activity activity, Class<?> calledActivity, String number) {
//        Intent myIntent = new Intent(activity, calledActivity);
//        myIntent.putExtra(Constants.PHONE_NUMBER, number);
//        activity.startActivity(myIntent);
//    }
//
//    public void openActivityAndSendMobileNoWithKey(Activity activity, Class<?> calledActivity, String number, String value) {
//        Intent myIntent = new Intent(activity, calledActivity);
//        myIntent.putExtra(Constants.PHONE_NUMBER, number);
//        myIntent.putExtra(Constants.ValueKey, value);
//        activity.startActivity(myIntent);
//    }

    /*public void openActivityAndCheckUser(Activity activity, Class<?> calledActivity,String userType, String verificationCode) {
        Intent myIntent = new Intent(activity, calledActivity);
        myIntent.putExtra(Constants.USER_TYPE, userType);
        myIntent.putExtra(Constants.VERIFICATION_CODE, verificationCode);
        myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        activity.startActivity(myIntent);

    }


    }*/

    public final boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

//    public void openClearAndSendValueActivity(Activity activity, Class<?> calledActivity, String value) {
//        Intent myIntent = new Intent(activity, calledActivity);
//        myIntent.putExtra(Constants.ValueKey, value);
//        myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        activity.startActivity(myIntent);
//    }

    /*public static void showSnackBar(String msg, Context context, View view) {
        Snackbar snackbar = Snackbar
                .make(view, msg, Snackbar.LENGTH_LONG);
                *//*.setAction("RETRY", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    }
                });*//*


        snackbar.setActionTextColor(context.getResources().getColor(R.color.colorWhite));
        View sbView = snackbar.getView();
        sbView.setBackgroundColor(context.getResources().getColor(R.color.colorRed));
        TextView textView = sbView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(context.getResources().getColor(R.color.colorWhite));
        snackbar.show();
    }*/


//    public  void initSingltons(Context context) {
//        PreferenceHelper.getInstance(context).init(context);
//        WebServices.getInstance().init(context);
//        //SpecialSharedPrefHelper.getInstance().init(context);
//    }

    public void openActivity(Activity activity, Class<?> calledActivity) {
        Intent myIntent = new Intent(activity, calledActivity);
        activity.startActivity(myIntent);
    }

    public void openAndClearActivity(Activity activity, Class<?> calledActivity) {
        Intent myIntent = new Intent(activity, calledActivity);
        myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        activity.startActivity(myIntent);
    }

    public boolean isValidEmail(String email) {

        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public int calculateTabWidth(Activity context) {
        Display display = context.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size.x / 3;
    }

    public void shareOurApp(Context context){
        try {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Qazi Public School System");
            String shareMessage= "\nLet me recommend you this application\n\n";
            shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" +
                    BuildConfig.APPLICATION_ID +"\n\n";
            shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
            context.startActivity(Intent.createChooser(shareIntent, "choose one"));
        } catch(Exception e) {
            //e.toString();
        }
    }
}