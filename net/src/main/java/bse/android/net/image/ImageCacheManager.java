package bse.android.net.image;

import com.android.volley.toolbox.ImageLoader;

import base.android.net.NetReqManager;

/**
 * 图片缓存管理
 * Created by dumh on 14/10/12.
 */
public class ImageCacheManager {

    private static final ImageCacheManager instance = new ImageCacheManager();

    private ImageLoader imageLoader;

    private ImageLoader.ImageCache imageCache;

    private ImageCacheManager() {

    }

    public static ImageCacheManager getInstance() {
        return instance;
    }

    public void init(int cacheSizeLimit) {
        imageCache = new BitmapLruImageCache(cacheSizeLimit);
        imageLoader = new ImageLoader(NetReqManager.getRequestQueue(), imageCache);
    }

    public ImageLoader getImageLoader() {
        return imageLoader;
    }

}
