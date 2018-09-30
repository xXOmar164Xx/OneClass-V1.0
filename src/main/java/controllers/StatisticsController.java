package controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import ring_loader_java.RingProgressIndicator;

public class StatisticsController {

    @FXML StackPane SSP1;
    @FXML StackPane SSP2;
    @FXML StackPane SSP3;

    public void initialize(){
        LoadCircles();
    }

    private void LoadCircles(){

        makeACircle(SSP1);
        makeACircle2(SSP2);
        makeACircle3(SSP3);
    }

    private void makeACircle(StackPane pp){

        RingProgressIndicator rpi = new RingProgressIndicator();
        rpi.setRingWidth(100);
        rpi.makeIndeterminate();

        pp.getChildren().add(rpi);

        new WorkerThread(rpi).start();

    }

    private void makeACircle2(StackPane pp){

        RingProgressIndicator rpi2 = new RingProgressIndicator();
        rpi2.setRingWidth(100);
        rpi2.makeIndeterminate();

        pp.getChildren().add(rpi2);

        new WorkerThread2(rpi2).start();
    }

    private void makeACircle3(StackPane pp){

        RingProgressIndicator rpi3 = new RingProgressIndicator();
        rpi3.setRingWidth(100);
        rpi3.makeIndeterminate();

        pp.getChildren().add(rpi3);

        new WorkerThread3(rpi3).start();
    }

    class WorkerThread extends Thread{
        RingProgressIndicator rpii;
        int progress = 0;

        public WorkerThread(RingProgressIndicator rpii){
            this.rpii = rpii;
        }

        @Override
        public void run(){
            while (true){
                try{
                    Thread.sleep(40);
                }catch (InterruptedException ex){
                }

                Platform.runLater(()->{
                    rpii.setProgress(progress);
                });
                progress += 1;
                if (progress > 75){
                    break;
                }
            }
        }
    }

    class WorkerThread2 extends Thread{
        RingProgressIndicator rpii;
        int progress = 0;

        public WorkerThread2(RingProgressIndicator rpii){
            this.rpii = rpii;
        }

        @Override
        public void run(){
            while (true){
                try{
                    Thread.sleep(40);
                }catch (InterruptedException ex){
                }

                Platform.runLater(()->{
                    rpii.setProgress(progress);
                });
                progress += 1;
                if (progress > 61){
                    break;
                }
            }
        }
    }

    class WorkerThread3 extends Thread {
        RingProgressIndicator rpii;
        int progress = 0;

        public WorkerThread3(RingProgressIndicator rpii){
            this.rpii = rpii;
        }

        @Override
        public void run(){
            while (true){
                try{
                    Thread.sleep(40);
                }catch (InterruptedException ex){
                }

                Platform.runLater(()->{
                    rpii.setProgress(progress);
                });
                progress += 1;
                if (progress > 46){
                    break;
                }
            }
        }
    }
}
