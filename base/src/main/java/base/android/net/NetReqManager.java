package base.android.net;

import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * 请求管理
 * Created by dumh on 14/10/12.
 */
public class NetReqManager {
    public static final String VERSION = "0.0.1.9";
    private static final String TAG = "ReqManager";
    private static RequestQueue requestQueue;

    private NetReqManager(){

    }

    public static void init(Context context){
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(context);
        }
    }

    public static RequestQueue getRequestQueue(){
        if (requestQueue != null) {
            return requestQueue;
        }else {
            Log.e(TAG, "RequestQueue is not initialized");
            return null;
        }
    }
}
