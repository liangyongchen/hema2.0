package com.hema.assist.common.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.Base64;

import com.hema.assist.common.loger.AppLogger;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Project: WangTouWang
 * Author: frank
 * Created: 2018/2/23:下午2:48
 * Email: 656266591@qq.com
 * Desc:
 */
public class BitmapUtil {/**
 * @param url
 * @return
 */
public static Bitmap getBitmapFromPath(String url) {
    FileInputStream fis = null;
    try {
        fis = new FileInputStream(url);
        Bitmap bitmap = BitmapFactory.decodeStream(fis);
        fis.close();
        return bitmap;
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if(fis != null){
                fis.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    return null;
}

    /**
     * 通过Base64将Bitmap转换成Base64字符串
     * @param bit
     * @return
     */
    public static String bitmap2StrByBase64(Bitmap bit){
        ByteArrayOutputStream bos = null;
        try {
            bos = new ByteArrayOutputStream();
            bit.compress(Bitmap.CompressFormat.JPEG, 100, bos);//参数100表示不压缩
            byte[] bytes=bos.toByteArray();
            bos.close();
            return Base64.encodeToString(bytes, Base64.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(bos != null){
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 将方形bitmap转换为圆形bitmap
     * @param bitmap
     * @return
     */
    public static Bitmap getCircleBitmap(Bitmap bitmap) {
        if (bitmap == null){
            return null;
        }
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        final int color = 0xff424242;
        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        Paint paint =new Paint();
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        int x = bitmap.getWidth();
        canvas.drawCircle(x / 2, x / 2, x / 2, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return output;
    }

    public static void recycleBitmap(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            // 回收并且置为null
            bitmap.recycle();
        }
    }

    public static byte[] bitmap2Byte(final Bitmap bmp, final boolean needRecycle){
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG, 80, output);
        if (needRecycle) {
            bmp.recycle();
        }
        byte[] result = output.toByteArray();
        try {
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 生成透明背景的圆形图片,！注意要生成透明背景的圆形，图片一定要png类型的，不能是jpg类型
     *
     * @param bitmap
     * @return
     */
    public static Bitmap getTransBgCircleBitmap(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        try {
            Bitmap circleBitmap = Bitmap.createBitmap(bitmap.getWidth(),
                    bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(circleBitmap);
            final Paint paint = new Paint();
            final Rect rect = new Rect(0, 0, bitmap.getWidth(),
                    bitmap.getHeight());
            final RectF rectF = new RectF(new Rect(0, 0, bitmap.getWidth(),
                    bitmap.getHeight()));
            float roundPx;
            // 以较短的边为标准
            if (bitmap.getWidth() > bitmap.getHeight()) {
                roundPx = bitmap.getHeight() / 2.0f;
            } else {
                roundPx = bitmap.getWidth() / 2.0f;
            }
            paint.setAntiAlias(true);
            canvas.drawARGB(0, 0, 0, 0);
            paint.setColor(Color.WHITE);
            canvas.drawRoundRect(rectF, roundPx, roundPx, paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            final Rect src = new Rect(0, 0, bitmap.getWidth(),
                    bitmap.getHeight());
            canvas.drawBitmap(bitmap, src, rect, paint);
            return circleBitmap;
        } catch (Exception e) {
            return bitmap;
        }
    }

    /**
     *
     * @param resId
     * @return
     */
    public static Bitmap res2Bitmap(Context context, int resId){
        return BitmapFactory.decodeResource(context.getResources(), resId);
    }

    /**
     * 上传图片压缩
     * @param path
     * @return
     */
    public static String compressUploadImage(String path,int maxW,int maxH,int maxSize){
        //先压缩大小
        Bitmap bitmap = compressImageWH(path, maxW,maxH);
        return compressImageQuality2Str(bitmap, maxSize);
    }

    //计算图片的缩放值
    public static int calculateInSampleSize(BitmapFactory.Options options,int reqWidth, int reqHeight) {
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {
            final int heightRatio = Math.round((float) height/ (float) reqHeight);
            final int widthRatio = Math.round((float) width / (float) reqWidth);
            inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
        }
        return inSampleSize;
    }

    /**
     * 压缩图片大小
     * @param srcPath
     * @param maxW
     * @param maxH
     * @return
     */
    public static Bitmap compressImageWH(String srcPath,int maxW,int maxH) {
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(srcPath, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, maxW, maxH);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;

        return BitmapFactory.decodeFile(srcPath, options);
    }

    /**
     * 压缩图片大小小于某个size,并且转换为 base64 字符串
     * @param image
     * @param maxSize
     * @return
     */
    public static String compressImageQuality2Str(Bitmap image,int maxSize) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.JPEG, 100, baos);//质量压缩方法，这里100表示不压缩，把压缩后的数据存放到baos中
        int options = 100;
        while (baos.size() / 1024 > maxSize) {  //循环判断如果压缩后图片是否大于maxSize kb,大于继续压缩
            baos.reset();//重置baos即清空baos
            image.compress(Bitmap.CompressFormat.JPEG, options, baos);//这里压缩options%，把压缩后的数据存放到baos中
            options -= 10;//每次都减少10
        }

        AppLogger.i("压缩图片大小为:"+baos.size()/1024+"kb");

        byte[] bytes = baos.toByteArray();
        String bitmapStr = Base64.encodeToString(bytes, Base64.DEFAULT);
        try {
            baos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bitmapStr;
    }

    public static Bitmap base642Bitmap(String base64Str,int reqW,int reqH){
        if (TextUtils.isEmpty(base64Str)){
            return null;
        }

        byte[] bytes = base64Decode(base64Str);

        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(bytes,0,bytes.length,options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqW, reqH);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeByteArray(bytes,0,bytes.length,options);
    }

    public static byte[] base64Decode(String base64Str) {
        return Base64.decode(base64Str,Base64.DEFAULT);
    }

    // 将InputStream转换成Bitmap
    public static Bitmap inputStream2Bitmap(InputStream is) {
        return BitmapFactory.decodeStream(is);
    }
}
