package com.example.bleach;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Capitan {

    interface CapitanListener {
        void cuandoDeLaOrden(String orden);
    }

    Random random = new Random();
    ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    ScheduledFuture<?> mostrar;

    void iniciarEntrenamiento(CapitanListener capitanListener) {
        if (mostrar == null || mostrar.isCancelled()) {
            mostrar = scheduler.scheduleAtFixedRate(new Runnable() {
                int capitan = 13;
                float cuentaAtras = -1;

                @Override
                public void run() {
                    if (capitan==1) capitan = 14;
                    capitan --;
                    switch (capitan){
                        case 1: cuentaAtras = 2.1f; break;
                        case 2: cuentaAtras = 6.1f; break;
                        case 3: cuentaAtras = 4.9f; break;
                        case 4: cuentaAtras = 1.7f; break;
                        case 5: cuentaAtras = 4.5f; break;
                        case 6: cuentaAtras = 2f; break;
                        case 7: cuentaAtras = 3.1f; break;
                        case 8: cuentaAtras = 2f; break;
                        case 9: cuentaAtras = 1.5f; break;
                        case 10: cuentaAtras = 3.5f; break;
                        case 11: cuentaAtras = 2.4f; break;
                        case 12: cuentaAtras = 1.6f; break;
                        case 13: cuentaAtras = 4.4f; break;
                        case 14: cuentaAtras = 444444.4444f; break;
                    }


                    capitanListener.cuandoDeLaOrden("Capitan" + capitan + ":" + (cuentaAtras == 0 ? "CAMBIO" : cuentaAtras));
                    cuentaAtras--;
                }
            }, 0, 1, SECONDS);
        }
    }

    void pararEntrenamiento() {
        if (mostrar != null) {
            mostrar.cancel(true);
        }
    }
}