package main;

import java.util.concurrent.BlockingQueue;

public class Consumidor implements Runnable {
    private String outputFolder;
    private BlockingQueue<Paciente> pacientesQueue;

    public Consumidor(String outputFolder, BlockingQueue<Paciente> pacientesQueue) {
        this.outputFolder = outputFolder;
        this.pacientesQueue = pacientesQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Paciente paciente = pacientesQueue.take();
                if (paciente != null) {
                	
                    System.out.println("ID: " + paciente.getId());
                    System.out.println("Nombre: " + paciente.getNombre());
                    System.out.println("Apellido1: " + paciente.getApellido1());
                    System.out.println("Apellido2: " + paciente.getApellido2());
                    System.out.println("Nacimiento: " + paciente.getNacimiento());
                    System.out.println("Localidad: " + paciente.getLocalidad());
                    System.out.println("Historial de Citas:");
                    for (Cita cita : paciente.getHistorialCitas()) {
                        System.out.println("\tCentro: " + cita.getCentro());
                        System.out.println("\tEspecialidad: " + cita.getEspecialidad());
                        System.out.println("\tDoctor/a: " + cita.getDoctor());
                        System.out.println("\tFecha: " + cita.getFecha());
                        System.out.println("\tHora: " + cita.getHora());
                        System.out.println();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
