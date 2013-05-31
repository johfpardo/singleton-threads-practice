package singletonthreads;

import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Antonio
 */
public class ProcessTwo implements Runnable{

    private static ProcessTwo uniqueInstance;
    private Thread t;
    
    private ProcessTwo(){
        t= new Thread(this);
        t.start();
    }
    
    public static synchronized ProcessTwo getInstance(){
        if (uniqueInstance == null){
            uniqueInstance = new ProcessTwo();
        }
        return uniqueInstance;
    }
    @Override
    public void run() {
        try {
            for (int i=0;i<10;i++){
                System.out.println("This is process Two running");
                t.sleep(2000L);
            }                        
        } catch (InterruptedException ex) {
            Logger.getLogger(ProcessOne.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
