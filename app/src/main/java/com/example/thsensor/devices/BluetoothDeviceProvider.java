package com.example.thsensor.devices;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.UUID;

public class BluetoothDeviceProvider implements DeviceProvider {
    BluetoothSocket bluetoothSocket;
    OutputStream outputStream;
    InputStream inputStream;
    MyDevice myDevice = null;

    public BluetoothDeviceProvider() throws IOException {
        BluetoothAdapter madapter= BluetoothAdapter.getDefaultAdapter();

        BluetoothDevice mdevice = madapter.getRemoteDevice(((BluetoothDevice)
                madapter.getBondedDevices().toArray()[0]).getAddress());

        // temporarily i get a loner device (other activity)

        bluetoothSocket = mdevice.createRfcommSocketToServiceRecord(UUID.randomUUID());
        BluetoothService bluetoothService = new BluetoothService();
        bluetoothService.execute();

        Receive receive = new Receive(this.selectAll().get(0));
        receive.execute();
    }

    public MyDevice selectLoner() {
        if (myDevice == null) {
            myDevice = new MyDevice("other device", "0.0.0.0", 1);
        }

        return myDevice;
    }

    @Override
    public ArrayList<MyDevice> selectAll() {
        ArrayList<MyDevice> devices = new ArrayList<>();

        devices.add(this.selectLoner());

        return devices;
    }

    public class BluetoothService extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void[] objects) {

            {
                try {
                    bluetoothSocket.connect();
                } catch (IOException exception) {
                    try {
                        bluetoothSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                return null;
            }
        }

        @Override
        protected void onPostExecute(Void result) {
            try {
                outputStream = bluetoothSocket.getOutputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                inputStream = bluetoothSocket.getInputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }

            super.onPostExecute(result);
        }
    }

    public class Receive extends AsyncTask<MyDevice,Void,Void> {
        MyDevice myDevice;

        public Receive(MyDevice myDevice) {
            this.myDevice = myDevice;
        }

        @Override
        protected Void doInBackground(MyDevice[] myDevices) {
            Scanner scanner = new Scanner(inputStream);
            while (true) {
                String value = scanner.nextLine();
                myDevice.addMessage(new Date().toString(), new Date().toString(), value);
            }
        }
    }
}
