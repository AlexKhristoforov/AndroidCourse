package alex.hristofor.courseproject.homework6

import alex.hristofor.courseproject.R
import android.app.Activity
import android.content.*
import android.net.wifi.WifiManager
import android.os.Bundle
import android.os.IBinder
import android.support.v4.content.LocalBroadcastManager
import android.util.Log
import android.view.View
import android.widget.TextView


class Homework6Activity : Activity(){
    var mService: CustromService? = null
    var isBound = false
    private val sConn: ServiceConnection = object : ServiceConnection {
        override fun onServiceConnected(className: ComponentName, binder: IBinder) {
            val localBinder: CustromService.LocalBinder = binder as CustromService.LocalBinder
            mService = localBinder.getService()
            isBound = true
            Log.d("AAA", "onServiceConnected")
        }

        override fun onServiceDisconnected(className: ComponentName) {
            Log.d("AAA", "onServiceDisconnected")
            isBound = false
        }
    }

    lateinit var localBroadcastManager: LocalBroadcastManager
    var wifiStatusTextView: TextView? = null

    val listener: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            if (intent.action.equals("NETWORK_AVAILABLE_YES")) {
                changeWifiStatus("WIFI - ON")
                Log.d("AAA", "Status changed to: YES")
            } else {
                changeWifiStatus("WIFI - OFF")
                Log.d("AAA", "Status changed to: NO")
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homework6)
        wifiStatusTextView = findViewById<TextView>(R.id.changeWifiStatus)

        localBroadcastManager = LocalBroadcastManager.getInstance(this)

        wifiStatusTextView?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                val wifiManager: WifiManager = getApplicationContext().getSystemService(Context.WIFI_SERVICE) as WifiManager
                mService?.changeWifiStatus(wifiManager)
                Log.d("AAA", "onClick changeWifiStatus")
            }
        })

    }

    override fun onResume() {
        super.onResume()
        var intent: Intent = object : Intent(this, CustromService::class.java) {}
        bindService(intent, sConn, BIND_AUTO_CREATE)

        val intentFilter = IntentFilter()
        intentFilter.addAction("NETWORK_AVAILABLE_YES")
        intentFilter.addAction("NETWORK_AVAILABLE_NO")

        LocalBroadcastManager.getInstance(this).registerReceiver(listener,
                intentFilter)
    }

    override fun onPause() {
        super.onPause()
        if (!isBound) return
        localBroadcastManager.unregisterReceiver(listener)
        unbindService(sConn)
        isBound = false
    }

    fun changeWifiStatus(message: String?) {
        wifiStatusTextView?.setText(message)
    }
}