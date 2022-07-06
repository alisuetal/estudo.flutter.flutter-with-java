package com.example.flutter_with_java;

import androidx.annotation.NonNull;
import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodChannel;
import java.util.Random;

public class MainActivity extends FlutterActivity {
     private static final String CHANNEL = "com.example.random/random";

     @Override
     public void configureFlutterEngine(@NonNull FlutterEngine flutterEngine) {
     super.configureFlutterEngine(flutterEngine);
     new MethodChannel(flutterEngine.getDartExecutor().getBinaryMessenger(), CHANNEL)
          .setMethodCallHandler(
               (call, result) -> {
                    Random rand = new Random();
                    int n = rand.nextInt(99999);
                    result.success(n);
               }
          );
     }
}