package bse.android.net.image;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

import com.android.volley.toolbox.ImageLoader;

/**
 * 图片缓存处理
 * Created by dumh on 14/10/12.
 */
public class BitmapLruImageCache implements ImageLoader.ImageCache {


    private LruCache<String, Bitmap> lruCache;

    BitmapLruImageCache(int sizeLimit) {
        lruCache = new LruCache<String, Bitmap>(sizeLimit) {
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getRowBytes() * value.getHeight();
            }
        };
    }

    @Override
    public Bitmap getBitmap(String url) {
        return lruCache.get(url);
    }

    @Override
    public void putBitmap(String url, Bitmap bitmap) {
        lruCache.put(url, bitmap);
    }
}
