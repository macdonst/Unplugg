package com.simonmacdonald.unplugg;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.util.Log;

import com.phonegap.api.PhonegapActivity;
import com.phonegap.api.Plugin;
import com.phonegap.api.PluginResult;

public class ServiceManager extends Plugin {
    
    private static final String LOG_TAG = "Unplugg";
    private WifiManager wifiMgr;
    private BluetoothAdapter blueMgr;

    /**
     * Executes the request and returns PluginResult.
     *
     * @param action        The action to execute.
     * @param args          JSONArry of arguments for the plugin.
     * @param callbackId    The callback id used when calling back into JavaScript.
     * @return              A PluginResult object with a status and message.
     */
    public PluginResult execute(String action, JSONArray args, String callbackId) {
        PluginResult.Status status = PluginResult.Status.OK;
        String result = "";

        Log.d(LOG_TAG, "In execute of Unplugg");
        try {
            if (action.equals("addSchedule")) {
                JSONObject schedule = args.getJSONObject(0);
                
                Log.d(LOG_TAG, "Setting wifi to disabled");
                // Disable wifi
                wifiMgr.setWifiEnabled(false);
                
                // Disable bluetooth
                if (blueMgr != null) {
                    blueMgr.disable();
                }
                
                return new PluginResult(status, result);
            }
            else {
                status = PluginResult.Status.INVALID_ACTION;
            }
            return new PluginResult(status, result);
        } catch (JSONException e) {
            return new PluginResult(PluginResult.Status.JSON_EXCEPTION);
        }
    }
    
    /**
     * Sets the context of the Command. This can then be used to do things like
     * get file paths associated with the Activity.
     * 
     * @param ctx The context of the main Activity.
     */
    public void setContext(PhonegapActivity ctx) {
        super.setContext(ctx);
        this.wifiMgr = (WifiManager) ctx.getSystemService(Context.WIFI_SERVICE); 
        this.blueMgr = BluetoothAdapter.getDefaultAdapter();
    }
}