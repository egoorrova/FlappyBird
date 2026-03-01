package com.example.flappybird;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BitmapBank {

    Bitmap background_game_summer;
    Bitmap background_game_snow;
    Bitmap background_game_dessert;

    Bitmap [] bird;

    Bitmap tubeTop, tubeBottom;
    Bitmap redTubeTop, redTubeBottom;

    public BitmapBank (Resources resources){

        background_game_summer = BitmapFactory.decodeResource(resources, R.drawable.background_game);
        background_game_summer = scaleImage(background_game_summer);

        background_game_snow = BitmapFactory.decodeResource(resources, R.drawable.background_snow);
        background_game_snow = scaleImage(background_game_snow);

        background_game_dessert = BitmapFactory.decodeResource(resources, R.drawable.background_dessert);
        background_game_dessert = scaleImage(background_game_dessert);

        bird = new Bitmap[4];
        bird[0] = BitmapFactory.decodeResource(resources, R.drawable.bird_frame1);
        bird[1] = BitmapFactory.decodeResource(resources, R.drawable.bird_frame2);
        bird[2] = BitmapFactory.decodeResource(resources, R.drawable.bird_frame3);
        bird[3] = BitmapFactory.decodeResource(resources, R.drawable.bird_frame4);

        tubeTop = BitmapFactory.decodeResource(resources, R.drawable.tube_top);
        tubeBottom = BitmapFactory.decodeResource(resources, R.drawable.tube_bottom);

        redTubeTop = BitmapFactory.decodeResource(resources, R.drawable.red_tube_top);
        redTubeBottom = BitmapFactory.decodeResource(resources, R.drawable.red_tube_bottom);
    }

    public Bitmap getRedTubeTop(){
        return redTubeTop;
    }

    public Bitmap getRedTubeBottom(){
        return redTubeBottom;
    }

    public Bitmap getTubeTop(){
        return tubeTop;
    }

    public Bitmap getTubeBottom(){
        return tubeBottom;
    }

    public int getTubeWidth(){
        return  tubeTop.getWidth();
    }

    public int getTubeHeight(){
        return tubeTop.getHeight();
    }

    public Bitmap getBird(int frame){
        return bird[frame];
    }

    public int getBirdWidth(){
        return bird[0].getWidth();
    }

    public int getBirdHeight(){
        return bird[0].getHeight();
    }

    public Bitmap getBackground_game_summer(){
        return background_game_summer;
    }

    public Bitmap getBackground_game_snow(){
        return background_game_snow;
    }

    public Bitmap getBackground_game_dessert(){
        return background_game_dessert;
    }

    public int getBackgroundWidth(){
        return background_game_summer.getWidth();
    }

    public int getBackgroundHeight(){
        return background_game_summer.getHeight();
    }



    public Bitmap scaleImage(Bitmap bitmap){
        float widthHeightRatio = getBackgroundWidth() / getBackgroundHeight();

        int backgtoundScaleWidth = (int) widthHeightRatio * AppConstants.SCREEN_HEIGHT;
        return Bitmap.createScaledBitmap(bitmap, backgtoundScaleWidth, AppConstants.SCREEN_HEIGHT, false);
    }
}
