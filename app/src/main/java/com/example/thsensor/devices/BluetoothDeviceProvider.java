package com.example.thsensor.devices;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.AsyncTask;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.UUID;

public class BluetoothDeviceProvider implements DeviceProvider {
    private final UUID UUID_CONSTANT = UUID.fromString("fa916458-bbce-42f5-a016-f6e5e95a62eb");

    private BluetoothSocket bluetoothSocket;
    private InputStream inputStream;
    private MyDevice myDevice = null;

    public BluetoothDeviceProvider() throws IOException {
        BluetoothAdapter madapter= BluetoothAdapter.getDefaultAdapter();

        BluetoothDevice mdevice = madapter.getRemoteDevice(((BluetoothDevice)
                madapter.getBondedDevices().toArray()[0]).getAddress());

        // temporarily i get a loner device (other activity)

        bluetoothSocket = mdevice.createRfcommSocketToServiceRecord(UUID_CONSTANT);
        BluetoothService bluetoothService = new BluetoothService();
        bluetoothService.execute();
    }

    public MyDevice selectLoner() {
        if (myDevice == null) {
            myDevice = new MyDevice(bluetoothSocket.getRemoteDevice().getName(), bluetoothSocket.getRemoteDevice().getAddress(), 1);
            System.out.println(bluetoothSocket.isConnected());
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
                inputStream = bluetoothSocket.getInputStream();

                Receive receive = new Receive(selectAll().get(0));
                receive.execute();
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
            byte[] bytes = new byte[1024];
            String stringResult = "";

            while (true) {
                System.out.println(bluetoothSocket.isConnected());
                Integer value = 0;
                try {
                    value = inputStream.read(bytes);

                } catch (IOException e) {
                    e.printStackTrace();
                }

                stringResult += new String(bytes, 0, value);

                myDevice.addMessage(new Date().toString(), new Date().toString(), stringResult);
            }
        }
    }
}
